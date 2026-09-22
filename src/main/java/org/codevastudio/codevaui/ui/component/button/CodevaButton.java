package org.codevastudio.codevaui.ui.component.button;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import java.net.URL;
import java.util.ResourceBundle;

// Creamos el controlador encargado de gestionar el comportamiento del componente CodevaButton
public class CodevaButton implements Initializable {

    // Definimos y conectamos nuestros componentes del archivo FXML.
    @FXML private Label lblTexto; // Representa el texto que mostramos dentro del botón
    @FXML private StackPane spBoton; // Representa el contenedor principal de nuestro botón

    // Guardamos la acción que deberá ejecutarse cuando el botón sea presionado
    private EventHandler<ActionEvent> onAction;

    // Ejecutamos la inicialización del componente una vez que JavaFX ha cargado el archivo FXML y conectado sus componentes
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        // Configuramos el evento que se ejecutará cuando hagamos clic sobre el botón
        spBoton.setOnMouseClicked(event -> {

            // Comprobamos si existe una acción configurada para el botón
            if (onAction != null) {

                // Ejecutamos la acción que previamente configuramos
                onAction.handle(new ActionEvent(spBoton, null));
            }
        });
    }

    // Getters

    // Obtenemos el texto actual del botón
    public String getText() {
        return lblTexto.getText();
    }

    // Obtenemos la acción actualmente configurada.
    public EventHandler<ActionEvent> getOnAction() {
        return onAction;
    }

    // Setters

    // Establecemos el texto que mostrará el botón.
    public void setText(String texto) {
        lblTexto.setText(texto);
    }

    // Establecemos la acción que ejecutará el botón al ser presionado.
    public void setOnAction(EventHandler<ActionEvent> onAction) {
        this.onAction = onAction;
    }

}