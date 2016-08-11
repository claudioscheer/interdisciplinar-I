/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chatcomservidor;

import classes.Criptografia;
import classes.Utils;
import java.io.PrintStream;
import java.net.Socket;

/**
 *
 * @author ADMIN
 */
public class InjetarConexoes extends javax.swing.JFrame {

    public InjetarConexoes(String ip) {
        initComponents();
        txtIp.setText(ip);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnInjetar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        txtIp = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtMensagem = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtNumeroConexoes = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Injetar Conexões");
        setResizable(false);

        btnInjetar.setText("Iniciar");
        btnInjetar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInjetarActionPerformed(evt);
            }
        });

        jLabel1.setText("IP servidor");

        jLabel2.setText("Mensagem");

        jLabel3.setText("Nº conexões");

        txtNumeroConexoes.setText("2");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtIp)
                    .addComponent(btnInjetar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtMensagem)
                    .addComponent(txtNumeroConexoes)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addGap(0, 107, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtIp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtMensagem, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNumeroConexoes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnInjetar, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnInjetarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInjetarActionPerformed
        new Thread(new IniciarCliente(txtIp.getText(), txtMensagem.getText(), Integer.valueOf(txtNumeroConexoes.getText()))).start();
    }//GEN-LAST:event_btnInjetarActionPerformed

    private InjetarConexoes getThis() {
        return this;
    }

    class IniciarCliente implements Runnable {

        private final String ipServidor;
        private final String mensagem;
        private final int numero_conexoes;

        public IniciarCliente(String ip, String mensagem, int numero_conexoes) {
            this.ipServidor = ip;
            this.mensagem = mensagem;
            this.numero_conexoes = numero_conexoes;
        }

        @Override
        public void run() {
            try {

                Utils.notificacao("A cada 2 segundos serão enviadas 5 mensagens para o destinatário!");

                for (int i = 0; i < numero_conexoes; i++) {
                    Socket cliente = new Socket(ipServidor, Utils.porta_conectar);
                    PrintStream manda = new PrintStream(cliente.getOutputStream());
                    for (int j = 0; j < 5; j++) {
                        manda.println(Criptografia.criptografa(mensagem));
                        manda.flush();
                    }
                    cliente.close();
                    Thread.sleep(2000);
                }
                Utils.notificacao("Operação finalizada com sucesso!");
                getThis().dispose();
            } catch (Exception ex) {
                Utils.notificacao("Ocorreu um erro ao se conectar. O servidor não está disponível!");
            }
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnInjetar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JTextField txtIp;
    private javax.swing.JTextField txtMensagem;
    private javax.swing.JTextField txtNumeroConexoes;
    // End of variables declaration//GEN-END:variables
}
