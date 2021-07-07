package br.com.italo.desafio.marvelapi.response;

import br.com.italo.desafio.comic.Comic;
import br.com.italo.desafio.usuario.Usuario;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class ResultResponse {

    @JsonProperty("id")
    private Integer comicId;
    @JsonProperty("title")
    private String title;
    @JsonProperty("isbn")
    private String isbn;
    @JsonProperty("description")
    private String description;
    @JsonProperty("prices")
    private List<PriceResponse> prices;

    public ResultResponse(Integer comicId, String title, String isbn, String description, List<PriceResponse> prices) {
        this.comicId = comicId;
        this.title = title;
        this.isbn = isbn;
        this.description = description;
        this.prices = prices;
    }

    public Comic toComic(Usuario usuario) {
        return new Comic(comicId, title, isbn, description, prices.get(0).getPrice(), usuario);
    }

    public Integer getComicId() {
        return comicId;
    }

    public String getTitle() {
        return title;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getDescription() {
        return description;
    }

    public Double getPrice() {
        return prices.get(0).getPrice();
    }
}

