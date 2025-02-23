public class ContaPoupanca extends ContaBancaria{

    public ContaPoupanca(String nomeTitular, String cpfTitular, double saldo) {
        super(nomeTitular, cpfTitular, saldo);
    }

    @Override
    public void depositar(double valor) {
        if (valor > 0) {
            double valorComTaxa = valor * 0.99; // Deduz 1% do valor depositado
            saldo += valorComTaxa;
            System.out.println("Depósito de R$ " + valorComTaxa + " realizado com sucesso após taxa de 1%.");
        } else {
            System.out.println("Valor de depósito inválido.");
        }
    }

}
