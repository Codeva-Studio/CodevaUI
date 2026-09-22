module org.codevastudio.codevaui {

    // Dependencias necesarias para JavaFX.
    requires javafx.controls;
    requires javafx.fxml;

    // Permite a FXML acceder a los elementos del componente.
    opens org.codevastudio.codevaui.ui.component.button to javafx.fxml;

    // Expone el componente para su uso desde otros proyectos.
    exports org.codevastudio.codevaui.ui.component.button;
}