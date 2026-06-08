package br.edu.ucsal.sergiolj.javafxexemplos;

import br.edu.ucsal.sergiolj.javafxexemplos.navigation.Navigation;
import javafx.application.Application;
import javafx.stage.Stage;

import java.io.IOException;

public class MainApp extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        Navigation.setStage(stage);
        Navigation.loadNumKeyboard();

    }

    public static void main(String[] args) {
        launch();
    }
}