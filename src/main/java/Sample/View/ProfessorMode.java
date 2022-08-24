package Sample.View;
import Sample.Controller.AddViewHandler;
import Sample.Controller.ListViewHandler;
import Sample.Model.Course;
import Sample.Model.DataBase;
import Sample.Model.Professor;
import Sample.Model.Student;
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
import java.util.List;
public class ProfessorMode {
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
        info.setText("Professor Info.");
        info.setLayoutX(200);
        info.setLayoutY(590);info.setPrefWidth(200);
        info.setFont(new Font(20));
        info.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                try {
                    new ListViewHandler().start2(DataBase.professors,index);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        pane.getChildren().add(info);
        Button addLecuter=new Button();
        addLecuter.setText("Add course");
        addLecuter.setLayoutX(570);
        addLecuter.setPrefWidth(200);
        addLecuter.setLayoutY(590);
        addLecuter.setFont(new Font(20));
        addLecuter.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                try {
                    new AddViewHandler().start6(DataBase.courses,index);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        pane.getChildren().add(addLecuter);
        Scene scene = new Scene(pane);
        stage.setScene(scene);
    }
    private void initializeText(AnchorPane pane) {
        Label Students = new Label("All Professors");
        Students.setLayoutX(200);Students.setLayoutY(125);
        Students.setPrefWidth(200);
        Students.setPrefHeight(50);
        Students.setFont(new Font(20));
        Students.setStyle("-fx-background-color:  rgba(9,13,236,0.67);");
        Students.setAlignment(Pos.CENTER);
        Label Professors = new Label("Lectured Courses");
        Professors.setLayoutX(570);Professors.setLayoutY(125);
        Professors.setPrefWidth(200);
        Professors.setPrefHeight(50);
        Professors.setFont(new Font(20));
        Professors.setStyle("-fx-background-color:  rgba(9,13,236,0.67);");
        Professors.setAlignment(Pos.CENTER);
        Label GodMode = new Label("Professor Mode");
        GodMode.setLayoutX(200);GodMode.setLayoutY(10);
        GodMode.setPrefWidth(650);
        GodMode.setPrefHeight(70);
        GodMode.setFont(new Font(20));
        GodMode.setStyle("-fx-background-color:  rgba(179,9,236,0.67);");
        GodMode.setAlignment(Pos.CENTER);
        pane.getChildren().add(Students);pane.getChildren().add(Professors);pane.getChildren().add(GodMode);
    }
    public static void initializeLists(AnchorPane pane, int index) {
        ListView allProfessors = new ListView();
        ListView lecturedCourses = new ListView();
        if (DataBase.professors.size()==0){
            allProfessors.getItems().add("There is no professor");
        }else{
            allProfessors.refresh();
            for (Professor professor : DataBase.professors) {
                if (! professor.equals(DataBase.professors.get(index)))
                allProfessors.getItems().add(professor.getProfessorName());
            }
        }
        allProfessors.setLayoutX(200);
        allProfessors.setLayoutY(180);
        allProfessors.setPrefWidth(200);
        allProfessors.setPrefHeight(350);
        if (DataBase.professors.get(index).getCourses().size()==0){
            lecturedCourses.getItems().add("There is no lectured courses");
        }else{
            lecturedCourses.refresh();
            for (Course course : DataBase.professors.get(index).getCourses()) {
                lecturedCourses.getItems().add(course.getCourseName());
            }
        }
        lecturedCourses.setLayoutX(570);
        lecturedCourses.setLayoutY(180);
        lecturedCourses.setPrefWidth(200);
        lecturedCourses.setPrefHeight(350);
        allProfessors.setOnMouseClicked(new ListViewHandler(){
            @Override
            public void handle(javafx.scene.input.MouseEvent event) {
                try {
                    if (DataBase.professors.size()>0)
                        new ListViewHandler().start2(DataBase.professors,allProfessors.getSelectionModel().getSelectedIndex());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        lecturedCourses.setOnMouseClicked(new ListViewHandler(){
            @Override
            public void handle(javafx.scene.input.MouseEvent event) {
                List<Course> courses111 = new ArrayList<>(DataBase.professors.get(index).getCourses());
                finalShow(pane, index,courses111.get(lecturedCourses.getSelectionModel().getSelectedIndex()));
                Label Students10 = new Label("Students");
                Students10.setLayoutX(770);Students10.setLayoutY(125);
                Students10.setPrefWidth(200);
                Students10.setPrefHeight(50);
                Students10.setFont(new Font(20));
                Students10.setStyle("-fx-background-color:  rgba(9,13,236,0.67);");
                Students10.setAlignment(Pos.CENTER);pane.getChildren().add(Students10);
            }
        });
        pane.getChildren().add(allProfessors);pane.getChildren().add(lecturedCourses);
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
        StudentsList.setLayoutX(770);
        StudentsList.setLayoutY(180);
        StudentsList.setPrefHeight(350);
        StudentsList.setPrefWidth(200);
        StudentsList.setOnMouseClicked(new ListViewHandler(){
            @Override
            public void handle(javafx.scene.input.MouseEvent event) {
                try {
                    if (DataBase.students.size()>0)
                        new ListViewHandler().start1(course.getTakenStudent(),StudentsList.getSelectionModel().getSelectedIndex(),course,pane,index);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        pane.getChildren().add(StudentsList);
    }
}
