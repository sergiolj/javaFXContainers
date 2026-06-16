package br.edu.ucsal.sergiolj.containers.chat.gui.util;

import java.util.ArrayList;
import java.util.List;

public class ChatServers {
    private static ChatServers instance;
    private final List<ChatServerSpecs> serversList = new ArrayList<>();

    public static ChatServers getInstance() {
        if (instance == null) {
            instance = new ChatServers();
        }
        return instance;
    }

    private ChatServers() {
        serversList.add(new ChatServerSpecs("Chat_RMI_Server", "127.0.0.1", 1099));
        serversList.add(new ChatServerSpecs("NewChatServer", "127.0.0.1", 1099));
        }

        public List<ChatServerSpecs> getServersList() {
            return serversList;
        }
    }