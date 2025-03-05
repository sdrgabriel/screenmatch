package br.com.sdrgabriel.infrastructure.controller;

import br.com.sdrgabriel.adapters.usecase.conteudo.recuperar.get.BuscarConteudoUseCase;
import br.com.sdrgabriel.infrastructure.dto.response.ConteudoDTO;
import br.com.sdrgabriel.infrastructure.mapper.ConteudoMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static br.com.sdrgabriel.infrastructure.utils.Log.log;

@RestController
@RequestMapping("conteudos")
@RequiredArgsConstructor
public class ConteudoController {

    private final BuscarConteudoUseCase buscarConteudoUseCase;
    private final ConteudoMapper conteudoMapper;

    @GetMapping("pesquisar/{titulo}")
    public ResponseEntity<ConteudoDTO> pesquisarConteudo(@PathVariable("titulo") String titulo) {
        log.info("Inicio da busca de conteudo::ConteudoController");
        var conteudo = buscarConteudoUseCase.execute(titulo);
        log.info("Fim da busca de conteudo::ConteudoController");
        return ResponseEntity.ok(conteudoMapper.toDto(conteudo));
    }
}
