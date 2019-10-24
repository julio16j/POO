package br.edu.ifpb;


import br.edu.ifpb.Exceptions.EntradaInvalidaException;
import br.edu.ifpb.Exceptions.QuantiaNegativaException;
import br.edu.ifpb.Exceptions.SaldoInsuficienteException;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu
{
    public static void ExibirMenu(ContaCorrente conta) throws SaldoInsuficienteException, EntradaInvalidaException, QuantiaNegativaException {
        int opcao;
        double valor;
        Scanner sc = new Scanner(System.in);
        try {
            while (true) {
                System.out.println("--------------------------------------------------------------------");
                System.out.println("Digite a opção Desejada: ");
                System.out.println("(1): Saque");
                System.out.println("(2): Deposito");
                System.out.println("(3): Extratp");
                System.out.println("(4): Saldo");
                System.out.println("(5): Sair");
                opcao = sc.nextInt();
                if (opcao == 1) {
                    System.out.println("Digite a quantia que você quer: ");
                    valor = sc.nextDouble();
                    System.out.println(conta.saque(valor));
                } else if (opcao == 2) {
                    System.out.println("Digite o valor desejado para depositar : ");
                    valor = sc.nextDouble();
                    System.out.println(conta.deposito(valor));
                } else if (opcao == 3) {

                    conta.extrato();
                } else if (opcao == 4) {
                    System.out.println("O Saldo atual: R$" + conta.getSaldo());
                } else if (opcao == 5) {
                    System.out.println("Até nunca!");
                    break;
                } else {
                    System.out.println("Opção Inválida\n Digite novamente: ");
                }
            }
        } catch (InputMismatchException e){
            throw new EntradaInvalidaException();
        }
    }
    public static void main( String[] args ) throws SaldoInsuficienteException, EntradaInvalidaException, QuantiaNegativaException {
        ContaCorrente Amilton = new ContaCorrente(3232,"Amilton Neves", 5000);
        ExibirMenu(Amilton);
    }
}
