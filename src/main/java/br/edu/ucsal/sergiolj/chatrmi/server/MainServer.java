package br.edu.ucsal.sergiolj.chatrmi.server;

import br.edu.ucsal.sergiolj.chatrmi.server.service.ChatServerRemoteObject;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class MainServer {
    public static void main(String[] args) {
        try{
            ChatServerRemoteObject chatServer = new ChatServerRemoteObject();
            Registry registry = LocateRegistry.createRegistry(Config.getServerPort());
            registry.rebind(Config.getServerName(), chatServer);

            System.out.println("Server RMI \n[Server Name: " + Config.getServerName() + "] port: "
                    + Config.getServerPort() + " ] online..");

        } catch (RemoteException e) {
            System.out.println("Erro ao iniciar servidor RMI. " + e.getMessage());
            throw new RuntimeException(e);
        }
    }
}
