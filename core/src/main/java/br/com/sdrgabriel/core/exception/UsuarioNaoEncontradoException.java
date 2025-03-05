package br.com.sdrgabriel.core.exception;

public class UsuarioNaoEncontradoException extends RuntimeException {
    public UsuarioNaoEncontradoException() {
      super("Usuário não encontrado");
    }
}
