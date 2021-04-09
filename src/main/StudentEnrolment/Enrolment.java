package StudentEnrolment;

import java.util.ArrayList;

public class Enrolment implements StudentEnrolmentManager {
    private String student;
    private String semester;
    private String course;
    private ArrayList<Enrolment>eList;

    public Enrolment() {
        this.student = "s00";
        this.course = "c00";
        this.semester= "null";
    }

    public Enrolment(String student, String course, String semester) {
        super();
        this.student = student;
        this.course= course;
        this.semester = semester;
        eList = new ArrayList<Enrolment>();
    }

    public String getEnrolledCourse() {
        return course;
    }

    public String getEnrolledStudent() {
        return student;
    }

    public String getEnrolledSemester() {
        return semester;
    }

    public ArrayList<Enrolment> getEnrolmentList() {
        return eList;
    }

    @Override
    public String toString() {
        return "[StudentID=" + student + ", CourseID=" + course + ", Semester=" + semester+ "]";
    }
    public void add(Enrolment enrolment){
        eList.add(enrolment);
    }
}
