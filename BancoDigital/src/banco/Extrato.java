package banco;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Extrato extends Cliente{

    private List<Movimentacao> movimentacoes;
    private Cliente cliente; // Adicione este atributo

    public Extrato() {
        super(nome, endereco);
        this.movimentacoes = new ArrayList<>();
    }

    public Extrato(String nome, String endereco, List<Movimentacao> movimentacoes, Cliente cliente) {
        super(nome, endereco);
        this.movimentacoes = movimentacoes;
        this.cliente = cliente;
    }

    // Construtor que recebe o objeto Cliente

   public Extrato(Cliente cliente) { 
        super(getNome(), getEndereco());
        this.movimentacoes = new ArrayList<>();
        this.cliente = cliente; // Atribua o cliente ao atributo
    }

    public void imprimirExtrato(Conta conta, LocalDate dataInicial, LocalDate dataFinal) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        System.out.println("----------------------------------------------------");
        System.out.println("Extrato da Conta");

        // Utilize o atributo banco
        // Utilize o atributo cliente
        
        System.out.println("Banco: " + BancoGui.getNome()); 
        System.out.println("Cliente: " + this.cliente.getNome()); 
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