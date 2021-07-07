package br.com.italo.desafio.comic.lista;

import br.com.italo.desafio.comic.Comic;
import br.com.italo.desafio.comic.ComicRepository;
import br.com.italo.desafio.usuario.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.stream.Collectors;

@RestController
@RequestMapping("/usuarios")
public class ListaComicController {

    @Autowired
    private ComicRepository comicRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @GetMapping("/{id}/comics")
    public ResponseEntity<?> lista(@PathVariable Long id){
        var possivelusuario = usuarioRepository.findById(id);
        if (possivelusuario.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        var listadecomics = comicRepository.findByUsuarioId(id);
        var listadecomicsResponse = listadecomics.stream()
                .map(ListaComicsPorUsuarioResponse::new)
                .collect(Collectors.toList());
        return ResponseEntity.ok(listadecomicsResponse);

    }

}
