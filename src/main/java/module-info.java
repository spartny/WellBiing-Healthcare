module com.wellbiing.wellbiinghealthcare {
    requires javafx.controls;
    requires javafx.fxml;
//    requires jbcrypt;
    requires java.sql;
    requires mysql.connector.j;


    opens com.wellbiing.wellbiinghealthcare to javafx.fxml;
    exports com.wellbiing.wellbiinghealthcare;
}