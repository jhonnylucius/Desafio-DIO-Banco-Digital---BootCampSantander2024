package banco;

public interface IConta {
	
	void sAnterior(double saldo);
	
	void sacar(double valor);
	
	void depositar (double valor);
	
	void transferido(double valor);
		
	void transferir(double valor, IConta contaDestino);	

	void imprimirExtrato();

	void pixTransferir(double valor, IConta contaDestino);
	
	
	
}