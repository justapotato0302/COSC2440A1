package StudentEnrolment;

import java.util.ArrayList;
import java.util.List;

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

    public void setEnrolledSID(String sID) {
        this.sID = sID;
    }

    public void setEnrolledName(String name) {
        this.name = name;
    }

    public void setEnrolledBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }

    public void setEnrolledCID(String cID) {
        this.cID=cID;
    }

    public void setEnrolledCourse(String course) {
        this.course = course;
    }

    public void setEnrolledCredits(int credits) {
        this.credits=credits;
    }

    public void setEnrolledSemester(String semester) {
        this.semester = semester;
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

    public String getEnrolledBirthdate() {
        return birthdate;
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
    //get old list and new enrolment to add into new list
    public List<Enrolment> add(List<Enrolment> eList ,Enrolment enrolment){
        eList.add(enrolment);
        return eList;
    }

    public void Update(List<Enrolment> eList,Enrolment enrolment,int index){
        eList.set(index,enrolment);
    }
}
