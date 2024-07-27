package banco;

import java.time.LocalDate;

public class ContaCorrente extends Conta {

    public ContaCorrente(Cliente cliente, String senha) {
        super(cliente, senha);
        this.conta = this.conta + "c";
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