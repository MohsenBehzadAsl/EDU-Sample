package Sample.View;
import Sample.Controller.AddViewHandler;
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
public class OfficerMode {
    private static Stage stage;
    public static AnchorPane pane;
    public void start(Stage stage, int i) throws Exception{
        this.stage=stage;
        pane = FXMLLoader.load(getClass().getResource("/Sample/fxml/GodMode.fxml"));
        initializeLists(pane,i);
        initializeButtons(pane,i);
        initializeText(pane,i);
        Scene scene = new Scene(pane);
        stage.setScene(scene);
    }
    private void initializeText(AnchorPane pane, int i) {
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
        Label GodMode = new Label("Officer Mode");
        GodMode.setLayoutX(200);GodMode.setLayoutY(10);
        GodMode.setPrefWidth(650);
        GodMode.setPrefHeight(70);
        GodMode.setFont(new Font(20));
        GodMode.setStyle("-fx-background-color:  rgba(179,9,236,0.67);");
        GodMode.setAlignment(Pos.CENTER);
        pane.getChildren().add(Students);pane.getChildren().add(Courses);pane.getChildren().add(Professors);pane.getChildren().add(GodMode);
    }
    private void initializeButtons(AnchorPane pane, int i) {
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
                    new AddViewHandler().start(DataBase.students,i);
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
                    new AddViewHandler().start2(DataBase.professors,i);
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
                    new AddViewHandler().start3(DataBase.courses,i);
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
        pane.getChildren().add(StudentButton);pane.getChildren().add(ProfessorButton);pane.getChildren().add(CourseButton); pane.getChildren().add(back);
    }
    public static void initializeLists(AnchorPane pane, int i) {
        ListView StudentsList = new ListView();
        ListView ProfessorsList = new ListView();
        ListView CoursesList = new ListView();
        if (DataBase.departments.get(i).getStudent().size()==0){
            StudentsList.getItems().add("There is no student");
        }else{
            StudentsList.refresh();
            for (Student student : DataBase.departments.get(i).getStudent()) {
                StudentsList.getItems().add(student.getStudentName());
            }
        }
        StudentsList.setLayoutX(55);
        StudentsList.setLayoutY(180);
        StudentsList.setPrefWidth(200);
        if (DataBase.departments.get(i).getFacaulty().size()==0){
            ProfessorsList.getItems().add("There is no professor");
        }else{
            ProfessorsList.refresh();
            for (Professor professor : DataBase.departments.get(i).getFacaulty()) {
                ProfessorsList.getItems().add(professor.getProfessorName());
            }
        }
        ProfessorsList.setLayoutX(300);
        ProfessorsList.setLayoutY(180);
        ProfessorsList.setPrefWidth(200);
        if (DataBase.departments.get(i).getCourses().size()==0){
            CoursesList.getItems().add("There is no course");
        }else{
            CoursesList.refresh();
            for (Course course : DataBase.departments.get(i).getCourses()) {
                CoursesList.getItems().add(course.getCourseName());
            }
        }
        CoursesList.setLayoutX(545);
        CoursesList.setLayoutY(180);
        CoursesList.setPrefWidth(200);
        CoursesList.setOnMouseClicked(new ListViewHandler(){
            @Override
            public void handle(javafx.scene.input.MouseEvent event) {
                finalShow(pane, i,DataBase.departments.get(i).getCourses().get(CoursesList.getSelectionModel().getSelectedIndex()));
                Label Students10 = new Label("Students");
                Students10.setLayoutX(745);Students10.setLayoutY(125);
                Students10.setPrefWidth(200);
                Students10.setPrefHeight(50);
                Students10.setFont(new Font(20));
                Students10.setStyle("-fx-background-color:  rgba(9,13,236,0.67);");
                Students10.setAlignment(Pos.CENTER);pane.getChildren().add(Students10);
                Button register=new Button();
                register.setText("Register Student");
                register.setLayoutX(745);
                register.setLayoutY(585);
                register.setPrefWidth(200);
                register.setPrefHeight(50);
                register.setStyle("-fx-background-color:  rgba(187,68,181,0.91);");
                register.setOnMouseClicked(new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent mouseEvent) {
                        try {
                            new AddViewHandler().register(DataBase.departments.get(i).getCourses().get(CoursesList.getSelectionModel().getSelectedIndex()),pane,i);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                });
                pane.getChildren().add(register);
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
        pane.getChildren().add(StudentsList);pane.getChildren().add(ProfessorsList);pane.getChildren().add(CoursesList);
    }
    public static void finalShow(AnchorPane pane, int index,Course course){
        ListView StudentsList = new ListView();
        if (course.getTakenStudent().size()==0){
            StudentsList.refresh();StudentsList.getItems().add("There is no student");
        }else{
            StudentsList.refresh();
            for (Student student : course.getTakenStudent()) {
                StudentsList.getItems().add(student.getStudentName());
            }
        }
        StudentsList.setLayoutX(745);
        StudentsList.setLayoutY(180);
        //StudentsList.setPrefHeight(350);
        StudentsList.setPrefWidth(200);
        StudentsList.setOnMouseClicked(new ListViewHandler(){
            @Override
            public void handle(javafx.scene.input.MouseEvent event) {
                try {
                    if (DataBase.students.size()>0)
                        new ListViewHandler().start10(course.getTakenStudent(),StudentsList.getSelectionModel().getSelectedIndex(),course,pane,index);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        pane.getChildren().add(StudentsList);
    }
}
