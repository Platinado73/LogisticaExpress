package Algoritmo;

import java.util.*;
import model.*;

/**
 *
 * @author PLATINADO
 */
public class AlgoritmoMochila {

    public static ResultadoMochila resolver(List<Pacote> pacotes, int capacidade) {

        int n = pacotes.size();

// Tabela DP (n+1) x (capacidade+1)
        int[][] dp = new int[n + 1][capacidade + 1];

// Construção da tabela
        for (int i = 1; i <= n; i++) {
            Pacote p = pacotes.get(i - 1);

            for (int w = 0; w <= capacidade; w++) {
                if (p.getPeso() <= w) {
                    dp[i][w] = Math.max(
                            dp[i - 1][w],
                            p.getValor() + dp[i - 1][w - p.getPeso()]
                    );
                } else {
                    dp[i][w] = dp[i - 1][w];
                }
            }
        }

// Reconstrução da solução
        List<Pacote> escolhidos = new ArrayList<>();
        int w = capacidade;
        int pesoTotal = 0;

        for (int i = n; i > 0; i--) {
            if (dp[i][w] != dp[i - 1][w]) {
                Pacote p = pacotes.get(i - 1);
                escolhidos.add(p);
                w -= p.getPeso();
                pesoTotal += p.getPeso();
            }
        }

        return new ResultadoMochila(dp[n][capacidade], pesoTotal, escolhidos);
    }
    
}
