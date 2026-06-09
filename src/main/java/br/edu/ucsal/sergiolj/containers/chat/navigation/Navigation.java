package br.edu.ucsal.sergiolj.containers.chat.navigation;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;

public class Navigation {
    private static Stage stage;

    public static void setStage(Stage primaryStage){
        stage = primaryStage;
    }

    private static void load(String fxml, String tittle, double width, double height){
        try{
            if(stage == null){
                throw new IllegalStateException("Stage principal não foi configurado corretamente no SceneManager. Verifique" +
                        "o uso do SceneManager.setStage(Stage stage) no MainApp. ");
            }
            URL fxmlURL = Navigation.class.getResource(fxml);
            if(fxmlURL == null){
                throw new IllegalArgumentException("Arquivo Fxml não encontrado em: " + fxml);
            }

            Parent root = FXMLLoader.load(Objects.requireNonNull(Navigation.class.getResource(fxml)));

            Scene scene = new Scene(root, width, height);
            stage.setScene(scene);
            scene.getStylesheets().add(Objects.requireNonNull(
                    Navigation.class.getResource("/styles/styles.css")).toExternalForm());
            stage.setTitle(tittle);
            stage.centerOnScreen();
            stage.sizeToScene();
            stage.setResizable(false);

            stage.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void loadMainView(){
        String fxml = "/view/chat/main_view.fxml";
        String tittle = "Chat Java RMI";
        double width = 420;
        double height = 450;
        load(fxml,tittle,width,height);
    }
}
