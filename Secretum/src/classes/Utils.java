package classes;

import java.io.*;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.sound.sampled.*;
import static javax.swing.JOptionPane.*;

public class Utils {

    public static final int porta_conectar = 56787;
    public static final String arquivo_audio = "resources/notificacao.wav";
    public static final String padrao_desligar = "D";
    public static final int tempo_delay_animacao = 3000;

    public static final String padrao_notificacao = "N";
    public static final String padrao_envio_nome = "EN";

    public static final String caracter_padrao = "/";
    public static final String mensagem_padrao_erro = "O servidor não está operando";

    public static String horaMsg() {
        return new SimpleDateFormat("HH:mm").format(new Date());
    }

    public static void audioRecebeMensagem(Class c) {
        try {
            URL sound = c.getClassLoader().getResource(arquivo_audio);
            AudioInputStream audio = AudioSystem.getAudioInputStream(sound);
            Clip clip = AudioSystem.getClip();
            clip.open(audio);
            clip.start();
        } catch (Exception e) {
        }
    }

    public static void notificacao(String mensagem) {
        showMessageDialog(null, mensagem);
    }

    public static String nomeUsuario() {
        return System.getProperty("user.name");
    }

    public static String formataMensagem(String msg, String usuario) {
        if (!usuario.isEmpty()) {
            return "(" + Utils.horaMsg() + ") " + usuario + ": " + msg;
        }
        return "(" + Utils.horaMsg() + ") " + msg;
    }

    public static boolean validaMensagem(String mensagem) {
        return mensagem.length() <= 140 && mensagem.length() > 0;
    }

    public static String[] quebraString(String texto) {
        return texto.split("(?<=\\G.{58})");
    }

    public static void criarArquivoText(String texto) {
        try {
            File f = new File("arquivo_mensagens.txt");
            f.createNewFile();
            PrintWriter escrever = new PrintWriter(f);
            escrever.print(texto);
            escrever.flush();
            escrever.close();
            Utils.notificacao("O arquivo foi salvo em:\n " + f.getAbsolutePath());
        } catch (Exception ex) {
        }
    }

    public static boolean validarIP(String ip) {
        Pattern pat = Pattern.compile("^(([1]?[0-9]{1,2}|2([0-4][0-9]|5[0-5])).){3}([1]?[0-9]{1,2}|2([0-4][0-9]|5[0-5]))$");
        Matcher mat = pat.matcher(ip);
        return mat.matches();
    }
}
