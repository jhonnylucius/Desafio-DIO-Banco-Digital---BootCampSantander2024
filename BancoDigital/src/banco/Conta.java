package banco;
public abstract class Conta {

    private static int proximoNumeroConta = 1;
    protected int agencia;
    protected int conta;
    private String senha;
    protected double saldo;
    protected Cliente cliente;

    public Conta(Cliente cliente, String senha) {
        this.agencia = 420; // Agência sempre 420
        this.conta = proximoNumeroConta++;
        this.senha = senha;
        this.saldo = 0;
        this.cliente = cliente;
    }

    public int getAgencia() {
        return agencia;
    }

    public int getConta() {
        return conta;
    }

    public double getSaldo() {
        return saldo;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public boolean verificarSenha(String senhaDigitada) {
        return this.senha.equals(senhaDigitada);
    }

    public void depositar(double valor, String senhaDigitada) {
        if (verificarSenha(senhaDigitada)) {
            this.saldo += valor;
            System.out.println("Depósito de R$ " + valor + " realizado com sucesso.");
        } else {
            System.out.println("Senha incorreta.");
        }
    }

    public void sacar(double valor, String senhaDigitada) {
        if (verificarSenha(senhaDigitada)) {
            if (valor <= saldo) {
                this.saldo -= valor;
                System.out.println("Saque de R$ " + valor + " realizado com sucesso.");
            } else {
                System.out.println("Saldo insuficiente.");
            }
        } else {
            System.out.println("Senha incorreta.");
        }
    }

    public void transferir(double valor, Conta contaDestino, String senhaDigitada) {
        if (verificarSenha(senhaDigitada)) {
            if (valor <= saldo && this.agencia == contaDestino.agencia) {
                this.sacar(valor, senhaDigitada);
                contaDestino.depositar(valor, contaDestino.senha);
                System.out.println("Transferência de R$ " + valor + " realizada com sucesso.");
            } else {
                if (this.agencia != contaDestino.agencia) {
                    System.out.println("Transferência para outra agência não permitida.");
                } else {
                    System.out.println("Saldo insuficiente.");
                }
            }
        } else {
            System.out.println("Senha incorreta.");
        }
    }

    @Override
    public String toString() {
        return "Conta{" +
                "agencia=" + agencia +
                ", conta=" + conta +
                ", saldo=" + saldo +
                ", cliente=" + cliente +
                '}';
    }
}