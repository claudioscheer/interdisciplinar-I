/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import java.awt.*;
import javax.swing.*;

/**
 *
 * @author ADMIN
 */
public class TrayItemChat {

    private JFrame janela;
    private TrayIcon trayIcon;
    private SystemTray tray;

    public TrayItemChat(JFrame janela) {
        this.janela = janela;
    }

    private void abreJanela() {
        janela.setVisible(true);
        tray.remove(trayIcon);
    }

    public void iniciar() {

        if (!SystemTray.isSupported()) {
            return;
        }

        PopupMenu popup = new PopupMenu();

        trayIcon = new TrayIcon(new ImageIcon(janela.getClass().getClassLoader().getResource("resources/icone_tray.png")).getImage(), "Secretum");
        tray = SystemTray.getSystemTray();

        MenuItem abrir = new MenuItem("Abrir");
        abrir.addActionListener((ActionListener) -> {
            abreJanela();
        });

        MenuItem fechar = new MenuItem("Fechar");
        fechar.addActionListener((ActionListener) -> {
            System.exit(0);
        });

        popup.add(abrir);
        popup.addSeparator();
        popup.add(fechar);

        trayIcon.addActionListener((ActionListener) -> {
            abreJanela();
        });

        trayIcon.setPopupMenu(popup);

        try {
            tray.add(trayIcon);
        } catch (Exception e) {
        }
    }
}
