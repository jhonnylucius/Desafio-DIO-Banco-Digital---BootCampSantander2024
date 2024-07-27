package banco;
public class ContaPoupanca extends Conta {
	
	@Override
	public void imprimirExtrato() {
		System.out.println("\n");
		System.out.println("*** Extrato conta Poupança ***");
		super.imprimirInformacoes();
	}

}