package model;

import java.util.List;

/**
 *
 * @author PLATINADO
 */
public class ResultadoMochila {
    
    private int valorTotal;
    private int pesoTotal;
    private List<Pacote> pacotes;

    public ResultadoMochila(int valorTotal, int pesoTotal, List<Pacote> pacotes) {
        this.valorTotal = valorTotal;
        this.pesoTotal = pesoTotal;
        this.pacotes = pacotes;
    }

    public int getValorTotal() {
        return valorTotal;
    }

    public int getPesoTotal() {
        return pesoTotal;
    }

    public List<Pacote> getPacotes() {
        return pacotes;
    }
    
    
    
    
}
