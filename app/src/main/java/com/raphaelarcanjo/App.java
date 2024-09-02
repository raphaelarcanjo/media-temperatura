package com.raphaelarcanjo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

/**
 * Faça um programa que receba a temperatura média dos 6 primeiros meses
 * do ano e armazene-as em uma lista.
 * Após isso, calcule a média semestral das temperaturas e mostre todas as
 * temperaturas acima da média e em qual mês elas ocorreram (mostrar o mês
 * por extenso: 1 - janeiero, 2 - fevereiro, etc.)
 */
public class App {
    public static void main(String[] args) throws Exception {
        List<String> meses = new ArrayList<>(Arrays.asList(
            "Janeiro", "Fevereiro", "Março", "Abril", "Maio", "Junho"
        ));

        List<Double> temperaturas = capturarTemperaturas(meses);

        Double mediaSemestral = calcularMediaSemestral(temperaturas);
        
        System.out.format("A média semestral foi de %.1f" + " graus \n", mediaSemestral);

        exibirMesesAcimaMedia(meses, temperaturas, mediaSemestral);

    }

    private static List<Double> capturarTemperaturas(List<String> meses) {
        Scanner scanner = new Scanner(System.in);
        scanner.useLocale(Locale.US);

        List<Double> temperaturas = new ArrayList<>();

        for (int i = 0; i < 6; i++) {
            System.out.println("Informe a temperatura para o mês de " + meses.get(i));
            Double temperatura = scanner.nextDouble();
            temperaturas.add(i, temperatura);
        }

        scanner.close();

        return temperaturas;
    }

    private static Double calcularMediaSemestral(List<Double> temperaturas) {
        Double mediaSemestral = 0d;

        Iterator<Double> iteratorTemperatura = temperaturas.iterator();

        while (iteratorTemperatura.hasNext()) {
            Double temperatura = iteratorTemperatura.next();
            mediaSemestral += temperatura;
        }

        mediaSemestral /= temperaturas.size();

        return mediaSemestral;
    }


    private static void exibirMesesAcimaMedia(List<String> meses, List<Double> temperaturas, Double mediaSemestral) {
        for (int i = 0; i < temperaturas.size(); i++) {
            if (temperaturas.get(i).compareTo(mediaSemestral) == 1) {
                String mes = meses.get(i);
                double acimaMedia = temperaturas.get(i) - mediaSemestral;
                System.out.format(
                    "No mês de %s" + " foi de %.1f" + ". %.1f" + " graus acima da média (%.1f" + ") \n",
                    mes,
                    temperaturas.get(i),
                    acimaMedia,
                    mediaSemestral
                );
            }
        }
    }


}
