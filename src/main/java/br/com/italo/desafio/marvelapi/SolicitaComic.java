package br.com.italo.desafio.marvelapi;

import br.com.italo.desafio.marvelapi.response.ResultResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@Service
public class SolicitaComic {

    @Autowired
    private MarvelClient marvelClient;

    @Value("${marvel.public.key}")
    private String publicKey;

    @Value("${marvel.private.key}")
    private String privateKey;

    @Autowired
    ObjectMapper mapper;

    public ResultResponse buscaComicPorId(Integer id) {
        var dataAtual = String.valueOf(System.currentTimeMillis());
        var response =  marvelClient.findComicsPorId(id, dataAtual, publicKey, hash(dataAtual)).getBody();
        return response.getResult();
    }

    private String hash(String dataAtual) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            var Stringhash = dataAtual + privateKey + publicKey;
            BigInteger hash = new BigInteger(1, md.digest(Stringhash.getBytes(StandardCharsets.UTF_8)));
            return hash.toString(16);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException();
        }
    }
}
