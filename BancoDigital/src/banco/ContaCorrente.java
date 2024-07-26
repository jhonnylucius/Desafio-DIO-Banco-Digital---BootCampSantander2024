package banco;

public class ContaCorrente extends Conta {

    public ContaCorrente(Cliente cliente, String senha) {
        super(cliente, senha);
        this.conta = this.conta + "C";
    }

    @Override
    public String toString() {
        return "ContaCorrente{" +
               "agencia=" + agencia +
               ", conta=" + conta +
               ", saldo=" + saldo +
               ", cliente=" + cliente +
               '}';
    }
}