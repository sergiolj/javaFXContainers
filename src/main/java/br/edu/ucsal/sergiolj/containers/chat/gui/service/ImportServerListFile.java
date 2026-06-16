package br.edu.ucsal.sergiolj.containers.chat.gui.service;

import br.edu.ucsal.sergiolj.containers.chat.gui.util.ChatServerSpecs;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class ImportServerListFile {
    public static List<ChatServerSpecs> readServerListFile(String path) throws IOException {
        List<ChatServerSpecs> serversList = new ArrayList<>();

        try {
            String fileContent = Files.readString(Path.of(path));
            String[] serverData = fileContent.split(";");

            for (String currentServer : serverData) {
                if (currentServer.trim().isEmpty()) continue;
                String[] server = currentServer.split(",");
                if (server.length == 3) {
                    String name = server[0].trim();
                    String IP = server[1].trim();
                    int port = Integer.parseInt(server[2].trim());

                    serversList.add(new ChatServerSpecs(name, IP, port));
                }
            }
        }catch (Exception e) {
            System.out.println("Erro ao ler o arquivo: " + e.getMessage());
        }
        return serversList;
    }
}
