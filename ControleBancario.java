/******************************************************************************
 
 Programa de exemplo de controle de conta bancaria usando orientação a objetos
 no modo console com menu de opções usando as operações de depositar, sacar e 
 consultar-saldo. 

*******************************************************************************/
import java.util.Scanner;

class ContaBancaria {
    private String titular;
    private double saldo;

    public ContaBancaria(String titular) {
        this.titular = titular;
        this.saldo = 0.0;
    }

    public void depositar(double valor) {
        if (valor > 0) {
            saldo += valor;
            System.out.println("Depósito de R$ " + valor + " realizado com sucesso.");
        } else {
            System.out.println("Valor de depósito inválido.");
        }
    }

    public void sacar(double valor) {
        if (valor > 0 && valor <= saldo) {
            saldo -= valor;
            System.out.println("Saque de R$ " + valor + " realizado com sucesso.");
        } else {
            System.out.println("Valor de saque inválido ou saldo insuficiente.");
        }
    }

    public double consultarSaldo() {
        return saldo;
    }

    public String getTitular() {
        return titular;
    }
}

public class ControleBancario {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite o nome do titular da conta: ");
        String nomeTitular = scanner.nextLine();
        ContaBancaria conta = new ContaBancaria(nomeTitular);

        int opcao;
        do {
            System.out.println("\nMenu de Operações:");
            System.out.println("1. Depositar");
            System.out.println("2. Sacar");
            System.out.println("3. Consultar Saldo");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    System.out.print("Digite o valor a ser depositado: ");
                    double valorDeposito = scanner.nextDouble();
                    conta.depositar(valorDeposito);
                    break;
                case 2:
                    System.out.print("Digite o valor a ser sacado: ");
                    double valorSaque = scanner.nextDouble();
                    conta.sacar(valorSaque);
                    break;
                case 3:
                    System.out.printf("Saldo atual: R$ %.2f\n", conta.consultarSaldo());
                    break;
                case 0:
                    System.out.println("Saindo do programa...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 0);

        scanner.close();
    }
}
