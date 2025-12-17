package io;

import model.Pacote;
import java.io.*;
import java.util.*;

public class LeitorDados {

    public static List<Pacote> lerPacotes(String caminho, int[] capacidade) {

        List<Pacote> pacotes = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(caminho))) {

            String linha;
            int id = 1;

            // Lê a capacidade (1ª linha)
            capacidade[0] = Integer.parseInt(br.readLine().trim());

            // Lê os pacotes
            while ((linha = br.readLine()) != null) {

                linha = linha.trim();
                if (linha.isEmpty()) {
                    continue;
                }

                String[] partes = linha.split("\\s+"); // espaço

                if (partes.length != 2) {
                    continue;
                }

                int peso = Integer.parseInt(partes[0]);
                int valor = Integer.parseInt(partes[1]);

                if (peso <= 0 || valor <= 0) {
                    continue;
                }

                pacotes.add(new Pacote(id++, peso, valor));
            }

        } catch (IOException e) {
            System.out.println("Erro ao ler ficheiro: " + e.getMessage());
        }

        return pacotes;
    }
}
