package banco;

import java.time.LocalDate;

public class Movimentacao {

    private LocalDate data;
    private String descricao;
    private double valor;

    public Movimentacao(LocalDate data, String descricao, double valor) {
        this.data = data;
        this.descricao = descricao;
        this.valor = valor;
    }

    public LocalDate getData() {
        return data;
    }

    public String getDescricao() {
        return descricao;
    }

    public double getValor() {
        return valor;
    }

    @Override
    public String toString() {
        return "Movimentacao{" +
                "data=" + data +
                ", descricao='" + descricao + '\'' +
                ", valor=" + valor +
                '}';
    }
}