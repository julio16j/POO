package br.edu.ifpb;

import br.edu.ifpb.Exceptions.QuantiaNegativaException;
import br.edu.ifpb.Exceptions.SaldoInsuficienteException;

import java.util.ArrayList;

public class ContaCorrente {
    private int numero;
    private String titular;
    private double saldo;
    private ArrayList<Double> ExtratoLi;
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
        ExtratoLi.add(this.saldo + valorDEP);
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
        ExtratoLi.add(this.saldo - valorSAQ);
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
            double Resultado = ExtratoLi.get(i) - ExtratoLi.get(i-1);
            if ( Resultado > 0){
                System.out.println("Deposito:\n" +
                                   "   SaldoIni: "+ ExtratoLi.get(i-1)+"\n"+
                                   "   Movimentação: "+ Resultado + "\n"+
                                   "   SaldoFini: "+ ExtratoLi.get(i));
            } else{
                System.out.println("Saque:\n" +
                        "   SaldoIni: "+ ExtratoLi.get(i-1)+"\n"+
                        "   Movimentação: "+ Resultado + "\n"+
                        "   SaldoFini: "+ ExtratoLi.get(i));
            }
        }
    }

    public ContaCorrente(int numero, String titular, double saldo) {
        this.numero = numero;
        this.titular = titular;
        this.saldo = saldo;
        this.ExtratoLi = new ArrayList<Double>();
        this.ExtratoLi.add(this.saldo);
    }

    public ContaCorrente() {
        this.titular = "Joao";
        this.numero = 0;
        this.saldo = 50;
        this.ExtratoLi = new ArrayList<Double>();
        this.ExtratoLi.add(this.saldo);
    }


}
