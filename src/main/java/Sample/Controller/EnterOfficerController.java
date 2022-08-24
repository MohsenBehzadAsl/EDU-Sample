package Sample.Controller;
import Sample.Model.DataBase;
import Sample.View.OfficerMode;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import java.io.IOException;
public class EnterOfficerController {
    TextField department=new TextField();
    Label departmentLabel=new Label("Department");
    Label AddStudent=new Label("Login Officer Menu");
    boolean flag=true;
    public void start(Stage stage) throws IOException {
        Stage stage2=new Stage();
        AnchorPane pane2 = FXMLLoader.load(getClass().getResource("/Sample/fxml/help.fxml"));
        initializeLabelsStudent(pane2);
        initializeTextFieldsStudents(pane2);
        Button button=new Button("Login");
        button.setStyle("-fx-background-color: rgba(15,238,8,0.67);");
        button.setLayoutX(260);
        button.setLayoutY(360);
        button.setPrefWidth(150);
        button.setPrefHeight(50);
        button.setFont(new Font(20));
        button.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                if (department.getText().isEmpty()){
                    department.setPromptText("please fill department");flag=false;
                }
                int i = -1;
                if (flag){
                    flag=false;
                    for ( i = 0; i< DataBase.departments.size() && !flag ; i++) {
                        if (DataBase.departments.get(i).getDepatrmentName().equals(department.getText().toString())){
                            flag=true;
                        }
                    }
                    i--;

                    if (flag){
                        stage2.close();
                        try {
                            new OfficerMode().start(stage,i);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }else{
                        department.setText("");
                        department.setPromptText(" please enter correct department ");flag=false;
                        flag=true;
                    }

                }
            }
        });
        pane2.getChildren().add(button);
        Scene scene2=new Scene(pane2);
        stage2.setScene(scene2);
        stage2.show();
    }
    private void initializeTextFieldsStudents(AnchorPane pane2) {
        department.setPromptText("Department");department.setLayoutX(371);department.setLayoutY(163);department.setPrefWidth(256);department.setPrefHeight(45);
        pane2.getChildren().add(department);
    }
    private void initializeLabelsStudent(AnchorPane pane2) {
        departmentLabel.setLayoutX(49);departmentLabel.setLayoutY(163);departmentLabel.setPrefWidth(256);departmentLabel.setPrefHeight(45); departmentLabel.setStyle("-fx-background-color:  rgba(9,13,236,0.67);");departmentLabel.setAlignment(Pos.CENTER);
        pane2.getChildren().add(departmentLabel);
        AddStudent.setLayoutX(222);AddStudent.setLayoutY(20);AddStudent.setPrefWidth(256);AddStudent.setPrefHeight(45); AddStudent.setStyle("-fx-background-color: rgba(207,8,238,0.67);");AddStudent.setAlignment(Pos.CENTER);
        pane2.getChildren().add(AddStudent);
    }
}
