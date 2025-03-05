package br.com.sdrgabriel.infrastructure.service.usuario;

import br.com.sdrgabriel.adapters.gateway.usuario.RecuperarTodosUsuariosGateway;
import br.com.sdrgabriel.adapters.usecase.usuario.recuperar.list.RecuperarTodosUsuariosInput;
import br.com.sdrgabriel.adapters.usecase.usuario.recuperar.list.RecuperarTodosUsuariosOutput;
import br.com.sdrgabriel.infrastructure.mapper.UsuarioMapper;
import br.com.sdrgabriel.infrastructure.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

import static br.com.sdrgabriel.infrastructure.utils.Log.log;

@Service
@RequiredArgsConstructor
public class RecuperarTodosUsuariosGatewayImpl implements RecuperarTodosUsuariosGateway {

    private final UsuarioMapper usuarioMapper;
    private final UsuarioRepository usuarioRepository;

    @Override
    public RecuperarTodosUsuariosOutput recuperar(RecuperarTodosUsuariosInput input) {
        log.info("Inicio da Listagem de usuários::RecuperarTodosUsuariosGatewayImpl");
        var pageable = PageRequest.of(input.page(), input.size());
        var usuarios = usuarioRepository.findAll(pageable);
        log.info("Fim da Listagem de usuários::RecuperarTodosUsuariosGatewayImpl");
        return RecuperarTodosUsuariosOutput.builder()
                .page(usuarios.getNumber())
                .size(usuarios.getSize())
                .total(usuarios.getTotalElements())
                .totalPages(usuarios.getTotalPages())
                .usuarios(usuarios.getContent().stream().map(usuarioMapper::toUsuario).collect(Collectors.toList()))
                .build();
    }
}
