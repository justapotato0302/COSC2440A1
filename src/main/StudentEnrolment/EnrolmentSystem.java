package StudentEnrolment;

import java.util.Scanner;

public class EnrolmentSystem {
    public static void main(String args[]) {
        Scanner myObj = new Scanner(System.in);
        System.out.println("Enter ID:");
        String sID = myObj.nextLine();
        System.out.println("Username is: " + sID);
        System.out.println("Enter Semester:");
        String semester = myObj.nextLine();
        System.out.println("sem is: " + semester);
        System.out.println("Enter Course:");
        String course = myObj.nextLine();
        System.out.println("Course is: " + course);


        Course c1 = new Course("c001", "SADI", 12);
        Student s1 = new Student("s001", "Minh", "1/1/2020");


        if (c1.enroll(s1)) {
            System.out.println("Successfully enrolled");
        }
        else {
            System.out.println("Already in there");
        }
        System.out.println(c1.getStudentList().toString());
        System.out.println(s1.getCourseList().toString());

    }
}
