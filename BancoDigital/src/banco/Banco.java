package banco;

public class Banco {

    private String nome;
    private int codigo;

    public Banco(String nome, int codigo) {
        this.nome = nome;
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public int getCodigo() {
        return codigo;
    }

    @Override
    public String toString() {
        return "Banco{" +
                "nome='" + nome + '\'' +
                ", codigo=" + codigo +
                '}';
    }
}