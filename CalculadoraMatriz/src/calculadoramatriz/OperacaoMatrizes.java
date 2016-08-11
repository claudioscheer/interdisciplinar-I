package calculadoramatriz;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class OperacaoMatrizes {

    public static final DecimalFormat formata_double = new DecimalFormat("0.00000");

    public static double[][] matrizBase() {
        return new double[][]{{2, 1, -2}, {3, 2, 1}, {-4, -2, 2}};
    }

    public static double[][] matrizBaseInversa() {
        return inversaMatriz(matrizBase());
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

    public static void imprimeVetor(double[] a) {
        for (double b : a) {
            System.out.print(formata_double.format(b) + "\t");
        }
    }

    public static void imprimeMatriz(double[][] mat) {
        for (double[] linha : mat) {
            imprimeVetor(linha);
            System.out.println();
        }
    }

    public static double[][] transpoemMatriz(double[][] mat) {
        double[][] matNew = new double[mat[0].length][mat.length];
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                matNew[j][i] = mat[i][j];
            }
        }
        return matNew;
    }

    private static double linhaxColuna(double[] a, double[] b) {
        double soma = 0;
        for (int i = 0; i < a.length; i++) {
            soma += a[i] * b[i];
        }
        return soma;
    }

    public static double[] vetorPorEscalar(double[] a, double escalar) {
        double[] result = new double[a.length];
        for (int i = 0; i < a.length; i++) {
            result[i] = a[i] * escalar;
        }
        return result;
    }

    public static double[][] matrizPorEscalar(double[][] mat, double escalar) {
        double[][] result = new double[mat.length][mat[0].length];
        for (int i = 0; i < mat.length; i++) {
            result[i] = vetorPorEscalar(mat[0], escalar);
        }
        return mat;
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

    public static double[][] matrizIdentidade(int l) {
        double[][] result = new double[l][l];
        for (int i = 0; i < l; i++) {
            for (int j = 0; j < l; j++) {
                result[i][j] = (i == j) ? 1 : 0;
            }
        }
        return result;
    }

    public static double inversoNumero(double num) {
        return (1 / num);
    }

    public static double[] linhaxLinhaMultiplicaLinha(double[] a, double[] b, double valor) {
        a = vetorPorEscalar(a, valor);
        return somaVetores(a, b);
    }

    public static double determinanteMatriz(double[][] mat) {
        if (mat.length != mat[0].length) {
            throw new Error("a coluna deve ser quadrada");
        }
        double[][] calcs = mat;
        ArrayList<Double> multi = new ArrayList();
        int l = mat.length;
        for (int i = 0; i < l; i++) {

            for (int k = 0; k < l; k++) {
                if (k != i && mat[k][i] != 0) {
                    double v = -mat[k][i];
                    mat[k] = linhaxLinhaMultiplicaLinha(mat[i], mat[k], v);
                }
            }
        }

        double valor = 0;
        for (int i = 0; i < l; i++) {
            for (int j = 0; j < l; j++) {
                if (i == j) {
                    valor *= mat[i][j];
                }
            }
        }

        for (double m : multi) {
            valor *= m;
        }

        return valor;

    }

    public static double[][] inversaMatriz(double[][] mat) {
        if (mat.length != mat[0].length) {
            throw new Error("a coluna deve ser quadrada");
        }
        double[][] calcs = mat;
        int l = calcs.length;
        double[][] iden = matrizIdentidade(l);
        for (int i = 0; i < l; i++) {
            for (int j = 0; j < l; j++) {
                if (i == j) {
                    while (calcs[i][j] == 0) {
                        calcs[i] = somaVetores(calcs[i], calcs[i + 1]);
                        iden[i] = somaVetores(iden[i], iden[i + 1]);
                    }
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
