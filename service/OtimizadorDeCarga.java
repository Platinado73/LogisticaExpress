package service;

/**
 *
 * @author PLATINADO
 */


import model.Pacote;
import java.util.*;

public class OtimizadorDeCarga {

    public static List<Pacote> otimizar(List<Pacote> pacotes, int capacidadeMax) {

        pacotes.sort(
            Comparator.comparingDouble(Pacote::getEficiencia).reversed()
        );

        List<Pacote> selecionados = new ArrayList<>();
        int pesoAtual = 0;

        for (Pacote p : pacotes) {
            if (pesoAtual + p.getPeso() <= capacidadeMax) {
                selecionados.add(p);
                pesoAtual += p.getPeso();
            }
        }

        return selecionados;
    }
}
