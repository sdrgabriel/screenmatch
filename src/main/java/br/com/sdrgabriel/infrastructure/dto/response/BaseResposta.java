package br.com.sdrgabriel.infrastructure.dto.response;

import br.com.sdrgabriel.infrastructure.dto.response.exception.ErroResposta;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;

@Builder
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public record BaseResposta<T>(
        Boolean sucesso,
        String mensagem,
        T resposta,
        ErroResposta erro
) {
}
