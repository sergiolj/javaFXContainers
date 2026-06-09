package br.edu.ucsal.sergiolj.containers.chat;

import br.edu.ucsal.sergiolj.containers.keypads.navigation.Navigation;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;

public class MainApp extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        try {
            URL fxmlURL = MainApp.class.getResource("/view/chat/chat_main.fxml");
            if (fxmlURL == null) {
                throw new IllegalArgumentException("Arquivo Fxml não encontrado");
            }
            FXMLLoader loader = new FXMLLoader(fxmlURL);
            Parent root = loader.load();

            Scene scene = new Scene(root);
            stage.setFullScreen(true);
            stage.setScene(scene);
            stage.setTitle("Cliente chat RMI");
            stage.centerOnScreen();
            stage.show();

        } catch (IllegalArgumentException | IOException e) {
            throw new IllegalArgumentException(e);
        }
    }

    public static void main(String[] args) {
        launch();
    }
}