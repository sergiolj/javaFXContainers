package br.edu.ucsal.sergiolj.javafxexemplos.model;

import java.util.LinkedList;
import java.util.List;

public class KeyboardLayout {
    private final List<String> labels = new LinkedList<>();

    public KeyboardLayout(){

    }

    public static List<String> getNumericKeypadLabelsExtended(){
        return List.of(
                "Num Lock", "/", "*", "-",
                "7", "8", "9", "+",
                "4","5","6",".",
                "1", "2", "3", "Enter",
                "0", ","
        );
    }

    public static List<String> getNumericKeypadLabelsSmall(){
        return List.of(
                "7", "8", "9", "/",
                "4","5","6","*",
                "1", "2", "3", "-",
                "C","0", ".", "+"
        );
    }
}
