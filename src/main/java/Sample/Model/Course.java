package Sample.Model;
import java.util.ArrayList;
import java.util.Objects;
public class Course {
    private String courseName;
    private int credit=3;
    private Department department;
    private Professor professor;
    public ArrayList<Student> takenStudent=new ArrayList<>();
    public ArrayList<Student> getTakenStudent() {
        return takenStudent;
    }
    public void setTakenStudent(ArrayList<Student> takenStudent) {
        this.takenStudent = takenStudent;
    }
    public Course(String courseName) {
        this.courseName = courseName;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Course course = (Course) o;
        return credit == course.credit && Objects.equals(courseName, course.courseName) && Objects.equals(department, course.department) && Objects.equals(professor, course.professor);
    }
    public String getCourseName() {
        return courseName;
    }
    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }
    public int getCredit() {
        return credit;
    }
    public void setCredit(int credit) {
        this.credit = credit;
    }
    public Department getDepartment() {
        return department;
    }
    public void setDepartment(Department department) {
        this.department = department;
    }
    public Professor getProfessor() {
        return professor;
    }
    public void setProfessor(Professor professor) {
        this.professor = professor;
    }
}
