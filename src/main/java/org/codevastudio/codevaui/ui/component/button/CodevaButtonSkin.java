package org.codevastudio.codevaui.ui.component.button;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.SkinBase;
import javafx.scene.layout.StackPane;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

// Skin encargado de representar visualmente el control CodevaButton.
public class CodevaButtonSkin extends SkinBase<CodevaButton> implements Initializable {

    // Declaramos y conectamos nuestros elementos del FXML
    @FXML private Label lblTexto;
    @FXML private StackPane spBoton;

    public CodevaButtonSkin(CodevaButton control) {

        // Asociamos este Skin con el CodevaButton que estamos representando.
        super(control);

        // Creamos el cargador encargado de construir nuestra vista desde el archivo FXML.
        FXMLLoader loader = new FXMLLoader(
                CodevaButton.class.getResource("CodevaButton.fxml")
        );

        // Indicamos que este Skin será el controlador del archivo FXML.
        loader.setController(this);

        try {

            // Cargamos la vista definida en nuestro archivo FXML.
            loader.load();

        } catch (IOException e) {

            // Informamos que no fue posible cargar la vista del componente.
            throw new RuntimeException("No se pudo cargar CodevaButton.fxml", e);
        }

        // Agregamos el contenedor principal al árbol visual del Skin.
        getChildren().add(spBoton);
    }

    // Ejecutamos la inicialización una vez que FXMLLoader conectó los elementos del FXML.
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        // Vinculamos el texto visual con la propiedad de texto del CodevaButton.
        lblTexto.textProperty().bind(getSkinnable().textProperty());

        // Configuramos el evento que se ejecutará cuando presionemos el botón.
        spBoton.setOnMouseClicked(event -> {

            // Obtenemos la acción configurada en el CodevaButton.
            if (getSkinnable().getOnAction() != null) {

                // Ejecutamos la acción que previamente configuramos.
                getSkinnable().getOnAction().handle(
                        new ActionEvent(getSkinnable(), null)
                );
            }
        });
    }
}