package Sample.View;
import Sample.Controller.AddViewHandler;
import Sample.Controller.ListViewHandler;
import Sample.Model.*;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import java.io.IOException;
public class GodMode {
    private static Stage stage;
   public static AnchorPane pane;
    public void start(Stage stage) throws Exception {
        this.stage=stage;
         pane = FXMLLoader.load(getClass().getResource("/Sample/fxml/GodMode.fxml"));
        initializeLists(pane);
        initializeButtons(pane);
        initializeText(pane);
        Scene scene = new Scene(pane);
        stage.setScene(scene);
    }
    private void initializeText(AnchorPane pane) {
        Label Students = new Label("Students");
        Students.setLayoutX(55);Students.setLayoutY(125);
        Students.setPrefWidth(200);
        Students.setPrefHeight(50);
        Students.setFont(new Font(20));
        Students.setStyle("-fx-background-color:  rgba(9,13,236,0.67);");
        Students.setAlignment(Pos.CENTER);
        Label Professors = new Label("Professors");
        Professors.setLayoutX(300);Professors.setLayoutY(125);
        Professors.setPrefWidth(200);
        Professors.setPrefHeight(50);
        Professors.setFont(new Font(20));
        Professors.setStyle("-fx-background-color:  rgba(9,13,236,0.67);");
        Professors.setAlignment(Pos.CENTER);
        Label Courses = new Label("Courses");
        Courses.setLayoutX(545);Courses.setLayoutY(125);
        Courses.setPrefWidth(200);
        Courses.setPrefHeight(50);
        Courses.setFont(new Font(20));
        Courses.setStyle("-fx-background-color:  rgba(9,13,236,0.67);");
        Courses.setAlignment(Pos.CENTER);
        Label Departments = new Label("Departments");
        Departments.setLayoutX(790);Departments.setLayoutY(125);
        Departments.setPrefWidth(200);
        Departments.setPrefHeight(50);
        Departments.setFont(new Font(20));
        Departments.setStyle("-fx-background-color:  rgba(9,13,236,0.67);");
        Departments.setAlignment(Pos.CENTER);
        Label GodMode = new Label("God Mode");
        GodMode.setLayoutX(200);GodMode.setLayoutY(10);
        GodMode.setPrefWidth(650);
        GodMode.setPrefHeight(70);
        GodMode.setFont(new Font(20));
        GodMode.setStyle("-fx-background-color:  rgba(179,9,236,0.67);");
        GodMode.setAlignment(Pos.CENTER);
        pane.getChildren().add(Students);pane.getChildren().add(Courses);pane.getChildren().add(Professors);pane.getChildren().add(Departments);pane.getChildren().add(GodMode);
    }
    private void initializeButtons(AnchorPane pane) {
        Button StudentButton=new Button();
        StudentButton.setText("Add Student");
        StudentButton.setLayoutX(55);
        StudentButton.setLayoutY(585);
        StudentButton.setPrefWidth(200);
        StudentButton.setPrefHeight(50);
        StudentButton.setFont(new Font(20));
        StudentButton.setStyle("-fx-background-color:  rgba(39,236,9,0.67);");
        StudentButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                try {
                    new AddViewHandler().start(DataBase.students);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        Button ProfessorButton=new Button();
        ProfessorButton.setText("Add Professor");
        ProfessorButton.setLayoutX(300);
        ProfessorButton.setLayoutY(585);
        ProfessorButton.setPrefWidth(200);
        ProfessorButton.setPrefHeight(50);
        ProfessorButton.setFont(new Font(20));
        ProfessorButton.setStyle("-fx-background-color:  rgba(39,236,9,0.67);");
        ProfessorButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                try {
                    new AddViewHandler().start2(DataBase.professors);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        Button CourseButton=new Button();
        CourseButton.setText("Add Course");
        CourseButton.setLayoutX(545);
        CourseButton.setLayoutY(585);
        CourseButton.setPrefWidth(200);
        CourseButton.setPrefHeight(50);
        CourseButton.setFont(new Font(20));
        CourseButton.setStyle("-fx-background-color:  rgba(39,236,9,0.67);");
        CourseButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                try {
                    new AddViewHandler().start3(DataBase.courses);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        Button DepartmentButton=new Button();
        DepartmentButton.setText("Add Department");
        DepartmentButton.setLayoutX(790);
        DepartmentButton.setLayoutY(585);
        DepartmentButton.setPrefWidth(200);
        DepartmentButton.setPrefHeight(50);
        DepartmentButton.setFont(new Font(20));
        DepartmentButton.setStyle("-fx-background-color:  rgba(39,236,9,0.67);");
        DepartmentButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                try {
                    new AddViewHandler().start4(DataBase.departments);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
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
        pane.getChildren().add(StudentButton);pane.getChildren().add(DepartmentButton);pane.getChildren().add(ProfessorButton);pane.getChildren().add(CourseButton); pane.getChildren().add(back);
    }
    public static void initializeLists(AnchorPane pane) {
        ListView StudentsList = new ListView();
        ListView ProfessorsList = new ListView();
        ListView CoursesList = new ListView();
        ListView DepartmentList = new ListView();

        if (DataBase.students.size()==0){
            StudentsList.getItems().add("There is no student");
        }else{
            StudentsList.refresh();
            for (Student student : DataBase.students) {
                StudentsList.getItems().add(student.getStudentName());
            }
        }
        StudentsList.setLayoutX(55);
        StudentsList.setLayoutY(180);
        StudentsList.setPrefWidth(200);
        if (DataBase.professors.size()==0){
            ProfessorsList.getItems().add("There is no professor");
        }else{
            ProfessorsList.refresh();
            for (Professor professor : DataBase.professors) {
                ProfessorsList.getItems().add(professor.getProfessorName());
            }
        }
        ProfessorsList.setLayoutX(300);
        ProfessorsList.setLayoutY(180);
        ProfessorsList.setPrefWidth(200);
        if (DataBase.courses.size()==0){
            CoursesList.getItems().add("There is no course");
        }else{
            CoursesList.refresh();
            for (Course course : DataBase.courses) {
                CoursesList.getItems().add(course.getCourseName());
            }
        }
        CoursesList.setLayoutX(545);
        CoursesList.setLayoutY(180);
        CoursesList.setPrefWidth(200);
        if (DataBase.departments.size()==0){
            DepartmentList.getItems().add("There is no Department");
        }else{
            DepartmentList.refresh();
            for (Department department : DataBase.departments) {
                DepartmentList.getItems().add(department.getDepatrmentName());
            }
        }
        DepartmentList.setLayoutX(790);
        DepartmentList.setLayoutY(180);
        DepartmentList.setPrefWidth(200);
        CoursesList.setOnMouseClicked(new ListViewHandler(){
            @Override
            public void handle(javafx.scene.input.MouseEvent event) {
                try {
                    if (DataBase.courses.size()>0)
                        new ListViewHandler().start3(DataBase.courses,CoursesList.getSelectionModel().getSelectedIndex());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        DepartmentList.setOnMouseClicked(new ListViewHandler(){
            @Override
            public void handle(javafx.scene.input.MouseEvent event) {
                try {
                    if (DataBase.departments.size()>0)
                        new ListViewHandler().start4(DataBase.departments,DepartmentList.getSelectionModel().getSelectedIndex());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        ProfessorsList.setOnMouseClicked(new ListViewHandler(){
            @Override
            public void handle(javafx.scene.input.MouseEvent event) {
                try {
                    if (DataBase.professors.size()>0)
                        new ListViewHandler().start2(DataBase.professors,ProfessorsList.getSelectionModel().getSelectedIndex());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        StudentsList.setOnMouseClicked(new ListViewHandler(){
            @Override
            public void handle(javafx.scene.input.MouseEvent event) {
                try {
                    if (DataBase.students.size()>0)
                    new ListViewHandler().start1(DataBase.students,StudentsList.getSelectionModel().getSelectedIndex());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        pane.getChildren().add(StudentsList);pane.getChildren().add(DepartmentList);pane.getChildren().add(ProfessorsList);pane.getChildren().add(CoursesList);
    }
}
