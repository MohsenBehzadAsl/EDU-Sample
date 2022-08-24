package Sample.Controller;

import Sample.Model.DataBase;
import Sample.View.GodMode;
import Sample.View.ProfessorMode;
import Sample.View.StudentMode;
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
public class EnterProfessorController {
    TextField professorName=new TextField();
    TextField department=new TextField();
    Label professorNameLabel=new Label("Professor Name");
    Label departmentLabel=new Label("Department");
    Label AddStudent=new Label("Login Professor Menu");
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
                if (professorName.getText().isEmpty()){
                    professorName.setPromptText("please fill professor Name ");flag=false;
                }if (department.getText().isEmpty()){
                    department.setPromptText("please fill department");flag=false;
                }
                if (flag){
                    flag=false;
                    int i=0;
                    for ( i=0;i<DataBase.professors.size() && !flag ;i++) {

                        if (DataBase.professors.get(i).getProfessorName().equals(professorName.getText().toString())){
                            if (DataBase.professors.get(i).getDepartment().getDepatrmentName().equals(department.getText().toString())){
                                flag=true;
                            }
                        }
                    }
                    i--;

                    if (flag){
                        stage2.close();
                        try {
                            new ProfessorMode().start(stage,i);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }else{
                        professorName.setText("");
                        professorName.setPromptText("please enter matched professor name ");flag=false;
                        department.setText("");
                        department.setPromptText(" please enter matched department ");flag=false;flag=true;
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
        professorName.setPromptText("Professor Name");professorName.setLayoutX(371);professorName.setLayoutY(101);professorName.setPrefWidth(256);professorName.setPrefHeight(45);
        pane2.getChildren().add(professorName);
        department.setPromptText("Department");department.setLayoutX(371);department.setLayoutY(163);department.setPrefWidth(256);department.setPrefHeight(45);
        pane2.getChildren().add(department);
    }
    private void initializeLabelsStudent(AnchorPane pane2) {
        professorNameLabel.setLayoutX(49);professorNameLabel.setLayoutY(101);professorNameLabel.setPrefWidth(256);professorNameLabel.setPrefHeight(45); professorNameLabel.setStyle("-fx-background-color:  rgba(9,13,236,0.67);");professorNameLabel.setAlignment(Pos.CENTER);
        pane2.getChildren().add(professorNameLabel);
        departmentLabel.setLayoutX(49);departmentLabel.setLayoutY(163);departmentLabel.setPrefWidth(256);departmentLabel.setPrefHeight(45); departmentLabel.setStyle("-fx-background-color:  rgba(9,13,236,0.67);");departmentLabel.setAlignment(Pos.CENTER);
        pane2.getChildren().add(departmentLabel);
        AddStudent.setLayoutX(222);AddStudent.setLayoutY(20);AddStudent.setPrefWidth(256);AddStudent.setPrefHeight(45); AddStudent.setStyle("-fx-background-color: rgba(207,8,238,0.67);");AddStudent.setAlignment(Pos.CENTER);
        pane2.getChildren().add(AddStudent);
    }
}
