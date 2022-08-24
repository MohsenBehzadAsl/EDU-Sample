package Sample.Controller;

import Sample.Model.*;
import Sample.View.OfficerMode;
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
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class ListViewHandler implements EventHandler<MouseEvent> {
    private String dateFormat="yyyy/MM/dd";
    @Override
    public void handle(MouseEvent event) {

    }
    public void start1(ArrayList<Student> students,  int selectedIndex) throws IOException {
        System.out.println(selectedIndex);
        Stage stage2=new Stage();
        AnchorPane pane2 = FXMLLoader.load(getClass().getResource("/Sample/fxml/help.fxml"));
        StudentinitializeLabels(pane2,students,selectedIndex);
        Scene scene2=new Scene(pane2);
        stage2.setScene(scene2);
        stage2.show();
    }
    public void start1(ArrayList<Student> students,  int selectedIndex,Course course,AnchorPane pane,int index) throws IOException {
        System.out.println(selectedIndex);
        Stage stage2=new Stage();
        AnchorPane pane2 = FXMLLoader.load(getClass().getResource("/Sample/fxml/help.fxml"));
        StudentinitializeLabels2(pane2,students,selectedIndex,course,pane,index);
    }
    public void start10(ArrayList<Student> students,  int selectedIndex,Course course,AnchorPane pane,int index) throws IOException {
        System.out.println(selectedIndex);
        Stage stage2=new Stage();
        AnchorPane pane2 = FXMLLoader.load(getClass().getResource("/Sample/fxml/help.fxml"));
        StudentinitializeLabels20(pane2,students,selectedIndex,course,pane,index);
    }
    public void start2(ArrayList<Professor> professors, int selectedIndex) throws IOException {
        System.out.println(selectedIndex);
        Stage stage2=new Stage();
        AnchorPane pane2 = FXMLLoader.load(getClass().getResource("/Sample/fxml/help.fxml"));
        ProfessorinitializeLabels(pane2,professors,selectedIndex);
        Scene scene2=new Scene(pane2);
        stage2.setScene(scene2);
        stage2.show();
    }
    public void start3(ArrayList<Course> courses, int selectedIndex) throws IOException {
        System.out.println(selectedIndex);
        Stage stage2=new Stage();
        AnchorPane pane2 = FXMLLoader.load(getClass().getResource("/Sample/fxml/help.fxml"));
        CourseinitializeLabels(pane2,courses,selectedIndex);
        Scene scene2=new Scene(pane2);
        stage2.setScene(scene2);
        stage2.show();
    }
    public void start4(ArrayList<Department> departments, int selectedIndex) throws IOException {
        System.out.println(selectedIndex);
        Stage stage2=new Stage();
        AnchorPane pane2 = FXMLLoader.load(getClass().getResource("/Sample/fxml/help.fxml"));
        DepartmentinitializeLabels(pane2,departments,selectedIndex);
        Scene scene2=new Scene(pane2);
        stage2.setScene(scene2);
        stage2.show();
    }
    public void start5(ArrayList<Course> courses, int selectedIndex, boolean flag, int index) throws IOException {
        System.out.println(selectedIndex);
        Stage stage2=new Stage();
        AnchorPane pane2 = FXMLLoader.load(getClass().getResource("/Sample/fxml/help.fxml"));
        CourseinitializeLabels(pane2,courses,selectedIndex);
        Button button = new Button("Take Course!");
        if (flag) {
            button.setStyle("-fx-background-color: rgba(15,238,8,0.67);");
            button.setLayoutX(260);
            button.setLayoutY(360);
            button.setPrefWidth(150);
            button.setPrefHeight(50);
            button.setFont(new Font(20));
            button.setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent mouseEvent) {
                    DataBase.students.get(index).takeCourse(courses.get(selectedIndex));
                    stage2.close();
                    StudentMode.initializeLists(StudentMode.pane,index);
                }
            });
        }else{
            button.setText("You have taken this course! click here to back to Student Mode Menu");
            button.setStyle("-fx-background-color: rgba(15,238,8,0.67);");
            button.setLayoutY(360);button.setLayoutX(30);
            button.setPrefHeight(50);
            button.setFont(new Font(20));
            button.setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent mouseEvent) {
                    stage2.close();
                }
            });
        }
        pane2.getChildren().add(button);
        Scene scene2=new Scene(pane2);
        stage2.setScene(scene2);
        stage2.show();
    }
    private void StudentinitializeLabels(AnchorPane pane2, ArrayList<Student> students, int selectedIndex) {
        Label studentNameLabel=new Label("Student Name");
        Label studentNumberLabel=new Label("Student Number");
        Label BirthdateLabel=new Label("Birthdate");
        Label DepartmentLabel=new Label("Department");
        Label studentNameLabel2=new Label();
        Label studentNumberLabel2=new Label();
        Label BirthdateLabel2=new Label();
        Label DepartmentLabel2=new Label();
        Label AddStudent=new Label("Student information");
        studentNameLabel.setLayoutX(49);studentNameLabel.setLayoutY(101);studentNameLabel.setPrefWidth(256);studentNameLabel.setPrefHeight(45); studentNameLabel.setStyle("-fx-background-color:  rgba(9,13,236,0.67);");studentNameLabel.setAlignment(Pos.CENTER);
        pane2.getChildren().add(studentNameLabel);
        studentNumberLabel.setLayoutX(49);studentNumberLabel.setLayoutY(163);studentNumberLabel.setPrefWidth(256);studentNumberLabel.setPrefHeight(45); studentNumberLabel.setStyle("-fx-background-color:  rgba(9,13,236,0.67);");studentNumberLabel.setAlignment(Pos.CENTER);
        pane2.getChildren().add(studentNumberLabel);
        BirthdateLabel.setLayoutX(49);BirthdateLabel.setLayoutY(226);BirthdateLabel.setPrefWidth(256);BirthdateLabel.setPrefHeight(45); BirthdateLabel.setStyle("-fx-background-color:  rgba(9,13,236,0.67);");BirthdateLabel.setAlignment(Pos.CENTER);
        pane2.getChildren().add(BirthdateLabel);
        DepartmentLabel.setLayoutX(49);DepartmentLabel.setLayoutY(287);DepartmentLabel.setPrefWidth(256);DepartmentLabel.setPrefHeight(45); DepartmentLabel.setStyle("-fx-background-color:  rgba(9,13,236,0.67);");DepartmentLabel.setAlignment(Pos.CENTER);
        pane2.getChildren().add(DepartmentLabel);
        AddStudent.setLayoutX(222);AddStudent.setLayoutY(20);AddStudent.setPrefWidth(256);AddStudent.setPrefHeight(45); AddStudent.setStyle("-fx-background-color: rgba(207,8,238,0.67);");AddStudent.setAlignment(Pos.CENTER);
        pane2.getChildren().add(AddStudent);
        studentNameLabel2.setText(students.get(selectedIndex).getStudentName());studentNameLabel2.setLayoutX(371);studentNameLabel2.setLayoutY(101);studentNameLabel2.setPrefWidth(256);studentNameLabel2.setPrefHeight(45);studentNameLabel2.setStyle("-fx-background-color: rgba(8,238,12,0.67);");studentNameLabel2.setAlignment(Pos.CENTER);
        pane2.getChildren().add(studentNameLabel2);
        studentNumberLabel2.setText(students.get(selectedIndex).getStudentNumber());studentNumberLabel2.setLayoutX(371);studentNumberLabel2.setLayoutY(163);studentNumberLabel2.setPrefWidth(256);studentNumberLabel2.setPrefHeight(45);studentNumberLabel2.setStyle("-fx-background-color: rgba(8,238,12,0.67);");studentNumberLabel2.setAlignment(Pos.CENTER);
        pane2.getChildren().add(studentNumberLabel2);
        BirthdateLabel2.setText(students.get(selectedIndex).getBirthDate().format(DateTimeFormatter.ofPattern(dateFormat))); BirthdateLabel2.setLayoutX(371);BirthdateLabel2.setLayoutY(225);BirthdateLabel2.setPrefWidth(256);BirthdateLabel2.setPrefHeight(45);BirthdateLabel2.setStyle("-fx-background-color: rgba(8,238,12,0.67);");BirthdateLabel2.setAlignment(Pos.CENTER);
        pane2.getChildren().add(BirthdateLabel2);
        DepartmentLabel2.setText(students.get(selectedIndex).getDepartment().getDepatrmentName());DepartmentLabel2.setLayoutX(371);DepartmentLabel2.setLayoutY(287);DepartmentLabel2.setPrefWidth(256);DepartmentLabel2.setPrefHeight(45);DepartmentLabel2.setStyle("-fx-background-color: rgba(8,238,12,0.67);");DepartmentLabel2.setAlignment(Pos.CENTER);
        pane2.getChildren().add(DepartmentLabel2);
    }
    private void StudentinitializeLabels2(AnchorPane pane2, ArrayList<Student> students, int selectedIndex, Course course, AnchorPane pane, int index) {
        Stage stage2=new Stage();
        Label studentNameLabel=new Label("Student Name");
        Label studentNumberLabel=new Label("Student Number");
        Label BirthdateLabel=new Label("Birthdate");
        Label DepartmentLabel=new Label("Department");
        Label studentNameLabel2=new Label();
        Label studentNumberLabel2=new Label();
        Label BirthdateLabel2=new Label();
        Label DepartmentLabel2=new Label();
        Label AddStudent=new Label("Student information");
        studentNameLabel.setLayoutX(49);studentNameLabel.setLayoutY(101);studentNameLabel.setPrefWidth(256);studentNameLabel.setPrefHeight(45); studentNameLabel.setStyle("-fx-background-color:  rgba(9,13,236,0.67);");studentNameLabel.setAlignment(Pos.CENTER);
        pane2.getChildren().add(studentNameLabel);
        studentNumberLabel.setLayoutX(49);studentNumberLabel.setLayoutY(163);studentNumberLabel.setPrefWidth(256);studentNumberLabel.setPrefHeight(45); studentNumberLabel.setStyle("-fx-background-color:  rgba(9,13,236,0.67);");studentNumberLabel.setAlignment(Pos.CENTER);
        pane2.getChildren().add(studentNumberLabel);
        BirthdateLabel.setLayoutX(49);BirthdateLabel.setLayoutY(226);BirthdateLabel.setPrefWidth(256);BirthdateLabel.setPrefHeight(45); BirthdateLabel.setStyle("-fx-background-color:  rgba(9,13,236,0.67);");BirthdateLabel.setAlignment(Pos.CENTER);
        pane2.getChildren().add(BirthdateLabel);
        DepartmentLabel.setLayoutX(49);DepartmentLabel.setLayoutY(287);DepartmentLabel.setPrefWidth(256);DepartmentLabel.setPrefHeight(45); DepartmentLabel.setStyle("-fx-background-color:  rgba(9,13,236,0.67);");DepartmentLabel.setAlignment(Pos.CENTER);
        pane2.getChildren().add(DepartmentLabel);
        AddStudent.setLayoutX(222);AddStudent.setLayoutY(20);AddStudent.setPrefWidth(256);AddStudent.setPrefHeight(45); AddStudent.setStyle("-fx-background-color: rgba(207,8,238,0.67);");AddStudent.setAlignment(Pos.CENTER);
        pane2.getChildren().add(AddStudent);
        studentNameLabel2.setText(students.get(selectedIndex).getStudentName());studentNameLabel2.setLayoutX(371);studentNameLabel2.setLayoutY(101);studentNameLabel2.setPrefWidth(256);studentNameLabel2.setPrefHeight(45);studentNameLabel2.setStyle("-fx-background-color: rgba(8,238,12,0.67);");studentNameLabel2.setAlignment(Pos.CENTER);
        pane2.getChildren().add(studentNameLabel2);
        studentNumberLabel2.setText(students.get(selectedIndex).getStudentNumber());studentNumberLabel2.setLayoutX(371);studentNumberLabel2.setLayoutY(163);studentNumberLabel2.setPrefWidth(256);studentNumberLabel2.setPrefHeight(45);studentNumberLabel2.setStyle("-fx-background-color: rgba(8,238,12,0.67);");studentNumberLabel2.setAlignment(Pos.CENTER);
        pane2.getChildren().add(studentNumberLabel2);
        BirthdateLabel2.setText(students.get(selectedIndex).getBirthDate().format(DateTimeFormatter.ofPattern(dateFormat))); BirthdateLabel2.setLayoutX(371);BirthdateLabel2.setLayoutY(225);BirthdateLabel2.setPrefWidth(256);BirthdateLabel2.setPrefHeight(45);BirthdateLabel2.setStyle("-fx-background-color: rgba(8,238,12,0.67);");BirthdateLabel2.setAlignment(Pos.CENTER);
        pane2.getChildren().add(BirthdateLabel2);
        DepartmentLabel2.setText(students.get(selectedIndex).getDepartment().getDepatrmentName());DepartmentLabel2.setLayoutX(371);DepartmentLabel2.setLayoutY(287);DepartmentLabel2.setPrefWidth(256);DepartmentLabel2.setPrefHeight(45);DepartmentLabel2.setStyle("-fx-background-color: rgba(8,238,12,0.67);");DepartmentLabel2.setAlignment(Pos.CENTER);
        pane2.getChildren().add(DepartmentLabel2);
        TextField Mark=new TextField();
        Mark.setPromptText("Mark");Mark.setLayoutX(170);Mark.setLayoutY(362);Mark.setPrefWidth(150);Mark.setPrefHeight(45);
        pane2.getChildren().add(Mark);
        Button button=new Button("Set Mark");
        button.setStyle("-fx-background-color: rgba(15,238,8,0.67);");
        button.setLayoutX(49);
        button.setLayoutY(360);
        button.setPrefWidth(120);
        button.setPrefHeight(50);
        button.setFont(new Font(20));
        button.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                boolean flag=true;
                int j=-1;
                if (Mark.getText().isEmpty()){
                    Mark.setText("");
                    Mark.setPromptText("please fill student Mark ");flag=false;
                }else if (Double.parseDouble(Mark.getText().toString())<0 || Integer.parseInt(Mark.getText().toString())>20){
                    Mark.setText("");Mark.setPromptText("please fill desired Mark ");flag=false;
                }
                if (flag){
                    stage2.close();
                    students.get(selectedIndex).finishCourse(course,Double.parseDouble(Mark.getText().toString()));
                }
            }
        });
        pane2.getChildren().add(button);
        Button button1=new Button("Withdraw");
        button1.setStyle("-fx-background-color: rgb(239,12,12);");
        button1.setLayoutX(507);
        button1.setLayoutY(360);
        button1.setPrefWidth(120);
        button1.setPrefHeight(50);
        button1.setFont(new Font(20));
        button1.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                stage2.close();
                students.get(selectedIndex).getCourses().remove(course);
                course.getTakenStudent().remove(students.get(selectedIndex));
                ProfessorMode.finalShow(pane,index,course);
            }
        });
        pane2.getChildren().add(button1);
        Scene scene2=new Scene(pane2);
        stage2.setScene(scene2);
        stage2.show();
    }
    private void StudentinitializeLabels20(AnchorPane pane2, ArrayList<Student> students, int selectedIndex, Course course, AnchorPane pane, int index) {
        Stage stage2=new Stage();
        Label studentNameLabel=new Label("Student Name");
        Label studentNumberLabel=new Label("Student Number");
        Label BirthdateLabel=new Label("Birthdate");
        Label DepartmentLabel=new Label("Department");
        Label studentNameLabel2=new Label();
        Label studentNumberLabel2=new Label();
        Label BirthdateLabel2=new Label();
        Label DepartmentLabel2=new Label();
        Label AddStudent=new Label("Student information");
        studentNameLabel.setLayoutX(49);studentNameLabel.setLayoutY(101);studentNameLabel.setPrefWidth(256);studentNameLabel.setPrefHeight(45); studentNameLabel.setStyle("-fx-background-color:  rgba(9,13,236,0.67);");studentNameLabel.setAlignment(Pos.CENTER);
        pane2.getChildren().add(studentNameLabel);
        studentNumberLabel.setLayoutX(49);studentNumberLabel.setLayoutY(163);studentNumberLabel.setPrefWidth(256);studentNumberLabel.setPrefHeight(45); studentNumberLabel.setStyle("-fx-background-color:  rgba(9,13,236,0.67);");studentNumberLabel.setAlignment(Pos.CENTER);
        pane2.getChildren().add(studentNumberLabel);
        BirthdateLabel.setLayoutX(49);BirthdateLabel.setLayoutY(226);BirthdateLabel.setPrefWidth(256);BirthdateLabel.setPrefHeight(45); BirthdateLabel.setStyle("-fx-background-color:  rgba(9,13,236,0.67);");BirthdateLabel.setAlignment(Pos.CENTER);
        pane2.getChildren().add(BirthdateLabel);
        DepartmentLabel.setLayoutX(49);DepartmentLabel.setLayoutY(287);DepartmentLabel.setPrefWidth(256);DepartmentLabel.setPrefHeight(45); DepartmentLabel.setStyle("-fx-background-color:  rgba(9,13,236,0.67);");DepartmentLabel.setAlignment(Pos.CENTER);
        pane2.getChildren().add(DepartmentLabel);
        AddStudent.setLayoutX(222);AddStudent.setLayoutY(20);AddStudent.setPrefWidth(256);AddStudent.setPrefHeight(45); AddStudent.setStyle("-fx-background-color: rgba(207,8,238,0.67);");AddStudent.setAlignment(Pos.CENTER);
        pane2.getChildren().add(AddStudent);
        studentNameLabel2.setText(students.get(selectedIndex).getStudentName());studentNameLabel2.setLayoutX(371);studentNameLabel2.setLayoutY(101);studentNameLabel2.setPrefWidth(256);studentNameLabel2.setPrefHeight(45);studentNameLabel2.setStyle("-fx-background-color: rgba(8,238,12,0.67);");studentNameLabel2.setAlignment(Pos.CENTER);
        pane2.getChildren().add(studentNameLabel2);
        studentNumberLabel2.setText(students.get(selectedIndex).getStudentNumber());studentNumberLabel2.setLayoutX(371);studentNumberLabel2.setLayoutY(163);studentNumberLabel2.setPrefWidth(256);studentNumberLabel2.setPrefHeight(45);studentNumberLabel2.setStyle("-fx-background-color: rgba(8,238,12,0.67);");studentNumberLabel2.setAlignment(Pos.CENTER);
        pane2.getChildren().add(studentNumberLabel2);
        BirthdateLabel2.setText(students.get(selectedIndex).getBirthDate().format(DateTimeFormatter.ofPattern(dateFormat))); BirthdateLabel2.setLayoutX(371);BirthdateLabel2.setLayoutY(225);BirthdateLabel2.setPrefWidth(256);BirthdateLabel2.setPrefHeight(45);BirthdateLabel2.setStyle("-fx-background-color: rgba(8,238,12,0.67);");BirthdateLabel2.setAlignment(Pos.CENTER);
        pane2.getChildren().add(BirthdateLabel2);
        DepartmentLabel2.setText(students.get(selectedIndex).getDepartment().getDepatrmentName());DepartmentLabel2.setLayoutX(371);DepartmentLabel2.setLayoutY(287);DepartmentLabel2.setPrefWidth(256);DepartmentLabel2.setPrefHeight(45);DepartmentLabel2.setStyle("-fx-background-color: rgba(8,238,12,0.67);");DepartmentLabel2.setAlignment(Pos.CENTER);
        pane2.getChildren().add(DepartmentLabel2);
        Button button1=new Button("Withdraw");
        button1.setStyle("-fx-background-color: rgb(239,12,12);");
        button1.setLayoutX(507);
        button1.setLayoutY(360);
        button1.setPrefWidth(120);
        button1.setPrefHeight(50);
        button1.setFont(new Font(20));
        button1.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                stage2.close();
                students.get(selectedIndex).getCourses().remove(course);
                course.getTakenStudent().remove(students.get(selectedIndex));
                OfficerMode.finalShow(pane,index,course);
            }
        });
        pane2.getChildren().add(button1);
        Scene scene2=new Scene(pane2);
        stage2.setScene(scene2);
        stage2.show();
    }
    private void ProfessorinitializeLabels(AnchorPane pane2, ArrayList<Professor> professors, int selectedIndex) {
        Label professorNameLabel=new Label("Professor Name");
        Label professorRankLabel=new Label("Professor Rank");
        Label BirthdateLabel=new Label("Birthdate");
        Label DepartmentLabel=new Label("Department");
        Label professorNameLabel2=new Label();
        Label professorRankLabel2=new Label();
        Label BirthdateLabel2=new Label();
        Label DepartmentLabel2=new Label();
        Label AddStudent=new Label("Professor information");
        professorNameLabel.setLayoutX(49);professorNameLabel.setLayoutY(101);professorNameLabel.setPrefWidth(256);professorNameLabel.setPrefHeight(45); professorNameLabel.setStyle("-fx-background-color:  rgba(9,13,236,0.67);");professorNameLabel.setAlignment(Pos.CENTER);
        pane2.getChildren().add(professorNameLabel);
        professorRankLabel.setLayoutX(49);professorRankLabel.setLayoutY(163);professorRankLabel.setPrefWidth(256);professorRankLabel.setPrefHeight(45); professorRankLabel.setStyle("-fx-background-color:  rgba(9,13,236,0.67);");professorRankLabel.setAlignment(Pos.CENTER);
        pane2.getChildren().add(professorRankLabel);
        BirthdateLabel.setLayoutX(49);BirthdateLabel.setLayoutY(226);BirthdateLabel.setPrefWidth(256);BirthdateLabel.setPrefHeight(45); BirthdateLabel.setStyle("-fx-background-color:  rgba(9,13,236,0.67);");BirthdateLabel.setAlignment(Pos.CENTER);
        pane2.getChildren().add(BirthdateLabel);
        DepartmentLabel.setLayoutX(49);DepartmentLabel.setLayoutY(287);DepartmentLabel.setPrefWidth(256);DepartmentLabel.setPrefHeight(45); DepartmentLabel.setStyle("-fx-background-color:  rgba(9,13,236,0.67);");DepartmentLabel.setAlignment(Pos.CENTER);
        pane2.getChildren().add(DepartmentLabel);
        AddStudent.setLayoutX(222);AddStudent.setLayoutY(20);AddStudent.setPrefWidth(256);AddStudent.setPrefHeight(45); AddStudent.setStyle("-fx-background-color: rgba(207,8,238,0.67);");AddStudent.setAlignment(Pos.CENTER);
        pane2.getChildren().add(AddStudent);
        professorNameLabel2.setText(professors.get(selectedIndex).getProfessorName());professorNameLabel2.setLayoutX(371);professorNameLabel2.setLayoutY(101);professorNameLabel2.setPrefWidth(256);professorNameLabel2.setPrefHeight(45);professorNameLabel2.setStyle("-fx-background-color: rgba(8,238,12,0.67);");professorNameLabel2.setAlignment(Pos.CENTER);
        pane2.getChildren().add(professorNameLabel2);
        professorRankLabel2.setText(String.valueOf(professors.get(selectedIndex).getAcademicRank()));professorRankLabel2.setLayoutX(371);professorRankLabel2.setLayoutY(163);professorRankLabel2.setPrefWidth(256);professorRankLabel2.setPrefHeight(45);professorRankLabel2.setStyle("-fx-background-color: rgba(8,238,12,0.67);");professorRankLabel2.setAlignment(Pos.CENTER);
        pane2.getChildren().add(professorRankLabel2);
        BirthdateLabel2.setText(professors.get(selectedIndex).getBirthDate().format(DateTimeFormatter.ofPattern(dateFormat))); BirthdateLabel2.setLayoutX(371);BirthdateLabel2.setLayoutY(225);BirthdateLabel2.setPrefWidth(256);BirthdateLabel2.setPrefHeight(45);BirthdateLabel2.setStyle("-fx-background-color: rgba(8,238,12,0.67);");BirthdateLabel2.setAlignment(Pos.CENTER);
        pane2.getChildren().add(BirthdateLabel2);
        DepartmentLabel2.setText(professors.get(selectedIndex).getDepartment().getDepatrmentName());DepartmentLabel2.setLayoutX(371);DepartmentLabel2.setLayoutY(287);DepartmentLabel2.setPrefWidth(256);DepartmentLabel2.setPrefHeight(45);DepartmentLabel2.setStyle("-fx-background-color: rgba(8,238,12,0.67);");DepartmentLabel2.setAlignment(Pos.CENTER);
        pane2.getChildren().add(DepartmentLabel2);
    }
    private void CourseinitializeLabels(AnchorPane pane2, ArrayList<Course> courses, int selectedIndex) {
        Label CourseNameLabel=new Label("Course Name");
        Label CourseCreditLabel=new Label("Course Credit");
        Label ProfessorLabel=new Label("Professor");
        Label DepartmentLabel=new Label("Department");
        Label CourseNameLabel2=new Label();
        Label CourseCreditLabel2=new Label();
        Label ProfessorLabel2=new Label();
        Label DepartmentLabel2=new Label();
        Label AddStudent=new Label("Course information");
        CourseNameLabel.setLayoutX(49);CourseNameLabel.setLayoutY(101);CourseNameLabel.setPrefWidth(256);CourseNameLabel.setPrefHeight(45); CourseNameLabel.setStyle("-fx-background-color:  rgba(9,13,236,0.67);");CourseNameLabel.setAlignment(Pos.CENTER);
        pane2.getChildren().add(CourseNameLabel);
        CourseCreditLabel.setLayoutX(49);CourseCreditLabel.setLayoutY(163);CourseCreditLabel.setPrefWidth(256);CourseCreditLabel.setPrefHeight(45); CourseCreditLabel.setStyle("-fx-background-color:  rgba(9,13,236,0.67);");CourseCreditLabel.setAlignment(Pos.CENTER);
        pane2.getChildren().add(CourseCreditLabel);
        ProfessorLabel.setLayoutX(49);ProfessorLabel.setLayoutY(226);ProfessorLabel.setPrefWidth(256);ProfessorLabel.setPrefHeight(45); ProfessorLabel.setStyle("-fx-background-color:  rgba(9,13,236,0.67);");ProfessorLabel.setAlignment(Pos.CENTER);
        pane2.getChildren().add(ProfessorLabel);
        DepartmentLabel.setLayoutX(49);DepartmentLabel.setLayoutY(287);DepartmentLabel.setPrefWidth(256);DepartmentLabel.setPrefHeight(45); DepartmentLabel.setStyle("-fx-background-color:  rgba(9,13,236,0.67);");DepartmentLabel.setAlignment(Pos.CENTER);
        pane2.getChildren().add(DepartmentLabel);
        AddStudent.setLayoutX(222);AddStudent.setLayoutY(20);AddStudent.setPrefWidth(256);AddStudent.setPrefHeight(45); AddStudent.setStyle("-fx-background-color: rgba(207,8,238,0.67);");AddStudent.setAlignment(Pos.CENTER);
        pane2.getChildren().add(AddStudent);
        CourseNameLabel2.setText(courses.get(selectedIndex).getCourseName());CourseNameLabel2.setLayoutX(371);CourseNameLabel2.setLayoutY(101);CourseNameLabel2.setPrefWidth(256);CourseNameLabel2.setPrefHeight(45);CourseNameLabel2.setStyle("-fx-background-color: rgba(8,238,12,0.67);");CourseNameLabel2.setAlignment(Pos.CENTER);
        pane2.getChildren().add(CourseNameLabel2);
        CourseCreditLabel2.setText(String.valueOf(courses.get(selectedIndex).getCredit()));CourseCreditLabel2.setLayoutX(371);CourseCreditLabel2.setLayoutY(163);CourseCreditLabel2.setPrefWidth(256);CourseCreditLabel2.setPrefHeight(45);CourseCreditLabel2.setStyle("-fx-background-color: rgba(8,238,12,0.67);");CourseCreditLabel2.setAlignment(Pos.CENTER);
        pane2.getChildren().add(CourseCreditLabel2);
        ProfessorLabel2.setText(courses.get(selectedIndex).getProfessor().getProfessorName()); ProfessorLabel2.setLayoutX(371);ProfessorLabel2.setLayoutY(225);ProfessorLabel2.setPrefWidth(256);ProfessorLabel2.setPrefHeight(45);ProfessorLabel2.setStyle("-fx-background-color: rgba(8,238,12,0.67);");ProfessorLabel2.setAlignment(Pos.CENTER);
        pane2.getChildren().add(ProfessorLabel2);
        DepartmentLabel2.setText(courses.get(selectedIndex).getDepartment().getDepatrmentName());DepartmentLabel2.setLayoutX(371);DepartmentLabel2.setLayoutY(287);DepartmentLabel2.setPrefWidth(256);DepartmentLabel2.setPrefHeight(45);DepartmentLabel2.setStyle("-fx-background-color: rgba(8,238,12,0.67);");DepartmentLabel2.setAlignment(Pos.CENTER);
        pane2.getChildren().add(DepartmentLabel2);
    }
    private void DepartmentinitializeLabels(AnchorPane pane2, ArrayList<Department> departments, int selectedIndex) {
        Label DepartmentNameLabel=new Label("Department Name");
        Label DepartmentSerial=new Label("Department Serial");
        Label DepartmentNameLabel2=new Label("Department Name");
        Label DepartmentSerial2=new Label("Department Serial");
        Label AddStudent=new Label("Department information");
        DepartmentNameLabel.setLayoutX(49);DepartmentNameLabel.setLayoutY(101);DepartmentNameLabel.setPrefWidth(256);DepartmentNameLabel.setPrefHeight(45); DepartmentNameLabel.setStyle("-fx-background-color:  rgba(9,13,236,0.67);");DepartmentNameLabel.setAlignment(Pos.CENTER);
        pane2.getChildren().add(DepartmentNameLabel);
        DepartmentSerial.setLayoutX(49);DepartmentSerial.setLayoutY(163);DepartmentSerial.setPrefWidth(256);DepartmentSerial.setPrefHeight(45); DepartmentSerial.setStyle("-fx-background-color:  rgba(9,13,236,0.67);");DepartmentSerial.setAlignment(Pos.CENTER);
        pane2.getChildren().add(DepartmentSerial);
        AddStudent.setLayoutX(222);AddStudent.setLayoutY(20);AddStudent.setPrefWidth(256);AddStudent.setPrefHeight(45); AddStudent.setStyle("-fx-background-color: rgba(207,8,238,0.67);");AddStudent.setAlignment(Pos.CENTER);
        pane2.getChildren().add(AddStudent);
        DepartmentNameLabel2.setText(departments.get(selectedIndex).getDepatrmentName());DepartmentNameLabel2.setLayoutX(371);DepartmentNameLabel2.setLayoutY(101);DepartmentNameLabel2.setPrefWidth(256);DepartmentNameLabel2.setPrefHeight(45);DepartmentNameLabel2.setStyle("-fx-background-color: rgba(8,238,12,0.67);");DepartmentNameLabel2.setAlignment(Pos.CENTER);
        pane2.getChildren().add(DepartmentNameLabel2);
        DepartmentSerial2.setText(String.valueOf(departments.get(selectedIndex).getDepatrmentSerial()));DepartmentSerial2.setLayoutX(371);DepartmentSerial2.setLayoutY(163);DepartmentSerial2.setPrefWidth(256);DepartmentSerial2.setPrefHeight(45);DepartmentSerial2.setStyle("-fx-background-color: rgba(8,238,12,0.67);");DepartmentSerial2.setAlignment(Pos.CENTER);
        pane2.getChildren().add(DepartmentSerial2);
    }
}