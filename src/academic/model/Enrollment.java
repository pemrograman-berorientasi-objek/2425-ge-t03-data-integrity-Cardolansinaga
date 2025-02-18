package academic.model;

public class Enrollment {
    private String courseCode;
    private String studentNim;
    private String academicYear;
    private String semester;
    private String grade;

    public Enrollment(String courseCode, String studentNim, String academicYear, String semester) {
        this.courseCode = courseCode;
        this.studentNim = studentNim;
        this.academicYear = academicYear;
        this.semester = semester;
        this.grade = "None";
    }

    public String getCourseCode() {
        return courseCode;
    }

    public String getStudentNim() {
        return studentNim;
    }

    public String getAcademicYear() {
        return academicYear;
    }

    public String getSemester() {
        return semester;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return courseCode + "|" + studentNim + "|" + academicYear + "|" + semester + "|" + grade;
    }
}