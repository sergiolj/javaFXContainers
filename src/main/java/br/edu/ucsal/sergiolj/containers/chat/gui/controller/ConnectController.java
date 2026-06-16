package br.edu.ucsal.sergiolj.containers.chat.gui.controller;

import br.edu.ucsal.sergiolj.containers.chat.gui.model.Client;
import br.edu.ucsal.sergiolj.containers.chat.gui.util.ChatServerSpecs;
import br.edu.ucsal.sergiolj.containers.chat.gui.util.ChatServers;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.rmi.RemoteException;
import java.util.List;

public class ConnectController {
    @FXML
    private TextField txf_user_name;
    @FXML
    private ChoiceBox<ChatServerSpecs> chbox_servers_list;


    @FXML
    public void initialize() {
        List<ChatServerSpecs> mockList = ChatServers.getInstance().getServersList();
        chbox_servers_list.getItems().addAll(mockList);
        if(!chbox_servers_list.getItems().isEmpty()) {
            chbox_servers_list.getSelectionModel().select(0);
        }
    }

    @FXML
    private void closeWindow(ActionEvent actionEvent) {
        Node component = (Node) actionEvent.getSource();
        Stage stage = (Stage) component.getScene().getWindow();
        stage.close();
    }

    public void connectToServer(ActionEvent actionEvent) {
        if(txf_user_name.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.showAndWait();
            return;
        }
        Thread connectionThread = new Thread(() -> {
            try{
                String userName = txf_user_name.getText();
                Client client = new Client(userName);
                Platform.runLater(() -> {
                    closeWindow(actionEvent);
                });

            } catch (RemoteException e) {
                throw new RuntimeException(e);
            }
        });
        connectionThread.setDaemon(true);
        connectionThread.start();

    }
}
