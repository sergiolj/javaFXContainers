package br.edu.ucsal.sergiolj.containers.chat.gui.navigation;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.TextAlignment;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;

public class Navigation {
    private static Stage primaryStage;

    public static void setPrimaryStage(Stage primaryStage) {
        Navigation.primaryStage = primaryStage;
    }

    private static void loadInPrimaryWindow(String fxml, String tittle, double width, double height) {
        try {
            if (primaryStage == null) {
                throw new IllegalStateException("Stage principal não foi configurado corretamente no SceneManager. Verifique" +
                        "o uso do SceneManager.setStage(Stage stage) no MainApp. ");
            }
            URL fxmlURL = Navigation.class.getResource(fxml);
            if (fxmlURL == null) {
                throw new IllegalArgumentException("Arquivo Fxml não encontrado em: " + fxml);
            }

            Parent root = FXMLLoader.load(Objects.requireNonNull(Navigation.class.getResource(fxml)));

            Scene scene = new Scene(root, width, height);
            primaryStage.setScene(scene);
            scene.getStylesheets().add(Objects.requireNonNull(
                    Navigation.class.getResource("/styles/styles.css")).toExternalForm());
            primaryStage.setTitle(tittle);
            primaryStage.centerOnScreen();
            primaryStage.sizeToScene();
            primaryStage.setResizable(false);

            primaryStage.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void loadInModalWindow(String fxml, String tittle, double width, double height) {
        try {
            FXMLLoader loader = new FXMLLoader(Navigation.class.getResource(fxml));
            Parent root = loader.load();

            Scene scene = new Scene(root);
            Stage stageModal = new Stage();
            stageModal.setScene(scene);

            stageModal.setTitle(tittle);
            stageModal.initOwner(primaryStage);
            stageModal.initModality(Modality.WINDOW_MODAL);

            stageModal.setResizable(false);
            stageModal.showAndWait();

        } catch (Exception e) {
            System.out.println("Erro ao carregar janela modal: " + fxml);
            System.out.println(e.getMessage());
        }
    }

    public static void loadMainView() {
        String fxml = "/view/chat/main_view.fxml";
        String tittle = "Chat Java RMI";
        double width = 420;
        double height = 450;
        loadInPrimaryWindow(fxml, tittle, width, height);
    }

    public static void loadConfigView() {
        String fxml = "/view/chat/chat_config.fxml";
        String tittle = "Server Configuration";
        double width = 400;
        double height = 450;
        loadInModalWindow(fxml, tittle, width, height);
    }

    public static void loadConnectView() {
        String fxml = "/view/chat/chat_connect.fxml";
        String tittle = "Connect to Server";
        double width = 400;
        double height = 450;
        loadInModalWindow(fxml, tittle, width, height);
    }
    /**
     * Essa foi uma janela About criada originalmente usando a classe Alert, mas para ter certa customização sobre o
     * resultado, foi substituída pelo método usando Stage que possibilitou uma customização da centralização e
     * das margens
     *
     */
    public static void about() {
        Stage dialogStage = new Stage();
        dialogStage.setTitle("About Chat Client RMI");

        //Uma janela modal é uma janela que bloqueia a janela atrás dela.
        dialogStage.initModality(Modality.APPLICATION_MODAL);

        VBox vbox = new VBox();
        vbox.setAlignment(Pos.CENTER);
        vbox.setSpacing(10);
        vbox.setPadding(new Insets(20));

        Label title = new Label("Chat Client Application");
        title.setStyle("-fx-font-size: 16px; -fx-font-weight: bold;");
        Label description = new Label("Este app foi desenvolvido pelo autor para" +
                "\n explorar os conceitos e aplicações de Java FX.\n" +
                "Verifique as configurações do servidor RMI disponível.");
        description.setTextAlignment(TextAlignment.CENTER);

        Button exit = new Button("Close");
        exit.setOnAction(event -> {
            dialogStage.close();
        });

        vbox.getChildren().addAll(title, description, exit);
        Scene scene = new Scene(vbox);
        dialogStage.setScene(scene);

        dialogStage.sizeToScene();
        dialogStage.setResizable(false);
        dialogStage.showAndWait();
    }
}

