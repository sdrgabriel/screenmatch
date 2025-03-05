package br.com.sdrgabriel.infrastructure.config;

import br.com.sdrgabriel.adapters.gateway.conteudo.BuscarConteudoGateway;
import br.com.sdrgabriel.adapters.usecase.conteudo.recuperar.get.BuscarConteudoUseCase;
import br.com.sdrgabriel.application.usecaseimpl.conteudo.recuperar.get.BuscarConteudoUseCaseImpl;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ConteudoConfig {

    @Bean
    public BuscarConteudoUseCase buscarConteudoUseCase(BuscarConteudoGateway buscarConteudoGateway) {
        return new BuscarConteudoUseCaseImpl(buscarConteudoGateway);
    }

    @Bean
    public ObjectMapper objectMapper() {
        return JsonMapper.builder()
                .configure(MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES, true)
                .findAndAddModules()
                .build();
    }

    @Bean
    public RestTemplate restTemplate(ObjectMapper objectMapper) {
        MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter(objectMapper);
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getMessageConverters().addFirst(converter);
        return restTemplate;
    }
}
