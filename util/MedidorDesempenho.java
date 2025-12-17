package util;

/**
 *
 * @author PLATINADO
 */
public class MedidorDesempenho {

    // Mede o tempo de execução de uma tarefa
    public static long medirTempo(Runnable tarefa) {
        long inicio = System.nanoTime();
        tarefa.run();
        long fim = System.nanoTime();
        return fim - inicio;
    }

// Mede a memória usada pela JVM
    public static long memoriaUsada() {
        Runtime rt = Runtime.getRuntime();
        return (rt.totalMemory() - rt.freeMemory()) / (1024 * 1024);
    }
}
