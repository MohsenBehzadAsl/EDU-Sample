package Sample.Controller;

import Sample.Model.DataBase;
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
public class EnterStudentController {
    TextField studentName=new TextField();
    TextField studentNumber=new TextField();
    Label studentNameLabel=new Label("Student Name");
    Label studentNumberLabel=new Label("Student Number");
    Label AddStudent=new Label("Login Student Menu");
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
                if (studentName.getText().isEmpty()){
                    studentName.setPromptText("please fill student Name ");flag=false;
                }if (studentNumber.getText().isEmpty()){
                    studentNumber.setPromptText("please fill student Number ");flag=false;
                }
                if (flag){
                    flag=false;
                    int i=0;
                    for ( i=0;i<DataBase.students.size() && !flag ;i++) {
                        if (DataBase.students.get(i).getStudentName().equals(studentName.getText().toString())){
                            if (DataBase.students.get(i).getStudentNumber().equals(studentNumber.getText().toString())){
                                flag=true;
                            }
                        }
                    }
                    i--;

                    if (flag){
                        stage2.close();
                        try {
                            new StudentMode().start(stage,i);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }else{
                        studentName.setText("");
                        studentName.setPromptText("please enter matched student name ");flag=false;
                        studentNumber.setText("");
                        studentNumber.setPromptText(" please enter matched student number ");flag=false;
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
        studentName.setPromptText("Student Name");studentName.setLayoutX(371);studentName.setLayoutY(101);studentName.setPrefWidth(256);studentName.setPrefHeight(45);
        pane2.getChildren().add(studentName);
        studentNumber.setPromptText("Student Number");studentNumber.setLayoutX(371);studentNumber.setLayoutY(163);studentNumber.setPrefWidth(256);studentNumber.setPrefHeight(45);
        pane2.getChildren().add(studentNumber);
    }
    private void initializeLabelsStudent(AnchorPane pane2) {
        studentNameLabel.setLayoutX(49);studentNameLabel.setLayoutY(101);studentNameLabel.setPrefWidth(256);studentNameLabel.setPrefHeight(45); studentNameLabel.setStyle("-fx-background-color:  rgba(9,13,236,0.67);");studentNameLabel.setAlignment(Pos.CENTER);
        pane2.getChildren().add(studentNameLabel);
        studentNumberLabel.setLayoutX(49);studentNumberLabel.setLayoutY(163);studentNumberLabel.setPrefWidth(256);studentNumberLabel.setPrefHeight(45); studentNumberLabel.setStyle("-fx-background-color:  rgba(9,13,236,0.67);");studentNumberLabel.setAlignment(Pos.CENTER);
        pane2.getChildren().add(studentNumberLabel);
        AddStudent.setLayoutX(222);AddStudent.setLayoutY(20);AddStudent.setPrefWidth(256);AddStudent.setPrefHeight(45); AddStudent.setStyle("-fx-background-color: rgba(207,8,238,0.67);");AddStudent.setAlignment(Pos.CENTER);
        pane2.getChildren().add(AddStudent);
    }
}
