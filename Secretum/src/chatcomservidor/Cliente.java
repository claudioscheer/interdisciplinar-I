package chatcomservidor;

import classes.*;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.io.*;
import java.net.*;
import javax.swing.*;
import javax.swing.text.*;

public class Cliente extends javax.swing.JFrame {

    //timer que controla o tempo das operacoes
    private Timer timer;

    //guarda a comunicacao com o servidor
    private PrintStream mandaMensagem;

    //guarda o nome do usuario cliente
    private String nomeUsuario;

    //form inicial, usado apenas se acontecer algum erro aqui
    private final Inicial inicial;

    //classe para mostrar icone piscando quando recebe mensagem
    private IconeAlerta alertas;

    private Cliente esteFrame() {
        return this;
    }

    public Cliente(String ip, Inicial inicial) {
        initComponents();
        this.inicial = inicial;
        configuracoesIniciais();
        new Thread(new IniciarCliente(ip)).start();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelUsuarioFechar = new javax.swing.JPanel();
        lblNomeUsuario = new javax.swing.JLabel();
        panelConectados = new javax.swing.JPanel();
        btnExportarMensagens = new javax.swing.JButton();
        txtMensagem = new javax.swing.JTextField();
        panelOpcoesMensagem = new javax.swing.JPanel();
        lblAvisos = new javax.swing.JLabel();
        lblQuantidadeCaracteres = new javax.swing.JLabel();
        scrool = new javax.swing.JScrollPane();
        txtMensagens = new javax.swing.JTextPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Usuário Secretum");
        setIconImage(new ImageIcon(getClass().getClassLoader().getResource("resources/icone.png")).getImage());
        setMinimumSize(new java.awt.Dimension(500, 500));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
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

        javax.swing.GroupLayout panelUsuarioFecharLayout = new javax.swing.GroupLayout(panelUsuarioFechar);
        panelUsuarioFechar.setLayout(panelUsuarioFecharLayout);
        panelUsuarioFecharLayout.setHorizontalGroup(
            panelUsuarioFecharLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelUsuarioFecharLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblNomeUsuario)
                .addContainerGap(392, Short.MAX_VALUE))
        );
        panelUsuarioFecharLayout.setVerticalGroup(
            panelUsuarioFecharLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblNomeUsuario, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 17, Short.MAX_VALUE)
        );

        panelConectados.setBackground(new java.awt.Color(255, 255, 255));
        panelConectados.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        btnExportarMensagens.setFont(new java.awt.Font("Lucida Console", 0, 12)); // NOI18N
        btnExportarMensagens.setText("Exportar");
        btnExportarMensagens.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExportarMensagensActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelConectadosLayout = new javax.swing.GroupLayout(panelConectados);
        panelConectados.setLayout(panelConectadosLayout);
        panelConectadosLayout.setHorizontalGroup(
            panelConectadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelConectadosLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnExportarMensagens)
                .addContainerGap())
        );
        panelConectadosLayout.setVerticalGroup(
            panelConectadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelConectadosLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnExportarMensagens, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        txtMensagem.setFont(new java.awt.Font("Lucida Console", 0, 11)); // NOI18N
        txtMensagem.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtMensagemKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtMensagemKeyReleased(evt);
            }
        });

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

        scrool.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        txtMensagens.setEditable(false);
        txtMensagens.setFont(new java.awt.Font("Lucida Console", 0, 11)); // NOI18N
        scrool.setViewportView(txtMensagens);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtMensagem, javax.swing.GroupLayout.DEFAULT_SIZE, 488, Short.MAX_VALUE)
                    .addComponent(panelUsuarioFechar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelOpcoesMensagem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelConectados, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addComponent(scrool, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelUsuarioFechar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelConectados, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scrool, javax.swing.GroupLayout.DEFAULT_SIZE, 342, Short.MAX_VALUE)
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
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            String mensagem = txtMensagem.getText();
            if (Utils.validaMensagem(mensagem)) {
                mandarMensagem(Utils.formataMensagem(mensagem, nomeUsuario));
                append(Utils.formataMensagem(mensagem, ""), Color.BLUE, StyleConstants.ALIGN_LEFT);
            } else {
                timer.stop();
                lblAvisos.setText("O máximo de caracteres é 140");
                timer.start();
            }
        } else if (evt.getKeyCode() == KeyEvent.VK_ESCAPE) {
            txtMensagem.setText("");
        }
    }//GEN-LAST:event_txtMensagemKeyPressed

    private void txtMensagemKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMensagemKeyReleased
        lblQuantidadeCaracteres.setText(String.valueOf(txtMensagem.getText().length()));
    }//GEN-LAST:event_txtMensagemKeyReleased

    private void btnExportarMensagensActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExportarMensagensActionPerformed
        Utils.criarArquivoText(txtMensagens.getText());
    }//GEN-LAST:event_btnExportarMensagensActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        System.exit(0);
    }//GEN-LAST:event_formWindowClosing

    //seta as  configuracoes iniciais
    private void configuracoesIniciais() {
        abrirFecharChat(false);

        alertas = new IconeAlerta(this);

        txtMensagem.requestFocus();
        try {
            nomeUsuario = InetAddress.getLocalHost().getHostName();
        } catch (Exception ex) {
        }
        lblNomeUsuario.setText(nomeUsuario);
        timer = new javax.swing.Timer(Utils.tempo_delay_animacao, (ActionEvent ae) -> {
            lblAvisos.setText("");
        });
    }

    //adiciona as mensagens recebidas ou enviadas na tela de mensagens do servidor
    private void append(String msg, Color c, int alinha) {
        try {
            //até o próximo comentário, faz a ação de formatar a mensagem que será mostrada na tela
            StyledDocument style = txtMensagens.getStyledDocument();
            SimpleAttributeSet r = new SimpleAttributeSet();
            StyleConstants.setAlignment(r, alinha);
            StyleConstants.setForeground(r, c);
            int length = style.getLength();
            style.insertString(style.getLength(), msg + "\n", null);
            style.setParagraphAttributes(length + 1, 1, r, false);

            //faz a ação de rolar a barra das mensagens para o ponto mais baixo
            JScrollBar vertical = scrool.getVerticalScrollBar();
            vertical.setValue(vertical.getMaximum());

            //limpa o campo de mensagem e dá o foco nele
            lblQuantidadeCaracteres.setText("0");
            txtMensagem.setText("");
            txtMensagem.requestFocus();

            //mostra o alerta do icone da aplicação, isso pra ficar visível que foi recebida uma nova mensagem
            alertas.alertar();
        } catch (Exception ex) {
        }
    }

    //envia mensagem para o servidor
    private void mandarMensagem(String mensagem) {
        mandaMensagem.println(Criptografia.criptografa(mensagem));
        mandaMensagem.flush();
    }

    //abre e fecha a possibilidade de digitar
    private void abrirFecharChat(boolean abrir) {
        if (abrir) {
            txtMensagem.setEnabled(true);
            txtMensagens.setText("");
            btnExportarMensagens.setEnabled(true);
            lblAvisos.setText("");
        } else {
            lblAvisos.setText("Não é possível se conectar ao servidor");
            txtMensagem.setEnabled(false);
            btnExportarMensagens.setEnabled(false);
        }
    }

    private void fecharForm() {
        inicial.setVisible(true);
        this.dispose();
    }

    //recebe as mensagens do servidor e verefica o tipo delas
    private void recebeMensagem(String mensagem) {
        String mensagem_descrip;
        try {
            mensagem_descrip = Criptografia.descriptografa(mensagem);
        } catch (Exception ex) {
            mensagem_descrip = mensagem;
        }
        String[] mensagem_tipo = mensagem_descrip.split(Utils.caracter_padrao);
        if (mensagem_tipo.length <= 1) {
            append(mensagem_descrip, Color.BLACK, StyleConstants.ALIGN_LEFT);
            Utils.audioRecebeMensagem(getClass());
        } else if (mensagem_tipo[1].equals(Utils.padrao_notificacao)) {
            append(mensagem_tipo[0], Color.GRAY, StyleConstants.ALIGN_CENTER);
        } else if (mensagem_tipo[1].equals(Utils.padrao_desligar)) {
            append(mensagem_tipo[0], Color.GRAY, StyleConstants.ALIGN_CENTER);
            abrirFecharChat(false);
        }
    }

    class RecebeMensagem implements Runnable {

        private final BufferedReader leMensagem;

        public RecebeMensagem(BufferedReader bufferCliente) {
            this.leMensagem = bufferCliente;
        }

        @Override
        public void run() {
            try {
                abrirFecharChat(true);
                String mensagem;
                while ((mensagem = leMensagem.readLine()) != null) {
                    recebeMensagem(mensagem);
                }
            } catch (Exception ex) {
                abrirFecharChat(false);
                append(Utils.mensagem_padrao_erro, Color.GRAY, StyleConstants.ALIGN_CENTER);
            }
        }
    }

    class IniciarCliente implements Runnable {

        private final String ipServidor;

        public IniciarCliente(String ip) {
            this.ipServidor = ip;
        }

        @Override
        public void run() {
            try {
                Socket cliente = new Socket(ipServidor, Utils.porta_conectar);
                mandaMensagem = new PrintStream(cliente.getOutputStream());
                new Thread(new RecebeMensagem(new BufferedReader(new InputStreamReader(cliente.getInputStream())))).start();
            } catch (Exception ex) {
                Utils.notificacao(Utils.mensagem_padrao_erro);
                fecharForm();
            }
        }

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnExportarMensagens;
    private javax.swing.JLabel lblAvisos;
    private javax.swing.JLabel lblNomeUsuario;
    private javax.swing.JLabel lblQuantidadeCaracteres;
    private javax.swing.JPanel panelConectados;
    private javax.swing.JPanel panelOpcoesMensagem;
    private javax.swing.JPanel panelUsuarioFechar;
    private javax.swing.JScrollPane scrool;
    private javax.swing.JTextField txtMensagem;
    private javax.swing.JTextPane txtMensagens;
    // End of variables declaration//GEN-END:variables
}
