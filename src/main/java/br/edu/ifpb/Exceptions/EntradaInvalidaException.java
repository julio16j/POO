package br.edu.ifpb.Exceptions;

public class EntradaInvalidaException extends Exception {
    public EntradaInvalidaException(){
        super("Não digite letras senhor, finalizando...");
    }
}
