package banco;

public abstract class Conta implements IConta {
	
	private static final int AGENCIA_PADRAO = 1;
	private static int SEQUENCIAL = 1;
	protected int agencia;
	protected int numero;
	protected double saldo = 1000;
	protected double sAnterior = saldo;
	protected double vTransferido;
	
	
	
	
	public Conta() {
		this.agencia = Conta.AGENCIA_PADRAO;
		this.numero = SEQUENCIAL++;	
}

	@Override
	public void sacar(double valor) {
		
		saldo-= valor;
	}
		
	@Override
	public void sAnterior(double saldo) {
			
		sAnterior = saldo;
	}

	public double getsAnterior() {
		return sAnterior;
	}

	@Override
	public void depositar(double valor) {
		saldo += valor;
	}

	@Override
	public void transferir(double valor, IConta contaDestino) {
		this.vTransferido = valor;
		this.sacar(valor);
		contaDestino.depositar(valor);
	}
	
	@Override
	public void transferido(double valor) {
		
		vTransferido = valor;
	}
	
	@Override
	public void pixTransferir(double valor, IConta contaDestino) {
		this.vTransferido = valor;
		this.sacar(valor);
		contaDestino.depositar(valor);
	}
	
	public int getAgencia() {
		return agencia;
	}

	public int getNumero() {
		return numero;
	}

	public double getSaldo() {
		return saldo;
	}
	
	public double getvTransferido() {
		return vTransferido;
	}

	
	protected void imprimirInformacoes() {
	
		System.out.println(String.format("Agencia: %d", this.agencia));
		System.out.println(String.format("Numero: %d", this.numero));
		System.out.println(String.format("Saldo anterior: %.2f", this.sAnterior));
		System.out.println(String.format("Valor transferido: %.2f", this.vTransferido));
		System.out.println(String.format("Saldo: %.2f", this.saldo));
	}
	

}