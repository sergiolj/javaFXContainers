package br.edu.ucsal.sergiolj.chatrmi.shared;

import br.edu.ucsal.sergiolj.chatrmi.gui.controller.MainViewController;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface ClientInterface extends Remote {

    void broadcast(String message) throws RemoteException;
    String userName() throws RemoteException;
    void onlineUsersListChanged(List<String> onlineUsersList) throws RemoteException;
    void disconnect(MainViewController mainController) throws RemoteException;
    void sendMessageCommand(String trim) throws RemoteException;
}
