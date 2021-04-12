package StudentEnrolment;

import java.util.ArrayList;

public class Enrolment implements StudentEnrolmentManager {
    private String name;
    private String semester;
    private String course;
    private String cID;
    private int credits;
    private String sID;
    private String birthdate;
    public ArrayList<Enrolment>eList;

    public Enrolment(String sID,String name, String birthdate ,String cID,String course, int credits, String semester) {
        super();
        this.name = name;
        this.sID = sID;
        this.birthdate = birthdate;
        this.cID=cID;
        this.course= course;
        this.credits = credits;
        this.semester = semester;
        eList = new ArrayList<Enrolment>();
    }

    public String getEnrolledSID() {
        return sID;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public String getEnrolledCID() {
        return cID;
    }

    public String getEnrolledCourse() {
        return course;
    }

    public int getEnrolledCredits() {
        return credits;
    }

    public String getEnrolledSName() {
        return name;
    }

    public String getEnrolledSemester() {
        return semester;
    }

    public ArrayList<Enrolment> getEnrolmentList() {
        return eList;
    }

    @Override
    public String toString() {
        return "[StudentID=" + sID + ", StudentName="+ name+", Birthdate="+birthdate+", CourseID=" + cID +", CourseName="+course+", Credits="+credits+ ", Semester=" + semester+ "]";
    }
    public void add(Enrolment enrolment){
        eList.add(enrolment);
    }


}
