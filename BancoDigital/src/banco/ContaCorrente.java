package banco;

public class ContaCorrente extends Conta {

	@Override
	public void imprimirExtrato() {
		System.out.println("\n");
		System.out.println("*** Extrato conta Corrente ***");
		super.imprimirInformacoes();
	}
}