package br.com.italo.desafio.comic.cadastra;

import br.com.italo.desafio.comic.Comic;
import br.com.italo.desafio.marvelapi.response.ResultResponse;
import br.com.italo.desafio.usuario.Usuario;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;

public class CadastraComicRequest {

    @NotNull
    private Integer comicId;
    @NotBlank
    private String titulo;
    @NotBlank
    private String isbn;
    @NotBlank
    private String descricao;
    @NotNull
    @PositiveOrZero
    private Double preco;

    public CadastraComicRequest(Integer comicId, String titulo, String isbn, String descricao, Double preco) {
        this.comicId = comicId;
        this.titulo = titulo;
        this.isbn = isbn;
        this.descricao = descricao;
        this.preco = preco;
    }

    public Integer getComicId() {
        return comicId;
    }

    public Comic toComic(Usuario usuario, ResultResponse apiResponse) {
        return new Comic(
                comicId,
                apiResponse.getTitle().isBlank() ? titulo : apiResponse.getTitle(),
                apiResponse.getIsbn().isBlank() ? isbn : apiResponse.getIsbn(),
                apiResponse.getDescription() == null ? descricao : apiResponse.getDescription(),
                apiResponse.getPrice() == 0.0 ? preco : apiResponse.getPrice(),
                usuario
        );
    }
}
