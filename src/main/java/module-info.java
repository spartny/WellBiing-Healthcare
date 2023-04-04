module com.wellbiing.wellbiinghealthcare {
    requires javafx.controls;
    requires javafx.fxml;
    requires jbcrypt;
    requires java.sql;


    opens com.wellbiing.wellbiinghealthcare to javafx.fxml;
    exports com.wellbiing.wellbiinghealthcare;
}