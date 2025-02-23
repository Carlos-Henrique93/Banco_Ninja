import java.util.Scanner;

public class BancoKonoha {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ContaCorrente contaCorrente = null;
        ContaPoupanca contaPoupanca = null;
        boolean sistemaAtivo = true;

        while (sistemaAtivo) {
            System.out.println("\n--- Banco de Konoha ---");
            System.out.println("1. Abrir conta");
            System.out.println("2. Acessar conta");
            System.out.println("3. Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine(); // Limpa o buffer

            switch (opcao) {
                case 1:
                    System.out.println("Escolha o tipo de conta para abrir:");
                    System.out.println("1. Conta Corrente");
                    System.out.println("2. Conta Poupança");
                    int tipoConta = scanner.nextInt();
                    scanner.nextLine(); // Limpa o buffer

                    System.out.print("Informe o nome do titular: ");
                    String nome = scanner.nextLine();

                    System.out.print("Informe o CPF do titular: ");
                    String cpf = scanner.nextLine();

                    System.out.print("Informe o saldo inicial: ");
                    double saldoInicial = scanner.nextDouble();

                    if (tipoConta == 1) {
                        contaCorrente = new ContaCorrente(nome, cpf, saldoInicial);
                        System.out.println("Conta Corrente aberta com sucesso!");
                    } else if (tipoConta == 2) {
                        contaPoupanca = new ContaPoupanca(nome, cpf, saldoInicial);
                        System.out.println("Conta Poupança aberta com sucesso!");
                    } else {
                        System.out.println("Tipo de conta inválido.");
                    }
                    break;

                case 2:
                    if (contaCorrente == null && contaPoupanca == null) {
                        System.out.println("Nenhuma conta foi aberta ainda.");
                        break;
                    }

                    System.out.println("Escolha a conta para acessar:");
                    System.out.println("1. Conta Corrente");
                    System.out.println("2. Conta Poupança");
                    int acessoConta = scanner.nextInt();

                    ContaBancaria contaSelecionada = null;
                    if (acessoConta == 1 && contaCorrente != null) {
                        contaSelecionada = contaCorrente;
                    } else if (acessoConta == 2 && contaPoupanca != null) {
                        contaSelecionada = contaPoupanca;
                    } else {
                        System.out.println("Conta inexistente.");
                        break;
                    }

                    boolean acessarConta = true;
                    while (acessarConta) {
                        System.out.println("\n--- Menu da Conta ---");
                        System.out.println("1. Consultar saldo");
                        System.out.println("2. Depositar");
                        System.out.println("3. Sacar");
                        System.out.println("4. Voltar");
                        System.out.print("Escolha uma opção: ");
                        int opcaoConta = scanner.nextInt();

                        switch (opcaoConta) {
                            case 1:
                                contaSelecionada.consultarSaldo();
                                break;
                            case 2:
                                System.out.print("Informe o valor para depósito: ");
                                double valorDeposito = scanner.nextDouble();
                                contaSelecionada.depositar(valorDeposito);
                                break;
                            case 3:
                                System.out.print("Informe o valor para saque: ");
                                double valorSaque = scanner.nextDouble();
                                contaSelecionada.sacar(valorSaque);
                                break;
                            case 4:
                                acessarConta = false;
                                break;
                            default:
                                System.out.println("Opção inválida.");
                        }
                    }
                    break;

                case 3:
                    sistemaAtivo = false;
                    System.out.println("Saindo do sistema... Até logo!");
                    break;

                default:
                    System.out.println("Opção inválida.");
            }
        }
        scanner.close();
    }
}
