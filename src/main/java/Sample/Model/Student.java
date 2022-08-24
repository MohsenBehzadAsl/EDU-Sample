package Sample.Model;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
public class Student {
    private String studentNumber;
    private String studentName;
    private LocalDate birthDate;
    Department department;
    private List<GradeReport> gradeReportList=new ArrayList<>();
    private List<Course> courses=new ArrayList<>();
    public Student(String studentNumber) {
        this.studentNumber=studentNumber;
    }
    public void takeCourse(Course course){
        this.courses.add(course);
        course.getTakenStudent().add(this);
    }
    public void finishCourse(Course course,double mark){
        GradeReport gradeReport=new GradeReport(this,course);
        gradeReport.setGrade(mark);
        gradeReportList.add(gradeReport);
    }
    public List<GradeReport> getGradeReport(){
        return gradeReportList;
    }
    public List<Course> getCourses(){
        return courses;
    }
    public String getStudentNumber() {
        return studentNumber;
    }
    public String getStudentName() {
        return studentName;
    }
    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }
    public LocalDate getBirthDate() {
        return birthDate;
    }
    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }
    public Department getDepartment() {
        return department;
    }
    public void setDepartment(Department department) {
        this.department = department;
    }
}
