module com.wellbiing.wellbiinghealthcare {
    requires javafx.controls;
    requires javafx.fxml;
            
                            
    opens com.wellbiing.wellbiinghealthcare to javafx.fxml;
    exports com.wellbiing.wellbiinghealthcare;
}