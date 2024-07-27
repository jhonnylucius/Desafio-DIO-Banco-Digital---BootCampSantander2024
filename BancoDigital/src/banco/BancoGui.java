package banco;

import javax.swing.*;
import javax.swing.text.JTextComponent;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalField;
import java.util.Locale;

public class BancoGui extends JFrame {

   
    private JTextField txtNomeCliente;
    private JTextField txtEnderecoCliente;
    private JTextField txtSenha;
    private JTextField txtNomeEvento;
    private JTextField txtDescricaoEvento;
    private JRadioButton rdCorrente;
    private JRadioButton rdPoupanca;
    private JTextField txtValor;
    private JTextField txtDataInicial;
    private JTextField txtDataFinal;
    private Extrato extrato;
    private JTextArea txtAreaExtrato;
    private Banco banco;
    private BancoGui bancoGUI;


    public BancoGui(BancoGui banco) {
        this.banco = new Banco("Banco Código", 12345);
        this.extrato = new Extrato();
        this.bancoGUI = new BancoGui(banco);
        setTitle("Sistema Bancário");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);
        setLayout(new BorderLayout());

        // Painel para os dados do cliente
        JPanel painelCliente = new JPanel(new GridLayout(3, 2, 10, 10));
        painelCliente.setBorder(BorderFactory.createTitledBorder("Dados do Cliente"));

        JLabel lblNome = new JLabel("Nome:");
        txtNomeCliente = new JTextField();
        painelCliente.add(lblNome);
        painelCliente.add(txtNomeCliente);

        JLabel lblEndereco = new JLabel("Endereço:");
        txtEnderecoCliente = new JTextField();
        painelCliente.add(lblEndereco);
        painelCliente.add(txtEnderecoCliente);

        JLabel lblSenha = new JLabel("Senha:");
        txtSenha = new JTextField();
        painelCliente.add(lblSenha);
        painelCliente.add(txtSenha);

        // Painel para os dados do evento
        JPanel painelEvento = new JPanel(new GridLayout(4, 2, 10, 10));
        painelEvento.setBorder(BorderFactory.createTitledBorder("Dados do Evento"));

        JLabel lblNomeEvento = new JLabel("Nome do Evento:");
        txtNomeEvento = new JTextField();
        painelEvento.add(lblNomeEvento);
        painelEvento.add(txtNomeEvento);

        JLabel lblDescricaoEvento = new JLabel("Descrição do Evento:");
        txtDescricaoEvento = new JTextField();
        painelEvento.add(lblDescricaoEvento);
        painelEvento.add(txtDescricaoEvento);

        JLabel lblTipoConta = new JLabel("Tipo de Conta:");
        rdCorrente = new JRadioButton("Corrente");
        rdPoupanca = new JRadioButton("Poupança");
        ButtonGroup grupoTipoConta = new ButtonGroup();
        grupoTipoConta.add(rdCorrente);
        grupoTipoConta.add(rdPoupanca);
        painelEvento.add(lblTipoConta);
        painelEvento.add(rdCorrente);
        painelEvento.add(rdPoupanca);

        // Painel para a operação
        JPanel painelOperacao = new JPanel(new GridLayout(3, 2, 10, 10));
        painelOperacao.setBorder(BorderFactory.createTitledBorder("Operação"));

        JLabel lblValor = new JLabel("Valor:");
        txtValor = new JTextField();
        painelOperacao.add(lblValor);
        painelOperacao.add(txtValor);

        JLabel lblDataInicial = new JLabel("Data Inicial (dd/MM/yyyy):");
        txtDataInicial = new JTextField();
        painelOperacao.add(lblDataInicial);
        painelOperacao.add(txtDataInicial);

        JLabel lblDataFinal = new JLabel("Data Final (dd/MM/yyyy):");
        txtDataFinal = new JTextField();
        painelOperacao.add(lblDataFinal);
        painelOperacao.add(txtDataFinal);

        // Painel para os botões
        JPanel painelBotoes = new JPanel(new FlowLayout());

        JButton btnCriarConta = new JButton("Criar Conta");
        btnCriarConta.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                criarConta();
            }
        });

        JButton btnDepositar = new JButton("Depositar");
        btnDepositar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                depositar(txtAreaExtrato, txtAreaExtrato, null);
            }
        });

        JButton btnSacar = new JButton("Sacar");
        btnSacar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sacar();
            }
        });

        JButton btnTransferir = new JButton("Transferir");
        btnTransferir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                transferir();
            }
        });

        JButton btnGerarExtrato = new JButton("Gerar Extrato");
        btnGerarExtrato.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gerarExtrato();
            }
        });

        painelBotoes.add(btnCriarConta);
        painelBotoes.add(btnDepositar);
        painelBotoes.add(btnSacar);
        painelBotoes.add(btnTransferir);
        painelBotoes.add(btnGerarExtrato);

        // Painel para o extrato
        JPanel painelExtrato = new JPanel(new BorderLayout());
        painelExtrato.setBorder(BorderFactory.createTitledBorder("Extrato"));

        txtAreaExtrato = new JTextArea();
        txtAreaExtrato.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(txtAreaExtrato);
        painelExtrato.add(scrollPane, BorderLayout.CENTER);

        // Adicionando painéis à tela
        add(painelCliente, BorderLayout.NORTH);
        add(painelEvento, BorderLayout.CENTER);
        add(painelOperacao, BorderLayout.WEST);
        add(painelBotoes, BorderLayout.SOUTH);
        add(painelExtrato, BorderLayout.EAST);

        setVisible(true);
    }

    protected void transferir() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'transferir'");
    }

    protected void sacar() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'sacar'");
    }

    private void criarConta() {
        String nomeCliente = txtNomeCliente.getText();
        String enderecoCliente = txtEnderecoCliente.getText();
        String senha = txtSenha.getText();

        if (nomeCliente.isEmpty() || enderecoCliente.isEmpty() || senha.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Preencha todos os campos.");
            return;
        }

        Cliente cliente = new Cliente(nomeCliente, enderecoCliente);
        Conta conta;
        if (rdCorrente.isSelected()) {
            conta = new ContaCorrente(cliente, senha);
            System.out.println("Conta Corrente criada com sucesso! " + conta);
        } else if (rdPoupanca.isSelected()) {
            conta = new ContaPoupanca(cliente, senha);
            System.out.println("Conta Poupança criada com sucesso! " + conta);
        } else {
            JOptionPane.showMessageDialog(this, "Selecione um tipo de conta.");
            return;
        }

        JOptionPane.showMessageDialog(this, "Conta criada com sucesso! \nDados da Conta: \n" + conta);
    }

    private void depositar(JTextComponent txtAgencia, JTextComponent txtConta, LocalDate contas) {
        if (txtValor.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Informe o valor do depósito.");
            return;
        }

        try {
            double valor = Double.parseDouble(txtValor.getText());
String senhaDigitada = JOptionPane.showInputDialog(this, "Digite a senha da conta:");

if (senhaDigitada != null && !senhaDigitada.isEmpty()) {
    // TODO: Implementar lógica de busca da conta para depósito
    String agencia = txtAgencia.getText();
    String contaNumero = txtConta.getText();
    Conta conta = contas.get(contaNumero); // Buscar a conta (corrente ou poupança) usando a agência, conta e senha digitada

    if (conta != null && conta.getAgencia().equals(agencia) && conta.validarSenha(senhaDigitada)) {
        // TODO: Realizar o depósito
        conta.depositar(valor, contaNumero);
        
        // Mostrar mensagem de sucesso
        JOptionPane.showMessageDialog(this, "Depósito realizado com sucesso.");
    } else {
        // Conta não encontrada ou senha incorreta
        JOptionPane.showMessageDialog(this, "Conta não encontrada ou senha incorreta.");
    }
} else {
    // Senha não digitada
    JOptionPane.showMessageDialog(this, "Depósito cancelado. Senha não foi digitada.");
}
    }

    private void sacar(JTextComponent txtAgencia) {
        if (txtValor.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Informe o valor do saque.");
            return;
        }

        try {
            double valor = Double.parseDouble(txtValor.getText());
            String senhaDigitada = JOptionPane.showInputDialog(this, "Digite a senha da conta:");
            
            if (senhaDigitada != null && !senhaDigitada.isEmpty()) {
                // TODO: Implementar lógica de busca da conta para depósito
                String agencia = txtAgencia.getText();
                String contaNumero = txtConta.getText();
                Conta conta = contas.get(contaNumero); // Buscar a conta (corrente ou poupança) usando a agência, conta e senha digitada
            
                if (conta != null && conta.getAgencia().equals(agencia) && conta.validarSenha(senhaDigitada)) {
                    // TODO: Realizar o depósito
                    conta.depositar(valor);
                    
                    // Mostrar mensagem de sucesso
                    JOptionPane.showMessageDialog(this, "Depósito realizado com sucesso.");
                } else {
                    // Conta não encontrada ou senha incorreta
                    JOptionPane.showMessageDialog(this, "Conta não encontrada ou senha incorreta.");
                }
            } else {
                // Senha não digitada
                JOptionPane.showMessageDialog(this, "Depósito cancelado. Senha não foi digitada.");
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Valor inválido.");
        }
    }

    private void transferir(LocalDate contas) {
        if (txtValor.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Informe o valor da transferência.");
            return;
        }

        try {
            double valor = Double.parseDouble(txtValor.getText());
        String senhaDigitada = JOptionPane.showInputDialog(this, "Digite a senha da conta de origem:");
        
        if (senhaDigitada != null && !senhaDigitada.isEmpty()) {
            // TODO: Implementar lógica de busca da conta de origem
            String agenciaOrigem = JOptionPane.showInputDialog(this, "Digite a agência da conta de origem:");
            TemporalField contaOrigemNumero = JOptionPane.showInputDialog(this, "Digite o número da conta de origem:");
            Conta contaOrigem = contas.get(contaOrigemNumero); // Buscar a conta de origem

            if (contaOrigem != null && contaOrigem.getAgencia().equals(agenciaOrigem) && contaOrigem.validarSenha(senhaDigitada)) {
                // TODO: Solicitar dados da conta de destino
                String agenciaDestino = JOptionPane.showInputDialog(this, "Digite a agência da conta de destino:");
                String contaDestinoNumero = JOptionPane.showInputDialog(this, "Digite o número da conta de destino:");
                Conta contaDestino = contas.get(contaDestinoNumero); // Buscar a conta de destino

                // TODO: Validar se a conta de destino existe
                if (contaDestino != null && contaDestino.getAgencia().equals(agenciaDestino)) {
                    // TODO: Realizar a transferência
                    contaOrigem.transferir(valor, contaDestino);

                    // Mostrar mensagem de sucesso
                    JOptionPane.showMessageDialog(this, "Transferência realizada com sucesso.");
                } else {
                    JOptionPane.showMessageDialog(this, "Conta de destino não encontrada.");
                }
            } else {
                JOptionPane.showMessageDialog(this, "Conta de origem não encontrada ou senha incorreta.");
            }
        } else {
            JOptionPane.showMessageDialog(this, "Senha inválida.");
        }
    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(this, "Valor inválido.");
    }
        
    

    private void gerarExtrato() {
        String agencia = JOptionPane.showInputDialog(this, "Digite a agência da conta:");
        String contaNumero = JOptionPane.showInputDialog(this, "Digite o número da conta:");
        String senhaDigitada = JOptionPane.showInputDialog(this, "Digite a senha da conta:");
        
        if (agencia == null || contaNumero == null || senhaDigitada == null ||
            agencia.isEmpty() || contaNumero.isEmpty() || senhaDigitada.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Todos os campos devem ser preenchidos.");
            return;
        }
    
        Conta conta = banco.buscarConta(agencia, contaNumero); // Implementar o método buscarConta no banco
    
        if (conta != null && conta.validarSenha(senhaDigitada)) {
            try {
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy", Locale.ENGLISH);
                LocalDate dataInicial = LocalDate.parse(txtDataInicial.getText(), formatter);
                LocalDate dataFinal = LocalDate.parse(txtDataFinal.getText(), formatter);
    
                if (dataInicial.isAfter(dataFinal)) {
                    JOptionPane.showMessageDialog(this, "A data inicial deve ser anterior à data final.");
                    return;
                }
    
                String extrato = conta.gerarExtrato(dataInicial, dataFinal); // Implementar o método gerarExtrato na classe Conta
                txtAreaExtrato.setText(extrato);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Erro ao gerar o extrato: " + e.getMessage());
            }
        } else {
            JOptionPane.showMessageDialog(this, "Conta não encontrada ou senha incorreta.");
        }
    
    

    public static String getNome() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getNome'");
    }
}
}
}

