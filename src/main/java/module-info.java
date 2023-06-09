module com.example.bundesligatabellemysql {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.logging;
    requires java.sql;
    requires com.jfoenix;
    requires de.jensd.fx.glyphs.fontawesome;


    opens com.example.bundesligatabellemysql to javafx.fxml;
    exports com.example.bundesligatabellemysql;
}