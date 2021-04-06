package StudentEnrolment;

import java.util.ArrayList;

public class Course {
    private String cName;
    private String cID;
    private int credits;
    private ArrayList<Student> sList;

    public Course() {
        this.cName = "Default Course";
        this.cID = "c00";
        this.credits= 0;
    }

    public Course(String courseName, String courseID, int credits) {
        super();
        this.cName = courseName;
        this.cID = courseID;
        this.credits= credits;
        sList = new ArrayList<Student>();
    }

    public String getCName() {
        return cName;
    }

    public String getCID() {
        return cID;
    }

    public ArrayList<Student> getStudentList() {
        return sList;
    }

    public boolean enroll (Student student) {
        if (sList.contains(student)) {
            return false;
        }
        sList.add(student);
        student.getCourseList().add(this);
        return true;
    }
    @Override
    public String toString() {
        return "Course [courseName=" + cName + ", courseID=" + cID + ", credits=" + credits+ "]";
    }
}
