package br.edu.ifpb.Exceptions;

public class SaldoInsuficienteException extends Exception {
    public SaldoInsuficienteException( String msg ) {
        super( msg );
    }

    public SaldoInsuficienteException() {
        super( "Saldo Insuficiente, finalizando..." );
    }
}
