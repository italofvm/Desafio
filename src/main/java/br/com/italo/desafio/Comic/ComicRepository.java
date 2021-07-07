package br.com.italo.desafio.comic;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ComicRepository extends JpaRepository<Comic, Integer> {

    Boolean existsByComicId(Integer comicId);
    List<Comic> findByUsuarioId(Long usuarioId);
}
