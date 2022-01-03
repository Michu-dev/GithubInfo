package com.github.info.rest;
import com.github.info.logic.Repo;
import com.github.info.logic.ReposUserStatistics;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;


@RestController
@RequestMapping("/{user}/")
public class InfoController {

    @Autowired
    private RestTemplate restTemplate;


    private static final Logger logger = LoggerFactory.getLogger(InfoController.class);

    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
    public ReposUserStatistics get(@PathVariable String user) {

        // log the parameters
        logger.debug(user);

        String resourceUrl = "https://api.github.com/users/" + user + "/repos";
        int allStargazzers = 0;

        Repo[] response;

        response = restTemplate.getForObject(resourceUrl, Repo[].class);

        for (Repo r : response) {
            allStargazzers += r.getStargazersCount();
        }
        ReposUserStatistics reposUserStatistics = new ReposUserStatistics();

        reposUserStatistics.setReposList(response);
        reposUserStatistics.setAllStars(allStargazzers);

        return reposUserStatistics;
    }



}
