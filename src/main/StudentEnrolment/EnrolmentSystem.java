package StudentEnrolment;

import java.util.ArrayList;
import java.util.Scanner;

public class EnrolmentSystem {
    public static void main(String args[]) {
        Boolean stop = false;
        Scanner myObj = new Scanner(System.in);
        Student currentStudent;
        Course currentCourse;
        ArrayList<Enrolment> EnrolmentList = new ArrayList<Enrolment>();
        ArrayList<Student> AllStudent = new ArrayList<Student>();
        ArrayList<Course> AllCourse = new ArrayList<Course>();
        Course c1 = new Course("SADI", "c001", 12);
        Student s1 = new Student("Minh", "s001", "1/1/2020");
        Student s2 = new Student("Ben", "s002","2/3/2020");

        AllStudent.add(s1);
        AllStudent.add(s2);
        AllCourse.add(c1);

        if (c1.enroll(s1)) {
            System.out.println("Successfully enrolled");
        }
        else {
            System.out.println("Already in there");
        }
        if (c1.enroll(s2)) {
            System.out.println("Successfully enrolled");
        }
        else {
            System.out.println("Already in there");
        }

        while (stop == false){
            System.out.println("Enter ID:");
            String sID = myObj.nextLine();
            //check if studentID is registered
            for (int i=0; i < AllStudent.size(); i++){
                currentStudent= AllStudent.get(i);
                if (sID.contains(s1.getStudentID())){
                    System.out.println("StudentID is: " + sID);
                    System.out.println("Enter Semester:");
                    String semester = myObj.nextLine();
                    System.out.println("Sem is: " + semester);
                    System.out.println("Enter Course:");
                    String cID = myObj.nextLine();
                    i=AllStudent.size();
                    //Check if this course has already registered on the system
                    for (int e=0; e<AllCourse.size();e++){
                        currentCourse=AllCourse.get(e);
                        if (cID.contains(c1.getCID())){
                            System.out.println("Course is: " + cID);
                            Enrolment SEnrol = new Enrolment(sID,cID,semester);
                            EnrolmentList.add(SEnrol);
                            System.out.println("Enrolment List: " + EnrolmentList);
                            e=AllCourse.size();
                            stop = true;
                        }
                    }
                }
            }
        }
    }
}
