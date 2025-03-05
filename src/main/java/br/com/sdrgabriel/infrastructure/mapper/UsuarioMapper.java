package br.com.sdrgabriel.infrastructure.mapper;

import br.com.sdrgabriel.adapters.usecase.usuario.recuperar.list.RecuperarTodosUsuariosOutput;
import br.com.sdrgabriel.core.domain.Usuario;
import br.com.sdrgabriel.infrastructure.dto.request.CriarUsuarioForm;
import br.com.sdrgabriel.infrastructure.dto.request.LogarUsuarioForm;
import br.com.sdrgabriel.infrastructure.dto.response.UsuarioDTO;
import br.com.sdrgabriel.infrastructure.dto.response.UsuarioPaginadoDTO;
import br.com.sdrgabriel.infrastructure.entity.UsuarioEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UsuarioMapper {

    public Usuario toUsuario(CriarUsuarioForm usuario) {
        return Usuario.builder()
                .nome(usuario.nome())
                .senha(new BCryptPasswordEncoder().encode(usuario.senha()))
                .email(usuario.email())
                .cargo(usuario.cargo())
                .build();
    }

    public Usuario toUsuario(LogarUsuarioForm usuario) {
        return Usuario.builder()
                .nome(usuario.nome())
                .senha(usuario.senha())
                .build();
    }

    public Usuario toUsuario(UsuarioEntity usuario) {
        return Usuario.builder()
                .id(usuario.getId())
                .nome(usuario.getNome())
                .senha(usuario.getSenha())
                .email(usuario.getEmail())
                .cargo(usuario.getCargo())
                .build();
    }

    public UsuarioDTO toUsuarioDTO(Usuario usuario) {
        return UsuarioDTO.builder()
                .id(usuario.id())
                .nome(usuario.nome())
                .email(usuario.email())
                .build();
    }

    public UsuarioPaginadoDTO toUsuarioPaginadoDTO(RecuperarTodosUsuariosOutput output) {
        return UsuarioPaginadoDTO.builder()
                .size(output.size())
                .page(output.page())
                .totalPages(output.totalPages())
                .usuarios(output.usuarios().stream()
                        .map(this::toUsuarioDTO)
                        .toList())
                .total(output.total())
                .build();
    }

    public UsuarioEntity toEntity(Usuario usuario) {
        return UsuarioEntity.builder()
                .nome(usuario.nome())
                .senha(usuario.senha())
                .email(usuario.email())
                .cargo(usuario.cargo())
                .build();
    }

}
