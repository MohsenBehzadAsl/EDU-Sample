module sample.edu {
    requires javafx.controls;
    requires javafx.fxml;


    opens Sample.View to javafx.fxml;
    exports Sample.View;
}