package br.edu.ucsal.sergiolj.containers.keypads.model;


import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;

import java.io.IOException;

public class NumericCard extends Button {

    public NumericCard(String name){
        setText(name);

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/view/calc/keypad_card.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);

        try{
            fxmlLoader.load();
        }catch (IOException exception){
            throw new RuntimeException("Falha ao carregar card para o keyboard", exception);
        }

        setOnAction(event -> {
            System.out.println("Tecla clicada: " + this.getText());
        });
    }



}
