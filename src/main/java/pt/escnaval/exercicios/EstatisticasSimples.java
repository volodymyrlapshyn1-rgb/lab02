package pt.escnaval.exercicios;

import java.util.Locale;
import java.util.Scanner;

public class EstatisticasSimples {

    public static void main(String[] args) {

        Locale.setDefault(Locale.US);

        try (Scanner sc = new Scanner(System.in)) {

            int n = 0;
            double soma = 0.0;
            double minimo = Double.POSITIVE_INFINITY;
            double maximo = Double.NEGATIVE_INFINITY;

            System.out.println("Introduza valores, um por linha.");
            System.out.println("Linha vazia termina o programa.");

            while (true) {

                System.out.print("Valor: ");
                String linha = sc.nextLine().trim();

                // Linha vazia termina a leitura
                if (linha.isEmpty()) {
                    break;
                }

                try {
                    double valor = Double.parseDouble(linha);

                    n++;
                    soma += valor;

                    if (valor < minimo) {
                        minimo = valor;
                    }

                    if (valor > maximo) {
                        maximo = valor;
                    }

                } catch (NumberFormatException e) {
                    System.out.println("Valor não numérico ignorado.");
                }
            }

            if (n > 0) {

                double media = soma / n;

                System.out.println("\n--- Estatísticas ---");
                System.out.println("n = " + n);
                System.out.printf("Soma = %.3f%n", soma);
                System.out.printf("Média = %.3f%n", media);
                System.out.printf("Mínimo = %.3f%n", minimo);
                System.out.printf("Máximo = %.3f%n", maximo);

            } else {
                System.out.println("Nenhum valor numérico introduzido.");
            }
        }
    }
}