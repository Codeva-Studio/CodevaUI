module org.codevastudio.codevaui {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.codevastudio.codevaui to javafx.fxml;
    exports org.codevastudio.codevaui;
}