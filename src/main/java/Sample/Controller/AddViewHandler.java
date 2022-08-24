package Sample.Controller;

import Sample.Model.*;
import Sample.View.GodMode;
import Sample.View.OfficerMode;
import Sample.View.ProfessorMode;
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
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
public class AddViewHandler  {
    private String dateFormat="yyyy/MM/dd";
    TextField studentName=new TextField();
    TextField studentNumber=new TextField();
    TextField Birthdate=new TextField();
    TextField Department=new TextField();
    Label studentNameLabel=new Label("Student Name");
    Label studentNumberLabel=new Label("Student Number");
    Label BirthdateLabel=new Label("Birthdate");
    Label DepartmentLabel=new Label("Department");
    Label AddStudent=new Label("Add Student Menu");
    Label register=new Label("Register Student Menu");
    TextField professorName=new TextField();
    TextField professorRank=new TextField();
    Label professorNameLabel=new Label("Proffesor Name");
    Label professorRankLabel=new Label("Proffesor Rank");
    Label AddProfessor=new Label("Add Proffessor Menu");
    TextField courseName=new TextField();
    Label courseNameLabel=new Label("Course Name");
    TextField courseCredit=new TextField();
    Label courseCreditLabel=new Label("Course Credit");
    Label AddCourse=new Label("Add Course Menu");
    TextField DepartmentName=new TextField();
    Label DepartmentNameLabel=new Label("Department Name");
    TextField DepartmentSerial=new TextField();
    Label DepartmentSerialLabel=new Label("Department Serial");
    Label AddDepartment=new Label("Add Department Menu");
    public void start(ArrayList<Student> students) throws IOException {
        Stage stage2=new Stage();
        AnchorPane pane2 = FXMLLoader.load(getClass().getResource("/Sample/fxml/help.fxml"));
        initializeLabelsStudent(pane2);
        initializeTextFieldsStudents(pane2);
        Button button=new Button("Add");
        button.setStyle("-fx-background-color: rgba(15,238,8,0.67);");
        button.setLayoutX(260);
        button.setLayoutY(360);
        button.setPrefWidth(150);
        button.setPrefHeight(50);
        button.setFont(new Font(20));
        button.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                boolean flag=true;
                int j=-1;
                if (studentName.getText().isEmpty()){
                    studentName.setPromptText("please fill student Name ");flag=false;
                }if (studentNumber.getText().isEmpty()){
                    studentNumber.setPromptText("please fill student Number ");flag=false;
                }if (Birthdate.getText().isEmpty()){
                    Birthdate.setPromptText("please fill Birthdate ");flag=false;
                }else if (!isValid(Birthdate.getText().toString())){
                    Birthdate.setText("");
                    Birthdate.setPromptText("Birthdate is invalid");flag=false;
                } if (Department.getText().isEmpty()){
                    Department.setPromptText("please fill Department ");flag=false;
                }else{
                    flag=false;
                    for (int i = 0; i < DataBase.departments.size() && !flag; i++) {
                        if (DataBase.departments.get(i).getDepatrmentName().equals(Department.getText().toString())){
                            flag=true;
                            j=i;
                        }
                    }
                    if (!flag){
                        String s=Department.getText().toString();
                        Department.setText("");
                        Department.setPromptText("There is not a Department "+ s);
                    }
                }
                if (flag){
                    Student student=new Student(studentNumber.getText().toString());
                    student.setStudentName(studentName.getText().toString());
                    student.setBirthDate(LocalDate.parse(Birthdate.getText().toString().replace("/","-")));
                    student.setDepartment(DataBase.departments.get(j));
                    DataBase.students.add(student);
                    DataBase.departments.get(j).addStudent(student);
                    stage2.close();
                    GodMode.initializeLists(GodMode.pane);
                }
            }
        });
        pane2.getChildren().add(button);
        System.out.println(studentName.getCharacters());
        Scene scene2=new Scene(pane2);
        stage2.setScene(scene2);
        stage2.show();
    }
    public void register(Course course,AnchorPane pane,int index) throws Exception {
        Stage stage2=new Stage();
        AnchorPane pane2 = FXMLLoader.load(getClass().getResource("/Sample/fxml/help.fxml"));
        initializeLabelsStudent3(pane2);
        initializeTextFieldsStudents3(pane2);
        Button button=new Button("register");
        button.setStyle("-fx-background-color: rgba(15,238,8,0.67);");
        button.setLayoutX(260);
        button.setLayoutY(360);
        button.setPrefWidth(150);
        button.setPrefHeight(50);
        button.setFont(new Font(20));
        button.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                boolean flag=true;
                int j=-1;
                if (studentName.getText().isEmpty()){
                    studentName.setPromptText("please fill student Name ");flag=false;
                }if (studentNumber.getText().isEmpty()){
                    studentNumber.setPromptText("please fill student Number ");flag=false;
                }
                if (flag){
                    flag=false;
                    int i=0;
                    for ( i=0;i<DataBase.students.size() && !flag;i++){
                        if (DataBase.students.get(i).getStudentName().equals(studentName.getText().toString())){
                            if (DataBase.students.get(i).getStudentNumber().equals(studentNumber.getText().toString())){
                                flag=true;
                            }
                        }
                    }
                    i--;
                    if (flag) {
                        if (!course.getTakenStudent().contains(DataBase.students.get(i))) {
                            course.getTakenStudent().add(DataBase.students.get(i));
                            DataBase.students.get(i).getCourses().add(course);
                        }
                        stage2.close();
                        OfficerMode.finalShow(pane, index, course);
                    }else{
                        studentName.setText(" ");
                        studentName.setPromptText("please fill matched student Name ");

                        studentNumber.setText(" ");
                        studentNumber.setPromptText("please fill matched student Name ");
                    }
                }
            }
        });
        pane2.getChildren().add(button);
        System.out.println(studentName.getCharacters());
        Scene scene2=new Scene(pane2);
        stage2.setScene(scene2);
        stage2.show();
    }
    public void start(ArrayList<Student> students,int i) throws IOException {
        Stage stage2=new Stage();
        AnchorPane pane2 = FXMLLoader.load(getClass().getResource("/Sample/fxml/help.fxml"));
        initializeLabelsStudent2(pane2);
        initializeTextFieldsStudents2(pane2);
        Button button=new Button("Add");
        button.setStyle("-fx-background-color: rgba(15,238,8,0.67);");
        button.setLayoutX(260);
        button.setLayoutY(360);
        button.setPrefWidth(150);
        button.setPrefHeight(50);
        button.setFont(new Font(20));
        button.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                boolean flag=true;
                int j=-1;
                if (studentName.getText().isEmpty()){
                    studentName.setPromptText("please fill student Name ");flag=false;
                }if (studentNumber.getText().isEmpty()){
                    studentNumber.setPromptText("please fill student Number ");flag=false;
                }if (Birthdate.getText().isEmpty()){
                    Birthdate.setPromptText("please fill Birthdate ");flag=false;
                }else if (!isValid(Birthdate.getText().toString())){
                    Birthdate.setText("");
                    Birthdate.setPromptText("Birthdate is invalid");flag=false;
                }
                if (flag){
                    Student student=new Student(studentNumber.getText().toString());
                    student.setStudentName(studentName.getText().toString());
                    student.setBirthDate(LocalDate.parse(Birthdate.getText().toString().replace("/","-")));
                    student.setDepartment(DataBase.departments.get(i));
                    DataBase.students.add(student);
                    DataBase.departments.get(i).addStudent(student);
                    stage2.close();
                    OfficerMode.initializeLists(OfficerMode.pane,i);
                }
            }
        });
        pane2.getChildren().add(button);
        System.out.println(studentName.getCharacters());
        Scene scene2=new Scene(pane2);
        stage2.setScene(scene2);
        stage2.show();
    }
    private void initializeTextFieldsStudents(AnchorPane pane2) {
        studentName.setPromptText("Student Name");studentName.setLayoutX(371);studentName.setLayoutY(101);studentName.setPrefWidth(256);studentName.setPrefHeight(45);
       pane2.getChildren().add(studentName);
        studentNumber.setPromptText("Student Number");studentNumber.setLayoutX(371);studentNumber.setLayoutY(163);studentNumber.setPrefWidth(256);studentNumber.setPrefHeight(45);
        pane2.getChildren().add(studentNumber);
        Birthdate.setPromptText("Birthdate");Birthdate.setLayoutX(371);Birthdate.setLayoutY(225);Birthdate.setPrefWidth(256);Birthdate.setPrefHeight(45);
        pane2.getChildren().add(Birthdate);
        Department.setPromptText("Department");Department.setLayoutX(371);Department.setLayoutY(287);Department.setPrefWidth(256);Department.setPrefHeight(45);
        pane2.getChildren().add(Department);
    }
    private void initializeLabelsStudent(AnchorPane pane2) {
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
    }
    private void initializeTextFieldsStudents3(AnchorPane pane2) {
        studentName.setPromptText("Student Name");studentName.setLayoutX(371);studentName.setLayoutY(101);studentName.setPrefWidth(256);studentName.setPrefHeight(45);
        pane2.getChildren().add(studentName);
        studentNumber.setPromptText("Student Number");studentNumber.setLayoutX(371);studentNumber.setLayoutY(163);studentNumber.setPrefWidth(256);studentNumber.setPrefHeight(45);
        pane2.getChildren().add(studentNumber);
    }
    private void initializeLabelsStudent3(AnchorPane pane2) {
        studentNameLabel.setLayoutX(49);studentNameLabel.setLayoutY(101);studentNameLabel.setPrefWidth(256);studentNameLabel.setPrefHeight(45); studentNameLabel.setStyle("-fx-background-color:  rgba(9,13,236,0.67);");studentNameLabel.setAlignment(Pos.CENTER);
        pane2.getChildren().add(studentNameLabel);
        studentNumberLabel.setLayoutX(49);studentNumberLabel.setLayoutY(163);studentNumberLabel.setPrefWidth(256);studentNumberLabel.setPrefHeight(45); studentNumberLabel.setStyle("-fx-background-color:  rgba(9,13,236,0.67);");studentNumberLabel.setAlignment(Pos.CENTER);
        pane2.getChildren().add(studentNumberLabel);
        register.setLayoutX(222);register.setLayoutY(20);register.setPrefWidth(256);register.setPrefHeight(45); register.setStyle("-fx-background-color: rgba(207,8,238,0.67);");register.setAlignment(Pos.CENTER);
        pane2.getChildren().add(register);
    }
    private void initializeTextFieldsStudents2(AnchorPane pane2) {
        studentName.setPromptText("Student Name");studentName.setLayoutX(371);studentName.setLayoutY(101);studentName.setPrefWidth(256);studentName.setPrefHeight(45);
        pane2.getChildren().add(studentName);
        studentNumber.setPromptText("Student Number");studentNumber.setLayoutX(371);studentNumber.setLayoutY(163);studentNumber.setPrefWidth(256);studentNumber.setPrefHeight(45);
        pane2.getChildren().add(studentNumber);
        Birthdate.setPromptText("Birthdate");Birthdate.setLayoutX(371);Birthdate.setLayoutY(225);Birthdate.setPrefWidth(256);Birthdate.setPrefHeight(45);
        pane2.getChildren().add(Birthdate);
    }
    private void initializeLabelsStudent2(AnchorPane pane2) {
        studentNameLabel.setLayoutX(49);studentNameLabel.setLayoutY(101);studentNameLabel.setPrefWidth(256);studentNameLabel.setPrefHeight(45); studentNameLabel.setStyle("-fx-background-color:  rgba(9,13,236,0.67);");studentNameLabel.setAlignment(Pos.CENTER);
        pane2.getChildren().add(studentNameLabel);
        studentNumberLabel.setLayoutX(49);studentNumberLabel.setLayoutY(163);studentNumberLabel.setPrefWidth(256);studentNumberLabel.setPrefHeight(45); studentNumberLabel.setStyle("-fx-background-color:  rgba(9,13,236,0.67);");studentNumberLabel.setAlignment(Pos.CENTER);
        pane2.getChildren().add(studentNumberLabel);
        BirthdateLabel.setLayoutX(49);BirthdateLabel.setLayoutY(226);BirthdateLabel.setPrefWidth(256);BirthdateLabel.setPrefHeight(45); BirthdateLabel.setStyle("-fx-background-color:  rgba(9,13,236,0.67);");BirthdateLabel.setAlignment(Pos.CENTER);
        pane2.getChildren().add(BirthdateLabel);
        AddStudent.setLayoutX(222);AddStudent.setLayoutY(20);AddStudent.setPrefWidth(256);AddStudent.setPrefHeight(45); AddStudent.setStyle("-fx-background-color: rgba(207,8,238,0.67);");AddStudent.setAlignment(Pos.CENTER);
        pane2.getChildren().add(AddStudent);
    }
    public boolean isValid(String dateStr) {
        DateFormat sdf = new SimpleDateFormat(this.dateFormat);
        sdf.setLenient(false);
        try {
            sdf.parse(dateStr);
        } catch (ParseException e) {
            return false;
        }
        return true;
    }
    public void start2(ArrayList<Professor> professors) throws IOException {
        Stage stage2=new Stage();
        AnchorPane pane2 = FXMLLoader.load(getClass().getResource("/Sample/fxml/help.fxml"));
        initializeLabelsProffessor(pane2);
        initializeTextFieldsProfessors(pane2);
        Button button=new Button("Add");
        button.setStyle("-fx-background-color: rgba(15,238,8,0.67);");
        button.setLayoutX(260);
        button.setLayoutY(360);
        button.setPrefWidth(150);
        button.setPrefHeight(50);
        button.setFont(new Font(20));
        button.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                boolean flag=true;
                int j=-1;
                if (professorName.getText().isEmpty()){
                    professorName.setPromptText("please fill professor Name ");flag=false;
                }if (Birthdate.getText().isEmpty()){
                    Birthdate.setPromptText("please fill Birthdate ");flag=false;
                }else if (!isValid(Birthdate.getText().toString())){
                    Birthdate.setText("");
                    Birthdate.setPromptText("Birthdate is invalid");flag=false;
                } if (Department.getText().isEmpty()){
                    Department.setPromptText("please fill Department ");flag=false;
                }else{
                    flag=false;
                    for (int i = 0; i < DataBase.departments.size() && !flag; i++) {
                        if (DataBase.departments.get(i).getDepatrmentName().equals(Department.getText().toString())){
                            flag=true;
                            j=i;
                        }
                    }
                    if (!flag){
                        String s=Department.getText().toString();
                        Department.setText("");
                        Department.setPromptText("There is not a Department "+ s);
                    }
                }if (professorRank.getText().isEmpty()){
                    professorRank.setPromptText("please fill professor rank ");flag=false;
                }else if(!(professorRank.getText().equals("PROFESSOR_ASSISTANT") || professorRank.getText().equals("PROFESSOR") || professorRank.getText().equals("PROFESSOR_ASSOCIATE"))){
                    professorRank.setText("");
                    professorRank.setPromptText("please fill desired rank ");flag=false;
                }
                if (flag){
                    Professor professor=new Professor(professorName.getText().toString());
                    professor.setBirthDate(LocalDate.parse(Birthdate.getText().toString().replace("/","-")));
                    professor.setDepartment(DataBase.departments.get(j));
                    if (professorRank.getText().equals("PROFESSOR_ASSISTANT")){
                        professor.setAcademicRank(AcademicRank.PROFESSOR_ASSISTANT);
                    }else if (professorRank.getText().equals("PROFESSOR")){
                        professor.setAcademicRank(AcademicRank.PROFESSOR);
                    }else if (professorRank.getText().equals("PROFESSOR_ASSOCIATE")){
                        professor.setAcademicRank(AcademicRank.PROFESSOR_ASSOCIATE);
                    }
                    DataBase.professors.add(professor);
                    DataBase.departments.get(j).addFacaulty(professor);
                    stage2.close();
                    GodMode.initializeLists(GodMode.pane);
                }
            }
        });
        pane2.getChildren().add(button);
        Scene scene2=new Scene(pane2);
        stage2.setScene(scene2);
        stage2.show();
    }
    public void start2(ArrayList<Professor> professors,int i) throws IOException {
        Stage stage2=new Stage();
        AnchorPane pane2 = FXMLLoader.load(getClass().getResource("/Sample/fxml/help.fxml"));
        initializeLabelsProffessor2(pane2);
        initializeTextFieldsProfessors2(pane2);
        Button button=new Button("Add");
        button.setStyle("-fx-background-color: rgba(15,238,8,0.67);");
        button.setLayoutX(260);
        button.setLayoutY(360);
        button.setPrefWidth(150);
        button.setPrefHeight(50);
        button.setFont(new Font(20));
        button.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                boolean flag=true;
                int j=-1;
                if (professorName.getText().isEmpty()){
                    professorName.setPromptText("please fill professor Name ");flag=false;
                }if (Birthdate.getText().isEmpty()){
                    Birthdate.setPromptText("please fill Birthdate ");flag=false;
                }else if (!isValid(Birthdate.getText().toString())){
                    Birthdate.setText("");
                    Birthdate.setPromptText("Birthdate is invalid");flag=false;
                }if (professorRank.getText().isEmpty()){
                    professorRank.setPromptText("please fill professor rank ");flag=false;
                }else if(!(professorRank.getText().equals("PROFESSOR_ASSISTANT") || professorRank.getText().equals("PROFESSOR") || professorRank.getText().equals("PROFESSOR_ASSOCIATE"))){
                    professorRank.setText("");
                    professorRank.setPromptText("please fill desired rank ");flag=false;
                }
                if (flag){
                    Professor professor=new Professor(professorName.getText().toString());
                    professor.setBirthDate(LocalDate.parse(Birthdate.getText().toString().replace("/","-")));
                    professor.setDepartment(DataBase.departments.get(i));
                    if (professorRank.getText().equals("PROFESSOR_ASSISTANT")){
                        professor.setAcademicRank(AcademicRank.PROFESSOR_ASSISTANT);
                    }else if (professorRank.getText().equals("PROFESSOR")){
                        professor.setAcademicRank(AcademicRank.PROFESSOR);
                    }else if (professorRank.getText().equals("PROFESSOR_ASSOCIATE")){
                        professor.setAcademicRank(AcademicRank.PROFESSOR_ASSOCIATE);
                    }
                    DataBase.professors.add(professor);
                    DataBase.departments.get(i).addFacaulty(professor);
                    stage2.close();
                    OfficerMode.initializeLists(OfficerMode.pane,i);
                }
            }
        });
        pane2.getChildren().add(button);
        Scene scene2=new Scene(pane2);
        stage2.setScene(scene2);
        stage2.show();
    }
    private void initializeLabelsProffessor(AnchorPane pane2) {
        professorNameLabel.setLayoutX(49);professorNameLabel.setLayoutY(101);professorNameLabel.setPrefWidth(256);professorNameLabel.setPrefHeight(45); professorNameLabel.setStyle("-fx-background-color:  rgba(9,13,236,0.67);");professorNameLabel.setAlignment(Pos.CENTER);
        pane2.getChildren().add(professorNameLabel);
        BirthdateLabel.setLayoutX(49);BirthdateLabel.setLayoutY(163);BirthdateLabel.setPrefWidth(256);BirthdateLabel.setPrefHeight(45); BirthdateLabel.setStyle("-fx-background-color:  rgba(9,13,236,0.67);");BirthdateLabel.setAlignment(Pos.CENTER);
        pane2.getChildren().add(BirthdateLabel);
        DepartmentLabel.setLayoutX(49);DepartmentLabel.setLayoutY(226);DepartmentLabel.setPrefWidth(256);DepartmentLabel.setPrefHeight(45); DepartmentLabel.setStyle("-fx-background-color:  rgba(9,13,236,0.67);");DepartmentLabel.setAlignment(Pos.CENTER);
        pane2.getChildren().add(DepartmentLabel);
        professorRankLabel.setLayoutX(49);professorRankLabel.setLayoutY(287);professorRankLabel.setPrefWidth(256);professorRankLabel.setPrefHeight(45); professorRankLabel.setStyle("-fx-background-color:  rgba(9,13,236,0.67);");professorRankLabel.setAlignment(Pos.CENTER);
        pane2.getChildren().add(professorRankLabel);
        AddProfessor.setLayoutX(222);AddProfessor.setLayoutY(20);AddProfessor.setPrefWidth(256);AddProfessor.setPrefHeight(45); AddProfessor.setStyle("-fx-background-color: rgba(207,8,238,0.67);");AddProfessor.setAlignment(Pos.CENTER);
        pane2.getChildren().add(AddProfessor);
    }
    private void initializeTextFieldsProfessors(AnchorPane pane2) {
        professorName.setPromptText("Professor Name");professorName.setLayoutX(371);professorName.setLayoutY(101);professorName.setPrefWidth(256);professorName.setPrefHeight(45);
        pane2.getChildren().add(professorName);
        Birthdate.setPromptText("Birthdate");Birthdate.setLayoutX(371);Birthdate.setLayoutY(163);Birthdate.setPrefWidth(256);Birthdate.setPrefHeight(45);
        pane2.getChildren().add(Birthdate);
        Department.setPromptText("Department");Department.setLayoutX(371);Department.setLayoutY(225);Department.setPrefWidth(256);Department.setPrefHeight(45);
        pane2.getChildren().add(Department);
        professorRank.setPromptText("Professor Rank");professorRank.setLayoutX(371);professorRank.setLayoutY(287);professorRank.setPrefWidth(256);professorRank.setPrefHeight(45);
        pane2.getChildren().add(professorRank);
    }
    private void initializeLabelsProffessor2(AnchorPane pane2) {
        professorNameLabel.setLayoutX(49);professorNameLabel.setLayoutY(101);professorNameLabel.setPrefWidth(256);professorNameLabel.setPrefHeight(45); professorNameLabel.setStyle("-fx-background-color:  rgba(9,13,236,0.67);");professorNameLabel.setAlignment(Pos.CENTER);
        pane2.getChildren().add(professorNameLabel);
        BirthdateLabel.setLayoutX(49);BirthdateLabel.setLayoutY(163);BirthdateLabel.setPrefWidth(256);BirthdateLabel.setPrefHeight(45); BirthdateLabel.setStyle("-fx-background-color:  rgba(9,13,236,0.67);");BirthdateLabel.setAlignment(Pos.CENTER);
        pane2.getChildren().add(BirthdateLabel);
        professorRankLabel.setLayoutX(49);professorRankLabel.setLayoutY(225);professorRankLabel.setPrefWidth(256);professorRankLabel.setPrefHeight(45); professorRankLabel.setStyle("-fx-background-color:  rgba(9,13,236,0.67);");professorRankLabel.setAlignment(Pos.CENTER);
        pane2.getChildren().add(professorRankLabel);
        AddProfessor.setLayoutX(222);AddProfessor.setLayoutY(20);AddProfessor.setPrefWidth(256);AddProfessor.setPrefHeight(45); AddProfessor.setStyle("-fx-background-color: rgba(207,8,238,0.67);");AddProfessor.setAlignment(Pos.CENTER);
        pane2.getChildren().add(AddProfessor);
    }
    private void initializeTextFieldsProfessors2(AnchorPane pane2) {
        professorName.setPromptText("Professor Name");professorName.setLayoutX(371);professorName.setLayoutY(101);professorName.setPrefWidth(256);professorName.setPrefHeight(45);
        pane2.getChildren().add(professorName);
        Birthdate.setPromptText("Birthdate");Birthdate.setLayoutX(371);Birthdate.setLayoutY(163);Birthdate.setPrefWidth(256);Birthdate.setPrefHeight(45);
        pane2.getChildren().add(Birthdate);
        professorRank.setPromptText("Professor Rank");professorRank.setLayoutX(371);professorRank.setLayoutY(225);professorRank.setPrefWidth(256);professorRank.setPrefHeight(45);
        pane2.getChildren().add(professorRank);
    }
    public void start3(ArrayList<Course> courses) throws IOException {
        Stage stage2=new Stage();
        AnchorPane pane2 = FXMLLoader.load(getClass().getResource("/Sample/fxml/help.fxml"));
        initializeLabelsCourse(pane2);
        initializeTextFieldsCourse(pane2);
        Button button=new Button("Add");
        button.setStyle("-fx-background-color: rgba(15,238,8,0.67);");
        button.setLayoutX(260);
        button.setLayoutY(360);
        button.setPrefWidth(150);
        button.setPrefHeight(50);
        button.setFont(new Font(20));
        button.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                boolean flag=true;
                int j=-1;
                int k=-1;
                if (courseName.getText().isEmpty()){
                    courseName.setPromptText("please fill Course Name ");flag=false;
                }if(courseCredit.getText().isEmpty()) {
                    courseCredit.setPromptText("please fill Course Credit ");flag=false;
                }else{
                    int y=Integer.parseInt(courseCredit.getText().toString());
                    if (y<3 && y>6){
                        courseCredit.setPromptText("please fill correct Course Credit (from 3 to 6)");
                        flag=false;
                    }
                }
                if (Department.getText().isEmpty()){
                    Department.setPromptText("please fill Department ");flag=false;
                }else{
                    flag=false;
                    for (int i = 0; i < DataBase.departments.size() && !flag; i++) {
                        if (DataBase.departments.get(i).getDepatrmentName().equals(Department.getText().toString())){
                            flag=true;
                            j=i;
                        }
                    }
                    if (!flag){
                        String s=Department.getText().toString();
                        Department.setText("");
                        Department.setPromptText("There is not a Department "+ s);
                    }
                }if (professorName.getText().isEmpty()){
                    professorName.setPromptText("please fill professor Name ");flag=false;
                }else{
                    flag=false;
                    for (int i = 0; i < DataBase.professors.size() && !flag; i++) {
                        if (DataBase.professors.get(i).getProfessorName().equals(professorName.getText().toString())){
                            flag=true;
                            k=i;
                        }
                    }
                    if (!flag){
                        String s=professorName.getText().toString();
                        professorName.setText("");
                        professorName.setPromptText("There is not a Professor "+ s);
                    }
                }
                if (flag){
                    Course course=new Course(courseName.getText().toString());
                    course.setCredit(Integer.parseInt(courseCredit.getText().toString()));
                    course.setDepartment(DataBase.departments.get(j));
                    course.setProfessor(DataBase.professors.get(k));
                    DataBase.courses.add(course);
                    DataBase.departments.get(j).addCourse(course);
                    DataBase.professors.get(k).getCourses().add(course);
                    stage2.close();
                    GodMode.initializeLists(GodMode.pane);
                }
            }
        });
        pane2.getChildren().add(button);
        Scene scene2=new Scene(pane2);
        stage2.setScene(scene2);
        stage2.show();
    }
    public void start3(ArrayList<Course> courses,int i) throws IOException {
        Stage stage2=new Stage();
        AnchorPane pane2 = FXMLLoader.load(getClass().getResource("/Sample/fxml/help.fxml"));
        initializeLabelsCourse3(pane2);
        initializeTextFieldsCourse3(pane2);
        Button button=new Button("Add");
        button.setStyle("-fx-background-color: rgba(15,238,8,0.67);");
        button.setLayoutX(260);
        button.setLayoutY(360);
        button.setPrefWidth(150);
        button.setPrefHeight(50);
        button.setFont(new Font(20));
        button.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                boolean flag=true;
                int j=-1;
                int k=-1;
                if (courseName.getText().isEmpty()){
                    courseName.setPromptText("please fill Course Name ");flag=false;
                }if(courseCredit.getText().isEmpty()) {
                    courseCredit.setPromptText("please fill Course Credit ");flag=false;
                }else{
                    int y=Integer.parseInt(courseCredit.getText().toString());
                    if (y<3 && y>6){
                        courseCredit.setPromptText("please fill correct Course Credit (from 3 to 6)");
                        flag=false;
                    }
                }
                if (professorName.getText().isEmpty()){
                    professorName.setPromptText("please fill professor Name ");flag=false;
                }else{
                    flag=false;
                    for (int i = 0; i < DataBase.professors.size() && !flag; i++) {
                        if (DataBase.professors.get(i).getProfessorName().equals(professorName.getText().toString())){
                            flag=true;
                            k=i;
                        }
                    }
                    if (!flag){
                        String s=professorName.getText().toString();
                        professorName.setText("");
                        professorName.setPromptText("There is not a Professor "+ s);
                    }
                }
                if (flag){
                    Course course=new Course(courseName.getText().toString());
                    course.setCredit(Integer.parseInt(courseCredit.getText().toString()));
                    course.setDepartment(DataBase.departments.get(i));
                    course.setProfessor(DataBase.professors.get(k));
                    DataBase.courses.add(course);
                    DataBase.departments.get(i).addCourse(course);
                    DataBase.professors.get(k).getCourses().add(course);
                    stage2.close();
                    OfficerMode.initializeLists(OfficerMode.pane,i);
                }
            }
        });
        pane2.getChildren().add(button);
        Scene scene2=new Scene(pane2);
        stage2.setScene(scene2);
        stage2.show();
    }
    public void start6(ArrayList<Course> courses, int index) throws IOException {
        Stage stage2=new Stage();
        AnchorPane pane2 = FXMLLoader.load(getClass().getResource("/Sample/fxml/help.fxml"));
        initializeLabelsCourse2(pane2);
        initializeTextFieldsCourse2(pane2);
        Button button=new Button("Add");
        button.setStyle("-fx-background-color: rgba(15,238,8,0.67);");
        button.setLayoutX(260);
        button.setLayoutY(360);
        button.setPrefWidth(150);
        button.setPrefHeight(50);
        button.setFont(new Font(20));
        button.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                boolean flag=true;
                int j=-1;
                int k=-1;
                if (courseName.getText().isEmpty()){
                    courseName.setPromptText("please fill Course Name ");flag=false;
                }if(courseCredit.getText().isEmpty()) {
                    courseCredit.setPromptText("please fill Course Credit ");flag=false;
                }else{
                    int y=Integer.parseInt(courseCredit.getText().toString());
                    if (y<3 && y>6){
                        courseCredit.setPromptText("please fill correct Course Credit (from 3 to 6)");
                        flag=false;
                    }
                }
                if (Department.getText().isEmpty()){
                    Department.setPromptText("please fill Department ");flag=false;
                }else{
                    flag=false;
                    for (int i = 0; i < DataBase.departments.size() && !flag; i++) {
                        if (DataBase.departments.get(i).getDepatrmentName().equals(Department.getText().toString())){
                            flag=true;
                            j=i;
                        }
                    }
                    if (!flag){
                        String s=Department.getText().toString();
                        Department.setText("");
                        Department.setPromptText("There is not a Department "+ s);
                    }
                }
                if (flag){
                    Course course=new Course(courseName.getText().toString());
                    course.setCredit(Integer.parseInt(courseCredit.getText().toString()));
                    course.setDepartment(DataBase.departments.get(j));
                    course.setProfessor(DataBase.professors.get(index));
                    DataBase.courses.add(course);
                    DataBase.departments.get(j).addCourse(course);
                    stage2.close();
                    //GodMode.initializeLists(GodMode.pane);
                    DataBase.professors.get(index).getCourses().add(course);
                    ProfessorMode.initializeLists(ProfessorMode.pane, index);
                }
            }
        });
        pane2.getChildren().add(button);
        Scene scene2=new Scene(pane2);
        stage2.setScene(scene2);
        stage2.show();
    }
    private void initializeLabelsCourse(AnchorPane pane2) {
        courseNameLabel.setLayoutX(49);courseNameLabel.setLayoutY(101);courseNameLabel.setPrefWidth(256);courseNameLabel.setPrefHeight(45); courseNameLabel.setStyle("-fx-background-color:  rgba(9,13,236,0.67);");courseNameLabel.setAlignment(Pos.CENTER);
        pane2.getChildren().add(courseNameLabel);
        courseCreditLabel.setLayoutX(49);courseCreditLabel.setLayoutY(163);courseCreditLabel.setPrefWidth(256);courseCreditLabel.setPrefHeight(45); courseCreditLabel.setStyle("-fx-background-color:  rgba(9,13,236,0.67);");courseCreditLabel.setAlignment(Pos.CENTER);
        pane2.getChildren().add(courseCreditLabel);
        DepartmentLabel.setLayoutX(49);DepartmentLabel.setLayoutY(226);DepartmentLabel.setPrefWidth(256);DepartmentLabel.setPrefHeight(45); DepartmentLabel.setStyle("-fx-background-color:  rgba(9,13,236,0.67);");DepartmentLabel.setAlignment(Pos.CENTER);
        pane2.getChildren().add(DepartmentLabel);
        professorNameLabel.setLayoutX(49);professorNameLabel.setLayoutY(287);professorNameLabel.setPrefWidth(256);professorNameLabel.setPrefHeight(45); professorNameLabel.setStyle("-fx-background-color:  rgba(9,13,236,0.67);");professorNameLabel.setAlignment(Pos.CENTER);
        pane2.getChildren().add(professorNameLabel);
        AddCourse.setLayoutX(222);AddCourse.setLayoutY(20);AddCourse.setPrefWidth(256);AddCourse.setPrefHeight(45); AddCourse.setStyle("-fx-background-color: rgba(207,8,238,0.67);");AddCourse.setAlignment(Pos.CENTER);
        pane2.getChildren().add(AddCourse);
    }
    private void initializeTextFieldsCourse(AnchorPane pane2) {
        courseName.setPromptText("Course Name");courseName.setLayoutX(371);courseName.setLayoutY(101);courseName.setPrefWidth(256);courseName.setPrefHeight(45);
        pane2.getChildren().add(courseName);
        courseCredit.setPromptText("Course Credit");courseCredit.setLayoutX(371);courseCredit.setLayoutY(163);courseCredit.setPrefWidth(256);courseCredit.setPrefHeight(45);
        pane2.getChildren().add(courseCredit);
        Department.setPromptText("Department");Department.setLayoutX(371);Department.setLayoutY(225);Department.setPrefWidth(256);Department.setPrefHeight(45);
        pane2.getChildren().add(Department);
        professorName.setPromptText("Professor Name");professorName.setLayoutX(371);professorName.setLayoutY(287);professorName.setPrefWidth(256);professorName.setPrefHeight(45);
        pane2.getChildren().add(professorName);
    }
    private void initializeLabelsCourse3(AnchorPane pane2) {
        courseNameLabel.setLayoutX(49);courseNameLabel.setLayoutY(101);courseNameLabel.setPrefWidth(256);courseNameLabel.setPrefHeight(45); courseNameLabel.setStyle("-fx-background-color:  rgba(9,13,236,0.67);");courseNameLabel.setAlignment(Pos.CENTER);
        pane2.getChildren().add(courseNameLabel);
        courseCreditLabel.setLayoutX(49);courseCreditLabel.setLayoutY(163);courseCreditLabel.setPrefWidth(256);courseCreditLabel.setPrefHeight(45); courseCreditLabel.setStyle("-fx-background-color:  rgba(9,13,236,0.67);");courseCreditLabel.setAlignment(Pos.CENTER);
        pane2.getChildren().add(courseCreditLabel);
        professorNameLabel.setLayoutX(49);professorNameLabel.setLayoutY(226);professorNameLabel.setPrefWidth(256);professorNameLabel.setPrefHeight(45); professorNameLabel.setStyle("-fx-background-color:  rgba(9,13,236,0.67);");professorNameLabel.setAlignment(Pos.CENTER);
        pane2.getChildren().add(professorNameLabel);
        AddCourse.setLayoutX(222);AddCourse.setLayoutY(20);AddCourse.setPrefWidth(256);AddCourse.setPrefHeight(45); AddCourse.setStyle("-fx-background-color: rgba(207,8,238,0.67);");AddCourse.setAlignment(Pos.CENTER);
        pane2.getChildren().add(AddCourse);
    }
    private void initializeTextFieldsCourse3(AnchorPane pane2) {
        courseName.setPromptText("Course Name");courseName.setLayoutX(371);courseName.setLayoutY(101);courseName.setPrefWidth(256);courseName.setPrefHeight(45);
        pane2.getChildren().add(courseName);
        courseCredit.setPromptText("Course Credit");courseCredit.setLayoutX(371);courseCredit.setLayoutY(163);courseCredit.setPrefWidth(256);courseCredit.setPrefHeight(45);
        pane2.getChildren().add(courseCredit);
        professorName.setPromptText("Professor Name");professorName.setLayoutX(371);professorName.setLayoutY(225);professorName.setPrefWidth(256);professorName.setPrefHeight(45);
        pane2.getChildren().add(professorName);
    }
    private void initializeLabelsCourse2(AnchorPane pane2) {
        courseNameLabel.setLayoutX(49);courseNameLabel.setLayoutY(101);courseNameLabel.setPrefWidth(256);courseNameLabel.setPrefHeight(45); courseNameLabel.setStyle("-fx-background-color:  rgba(9,13,236,0.67);");courseNameLabel.setAlignment(Pos.CENTER);
        pane2.getChildren().add(courseNameLabel);
        courseCreditLabel.setLayoutX(49);courseCreditLabel.setLayoutY(163);courseCreditLabel.setPrefWidth(256);courseCreditLabel.setPrefHeight(45); courseCreditLabel.setStyle("-fx-background-color:  rgba(9,13,236,0.67);");courseCreditLabel.setAlignment(Pos.CENTER);
        pane2.getChildren().add(courseCreditLabel);
        DepartmentLabel.setLayoutX(49);DepartmentLabel.setLayoutY(226);DepartmentLabel.setPrefWidth(256);DepartmentLabel.setPrefHeight(45); DepartmentLabel.setStyle("-fx-background-color:  rgba(9,13,236,0.67);");DepartmentLabel.setAlignment(Pos.CENTER);
        pane2.getChildren().add(DepartmentLabel);
        AddCourse.setLayoutX(222);AddCourse.setLayoutY(20);AddCourse.setPrefWidth(256);AddCourse.setPrefHeight(45); AddCourse.setStyle("-fx-background-color: rgba(207,8,238,0.67);");AddCourse.setAlignment(Pos.CENTER);
        pane2.getChildren().add(AddCourse);
    }
    private void initializeTextFieldsCourse2(AnchorPane pane2) {
        courseName.setPromptText("Course Name");courseName.setLayoutX(371);courseName.setLayoutY(101);courseName.setPrefWidth(256);courseName.setPrefHeight(45);
        pane2.getChildren().add(courseName);
        courseCredit.setPromptText("Course Credit");courseCredit.setLayoutX(371);courseCredit.setLayoutY(163);courseCredit.setPrefWidth(256);courseCredit.setPrefHeight(45);
        pane2.getChildren().add(courseCredit);
        Department.setPromptText("Department");Department.setLayoutX(371);Department.setLayoutY(225);Department.setPrefWidth(256);Department.setPrefHeight(45);
        pane2.getChildren().add(Department);
    }
    public void start4(ArrayList<Department> departments) throws IOException {
        Stage stage2=new Stage();
        AnchorPane pane2 = FXMLLoader.load(getClass().getResource("/Sample/fxml/help.fxml"));
        initializeLabelsDepartment(pane2);
        initializeTextFieldsDepartment(pane2);
        Button button=new Button("Add");
        button.setStyle("-fx-background-color: rgba(15,238,8,0.67);");
        button.setLayoutX(260);
        button.setLayoutY(360);
        button.setPrefWidth(150);
        button.setPrefHeight(50);
        button.setFont(new Font(20));
        button.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                boolean flag=true;
                if (DepartmentName.getText().isEmpty()){
                    DepartmentName.setPromptText("please fill Department Name ");flag=false;
                }if(DepartmentSerial.getText().isEmpty()) {
                    DepartmentSerial.setPromptText("please fill Department Serial ");flag=false;
                }
                if (flag){
                    Department department=new Department(DepartmentName.getText().toString());
                    department.setDepatrmentSerial(DepartmentSerial.getText().toString());
                    DataBase.departments.add(department);
                    stage2.close();
                    GodMode.initializeLists(GodMode.pane);
                }

            }
        });
        pane2.getChildren().add(button);
        Scene scene2=new Scene(pane2);
        stage2.setScene(scene2);
        stage2.show();
    }
    private void initializeLabelsDepartment(AnchorPane pane2) {
        DepartmentNameLabel.setLayoutX(49);DepartmentNameLabel.setLayoutY(101);DepartmentNameLabel.setPrefWidth(256);DepartmentNameLabel.setPrefHeight(45); DepartmentNameLabel.setStyle("-fx-background-color:  rgba(9,13,236,0.67);");DepartmentNameLabel.setAlignment(Pos.CENTER);
        pane2.getChildren().add(DepartmentNameLabel);
        DepartmentSerialLabel.setLayoutX(49);DepartmentSerialLabel.setLayoutY(163);DepartmentSerialLabel.setPrefWidth(256);DepartmentSerialLabel.setPrefHeight(45); DepartmentSerialLabel.setStyle("-fx-background-color:  rgba(9,13,236,0.67);");DepartmentSerialLabel.setAlignment(Pos.CENTER);
        pane2.getChildren().add(DepartmentSerialLabel);
        AddDepartment.setLayoutX(222);AddDepartment.setLayoutY(20);AddDepartment.setPrefWidth(256);AddDepartment.setPrefHeight(45); AddDepartment.setStyle("-fx-background-color: rgba(207,8,238,0.67);");AddDepartment.setAlignment(Pos.CENTER);
        pane2.getChildren().add(AddDepartment);
    }
    private void initializeTextFieldsDepartment(AnchorPane pane2) {
        DepartmentName.setPromptText("Department Name");DepartmentName.setLayoutX(371);DepartmentName.setLayoutY(101);DepartmentName.setPrefWidth(256);DepartmentName.setPrefHeight(45);
        pane2.getChildren().add(DepartmentName);
        DepartmentSerial.setPromptText("Department Serial");DepartmentSerial.setLayoutX(371);DepartmentSerial.setLayoutY(163);DepartmentSerial.setPrefWidth(256);DepartmentSerial.setPrefHeight(45);
        pane2.getChildren().add(DepartmentSerial);
    }
}

