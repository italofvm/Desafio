package br.com.italo.desafio.marvelapi.response;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class DataResponse {

    @JsonProperty("results")
    private List<ResultResponse> results;

    public DataResponse(@JsonProperty("results") List<ResultResponse> results) {
        this.results = results;
    }

    @Deprecated
    public DataResponse() {
    }

    public ResultResponse getResult() {
        return results.get(0);
    }
}