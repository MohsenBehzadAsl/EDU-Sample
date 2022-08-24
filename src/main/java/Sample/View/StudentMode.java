package Sample.View;
import Sample.Controller.ListViewHandler;
import Sample.Model.*;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.ArrayList;
public class StudentMode {
    private static Stage stage;
    public static AnchorPane pane;
    public void start(Stage stage, int index) throws Exception{
        this.stage=stage;
        pane = FXMLLoader.load(getClass().getResource("/Sample/fxml/GodMode.fxml"));
        initializeLists(pane,index);
        initializeText(pane);
        Button back=new Button();
        back.setText("Back");
        back.setLayoutX(0);
        back.setLayoutY(650);
        back.setFont(new Font(20));
        back.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                try {
                    new Main1().start(stage);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        pane.getChildren().add(back);
        Button info=new Button();
        info.setText("Student Info.");
        info.setLayoutX(450);
        info.setLayoutY(590);
        info.setFont(new Font(20));
        info.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                try {
                    new ListViewHandler().start1(DataBase.students,index);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        pane.getChildren().add(info);
        Scene scene = new Scene(pane);
        stage.setScene(scene);
    }
    private void initializeText(AnchorPane pane) {
        Label Students = new Label("All Courses");
        Students.setLayoutX(80);Students.setLayoutY(125);
        Students.setPrefWidth(200);
        Students.setPrefHeight(50);
        Students.setFont(new Font(20));
        Students.setStyle("-fx-background-color:  rgba(9,13,236,0.67);");
        Students.setAlignment(Pos.CENTER);
        Label Professors = new Label("Taken Courses");
        Professors.setLayoutX(470);Professors.setLayoutY(125);
        Professors.setPrefWidth(200);
        Professors.setPrefHeight(50);
        Professors.setFont(new Font(20));
        Professors.setStyle("-fx-background-color:  rgba(9,13,236,0.67);");
        Professors.setAlignment(Pos.CENTER);
        Label Courses = new Label("Credit");
        Courses.setLayoutX(670);Courses.setLayoutY(125);
        Courses.setPrefWidth(150);
        Courses.setPrefHeight(50);
        Courses.setFont(new Font(20));
        Courses.setStyle("-fx-background-color:  rgba(9,13,236,0.67);");
        Courses.setAlignment(Pos.CENTER);
        Label Departments = new Label("Mark");
        Departments.setLayoutX(820);Departments.setLayoutY(125);
        Departments.setPrefWidth(150);
        Departments.setPrefHeight(50);
        Departments.setFont(new Font(20));
        Departments.setStyle("-fx-background-color:  rgba(9,13,236,0.67);");
        Departments.setAlignment(Pos.CENTER);
        Label GodMode = new Label("Student Mode");
        GodMode.setLayoutX(200);GodMode.setLayoutY(10);
        GodMode.setPrefWidth(650);
        GodMode.setPrefHeight(70);
        GodMode.setFont(new Font(20));
        GodMode.setStyle("-fx-background-color:  rgba(179,9,236,0.67);");
        GodMode.setAlignment(Pos.CENTER);
        pane.getChildren().add(Students);pane.getChildren().add(Courses);pane.getChildren().add(Professors);pane.getChildren().add(Departments);pane.getChildren().add(GodMode);
    }
    public static void initializeLists(AnchorPane pane, int index) {
        ListView AllCourses = new ListView();
        ListView TakenCourses = new ListView();
        ListView Credits = new ListView();
        ListView Marks = new ListView();

        if (DataBase.courses.size()==0){
            AllCourses.getItems().add("There is no course");
        }else{
            AllCourses.refresh();
            for (Course course : DataBase.courses) {
                AllCourses.getItems().add(course.getCourseName());
            }
        }
        AllCourses.setLayoutX(80);
        AllCourses.setLayoutY(180);
        //StudentsList.setPrefHeight(300);
        AllCourses.setPrefWidth(200);
        AllCourses.setPrefHeight(350);
        if (DataBase.students.get(index).getCourses().size()==0){
            TakenCourses.getItems().add("There is no taken courses");
        }else{
            TakenCourses.refresh();
            for (Course course : DataBase.students.get(index).getCourses()) {
                TakenCourses.getItems().add(course.getCourseName());
            }
        }
        TakenCourses.setLayoutX(470);
        TakenCourses.setLayoutY(180);
        TakenCourses.setPrefWidth(200);
        TakenCourses.setPrefHeight(350);
        if (DataBase.students.get(index).getCourses().size()==0){
            Credits.getItems().add("There is no credit");
        }else{
            Credits.refresh();
            for (Course course : DataBase.students.get(index).getCourses()) {
                Credits.getItems().add(course.getCredit());

            }
        }
        Credits.setLayoutX(670);
        Credits.setLayoutY(180);
        Credits.setPrefWidth(150);
        Credits.setPrefHeight(350);
        if (DataBase.students.get(index).getCourses().size()==0){
            Marks.getItems().add("There is no Mark");
        }else{
            Marks.refresh();
            for (Course course : DataBase.students.get(index).getCourses()) {
                boolean flag=false;
                int i=0;
                for ( i=0;i<DataBase.students.get(index).getGradeReport().size() && !flag;i++){
                    if (course.equals(DataBase.students.get(index).getGradeReport().get(i).getCourse())){
                        flag=true;
                    }
                }
                i--;
                if (flag){
                    Marks.getItems().add(DataBase.students.get(index).getGradeReport().get(i).getGrade());
                }else{
                    Marks.getItems().add("null");
                }

            }
        }
        Marks.setLayoutX(820);
        Marks.setLayoutY(180);
        Marks.setPrefWidth(150);
        Marks.setPrefHeight(350);
        AllCourses.setOnMouseClicked(new ListViewHandler(){
            @Override
            public void handle(javafx.scene.input.MouseEvent event) {
                boolean flag=true;
                try {
                    if (DataBase.courses.size()>0)
                        if (DataBase.students.get(index).getCourses().contains(DataBase.courses.get(AllCourses.getSelectionModel().getSelectedIndex()))){
                            flag=false;
                        }
                        new ListViewHandler().start5(DataBase.courses,AllCourses.getSelectionModel().getSelectedIndex(),flag,index);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        TakenCourses.setOnMouseClicked(new ListViewHandler(){
            @Override
            public void handle(javafx.scene.input.MouseEvent event) {
                try {
                    if (DataBase.courses.size()>0)
                    new ListViewHandler().start3((ArrayList<Course>) DataBase.students.get(index).getCourses(),TakenCourses.getSelectionModel().getSelectedIndex());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        pane.getChildren().add(AllCourses);pane.getChildren().add(Marks);pane.getChildren().add(TakenCourses);pane.getChildren().add(Credits);
    }
}
