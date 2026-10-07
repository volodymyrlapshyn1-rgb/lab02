package pt.escnaval.exercicios;

import java.util.Locale;
import java.util.Scanner;

public class ConversorUnidades {

    private static final double KM_POR_MILHA = 1.609344;

    // Métodos puros: recebem um valor e devolvem o resultado.
    // Não fazem leitura nem impressão.
    static double kmParaMi(double km) {
        return km / KM_POR_MILHA;
    }

    static double miParaKm(double mi) {
        return mi * KM_POR_MILHA;
    }

    public static void main(String[] args) {

        Locale.setDefault(Locale.US);

        try (Scanner sc = new Scanner(System.in)) {

            int opcao;

            // Validação da opção
            while (true) {
                System.out.println("1) km -> mi");
                System.out.println("2) mi -> km");
                System.out.print("Escolha uma opção: ");

                String entrada = sc.nextLine().trim();

                try {
                    opcao = Integer.parseInt(entrada);

                    if (opcao == 1 || opcao == 2) {
                        break;
                    }

                } catch (NumberFormatException e) {
                    // Continua para a mensagem de erro
                }

                System.out.println("Opção inválida. Tente novamente.\n");
            }

            System.out.print("Introduza o valor: ");
            double valor = lerDouble(sc);

            double resultado;

            if (opcao == 1) {
                resultado = kmParaMi(valor);
                System.out.printf("%.3f km = %.3f mi%n",
                        valor, resultado);
            } else {
                resultado = miParaKm(valor);
                System.out.printf("%.3f mi = %.3f km%n",
                        valor, resultado);
            }
        }
    }

    static double lerDouble(Scanner sc) {

        while (true) {
            String entrada = sc.nextLine();

            try {
                return Double.parseDouble(entrada.trim());
            } catch (NumberFormatException e) {
                System.out.print("Número inválido. Tente novamente: ");
            }
        }
    }
}