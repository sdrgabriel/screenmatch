package br.com.sdrgabriel.core.exception;

public class ConteudoNaoEncontrado extends RuntimeException {
    public ConteudoNaoEncontrado() {
        super("Conteudo não encontrado");
    }
}
