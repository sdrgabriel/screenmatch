package br.com.sdrgabriel.adapters.usecase;

public interface UseCase<I, O> {

    O execute(I input);

}
