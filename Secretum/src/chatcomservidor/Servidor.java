/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chatcomservidor;

import classes.*;
import java.awt.Color;
import java.awt.event.*;
import java.io.*;
import java.net.*;
import java.util.*;
import javax.swing.*;
import javax.swing.text.*;

public class Servidor extends javax.swing.JFrame {

    //timer para limpar o campo de avisos depois de um tempo
    private javax.swing.Timer timer;

    //guarda os dados dos clientes conectados
    private ArrayList<UsuariosConectados> conexoes_usuarios;

    //número máximo de clientes que o chat aceita
    private int maximo_conectados;

    //número de clientes que estao conectados ao chat no momento
    private int numero_conectados;

    //sequencial de códigos dos clientes já conectados
    private int codigo_usuario;

    //nome do usuário servidor
    private String nome_usuario;

    //form inicial, usado apenas se acontecer algum erro aqui
    private final Inicial inicial;

    //socket de conexão do servidor, a hora que este fechar, fecha o chat
    private ServerSocket servidor;

    //classe para mostrar ícone piscando quando recebe mensagem
    private IconeAlerta alertas;

    //construtor da classe servidor, onde são passado o numero máximo de conexões permitidas, 
    public Servidor(int maximo_usuarios, Inicial inicial) {
        initComponents();
        this.inicial = inicial;
        //seta as configurações iniciais do chat
        configuracoesIniciais(maximo_usuarios);
        //inicia em um processo paralelo, a criação do servidor
        new Thread(new IniciarServidor()).start();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelConectados = new javax.swing.JPanel();
        btnPermitirMaisUmaConexao = new javax.swing.JButton();
        btnRemoverUmaPermicaoDeConexao = new javax.swing.JButton();
        lblNumeroConectados = new javax.swing.JLabel();
        lblTextoQuantiaConectados = new javax.swing.JLabel();
        lblTextoNumeropermicoes = new javax.swing.JLabel();
        lblConexoesPermitidas = new javax.swing.JLabel();
        btnExportarMensagens = new javax.swing.JButton();
        scrollMensagens = new javax.swing.JScrollPane();
        txtMensagens = new javax.swing.JTextPane();
        txtMensagem = new javax.swing.JTextField();
        panelUsuarioFechar = new javax.swing.JPanel();
        lblNomeUsuario = new javax.swing.JLabel();
        lblIPServidor = new javax.swing.JLabel();
        cbCriptografa = new javax.swing.JCheckBox();
        panelOpcoesMensagem = new javax.swing.JPanel();
        lblAvisos = new javax.swing.JLabel();
        lblQuantidadeCaracteres = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Servidor Secretum");
        setIconImage(new ImageIcon(getClass().getClassLoader().getResource("resources/icone.png")).getImage());
        setMinimumSize(new java.awt.Dimension(500, 500));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        panelConectados.setBackground(new java.awt.Color(255, 255, 255));
        panelConectados.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        btnPermitirMaisUmaConexao.setFont(new java.awt.Font("Lucida Console", 0, 12)); // NOI18N
        btnPermitirMaisUmaConexao.setText("+");
        btnPermitirMaisUmaConexao.setToolTipText("Permitir mais uma conexão");
        btnPermitirMaisUmaConexao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPermitirMaisUmaConexaoActionPerformed(evt);
            }
        });

        btnRemoverUmaPermicaoDeConexao.setFont(new java.awt.Font("Lucida Console", 0, 12)); // NOI18N
        btnRemoverUmaPermicaoDeConexao.setText("-");
        btnRemoverUmaPermicaoDeConexao.setToolTipText("Permitir uma conexão a menos");
        btnRemoverUmaPermicaoDeConexao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoverUmaPermicaoDeConexaoActionPerformed(evt);
            }
        });

        lblNumeroConectados.setBackground(new java.awt.Color(221, 221, 221));
        lblNumeroConectados.setFont(new java.awt.Font("Lucida Console", 0, 11)); // NOI18N
        lblNumeroConectados.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblNumeroConectados.setText("0");
        lblNumeroConectados.setToolTipText("Número conexões permitidas");
        lblNumeroConectados.setOpaque(true);

        lblTextoQuantiaConectados.setFont(new java.awt.Font("Lucida Console", 0, 12)); // NOI18N
        lblTextoQuantiaConectados.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTextoQuantiaConectados.setText("Nº conectados:");

        lblTextoNumeropermicoes.setFont(new java.awt.Font("Lucida Console", 0, 12)); // NOI18N
        lblTextoNumeropermicoes.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTextoNumeropermicoes.setText("Nº permissões:");

        lblConexoesPermitidas.setBackground(new java.awt.Color(204, 204, 204));
        lblConexoesPermitidas.setFont(new java.awt.Font("Lucida Console", 0, 11)); // NOI18N
        lblConexoesPermitidas.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblConexoesPermitidas.setText("0");
        lblConexoesPermitidas.setToolTipText("Número conexões permitidas");
        lblConexoesPermitidas.setBorder(null);
        lblConexoesPermitidas.setOpaque(true);

        btnExportarMensagens.setFont(new java.awt.Font("Lucida Console", 0, 12)); // NOI18N
        btnExportarMensagens.setText("Exportar");
        btnExportarMensagens.setToolTipText("Permitir mais uma conexão");
        btnExportarMensagens.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExportarMensagensActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelConectadosLayout = new javax.swing.GroupLayout(panelConectados);
        panelConectados.setLayout(panelConectadosLayout);
        panelConectadosLayout.setHorizontalGroup(
            panelConectadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelConectadosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTextoQuantiaConectados)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblNumeroConectados, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(lblTextoNumeropermicoes)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblConexoesPermitidas, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnRemoverUmaPermicaoDeConexao, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnPermitirMaisUmaConexao)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnExportarMensagens))
        );
        panelConectadosLayout.setVerticalGroup(
            panelConectadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelConectadosLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(panelConectadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTextoQuantiaConectados)
                    .addComponent(lblNumeroConectados, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblTextoNumeropermicoes)
                    .addComponent(lblConexoesPermitidas, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPermitirMaisUmaConexao)
                    .addComponent(btnRemoverUmaPermicaoDeConexao)
                    .addComponent(btnExportarMensagens)))
        );

        scrollMensagens.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        txtMensagens.setEditable(false);
        txtMensagens.setFont(new java.awt.Font("Lucida Console", 0, 11)); // NOI18N
        scrollMensagens.setViewportView(txtMensagens);

        txtMensagem.setFont(new java.awt.Font("Lucida Console", 0, 11)); // NOI18N
        txtMensagem.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtMensagemKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtMensagemKeyReleased(evt);
            }
        });

        panelUsuarioFechar.setBackground(new java.awt.Color(255, 255, 255));
        panelUsuarioFechar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        lblNomeUsuario.setBackground(new java.awt.Color(255, 255, 255));
        lblNomeUsuario.setFont(new java.awt.Font("Lucida Console", 0, 12)); // NOI18N
        lblNomeUsuario.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblNomeUsuario.setText("Nome Usuário");
        lblNomeUsuario.setToolTipText("Número conexões permitidas");
        lblNomeUsuario.setOpaque(true);

        lblIPServidor.setBackground(new java.awt.Color(255, 255, 255));
        lblIPServidor.setFont(new java.awt.Font("Lucida Console", 0, 12)); // NOI18N
        lblIPServidor.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblIPServidor.setText("IP servidor");
        lblIPServidor.setToolTipText("Número conexões permitidas");
        lblIPServidor.setOpaque(true);

        cbCriptografa.setSelected(true);
        cbCriptografa.setText("Criptografar");

        javax.swing.GroupLayout panelUsuarioFecharLayout = new javax.swing.GroupLayout(panelUsuarioFechar);
        panelUsuarioFechar.setLayout(panelUsuarioFecharLayout);
        panelUsuarioFecharLayout.setHorizontalGroup(
            panelUsuarioFecharLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelUsuarioFecharLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblNomeUsuario)
                .addGap(105, 105, 105)
                .addComponent(lblIPServidor)
                .addGap(102, 102, 102)
                .addComponent(cbCriptografa)
                .addGap(21, 21, 21))
        );
        panelUsuarioFecharLayout.setVerticalGroup(
            panelUsuarioFecharLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelUsuarioFecharLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(lblNomeUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, 19, Short.MAX_VALUE)
                .addComponent(lblIPServidor, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(cbCriptografa))
        );

        panelOpcoesMensagem.setBackground(new java.awt.Color(255, 255, 255));
        panelOpcoesMensagem.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        lblAvisos.setFont(new java.awt.Font("Lucida Console", 0, 11)); // NOI18N
        lblAvisos.setForeground(new java.awt.Color(246, 0, 0));

        lblQuantidadeCaracteres.setFont(new java.awt.Font("sansserif", 0, 10)); // NOI18N
        lblQuantidadeCaracteres.setText("0");

        javax.swing.GroupLayout panelOpcoesMensagemLayout = new javax.swing.GroupLayout(panelOpcoesMensagem);
        panelOpcoesMensagem.setLayout(panelOpcoesMensagemLayout);
        panelOpcoesMensagemLayout.setHorizontalGroup(
            panelOpcoesMensagemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelOpcoesMensagemLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblQuantidadeCaracteres)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblAvisos)
                .addContainerGap())
        );
        panelOpcoesMensagemLayout.setVerticalGroup(
            panelOpcoesMensagemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelOpcoesMensagemLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(panelOpcoesMensagemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblAvisos)
                    .addComponent(lblQuantidadeCaracteres)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(scrollMensagens)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(panelUsuarioFechar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelConectados, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelOpcoesMensagem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtMensagem))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelUsuarioFechar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelConectados, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scrollMensagens, javax.swing.GroupLayout.DEFAULT_SIZE, 340, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelOpcoesMensagem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtMensagem, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtMensagemKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMensagemKeyPressed
        //se a tecla de atalho for enter, envia a mensagem
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            String mensagem = txtMensagem.getText();
            //verifica se a mensagem é válida
            if (Utils.validaMensagem(mensagem)) {
                //manda a mensagem a todos os conectados
                mandamensagensTodos(Utils.formataMensagem(mensagem, nome_usuario), 0, cbCriptografa.isSelected());
                //adiciona na tela do servidor a mensagem enviada
                append(Utils.formataMensagem(mensagem, ""), Color.BLUE, StyleConstants.ALIGN_LEFT);
            } else {
                //se a mensagem for inválida , avisa o por que
                avisoLabelAvisos("O máximo de caracteres é 140");
            }
        } else if (evt.getKeyCode() == KeyEvent.VK_ESCAPE) {
            txtMensagem.setText("");
        } else if (evt.getKeyCode() == KeyEvent.VK_F12) {
            InjetarConexoes injetar = new InjetarConexoes(lblIPServidor.getText());
            injetar.setVisible(true);
        } else if (evt.isControlDown() && evt.getKeyCode() == KeyEvent.VK_DELETE) {
            removeTodosConectados();
        } else if (evt.isAltDown() && evt.getKeyCode() == KeyEvent.VK_E) {
            RecebeMensagensCriptografadas recebe = new RecebeMensagensCriptografadas(lblIPServidor.getText());
            recebe.setVisible(true);
        }
    }//GEN-LAST:event_txtMensagemKeyPressed

    private void txtMensagemKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMensagemKeyReleased
        //pega a quantidade de caracteres digitados e mostra para o cliente
        lblQuantidadeCaracteres.setText(String.valueOf(txtMensagem.getText().length()));
    }//GEN-LAST:event_txtMensagemKeyReleased

    private void btnPermitirMaisUmaConexaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPermitirMaisUmaConexaoActionPerformed
        atualizaNumeroConexoesPossiveis(1);
    }//GEN-LAST:event_btnPermitirMaisUmaConexaoActionPerformed

    private void btnRemoverUmaPermicaoDeConexaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoverUmaPermicaoDeConexaoActionPerformed
        atualizaNumeroConexoesPossiveis(-1);
    }//GEN-LAST:event_btnRemoverUmaPermicaoDeConexaoActionPerformed

    private void btnExportarMensagensActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExportarMensagensActionPerformed
        //cria o arquivo a partor das mensagens já recebidas e enviadas
        Utils.criarArquivoText(txtMensagens.getText());
    }//GEN-LAST:event_btnExportarMensagensActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        //quando for fechar o form, pede é para deixar o formulário em segundo plano
        if (JOptionPane.showConfirmDialog(rootPane, "Deseja deixar em segundo plano?", "", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE) == JOptionPane.YES_OPTION) {
            //se é pra deixar em segundo plano, cria o iconezinho em baixo na barra de tarefas
            new TrayItemChat(this).iniciar();
            this.setVisible(false);
        } else {
            //se não, fecha o sistema
            System.exit(0);
        }
    }//GEN-LAST:event_formWindowClosing

    //retorna o frame utilizado
    private Servidor esteFrame() {
        return this;
    }

    //retorna o código do usuário que estará se conectando, o ++ está antes para incrementar a variável antes dela ser retornada
    private int codigoConexao() {
        return ++codigo_usuario;
    }

    //verifica se existe espaço para nova conexão
    private boolean existeConexaoDisponivel() {
        return numero_conectados < maximo_conectados;
    }

    //atualiza o numero de conexoes possiveis
    private void atualizaNumeroConexoesPossiveis(int tipo) {
        switch (tipo) {
            case 1:
                if (maximo_conectados <= 19) {
                    maximo_conectados++;
                }
                break;
            case -1:
                if (maximo_conectados >= 2 && maximo_conectados > numero_conectados) {
                    maximo_conectados--;
                }
                break;
        }
        lblConexoesPermitidas.setText(String.valueOf(maximo_conectados));
    }

    //atualiza o numero de conectados no chat
    private void atualizaNumeroConectados(int tipo) {
        switch (tipo) {
            case 1:
                numero_conectados++;
                break;
            case -1:
                numero_conectados--;
                break;
        }
        //seta o número de conectados na tela
        lblNumeroConectados.setText(String.valueOf(numero_conectados));
    }

    //seta as configuracoes iniciais para o funcionamento do chat
    private void configuracoesIniciais(int max) {
        //máximo de conectados recebidos por parâmetro da tela incial
        maximo_conectados = max;
        //inicia o objeto que irá permitir criar o alerta que foi recebido uma nova mensagem
        alertas = new IconeAlerta(this);
        //cria o objeto que irá armazenar os clientes conectados ao servidor
        conexoes_usuarios = new ArrayList<>();
        try {
            //pega o nome do servidor (nome do usuário logado no computador)
            nome_usuario = InetAddress.getLocalHost().getHostName();
        } catch (Exception ex) {
        }
        try {
            //pega o IP da máquina e passa para a tela
            lblIPServidor.setText(InetAddress.getLocalHost().getHostAddress());
        } catch (Exception ex) {
        }
        //passa o nome do servidor e passa pra tela
        lblNomeUsuario.setText(nome_usuario);
        //atualiza o número de conexões possíveis
        atualizaNumeroConexoesPossiveis(0);
        //passa o foco para o campo de mensagens
        txtMensagem.requestFocus();
        //cria o timer que vai vai fica responsável por executar um ação depois de um determinado tempo (delay)
        //aqui no caso a ação vai ser de limpar o campo onde vai aparecer o texto de mensagem inválida
        timer = new javax.swing.Timer(Utils.tempo_delay_animacao, (ActionEvent) -> {
            lblAvisos.setText("");
        });
    }

    //manda um aviso pra todos os conectados, menos o usuario que que causou o envio do aviso
    private void mandaAvisoPraTodos(String mensagem, int codigo) {
        //envia o aviso para todos conectados
        mandamensagensTodos(mensagem + Utils.caracter_padrao + Utils.padrao_notificacao, codigo, true);
        //adiciona a mensagem na tela do servidor
        append(mensagem, Color.GRAY, StyleConstants.ALIGN_CENTER);
    }

    //manda uma mensagem recebida para todos os conectados, menos para o que mando a mensagem originalmente
    private void mandamensagensTodos(String mensagem, int codigo, boolean criptografa) {
        //verefica se é para criptografar a mensagem
        String mensagem_criptografada = criptografa ? Criptografia.criptografa(mensagem) : mensagem;
        //percorre todos os clientes conectados
        for (UsuariosConectados usu : conexoes_usuarios) {
            if (usu.codigo != codigo) {
                //envia a mensagem criptografada ao cliente
                usu.mandaMensagem.println(mensagem_criptografada);
                //força o envio da mensagem
                usu.mandaMensagem.flush();
            }
        }
    }

    //função que percorre todos os usuários conectados, e remove-os
    private void removeTodosConectados() {
        for (UsuariosConectados conexoes_usuario : conexoes_usuarios) {
            acaoRemover(conexoes_usuario);
        }
        conexoes_usuarios.clear();
        //mostra aviso que todas as conexões foram removidas
        avisoLabelAvisos("Todas conexões foram removidas!");
    }

    //mostra o aviso no label, como por exemplo quando a mensagem for inválida
    private void avisoLabelAvisos(String mensagem) {
        //para a excução do timer
        timer.stop();
        lblAvisos.setText(mensagem);
        //inicia novamente a execução do timer
        timer.start();
    }

    //realiza as ações para remover o cliente
    private void acaoRemover(UsuariosConectados cliente) {
        try {
            //fechar a conexão socket do cliente
            cliente.clienteSocket.close();
            //fecha a possíbilidade de enviar mensagem para ele
            cliente.mandaMensagem.close();
            //atualiza na tela o número de conectados -1
            atualizaNumeroConectados(-1);
        } catch (Exception ex) {
        }
    }

    //remove um usuario conectado ao chat, recebe como parâmetro o código do cliente que será removido
    private void removeConectado(int codigo) {
        //realiza a busca pelo código, na lista dos usuários conectados
        UsuariosConectados clienteRemover = null;
        for (UsuariosConectados cliente : conexoes_usuarios) {
            //no momento em que o código recebido por parâmetro for igual ao código da lista percorrida, para a execução do for
            if (cliente.codigo == codigo) {
                clienteRemover = cliente;
                break;
            }
        }
        //remove o cliente da lista dos conectados
        conexoes_usuarios.remove(clienteRemover);
        //ações remover usuário
        acaoRemover(clienteRemover);
    }

    //faz as ações necessárias quando um novo cliente se conecta no chat
    protected UsuariosConectados adicionaConectado(UsuariosConectados cliente) throws IOException {
        //adiciona o novo cliente na lista dos conectados
        conexoes_usuarios.add(cliente);
        //atualiza o número de conectados na tela
        atualizaNumeroConectados(1);
        //envia uma mensagem para todos os conectados, informando que mais um cliente se conectou ao chat
        mandaAvisoPraTodos(cliente.nome + " se conectou", cliente.codigo);
        return cliente;
    }

    //adiciona as mensagens recebidas ou enviadas na tela de mensagens do servidor
    private void append(String msg, Color c, int alinhamento) {
        try {
            //até o próximo comentário, faz a ação de formatar a mensagem que será mostrada na tela
            StyledDocument style = txtMensagens.getStyledDocument();
            SimpleAttributeSet r = new SimpleAttributeSet();
            StyleConstants.setAlignment(r, alinhamento);
            StyleConstants.setForeground(r, c);
            int length = style.getLength();
            style.insertString(style.getLength(), msg + "\n", null);
            style.setParagraphAttributes(length + 1, 1, r, false);

            //faz a ação de rolar a barra das mensagens para o ponto mais baixo
            JScrollBar vertical = scrollMensagens.getVerticalScrollBar();
            vertical.setValue(vertical.getMaximum());

            //limpa o campo de mensagem e dá o foco nele
            lblQuantidadeCaracteres.setText("0");
            txtMensagem.setText("");
            txtMensagem.requestFocus();

            //verefica se a tela está visível
            if (this.isVisible()) {
                //se estiver visível, mostra o alerta do icone da aplicação, isso pra ficar visível que foi recebida uma nova mensagem
                alertas.alertar();
            }
        } catch (Exception ex) {
        }
    }

    //manda a mensagem recebida para todos os usuarios e executa o som de nova mensagem
    private void recebeMensagem(String mensagem, int codigo) {
        //chama o método resposável por enviar as mensagens a todos os clientes conectados
        //o código é passado como paramêtro para não enviar a mensagem pro mesmo cliente que enviou a mensagem
        mandamensagensTodos(mensagem, codigo, false);
        //descriptografa a mensagem recebida
        String mensagem_descrip = Criptografia.descriptografa(mensagem);
        //adiciona a mensagem descriptografada na tela do servidor,
        append(mensagem_descrip, Color.BLACK, StyleConstants.ALIGN_LEFT);
        //executa o alerta da mensagem, o áudio
        Utils.audioRecebeMensagem(this.getClass());
    }

    //método para fechar este formulário e abrir o formulário inicial
    private void fecharForm() {
        inicial.setVisible(true);
        this.dispose();
    }

    // está é responsável por ficar monitorando cada cliente que se conecta
    //quando um cliente se conecta, é iniciada um processo paralelo (Thread)
    //ou seja, vai ficar rodando o processo do sistema mais o processo de receber as mensagens de cada cliente que se conecta
    class RecebeMensagens implements Runnable {

        //objeto responsável por receber as mensagens
        private final BufferedReader leMensagem;

        //objeto com os dados do cliente conectado ao servidor
        private final UsuariosConectados clienteConectado;

        //construtor da classe que recebe os dados do cliente
        public RecebeMensagens(UsuariosConectados cli) throws IOException {
            clienteConectado = cli;
            //a partir dos dados dos clientes cria o objeto que vai ler as mensagens
            leMensagem = new BufferedReader(new InputStreamReader(cli.clienteSocket.getInputStream()));
        }

        //método onde será iniciado a leitura das mensagens
        @Override
        public void run() {
            try {
                //variavel onde estará a mensagem
                String mensagem;
                //le a linha do objeto, quando a linha for diferente de nula, é por que recebeu uma mensagem
                while ((mensagem = leMensagem.readLine()) != null) {
                    //chama o método resposável por tratar a mensagem recebida, como paramêtro passa a mensagem
                    // e o código do cliente que recebeu a mensagem
                    recebeMensagem(mensagem, clienteConectado.codigo);
                }
            } catch (Exception ex) {
                //no momento em que em que cair aqui, é por que o usuário que estava conectado se desconectou ou caiu a rede dele
                removeConectado(clienteConectado.codigo);
                //manda um aviso a todos os usuários conectados com o nome de quem saiu
                mandaAvisoPraTodos(clienteConectado.nome + " saiu", 0);
            }
        }
    }

    class IniciarServidor implements Runnable {

        @Override
        public void run() {
            try {
                servidor = new ServerSocket(Utils.porta_conectar);
                while (true) {
                    Socket cliente = servidor.accept();
                    if (existeConexaoDisponivel()) {
                        UsuariosConectados cli = new UsuariosConectados(cliente, codigoConexao());
                        alertas.alertar();
                        if (JOptionPane.showConfirmDialog(rootPane, cli.nome + " deseja se conectar, permitir?", "Nova conexão", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE) == JOptionPane.YES_OPTION) {
                            new Thread(new RecebeMensagens(adicionaConectado(cli))).start();
                        } else {
                            new PrintStream(cliente.getOutputStream()).println(Utils.mensagem_padrao_erro + Utils.caracter_padrao + Utils.padrao_desligar);
                            cliente.close();
                        }
                    } else {
                        new PrintStream(cliente.getOutputStream()).println(Utils.mensagem_padrao_erro + Utils.caracter_padrao + Utils.padrao_desligar);
                        cliente.close();
                    }
                }
            } catch (Exception ex) {
                Utils.notificacao("Já existe um servidor criado nesta rede!");
                fecharForm();
            }
        }
    }

    class UsuariosConectados {

        private int codigo;
        private final String nome;
        private final PrintStream mandaMensagem;
        private final Socket clienteSocket;

        public UsuariosConectados(Socket cliente, int cod) throws IOException {
            codigo = cod;
            nome = cliente.getInetAddress().getHostName();
            mandaMensagem = new PrintStream(cliente.getOutputStream());
            clienteSocket = cliente;
        }

        public void setCodigo(int cod) {
            codigo = cod;
        }

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnExportarMensagens;
    private javax.swing.JButton btnPermitirMaisUmaConexao;
    private javax.swing.JButton btnRemoverUmaPermicaoDeConexao;
    private javax.swing.JCheckBox cbCriptografa;
    private javax.swing.JLabel lblAvisos;
    private javax.swing.JLabel lblConexoesPermitidas;
    private javax.swing.JLabel lblIPServidor;
    private javax.swing.JLabel lblNomeUsuario;
    private javax.swing.JLabel lblNumeroConectados;
    private javax.swing.JLabel lblQuantidadeCaracteres;
    private javax.swing.JLabel lblTextoNumeropermicoes;
    private javax.swing.JLabel lblTextoQuantiaConectados;
    private javax.swing.JPanel panelConectados;
    private javax.swing.JPanel panelOpcoesMensagem;
    private javax.swing.JPanel panelUsuarioFechar;
    private javax.swing.JScrollPane scrollMensagens;
    private javax.swing.JTextField txtMensagem;
    private javax.swing.JTextPane txtMensagens;
    // End of variables declaration//GEN-END:variables
}
