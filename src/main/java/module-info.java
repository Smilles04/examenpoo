module com.utap.crud {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.utap.crud to javafx.fxml;
    exports com.utap.crud;

    opens com.utap.controller to javafx.fxml;
    exports com.utap.controller;

    opens com.utap.library to javafx.fxml;
    exports com.utap.library;

}