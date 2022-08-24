package Sample.View;
import Sample.Controller.EnterOfficerController;
import Sample.Controller.EnterProfessorController;
import Sample.Controller.EnterStudentController;
import Sample.Model.*;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import java.io.IOException;
import java.time.LocalDate;
public class Main1 extends Application {
    private static Stage stage;
    @Override
    public void start(Stage stage) throws Exception {
        this.stage=stage;
        Pane pane = FXMLLoader.load(getClass().getResource("/Sample/fxml/main1.fxml"));
        primaryInitialize();
        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.setTitle("EDU");
        stage.show();
    }
    private void primaryInitialize() {
        if (DataBase.courses.isEmpty()) {
            Department department = new Department("Electrical Engineering");
            department.setDepatrmentSerial("e");
            DataBase.departments.add(department);
            Student student = new Student("400");
            student.setStudentName("Mohsen BehzadAsl 1");
            student.setBirthDate(LocalDate.parse("2021/01/01".replace("/", "-")));
            student.setDepartment(department);
            DataBase.students.add(student);
            DataBase.departments.get(0).addStudent(student);
            Student student1 = new Student("400");
            student1.setStudentName("Mohsen BehzadAsl 2");
            student1.setBirthDate(LocalDate.parse("2021/01/01".replace("/", "-")));
            student1.setDepartment(department);
            DataBase.students.add(student1);
            DataBase.departments.get(0).addStudent(student1);
            for (int i=2;i<30;i++){
                Student student2 = new Student("400");
                student2.setStudentName("Mohsen BehzadAsl "+i);
                student2.setBirthDate(LocalDate.parse("2021/01/01".replace("/", "-")));
                student2.setDepartment(department);
                DataBase.students.add(student2);
                DataBase.departments.get(0).addStudent(student2);
            }
            Professor professor = new Professor("Vosoghi");
            professor.setDepartment(department);
            professor.setAcademicRank(AcademicRank.PROFESSOR_ASSOCIATE);
            professor.setBirthDate(LocalDate.parse("2021/01/01".replace("/", "-")));
            DataBase.professors.add(professor);
            DataBase.departments.get(0).addFacaulty(professor);
            Professor professor1 = new Professor("Hashemi");
            professor1.setDepartment(department);
            professor1.setAcademicRank(AcademicRank.PROFESSOR_ASSOCIATE);
            professor1.setBirthDate(LocalDate.parse("2021/01/01".replace("/", "-")));
            DataBase.professors.add(professor1);
            DataBase.departments.get(0).addFacaulty(professor1);
            Course course = new Course("OOP");
            course.setProfessor(professor);
            course.setDepartment(department);
            course.setCredit(3);
            course.getTakenStudent().add(student);course.getTakenStudent().add(student1);
            student.getCourses().add(course);student1.getCourses().add(course);
            DataBase.courses.add(course);professor.getCourses().add(course);
            DataBase.departments.get(0).addCourse(course);
        }
    }
    public void GodMode(MouseEvent mouseEvent) throws Exception {
        new GodMode().start(stage);
    }
    public void Student(MouseEvent mouseEvent) throws Exception{
        new EnterStudentController().start(stage);
    }
    public void Professor(MouseEvent mouseEvent) throws IOException {
        new EnterProfessorController().start(stage);
    }
    public void Officer(MouseEvent mouseEvent) throws IOException {
        new EnterOfficerController().start(stage);
    }
}
