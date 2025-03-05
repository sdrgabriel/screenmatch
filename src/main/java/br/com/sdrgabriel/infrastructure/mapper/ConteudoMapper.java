package br.com.sdrgabriel.infrastructure.mapper;

import br.com.sdrgabriel.core.domain.Conteudo;
import br.com.sdrgabriel.infrastructure.dto.response.ConteudoDTO;
import org.springframework.stereotype.Component;

@Component
public class ConteudoMapper {

    public ConteudoDTO toDto(Conteudo conteudo) {
        return ConteudoDTO.builder()
                .titulo(conteudo.titulo())
                .descricao(conteudo.descricao())
                .dataDePublicacao(conteudo.dataDePublicacao())
                .genero(conteudo.genero())
                .idioma(conteudo.idioma())
                .nota(conteudo.nota())
                .quantidadeDeVotos(conteudo.quantidadeDeVotos())
                .tipo(conteudo.tipo())
                .totalDeTemporadas(conteudo.totalDeTemporadas())
                .build();
    }

    public Conteudo toConteudo(ConteudoDTO conteudoDTO) {
        return Conteudo.builder()
                .titulo(conteudoDTO.titulo())
                .descricao(conteudoDTO.descricao())
                .dataDePublicacao(conteudoDTO.dataDePublicacao())
                .genero(conteudoDTO.genero())
                .idioma(conteudoDTO.idioma())
                .nota(conteudoDTO.nota())
                .quantidadeDeVotos(conteudoDTO.quantidadeDeVotos())
                .tipo(conteudoDTO.tipo())
                .totalDeTemporadas(conteudoDTO.totalDeTemporadas())
                .build();
    }
}
