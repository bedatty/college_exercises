package com.mycompany.gerenciabanco;

/**
 *
 * @author Lucas Bedatty
 */
import java.util.Scanner;

class ContaBancaria {
    private String nome;
    private String sobrenome;
    private String cpf;
    private double saldo;

    public ContaBancaria(String nome, String sobrenome, String cpf) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.cpf = cpf;
        this.saldo = 0.0;
    }

    public void exibirMenu() {
        System.out.println("\nMenu do Banco:");
        System.out.println("1. Consultar Saldo");
        System.out.println("2. Depositar");
        System.out.println("3. Sacar");
        System.out.println("4. Sair");
        System.out.print("Digite sua escolha: ");
    }

    public void consultarSaldo() {
        System.out.println("Saldo: R$" + saldo);
    }

    public void depositar(double valor) {
        saldo += valor;
        System.out.println("Deposito realizado com sucesso. Novo saldo: R$" + saldo);
    }

    public void sacar(double valor) {
        if (saldo >= valor) {
            saldo -= valor;
            System.out.println("Saque realizado com sucesso. Novo saldo: R$" + saldo);
        } else {
            System.out.println("Saldo insuficiente. Saque nao realizado.");
        }
    }

    public String getNomeCompleto() {
        return nome + " " + sobrenome;
    }
}

public class GerenciaBanco {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Bem-vindo ao Aplicativo de Gerenciamento Bancario!");

        System.out.print("Digite seu nome: ");
        String nome = scanner.nextLine();

        System.out.print("Digite seu sobrenome: ");
        String sobrenome = scanner.nextLine();

        System.out.print("Digite seu CPF: ");
        String cpf = scanner.nextLine();

        ContaBancaria contaUsuario = new ContaBancaria(nome, sobrenome, cpf);

        int escolha;
        do {
            contaUsuario.exibirMenu();
            escolha = scanner.nextInt();

            switch (escolha) {
                case 1 -> contaUsuario.consultarSaldo();
                case 2 -> {
                    System.out.print("Digite o valor do deposito: R$");
                    double valorDeposito = scanner.nextDouble();
                    contaUsuario.depositar(valorDeposito);
                }
                case 3 -> {
                    System.out.print("Digite o valor do saque: R$");
                    double valorSaque = scanner.nextDouble();
                    contaUsuario.sacar(valorSaque);
                }
                case 4 -> System.out.println("Ate logo, " + contaUsuario.getNomeCompleto() + "!");
                default -> System.out.println("Escolha invalida. Por favor, tente novamente.");
            }
        } while (escolha != 4);

        scanner.close();
    }
}