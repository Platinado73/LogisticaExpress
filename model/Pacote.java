package model;

/**
 *
 * @author PLATINADO
 */
import java.util.Objects;

public class Pacote {

    private final int id;
    private final int peso;
    private final int valor;

    public Pacote(int id, int peso, int valor) {
        this.id = id;
        this.peso = peso;
        this.valor = valor;
    }

    public int getId() {
        return id;
    }

    public int getPeso() {
        return peso;
    }

    public int getValor() {
        return valor;
    }

    public double getEficiencia() {
        return (double) valor / peso;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Pacote)) {
            return false;
        }
        Pacote pacote = (Pacote) o;
        return id == pacote.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
