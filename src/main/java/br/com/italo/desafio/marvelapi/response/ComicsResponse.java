package br.com.italo.desafio.marvelapi.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ComicsResponse {

    @JsonProperty("data")
    private DataResponse data;

    public ComicsResponse(@JsonProperty("data") DataResponse data) {
        this.data = data;
    }

    public ResultResponse getResult() {
        return data.getResult();
    }

}
