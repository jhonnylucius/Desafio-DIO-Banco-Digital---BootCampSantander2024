package banco;
public class ContaPoupanca extends Conta {

    public ContaPoupanca(Cliente cliente, String senha) {
        super(cliente, senha);
        this.conta = this.conta + "P";
    }

    @Override
    public String toString() {
        return "ContaPoupanca{" +
               "agencia=" + agencia +
               ", conta=" + conta +
               ", saldo=" + saldo +
               ", cliente=" + cliente +
               '}';
    }
}