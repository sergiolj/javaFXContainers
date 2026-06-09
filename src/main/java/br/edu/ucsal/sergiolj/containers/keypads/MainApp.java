package br.edu.ucsal.sergiolj.containers.keypads;

import br.edu.ucsal.sergiolj.containers.keypads.navigation.Navigation;
import javafx.application.Application;
import javafx.stage.Stage;

import java.io.IOException;

public class MainApp extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        Navigation.setStage(stage);
        Navigation.loadMainView();

    }

    public static void main(String[] args) {
        launch();
    }
}