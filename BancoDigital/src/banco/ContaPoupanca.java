package banco;

import java.time.LocalDate;

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

    @Override
    protected boolean validarSenha(String senhaDigitada) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'validarSenha'");
    }

    @Override
    protected String gerarExtrato(LocalDate dataInicial, LocalDate dataFinal) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'gerarExtrato'");
    }
}