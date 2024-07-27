# Sistema Bancário Simples em Java (Terminal)</br>

- Este projeto é uma implementação básica de um sistema bancário em Java, projetado para</br> rodar no terminal. Ele permite criar contas correntes e poupança, realizar depósitos, saques,</br> transferências e gerar extratos. Os dados são armazenados em memória enquanto o</br> aplicativo está em execução.</br>
</br>

- Funcionalidades</br>
</br>

1. Criar Conta:</br>

- Permite criar contas correntes e poupança com números sequenciais únicos.</br>
</br>

2.Depositar:</br>
</br>

Permite depositar dinheiro em uma conta existente.
</br>
Solicita o número da conta e a senha para validação.
</br>
Sacar:
</br>
Permite sacar dinheiro de uma conta existente.
</br>
Solicita o número da conta e a senha para validação.</br>
</br>
3. Transferir: </br>

</br>

- Permite transferir dinheiro entre contas.< /br>

- Solicita o número da conta de origem, o número da conta de destino, o valor e a </br>senha para validação.</br>

</br>
4. Gerar Extrato:</br>

</br>

- Permite gerar um extrato com as movimentações da conta.</br>
- Solicita o número da conta e a senha para validação.</br>

</br>
5. Classes</br>
</br>

1. Banco.java: Classe principal que gerencia as contas e clientes.</br>

2. Cliente.java: Classe que representa um cliente com nome .</br>

3. Conta.java: Classe abstrata que representa uma conta bancária com atributos como</br> número, saldo, agência e cliente.</br>

4. ContaCorrente.java: Classe que representa uma conta corrente, herdando da classe Conta.</br>

5. ContaPoupanca.java: Classe que representa uma conta poupança, herdando da classe Conta.</br>

6. IConta.java: Interface que define os métodos básicos de uma conta bancária.</br>

7. Main.java: Classe com o método main que inicia o aplicativo.</br>
8. Movimentacao.java: Classe que representa uma movimentação na conta com data, </br>descrição e valor.</br>

- Próximos Passos</br>

Implementar a persistência de dados para salvar as informações das contas e </br>clientes de forma permanente.</br>
</br>
Adicionar novas funcionalidades como consulta de saldo, histórico de movimentações</br> e outras operações bancárias.</br>
</br>
Melhorar a segurança, como criptografando as senhas.</br>
</br>
Observações</br>
O código atual é uma implementação básica e pode ser aprimorado com recursos adicionais.</br>
O sistema não utiliza nenhuma interface gráfica.</br>