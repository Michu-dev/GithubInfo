package com.github.info.app;

import com.github.info.rest.InfoController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.client.RestTemplate;

import javax.sound.sampled.Line;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;




@SpringBootTest
class InfoApplicationTest {

    @Autowired
    private InfoController infoController;

    @Autowired
    private RestTemplate restTemplate;

    @Test
    public void contextLoads() {
        assertThat(infoController).isNotNull();
    }

    @Test
    public void connectionToApiTest() {
        ResponseEntity<Map> response = restTemplate.getForEntity("https://api.github.com/users/Michu-dev", Map.class);

        assertEquals(response.getBody().get("id"), 72170326);

    }





}