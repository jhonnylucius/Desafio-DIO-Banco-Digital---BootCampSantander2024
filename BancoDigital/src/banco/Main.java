package banco;

public class Main {

	public static void main(String[] args) {
		Conta cc = new ContaCorrente();
		Conta poupança = new ContaPoupanca();
		
		cc.depositar(10500);
		cc.transferir(50, poupança);
		poupança.pixTransferir(320, cc);
		
		
		cc.imprimirExtrato();	
		poupança.imprimirExtrato();
	}

}