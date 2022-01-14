package com.github.info.rest;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.info.logic.Repo;
import com.github.info.logic.ReposUserStatistics;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/{user}/")
public class InfoController {


    private RestTemplate restTemplate = new RestTemplate();


    private static final Logger logger = LoggerFactory.getLogger(InfoController.class);

    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
    public ReposUserStatistics get(@PathVariable String user) throws IllegalAccessException {

        // log the parameters
        logger.debug(user);
        ObjectMapper oMapper = new ObjectMapper();
        String resourceUrl = "https://api.github.com/users/" + user + "/repos";
        int allStargazzers = 0;

        Repo[] response;

        response = restTemplate.getForObject(resourceUrl, Repo[].class);
        String repoLanguagesUrl;
        Map<String, Integer> map = new HashMap<String, Integer>();

        for (Repo r : response) {
            allStargazzers += r.getStargazers_count();
            repoLanguagesUrl = "https://api.github.com/repos/" + user + "/" + r.getName() + "/languages";
            Object object = restTemplate.getForObject(repoLanguagesUrl, Object.class);
            logger.info(String.valueOf(object));
            Map<String, Integer> oneMap = oMapper.convertValue(object, Map.class);


            for (Entry<String, Integer> entry : oneMap.entrySet()) {
                String key = entry.getKey();
                Integer value = entry.getValue();
                Integer valueOfMap = map.containsKey(key) ? map.get(key) : 0;
                map.put(key, valueOfMap + value);
            }

        }

        List<Entry<String, Integer>> entryLanguagesList = map.entrySet().stream().collect(Collectors.toList());


        ReposUserStatistics reposUserStatistics = new ReposUserStatistics();


        reposUserStatistics.setReposList(response);
        reposUserStatistics.setAllStars(allStargazzers);
        reposUserStatistics.setLanguagesList(entryLanguagesList);

        return reposUserStatistics;
    }



}
