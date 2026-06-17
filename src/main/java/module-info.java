module br.edu.ucsal.sergiolj.chatrmi {
    requires javafx.controls;
    requires javafx.fxml;
    requires atlantafx.base;
    requires java.rmi;

    exports br.edu.ucsal.sergiolj.chatrmi.gui.controller;
    opens br.edu.ucsal.sergiolj.chatrmi.gui.controller to javafx.fxml;
    exports br.edu.ucsal.sergiolj.chatrmi.gui;
    opens br.edu.ucsal.sergiolj.chatrmi.gui to javafx.fxml;
    exports br.edu.ucsal.sergiolj.chatrmi.shared;
    opens br.edu.ucsal.sergiolj.chatrmi.shared to javafx.fxml;
    exports br.edu.ucsal.sergiolj.chatrmi.server;
    opens br.edu.ucsal.sergiolj.chatrmi.server to javafx.fxml;
}