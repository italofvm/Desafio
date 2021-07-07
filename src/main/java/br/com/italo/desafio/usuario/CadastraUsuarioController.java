package br.com.italo.desafio.usuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping("/usuarios")
public class CadastraUsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @PostMapping
    public ResponseEntity<?> cadastra(@RequestBody  @Valid CadastraUsuarioRequest request) {
        if(usuarioRepository.existsByCpf(request.getCpf())  && usuarioRepository.existsByEmail(request.getEmail())) {
            return ResponseEntity.unprocessableEntity().build();
        }
        var usuario = usuarioRepository.save(request.toUsuario());
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}")
                .buildAndExpand(usuario.getId()).toUri();
        return  ResponseEntity.created(uri).build();
    }

}
