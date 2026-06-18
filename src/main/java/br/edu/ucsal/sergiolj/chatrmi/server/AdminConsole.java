package br.edu.ucsal.sergiolj.chatrmi.server;

import br.edu.ucsal.sergiolj.chatrmi.shared.ChatServerInterface;

import java.rmi.Naming;



public class AdminConsole {
    public static void main(String[] args) {
        if(args.length<3){
            System.out.println("Uso correto: AdminConsole <ip_servidor> <porta> <senha>\nSenha default: admin");
            return;
        }
        String ip = args[0];
        int port = Integer.parseInt(args[1]);
        String password = args[2];

        try{
            String url = "rmi://" + ip + ":" + port + "/" + Config.getServerName();
            ChatServerInterface adminStub = (ChatServerInterface) Naming.lookup(url);

            System.out.println("Conectado ao servidor " + ip + ". Enviando comando de shutdown...");

            adminStub.shuttdown(password);

            System.out.println("Comando aceito! O servidor será desligado com segurança.");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
