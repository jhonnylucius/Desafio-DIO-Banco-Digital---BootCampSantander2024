package banco;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Extrato extends Cliente{

    private List<Movimentacao> movimentacoes;

    public Extrato() {
        this.movimentacoes = new ArrayList<>();
    }

    public void adicionarMovimentacao(Movimentacao movimentacao) {
        movimentacoes.add(movimentacao);
    }

    public void imprimirExtrato(Conta conta, LocalDate dataInicial, LocalDate dataFinal) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        System.out.println("----------------------------------------------------");
        System.out.println("Extrato da Conta");
        System.out.println("Banco: " + conta.getCliente().getNome());
        System.out.println("Cliente: " + conta.getCliente().getNome());
        System.out.println("Agência: " + conta.getAgencia());
        System.out.println("Conta: " + conta.getConta());
        System.out.println("----------------------------------------------------");

        for (Movimentacao movimentacao : movimentacoes) {
            if (movimentacao.getData().isEqual(dataInicial) ||
                movimentacao.getData().isAfter(dataInicial) &&
                movimentacao.getData().isBefore(dataFinal) ||
                movimentacao.getData().isEqual(dataFinal)) {
                System.out.println(movimentacao.getData().format(formatter) + " - " +
                                   movimentacao.getDescricao() + " - R$ " +
                                   String.format("%.2f", movimentacao.getValor()));
            }
        }

        System.out.println("----------------------------------------------------");
        System.out.println("Saldo: R$ " + String.format("%.2f", conta.getSaldo()));
        System.out.println("----------------------------------------------------");
    }
}