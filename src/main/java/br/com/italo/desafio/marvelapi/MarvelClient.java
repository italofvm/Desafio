package br.com.italo.desafio.marvelapi;

import br.com.italo.desafio.marvelapi.response.ComicsResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(url = "${marvel.url}/comics", name = "marvel-url")
public interface MarvelClient {

    @GetMapping("/{id}")
    ResponseEntity<ComicsResponse> findComicsPorId(
            @PathVariable Integer id,
            @RequestParam String ts,
            @RequestParam String apikey,
            @RequestParam String hash);
}
