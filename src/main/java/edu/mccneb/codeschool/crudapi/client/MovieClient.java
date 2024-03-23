package edu.mccneb.codeschool.crudapi.client;

import edu.mccneb.codeschool.crudapi.config.ApiConfig;
import edu.mccneb.codeschool.crudapi.model.ExternalMovieAPI;
import edu.mccneb.codeschool.crudapi.model.Movie;
import edu.mccneb.codeschool.crudapi.model.Results;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class MovieClient {

    private final ApiConfig apiConfig;
    private final RestTemplate restTemplate;

    public MovieClient(ApiConfig apiConfig, RestTemplate restTemplate) {
        this.apiConfig = apiConfig;
        this.restTemplate = restTemplate;
    }

    public Results getOverview(String q){
        ExternalMovieAPI response = restTemplate.getForObject(apiConfig.getHost() + apiConfig.getPath(), ExternalMovieAPI.class, q, apiConfig.getApiKey());
        return response.getResults().stream().findFirst().get();
    }
}
