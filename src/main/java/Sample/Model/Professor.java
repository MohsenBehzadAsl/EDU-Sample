package Sample.Model;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
public class Professor {
    private String professorName;
    private LocalDate birthDate;
    private Department department;
    private AcademicRank academicRank;
    public String getProfessorName() {
        return professorName;
    }
    public LocalDate getBirthDate() {
        return birthDate;
    }
    public Department getDepartment() {
        return department;
    }
    public AcademicRank getAcademicRank() {
        return academicRank;
    }
    private Set<Course> courses=new HashSet<>();
    public Professor(String professorName) {
        this.professorName = professorName;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Professor professor = (Professor) o;
        return Objects.equals(professorName, professor.professorName) && Objects.equals(birthDate, professor.birthDate) && Objects.equals(department, professor.department) && Objects.equals(academicRank, professor.academicRank);
    }
    public Set<Course> getCourses(){
        return courses;
    }
    public void setAcademicRank(AcademicRank academicRank){this.academicRank= academicRank;}
    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }
    public void setDepartment(Department department) {
        this.department = department;
    }
}