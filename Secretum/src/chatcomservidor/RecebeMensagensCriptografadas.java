/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chatcomservidor;

import classes.Utils;
import java.awt.Color;
import java.io.*;
import java.net.Socket;
import javax.swing.JScrollBar;
import javax.swing.text.*;

public class RecebeMensagensCriptografadas extends javax.swing.JFrame {

    public RecebeMensagensCriptografadas(String ip) {
        initComponents();
        new Thread(new IniciarCliente(ip)).start();
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
                new Thread(new RecebeMensagem(new BufferedReader(new InputStreamReader(cliente.getInputStream())))).start();
            } catch (Exception ex) {
                Utils.notificacao(Utils.mensagem_padrao_erro);
            }
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
                String mensagem;
                while ((mensagem = leMensagem.readLine()) != null) {
                    append(mensagem, Color.BLACK, StyleConstants.ALIGN_LEFT);
                }
            } catch (Exception ex) {
                append(Utils.mensagem_padrao_erro, Color.GRAY, StyleConstants.ALIGN_CENTER);
            }
        }
    }

    private void append(String msg, Color c, int alinha) {
        try {
            StyledDocument style = txtMensagens.getStyledDocument();
            SimpleAttributeSet r = new SimpleAttributeSet();
            StyleConstants.setAlignment(r, alinha);
            StyleConstants.setForeground(r, c);
            int length = style.getLength();
            style.insertString(style.getLength(), "\n" + msg + "\n\n", null);
            style.setParagraphAttributes(length + 1, 1, r, false);
            JScrollBar vertical = scrollMensagens.getVerticalScrollBar();
            vertical.setValue(vertical.getMaximum());
        } catch (Exception ex) {
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        scrollMensagens = new javax.swing.JScrollPane();
        txtMensagens = new javax.swing.JTextPane();
        btnExportarMensagens = new javax.swing.JButton();
        btnExportarMensagens1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        scrollMensagens.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        txtMensagens.setEditable(false);
        txtMensagens.setFont(new java.awt.Font("Lucida Console", 0, 11)); // NOI18N
        scrollMensagens.setViewportView(txtMensagens);

        btnExportarMensagens.setFont(new java.awt.Font("Lucida Console", 0, 12)); // NOI18N
        btnExportarMensagens.setText("Limpar");
        btnExportarMensagens.setToolTipText("Permitir mais uma conexão");
        btnExportarMensagens.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExportarMensagensActionPerformed(evt);
            }
        });

        btnExportarMensagens1.setFont(new java.awt.Font("Lucida Console", 0, 12)); // NOI18N
        btnExportarMensagens1.setText("Exportar");
        btnExportarMensagens1.setToolTipText("Permitir mais uma conexão");
        btnExportarMensagens1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExportarMensagens1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(scrollMensagens)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(509, Short.MAX_VALUE)
                .addComponent(btnExportarMensagens)
                .addGap(18, 18, 18)
                .addComponent(btnExportarMensagens1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnExportarMensagens)
                    .addComponent(btnExportarMensagens1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scrollMensagens, javax.swing.GroupLayout.DEFAULT_SIZE, 505, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnExportarMensagensActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExportarMensagensActionPerformed
        txtMensagens.setText("");
    }//GEN-LAST:event_btnExportarMensagensActionPerformed

    private void btnExportarMensagens1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExportarMensagens1ActionPerformed
        Utils.criarArquivoText(txtMensagens.getText());
    }//GEN-LAST:event_btnExportarMensagens1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnExportarMensagens;
    private javax.swing.JButton btnExportarMensagens1;
    private javax.swing.JScrollPane scrollMensagens;
    private javax.swing.JTextPane txtMensagens;
    // End of variables declaration//GEN-END:variables
}
