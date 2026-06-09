package br.edu.ucsal.sergiolj.containers.keypads.controller;

import javafx.fxml.FXML;

import javafx.scene.Parent;
import javafx.scene.control.ToggleButton;

public class MainViewController {
    @FXML
    private Parent keypad_reg, keypad_ext;

    @FXML
    private ToggleButton tgb_switch;

    /**
     * Implementação da alternância de layouts de teclado com base em um ToggleButton.
     *
     * O bind usa uma lógica binária existente no toggle button e conecta essa mesma lógica aos atributos do Parent, que é uma
     * superclasse abstrata de elementos visuais do JavaFX filha de Node. A classe Parent é superclasse dos
     * gerenciadores de layout como GridPane, StackPane, HBox, TilePane, etc.
     * Embora as propriedades de bind utilizadas sejam herdadas de Node, a classe Parent é a mais específica.
     */
    @FXML
    public void initialize(){
        keypad_ext.visibleProperty().bind(tgb_switch.selectedProperty());
        keypad_ext.managedProperty().bind(tgb_switch.selectedProperty());

        keypad_reg.visibleProperty().bind(tgb_switch.selectedProperty().not());
        keypad_reg.managedProperty().bind(tgb_switch.selectedProperty().not());
    }

}
