package br.com.sdrgabriel.application.usecaseimpl.conteudo.recuperar.get;

import br.com.sdrgabriel.adapters.gateway.conteudo.BuscarConteudoGateway;
import br.com.sdrgabriel.adapters.usecase.conteudo.recuperar.get.BuscarConteudoUseCase;
import br.com.sdrgabriel.core.domain.Conteudo;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class BuscarConteudoUseCaseImpl implements BuscarConteudoUseCase {

    private final BuscarConteudoGateway buscarConteudoGateway;

    @Override
    public Conteudo execute(String input) {
        return buscarConteudoGateway.buscar(input);
    }
}
