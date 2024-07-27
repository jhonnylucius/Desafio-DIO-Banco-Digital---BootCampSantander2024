package banco;


public class Cliente {

    protected static String nome;
    protected static String endereco;

    protected Cliente(String nome, String endereco) {
        Cliente.nome = nome;
        Cliente.endereco = endereco;
    }

    // Getters
    public static String getNome() {
        return nome;
    }

    public static String getEndereco() {
        return endereco;
    }

    // Setters (métodos protegidos)
    protected void setNome(String nome) {
        Cliente.nome = nome;
    }

    protected void setEndereco(String endereco) {
        Cliente.endereco = endereco;
    }

   
}