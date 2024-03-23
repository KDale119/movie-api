package edu.mccneb.codeschool.crudapi.model;

import jakarta.persistence.Entity;

import java.util.List;


public class ExternalMovieAPI {
    private Integer page;

    private List<Results> results;

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public List<Results> getResults() {
        return results;
    }

    public void setResults(List<Results> results) {
        this.results = results;
    }
}
