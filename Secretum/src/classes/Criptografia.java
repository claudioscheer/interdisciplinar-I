package classes;

public class Criptografia {

    private static final int numero_linhas = 3;
    
    public static void main(String[] args) {
        String s = criptografa("Oi! Qual é o seu nome?");
        System.out.println(s);
        System.out.println(descriptografa(s));
    }

    //pega o texto e transforma ele em um vetor
    private static double[] textoParaVetor(String texto, boolean remover_separador) {
        double[] result;
        if (!remover_separador) {
            result = new double[texto.length()];
            for (int i = 0; i < result.length; i++) {
                result[i] = (double) texto.charAt(i);
            }
        } else {
            String[] chars = texto.split(Utils.caracter_padrao);
            result = new double[chars.length];
            for (int i = 0; i < result.length; i++) {
                result[i] = Double.valueOf(chars[i]);
            }
        }
        return result;
    }

    private static double[][] textoParaMatriz(String texto, boolean criptografa) {
        double[] chars = textoParaVetor(texto, !criptografa);
        int lenght_matriz = chars.length;

        while (lenght_matriz % numero_linhas != 0) {
            lenght_matriz++;
        }

        double[][] letras;
        if (!criptografa) {
            letras = new double[lenght_matriz / numero_linhas][numero_linhas];
        } else {
            letras = new double[numero_linhas][lenght_matriz / numero_linhas];
        }
        int posicao_letra = 0;
        for (double[] linha : letras) {
            for (int j = 0; j < letras[0].length; j++) {
                if (posicao_letra < chars.length) {
                    linha[j] = (double) chars[posicao_letra];
                    posicao_letra++;
                } else {
                    linha[j] = 0;
                }
            }
        }
        return letras;
    }

    /**
     * Criptografia o texto passado como parametro.
     * @param texto O texto pode conter qualquer caractere e não têm limite de caracteres
     * @return String de texto criptografado
     */
    public static String criptografa(String texto) {
        double[][] mat = textoParaMatriz(texto, true);
        double[][] multi = OperacaoMatrizes.multiplicaMatrizes(OperacaoMatrizes.matrizBase(), mat);
        double[][] result = OperacaoMatrizes.transpoemMatriz(multi);
        return bytesParaTexto(matrizParaTexto(result).getBytes());
    }

    private static byte[] stringParaByte(String bytes) {
        int length = bytes.length();
        byte[] result = new byte[length / 2];
        String s;
        int posicao_byte = 0;
        for (int i = 0; i < length; i += 2) {
            s = bytes.substring(i, i + 2);
            result[posicao_byte] = Byte.valueOf(s);
            posicao_byte++;
        }
        return result;
    }

    private static String bytesParaTexto(byte[] b) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < b.length; i++) {
            sb.append(b[i]);
        }
        return sb.toString();
    }

    private static String matrizParaTexto(double[][] chars) {
        StringBuilder sb = new StringBuilder();
        for (double[] linha : chars) {
            for (int j = 0; j < linha.length; j++) {
                sb.append(linha[j]).append(Utils.caracter_padrao);
            }
        }
        return sb.toString();
    }

    /**
     * Dexcriptografa o texto passado, transformando-o em um texto legível.
     * @param texto Passar o texto criptografado para descriptografar
     * @return Retorna o texto descriptografado
     */
    public static String descriptografa(String texto) {
        double[][] chars = OperacaoMatrizes.transpoemMatriz(textoParaMatriz(new String(stringParaByte(texto)), false));
        double[][] result = OperacaoMatrizes.multiplicaMatrizes(OperacaoMatrizes.matrizBaseInversa(), chars);
        StringBuilder sb = new StringBuilder();
        for (double[] linha : result) {
            for (int j = 0; j < linha.length; j++) {
                if (linha[j] != 0) {
                    sb.append((char) linha[j]);
                }
            }
        }
        return sb.toString();
    }
}