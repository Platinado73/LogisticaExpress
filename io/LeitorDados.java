package io;

import java.io.*;
import java.util.*;
import model.Pacote;

/**
 *
 * @author PLATINADO
 */
public class LeitorDados {

    public static List<Pacote> lerPacotes(String caminho, int[] capacidade) throws IOException {

        List<Pacote> pacotes = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader(caminho));

        capacidade[0] = Integer.parseInt(br.readLine());

        String linha;
        int id = 1;

// Restantes linhas: peso e valor de cada pacote
        while ((linha = br.readLine()) != null) {
            String[] partes = linha.trim().split("\\s+");
            int peso = Integer.parseInt(partes[0]);
            int valor = Integer.parseInt(partes[1]);
            pacotes.add(new Pacote(id++, peso, valor));
        }

        br.close();
        return pacotes;
    }
}
