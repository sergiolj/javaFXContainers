package br.edu.ucsal.sergiolj.containers.chat.gui.controller;

import br.edu.ucsal.sergiolj.containers.chat.gui.navigation.Navigation;
import br.edu.ucsal.sergiolj.containers.chat.server.service.ChatServerRemoteObject;
import br.edu.ucsal.sergiolj.containers.chat.shared.ClientInterface;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainViewController {

    @FXML
    private ListView<String> listv_online_users;

    @FXML
    private void configServerSpecs(ActionEvent actionEvent) {
        Navigation.loadConfigView();
    }

    @FXML
    private void exitApp(ActionEvent actionEvent) {
        System.exit(0);
    }

    @FXML
    public void initialize() {
    }

    public void refreshOnlineUsers(List<String> onlineUsers) {
        listv_online_users.getItems().clear();
        listv_online_users.getItems().addAll(onlineUsers);
    }

    public void connectToServer(ActionEvent actionEvent) {
        Navigation.loadConnectView();
    }

    public void about(ActionEvent actionEvent) {
        Navigation.about();
    }
}
