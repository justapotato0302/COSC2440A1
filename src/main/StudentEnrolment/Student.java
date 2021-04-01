package StudentEnrolment;

import java.util.ArrayList;

public class Student {
    private String sName;
    private String sID;
    private String birthdate;
    private ArrayList<Course> cList;

    public Student(){
        this.sName = "Student";
        this.sID = "s00";
        this.birthdate = "01/01/2021";
    }

    public Student(String studentName, String studentID, String birthdate) {
        super();
        this.sName = studentName;
        this.sID = studentID;
        this.birthdate = birthdate;
        cList = new ArrayList<Course>();
    }

    public ArrayList<Course> getCourseList() {
        return cList;
    }

    public String getStudentName() {
        return sName;
    }

    public String getStudentID() {
        return sID;
    }

    public String getBirthdate() {
        return birthdate;
    }

    @Override
    public String toString() {
        return "Student [studentName=" + sName + ", studentID=" + sID + ", birthdate=" + birthdate + "]";
    }
}
