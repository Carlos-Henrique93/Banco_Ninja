public class ContaCorrente extends ContaBancaria{

    public ContaCorrente(String nomeTitular, String cpfTitular, double saldo) {
        super(nomeTitular, cpfTitular, saldo);
    }

    @Override
    public void depositar(double valor) {
        if (valor > 0) {
            saldo += valor;
            System.out.println("Depósito de R$ " + valor + " realizado com sucesso: " + nomeTitular);
        } else {
            System.out.println("Valor de depósito inválido.");
        }
    }
}

