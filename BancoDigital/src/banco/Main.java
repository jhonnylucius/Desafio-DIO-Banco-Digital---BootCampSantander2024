package banco;
public class Main {

    public static <BancoGUI> void main(String[] args, String nome, int codigo) {
        BancoGUI gui = (BancoGUI) new Banco(nome, codigo); // Cria a interface gráfica
    }
}