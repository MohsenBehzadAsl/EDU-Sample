package Sample.Model;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
public class Department {
    private String depatrmentName;
    private String depatrmentSerial;
    private List<Student> students=new ArrayList<>();
    private List<Professor> professors=new ArrayList<>();
    private List<Course> courses=new ArrayList<>();
    public String getDepatrmentName() {
        return depatrmentName;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Department that = (Department) o;
        return Objects.equals(depatrmentName, that.depatrmentName) && Objects.equals(depatrmentSerial, that.depatrmentSerial);
    }
    public List<Student> getStudent(){
        return students;
    }
    public List<Professor> getFacaulty(){
        return professors;
    }
    public List<Course> getCourses(){
        return courses;
    }
    public void addStudent(Student student) {
        this.students.add(student);
    }
    public void addFacaulty(Professor professor) {
        this.professors.add(professor);
    }
    public void addCourse(Course course) {
        this.courses.add(course);
    }
    public void setDepatrmentName(String depatrmentName) {
        this.depatrmentName = depatrmentName;
    }
    public String getDepatrmentSerial() {
        return depatrmentSerial;
    }
    public void setDepatrmentSerial(String depatrmentSerial) {
        this.depatrmentSerial = depatrmentSerial;
    }
    public Department(String depatrmentName) {
        this.depatrmentName=depatrmentName;
    }
}
