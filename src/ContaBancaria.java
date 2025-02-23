public class ContaBancaria implements Conta {

    public String nomeTitular;
    public String cpfTitular;
    public double saldo;

    public ContaBancaria(String nomeTitular, String cpfTitular, double saldo) {
        this.nomeTitular = nomeTitular;
        this.cpfTitular = cpfTitular;
        this.saldo = saldo;
    }

    @Override
    public void consultarSaldo() {
        System.out.println("Titular: " + nomeTitular + " | CPF: " + cpfTitular);
        System.out.println("Saldo atual: R$ " + saldo);
    }

    @Override
    public void sacar(double valor) {
        if (valor > 0 && valor <= saldo) {
            saldo -= valor;
            System.out.println("Saque de R$ " + valor + " realizado com sucesso.");
        } else {
            System.out.println("Saldo insuficiente ou valor inválido.");
        }
    }

    @Override
    public void depositar(double valor) {

    }
}
