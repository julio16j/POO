package br.edu.ifpb;

import br.edu.ifpb.Exceptions.QuantiaNegativaException;
import br.edu.ifpb.Exceptions.SaldoInsuficienteException;

import java.util.*;

public class ContaCorrente {

    private int numero;
    private String titular;
    private double saldo;
    private HashSet<Double> ExtratoLi;
    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public double getSaldo() {
        return saldo;
    }

    public boolean deposito(double valorDEP) throws QuantiaNegativaException {
        if(valorDEP < 0){
            throw new QuantiaNegativaException();
        }
        this.saldo += valorDEP ;
        ExtratoLi.add(this.saldo);
        return true;
    }

    public boolean saque(double valorSAQ) throws SaldoInsuficienteException, QuantiaNegativaException {
        if(valorSAQ < 0){
            throw new QuantiaNegativaException();
        }
        if(valorSAQ > this.saldo){
            throw new SaldoInsuficienteException();
        }
        this.saldo -= valorSAQ ;
        ExtratoLi.add(this.saldo);
        return true;
    }

    @Override
    public String toString() {
        return "ContaCorrente{" +
                "numero=" + numero +
                ", titular='" + titular + '\'' +
                ", saldo=" + saldo +
                '}';
    }

    public void extrato(){
        for(int i = 1 ; i < this.ExtratoLi.size(); i++){
            double Resultado = Buscar(i, (HashSet<Double>) ExtratoLi) - Buscar(i-1, (HashSet<Double>) ExtratoLi);
            //if ( Resultado > 0){
                System.out.println("Transacao:\n" +
                                   "   SaldoIni: "+ Buscar(i-1, (HashSet<Double>) ExtratoLi)+"\n"+
                                   "   Movimentação: "+ Resultado + "\n"+
                                   "   SaldoFini: "+ Buscar(i, (HashSet<Double>) ExtratoLi));
            /*} else{
                System.out.println("Saque:\n" +
                        "   SaldoIni: "+ Buscar(i-1, (HashSet<Double>) ExtratoLi)+"\n"+
                        "   Movimentação: "+ Resultado + "\n"+
                        "   SaldoFini: "+ Buscar(i, (HashSet<Double>) ExtratoLi));
            }*/
        }
    }

     public static Double Buscar(int posicao, HashSet<Double> lista)
    {
        int contador = 0;
        if (lista.size() >= posicao) {
            for (Double obj : lista) {
                if (contador == posicao) return obj;
                else contador++;
            }
        }

        return null;
    }



    public ContaCorrente(int numero, String titular, double saldo) {
        this.numero = numero;
        this.titular = titular;
        this.saldo = saldo;
        this.ExtratoLi = new HashSet<>();
        this.ExtratoLi.add(this.saldo);
    }

    public ContaCorrente() {
        this.titular = "Joao";
        this.numero = 0;
        this.saldo = 50;
        this.ExtratoLi = new HashSet<>();
        this.ExtratoLi.add(this.saldo);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ContaCorrente)) return false;
        ContaCorrente that = (ContaCorrente) o;
        return getNumero() == that.getNumero();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getNumero());
    }
}
