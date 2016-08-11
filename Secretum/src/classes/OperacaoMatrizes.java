package classes;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class OperacaoMatrizes {

    public static final DecimalFormat formata_double = new DecimalFormat("0.00000");

    public static double[][] matrizBase() {
        return new double[][]{{2, 1, -2}, {3, 2, 1}, {-4, -2, 2}};
    }

    public static double numerosPrimosPadrao() {
        return 3d * 2d;
    }

    public static double[][] matrizBaseInversa() {
        return inversaMatriz(matrizBase(), false);
    }

    public static double[] somaVetores(double[] a, double[] b) {
        if (a.length != b.length) {
            throw new Error("colunas vetor a != colunas vetor b");
        }

        double[] result = new double[a.length];
        for (int i = 0; i < a.length; i++) {
            result[i] = a[i] + b[i];
        }
        return result;
    }

    public static double[] diminuirVetores(double[] a, double[] b) {
        if (a.length != b.length) {
            throw new Error("colunas vetor a != colunas vetor b");
        }

        double[] result = new double[a.length];
        for (int i = 0; i < a.length; i++) {
            result[i] = a[i] - b[i];
        }
        return result;
    }

    public static void imprimeVetor(double[] a) {
        for (double b : a) {
            System.out.print(formata_double.format(b) + "\t");
        }
    }

    public static void imprimeMatriz(double[][] a) {
        for (double[] linha : a) {
            imprimeVetor(linha);
            System.out.println();
        }
    }

    public static double[][] transpoemMatriz(double[][] a) {
        double[][] result = new double[a[0].length][a.length];
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                result[j][i] = a[i][j];
            }
        }
        return result;
    }

    private static double linhaxColuna(double[] a, double[] b) {
        double soma = 0;
        for (int i = 0; i < a.length; i++) {
            soma += a[i] * b[i];
        }
        return soma;
    }

    public static double[] vetorPorEscalar(double[] a, double num) {
        double[] result = new double[a.length];
        for (int i = 0; i < a.length; i++) {
            result[i] = a[i] * num;
        }
        return result;
    }

    public static double[][] matrizPorEscalar(double[][] a, double num) {
        double[][] result = new double[a.length][a[0].length];
        for (int i = 0; i < a.length; i++) {
            result[i] = vetorPorEscalar(a[i], num);
        }
        return result;
    }

    public static double[][] multiplicaMatrizes(double[][] a, double[][] b) {
        if (a[0].length != b.length) {
            throw new Error("colunas matriz a != linhas matriz b");
        }
        double[][] transpostaB = transpoemMatriz(b);
        double[][] mat_produto = new double[a.length][b[0].length];
        for (int linhaA = 0; linhaA < a.length; linhaA++) {
            for (int linhaB = 0; linhaB < transpostaB.length; linhaB++) {
                mat_produto[linhaA][linhaB] = linhaxColuna(a[linhaA], transpostaB[linhaB]);
            }
        }
        return mat_produto;
    }

    public static double[][] matrizIdentidade(int ordem) {
        double[][] result = new double[ordem][ordem];
        for (int i = 0; i < ordem; i++) {
            for (int j = 0; j < ordem; j++) {
                result[i][j] = (i == j) ? 1 : 0;
            }
        }
        return result;
    }

    public static double[][] somaMatrizes(double[][] a, double[][] b) {
        if (a.length != b.length || a[0].length != b[0].length) {
            throw new Error("as matrixes devem possuir a mesma ordem");
        }

        double[][] result = new double[a.length][a[0].length];

        for (int i = 0; i < a.length; i++) {
            result[i] = somaVetores(a[i], b[i]);
        }

        return result;
    }

    public static double[][] diminuiMatrizes(double[][] a, double[][] b) {
        if (a.length != b.length || a[0].length != b[0].length) {
            throw new Error("as matrixes devem possuir a mesma ordem");
        }

        double[][] result = new double[a.length][a[0].length];

        for (int i = 0; i < a.length; i++) {
            result[i] = diminuirVetores(a[i], b[i]);
        }

        return result;
    }

    public static double inversoNumero(double num) {
        return (1 / num);
    }

    public static double[] linhaxLinhaMultiplicaLinha(double[] a, double[] b, double num) {
        a = vetorPorEscalar(a, num);
        return somaVetores(a, b);
    }

    public static double determinanteMatriz(double[][] a) {
        if (a.length != a[0].length) {
            throw new Error("a coluna deve ser quadrada");
        }

        if (todosValoresColunaSaoZero(0, a)) {
            return 0;
        }

        double[][] calcs = a.clone();
        int l = calcs.length;

        //deixa o pivo inicial diferente de 0 se o mesmo for 0
        int linha_somar = 1;
        while (calcs[0][0] == 0d) {
            calcs[0] = somaVetores(calcs[0], calcs[linha_somar]);
            linha_somar++;
        }

        ArrayList<Double> multiplicacoes = new ArrayList<>();

        for (int i = 0; i < l; i++) {
            for (int j = 0; j < l; j++) {
                if (i == j) {
                    double valor_normal = calcs[i][j];
                    multiplicacoes.add(valor_normal);
                    double valor_inverso = inversoNumero(valor_normal);
                    calcs[i] = vetorPorEscalar(calcs[i], valor_inverso);
                    break;
                }
            }
            for (int k = 0; k < l; k++) {
                if (k != i && calcs[k][i] != 0) {
                    double v = -calcs[k][i];
                    calcs[k] = linhaxLinhaMultiplicaLinha(calcs[i], calcs[k], v);
                }
            }
        }

        double valor = 1;
        for (Double v : multiplicacoes) {
            valor *= v;
        }

        return valor;
    }

    private static boolean todosValoresColunaSaoZero(int col, double[][] a) {
        for (double[] linha : a) {
            if (linha[col] != 0d) {
                return false;
            }
        }
        return true;
    }

    public static double[][] inversaMatriz(double[][] a, boolean veref_det) {
        if (a.length != a[0].length) {
            throw new Error("a coluna deve ser quadrada");
        }

        if (veref_det) {
            if (determinanteMatriz(a) == 0d) {
                throw new Error("o determinante é 0, nao existe inversa");
            }
        }

        double[][] calcs = a.clone();
        int l = calcs.length;
        double[][] iden = matrizIdentidade(l);

        int linha_somar = 1;
        while (calcs[0][0] == 0d) {
            calcs[0] = somaVetores(calcs[0], calcs[linha_somar]);
            iden[0] = somaVetores(iden[0], iden[linha_somar]);
            linha_somar++;
        }

        for (int i = 0; i < l; i++) {
            for (int j = 0; j < l; j++) {
                if (i == j) {
                    double valor = inversoNumero(calcs[i][j]);
                    calcs[i] = vetorPorEscalar(calcs[i], valor);
                    iden[i] = vetorPorEscalar(iden[i], valor);
                    break;
                }
            }
            for (int k = 0; k < l; k++) {
                if (k != i && calcs[k][i] != 0) {
                    double v = -calcs[k][i];
                    calcs[k] = linhaxLinhaMultiplicaLinha(calcs[i], calcs[k], v);
                    iden[k] = linhaxLinhaMultiplicaLinha(iden[i], iden[k], v);
                }
            }
        }

        return iden;
    }

}
