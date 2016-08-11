/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculadoramatriz;

/**
 *
 * @author Larissa Guder
 */import java.awt.*;  
import java.awt.event.*;  
import java.util.*;  
  
public class CalculadoraMatriz extends MatrizResult {  
  
    public static void main(String[] args) {  
        try {  
            CalculadoraMatriz campo = new CalculadoraMatriz();  
            campo.setVisible(true);  
        } catch (Throwable t) {  
            t.printStackTrace();  
        }  
    }  
  
 private class Botao extends Button implements ActionListener {  
  
        private boolean explode;  
  
        Botao(boolean explode) {  
            this.explode = explode;  
            this.setLabel("?");  
            this.addActionListener(this);  
        }  
  
        public void actionPerformed(ActionEvent e) {  
            if (explode) {  
                this.setLabel("*");  
                janela.setVisible(true);  
            } else {  
                this.setLabel(" ");  
            }  
        }  
    }  
  
  
    private Dialog janela;  
  
    private CalculadoraMatriz() {  
        this.setTitle("Campo Minado");  
        this.setSize(1200, 1200);  
        this.setLocationRelativeTo(null);  
       janela = new Dialog(this, "Campo Minado", true);  
        janela.setLayout(new BorderLayout());  
        janela.add(BorderLayout.CENTER, new Label("Buuuummmm!!!", Label.CENTER));  
        janela.setSize(150, 75);  
        janela.setLocationRelativeTo(this);  
        int linhas = 36;  
        int colunas = 34;  
        Panel painel = new Panel(new GridLayout(linhas, colunas));  
        for (int i = 0; i < linhas; i++) {  
            for (int j = 0; j < colunas; j++) {  
                painel.add(new Botao(new Random().nextBoolean()));  
            }  
        }  
        this.setLayout(new BorderLayout());  
        this.add(BorderLayout.CENTER, painel);  
        WindowListener listener = new WindowAdapter() {  
            public void windowClosing(WindowEvent e) {  
                Object origem = e.getSource();  
                if (origem == CalculadoraMatriz.this) {  
                    System.exit(0);  
                } else if (origem == janela) {  
                    janela.setVisible(false);  
                }  
            }  
        };  
        this.addWindowListener(listener);  
        janela.addWindowListener(listener);  
    }  
}  

    /**
     * @param args the command line arguments
     */
   
    
