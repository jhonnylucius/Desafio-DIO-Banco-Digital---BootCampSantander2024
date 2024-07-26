package banco;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class BancoGui extends JFrame {

    private BancoGui banco;
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

    public BancoGui(BancoGui banco) {
        this.banco = banco;
        this.extrato = new Extrato();
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
                depositar();
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

    private void depositar() {
        if (txtValor.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Informe o valor do depósito.");
            return;
        }

        try {
            double valor = Double.parseDouble(txtValor.getText());
            String senhaDigitada = JOptionPane.showInputDialog(this, "Digite a senha da conta:");
            if (senhaDigitada != null && !senhaDigitada.isEmpty()) {
                // TODO: Implementar lógica de busca da conta para depósito
                // Buscar a conta (corrente ou poupança) usando a agência, conta e senha digitada
                // ...
                // Realizar o depósito
                // ...
                // Mostrar mensagem de sucesso
                JOptionPane.showMessageDialog(this, "Depósito realizado com sucesso.");
            } else {
                JOptionPane.showMessageDialog(this, "Senha inválida.");
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Valor inválido.");
        }
    }

    private void sacar() {
        if (txtValor.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Informe o valor do saque.");
            return;
        }

        try {
            double valor = Double.parseDouble(txtValor.getText());
            String senhaDigitada = JOptionPane.showInputDialog(this, "Digite a senha da conta:");
            if (senhaDigitada != null && !senhaDigitada.isEmpty()) {
                // TODO: Implementar lógica de busca da conta para saque
                // Buscar a conta (corrente ou poupança) usando a agência, conta e senha digitada
                // ...
                // Realizar o saque
                // ...
                // Mostrar mensagem de sucesso ou erro
                // ...
            } else {
                JOptionPane.showMessageDialog(this, "Senha inválida.");
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Valor inválido.");
        }
    }

    private void transferir() {
        if (txtValor.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Informe o valor da transferência.");
            return;
        }

        try {
            double valor = Double.parseDouble(txtValor.getText());
            String senhaDigitada = JOptionPane.showInputDialog(this, "Digite a senha da conta de origem:");
            if (senhaDigitada != null && !senhaDigitada.isEmpty()) {
                // TODO: Implementar lógica de busca da conta de origem
                // Buscar a conta (corrente ou poupança) usando a agência, conta e senha digitada
                // ...
                // Solicitar dados da conta de destino
                // ...
                // Validar se a conta de destino existe
                // ...
                // Realizar a transferência
                // ...
                // Mostrar mensagem de sucesso ou erro
                // ...
            } else {
                JOptionPane.showMessageDialog(this, "Senha inválida.");
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Valor inválido.");
        }
    }

    private void gerarExtrato() {
        // TODO: Implementar lógica de busca da conta para extrato
        // Buscar a conta (corrente ou poupança) usando a agência, conta e senha digitada
        // ...
        // Validar as datas
        // ...
        // Gerar o extrato
        // ...
        // Mostrar o extrato na área de texto
        // ...
    }
}