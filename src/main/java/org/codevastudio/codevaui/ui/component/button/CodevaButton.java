package org.codevastudio.codevaui.ui.component.button;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Control;
import javafx.scene.control.Skin;

// Control personalizado que representa un botón reutilizable dentro de la librería CodevaUI
 public class CodevaButton extends Control {

    // Guardamos el texto que representa nuestro botón
    // Creamos una propiedad propia de este elemento cuyo nombre es text y tiene un valor por defecto
    private final StringProperty text = new SimpleStringProperty(this, "text", "Button");

    // Guardamos la acción que deberá ejecutarse cuando el botón sea presionado
    private final ObjectProperty<EventHandler<ActionEvent>> onAction = new SimpleObjectProperty<>(this, "onAction");

    // Constructor explícito requerido por Scene Builder
    public CodevaButton() {
        super();
    }

    // Obtenemos el texto actual del botón
    public String getText() {
        return text.get();
    }

    // Establecemos el texto que mostrará el botón
    public void setText(String texto) {
        text.set(texto);
    }

    // Obtenemos la propiedad observable que representa el texto
    public StringProperty textProperty() {
        return text;
    }

    // Obtenemos la acción actualmente configurada
    public EventHandler<ActionEvent> getOnAction() {
        return onAction.get();
    }

    // Establecemos la acción que ejecutará el botón
    public void setOnAction(EventHandler<ActionEvent> accion) {
        onAction.set(accion);
    }

    // Obtenemos la propiedad observable que representa la acción
    public ObjectProperty<EventHandler<ActionEvent>> onActionProperty() {
        return onAction;
    }

    // Creamos el Skin encargado de representar visualmente nuestro botón
    @Override
    protected Skin<?> createDefaultSkin() {
        return new CodevaButtonSkin(this);
    }
}