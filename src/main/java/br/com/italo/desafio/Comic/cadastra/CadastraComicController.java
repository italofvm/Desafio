package br.com.italo.desafio.comic.cadastra;

import br.com.italo.desafio.comic.Comic;
import br.com.italo.desafio.comic.ComicRepository;
import br.com.italo.desafio.marvelapi.SolicitaComic;
import br.com.italo.desafio.usuario.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping("/usuarios")
public class CadastraComicController {

    @Autowired
    private SolicitaComic solicitaComic;
    @Autowired
    private ComicRepository repository;
    @Autowired
    private UsuarioRepository usuarioRepository;


    @PostMapping("/{id}/comics")
    public ResponseEntity<?> cadastra(@PathVariable Long id, @RequestBody @Valid CadastraComicRequest request) {
        var possivelUsuario = usuarioRepository.findById(id);
        if(possivelUsuario.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        var response = solicitaComic.buscaComicPorId(request.getComicId());
        Comic comic = repository.save(request.toComic(possivelUsuario.get(), response));
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(comic.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }
}
