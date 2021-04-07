package StudentEnrolment;

import java.util.ArrayList;
import java.util.Scanner;

public class StudentEnrolment implements StudentEnrolmentManager {
    private String eID;
    private String student;
    private String semester;
    private String course;
    private ArrayList<StudentEnrolment>eList;

    public StudentEnrolment(String eID, String student, String course, String semester) {
        super();
        this.eID= eID;
        this.student = student;
        this.semester = semester;
        this.course= course;
        ArrayList<StudentEnrolment> eList = new ArrayList<StudentEnrolment>();
    }

    public String getEnrolmentID() {
        return eID;
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

    public ArrayList<StudentEnrolment> getEnrolmentList() {
        return eList;
    }


    @Override
    public boolean add(StudentEnrolment enrolment){
        //Check if the enrolment already existed on the system
        if (eList.contains(enrolment)){
            return false;
        }
        eList.add(enrolment);
        enrolment.getEnrolmentList().add(this);
        return true;
    }


}
