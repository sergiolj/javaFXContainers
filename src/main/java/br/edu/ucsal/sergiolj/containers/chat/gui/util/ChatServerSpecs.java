package br.edu.ucsal.sergiolj.containers.chat.gui.util;

public record ChatServerSpecs(String name, String IP, int port) {

    @Override
    public String toString() {
        return this.name + " (" + this.IP + ": " + this.port + ")";
    }
}
