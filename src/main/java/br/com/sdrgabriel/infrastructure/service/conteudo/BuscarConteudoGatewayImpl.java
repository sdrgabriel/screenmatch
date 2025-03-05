package br.com.sdrgabriel.infrastructure.service.conteudo;

import br.com.sdrgabriel.adapters.gateway.conteudo.BuscarConteudoGateway;
import br.com.sdrgabriel.core.domain.Conteudo;
import br.com.sdrgabriel.core.exception.ConteudoNaoEncontrado;
import br.com.sdrgabriel.core.exception.FalhaEmConverterConteudo;
import br.com.sdrgabriel.infrastructure.dto.response.ConteudoDTO;
import br.com.sdrgabriel.infrastructure.mapper.ConteudoMapper;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

import static br.com.sdrgabriel.infrastructure.utils.Log.log;

@Service
@RequiredArgsConstructor
public class BuscarConteudoGatewayImpl implements BuscarConteudoGateway {

    @Value("${api.url}")
    private String apiUrl;
    private final RestTemplate restTemplate;
    private final ConteudoMapper conteudoMapper;
    private final ObjectMapper objectMapper;

    @Override
    public Conteudo buscar(String title) {
        log.info("Inicio da busca de conteudo para \"{}\"::BuscarConteudoGatewayImpl", title);
        Map<String, String> params = Map.of("titulo", title);
        JsonNode json = restTemplate.getForObject(apiUrl, JsonNode.class, params);
        if (json != null && json.get("Response").asText().equals("False")) {
            throw new ConteudoNaoEncontrado();
        }
        ConteudoDTO conteudoDTO;
        try {
            conteudoDTO = objectMapper.treeToValue(json, ConteudoDTO.class);
        } catch (JsonProcessingException e) {
            throw new FalhaEmConverterConteudo(e.getMessage());
        }

        log.info("Fim da busca de conteudo para \"{}\"::BuscarConteudoGatewayImpl", title);
        return conteudoMapper.toConteudo(conteudoDTO);
    }
}
