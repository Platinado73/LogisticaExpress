package app;

import io.LeitorDados;
import java.util.List;
import model.Pacote;
import service.OtimizadorDeCarga;
import util.MedidorDesempenho;

public class NewMain {

    public static void main(String[] args) {

        long inicio = System.nanoTime();

        // capacidade será lida do ficheiro
        int[] capacidade = new int[1];

        // leitura correta (capacidade + pacotes)
        List<Pacote> pacotes = LeitorDados.lerPacotes("delivery_data.txt", capacidade);

        List<Pacote> selecionados
                = OtimizadorDeCarga.otimizar(pacotes, capacidade[0]);

        int pesoTotal = 0;
        int valorTotal = 0;

        for (Pacote p : selecionados) {
            pesoTotal += p.getPeso();
            valorTotal += p.getValor();
        }

        System.out.println("\n\t===== LOGÍSTICA EXPRESS =====\n");
        System.out.println("Capacidade máxima: " + capacidade[0] + " kg");
        System.out.println("Pacotes selecionados: " + selecionados.size());
        System.out.println("Peso total utilizado: " + pesoTotal + " kg");
        System.out.println("Valor total obtido: " + valorTotal);

        double pesoMedio = (double) pesoTotal / selecionados.size();
        double valorMedio = (double) valorTotal / selecionados.size();

        System.out.printf("Peso médio por pacote: %.2f kg%n", pesoMedio);
        System.out.printf("Valor médio por pacote: %.2f%n", valorMedio);

        System.out.println("\n--- LISTA DE PACOTES ---");

        for (Pacote p : selecionados) {
            System.out.printf(
                    "ID: %-4d | Peso: %3d | Valor: %4d%n",
                    p.getId(), p.getPeso(), p.getValor()
            );
        }
    }
}
