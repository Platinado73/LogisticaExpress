package app;

import Algoritmo.*;
import java.util.*;
import model.*;
import util.MedidorDesempenho;

/**
 *
 * @author PLATINADO
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            int[] capacidade = new int[1];

// Leitura dos dados
            List<Pacote> pacotes = LeitorDeDados.lerPacotes("delivery_data.txt", capacidade);

            long memoriaAntes = MedidorDesempenho.memoriaUsada();

            final ResultadoMochila[] resultado = new ResultadoMochila[1];

            long tempo = MedidorDesempenho.medirTempo(() -> {
                resultado[0] = AlgoritmoMochila.resolver(pacotes, capacidade[0]);
            });

            long memoriaDepois = MedidorDesempenho.memoriaUsada();

// Apresentação dos resultados
            System.out.println("\n\t===== LOGÍSTICA EXPRESS =====\n\t");
            System.out.println("Capacidade máxima: " + capacidade[0] + " kg");
            System.out.println("Valor total obtido: " + resultado[0].getValorTotal());
            System.out.println("Peso total utilizado: " + resultado[0].getPesoTotal() + " kg");

            System.out.println("\n\tPacotes selecionados:\n\t");
            for (Pacote p : resultado[0].getPacotes()) {
                System.out.println("ID " + p.getId() + " | Peso: " + p.getPeso() + " | Valor: " + p.getValor());
            }

            System.out.println("\n\tTempo de execução: " + tempo / 1_000_000 + " ms");
            System.out.println("Memória utilizada: " + (memoriaDepois - memoriaAntes) / (1024 * 1024) + " MB");
            System.out.println("============================");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

}
