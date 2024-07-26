package banco;

public class Main {

    public static void main(String[] args) {
        Banco banco = new Banco("Banco do Código", 12345);
        BancoGUI gui = new BancoGUI(banco);
    }
}