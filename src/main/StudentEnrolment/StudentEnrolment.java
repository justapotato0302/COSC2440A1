package StudentEnrolment;

public class StudentEnrolment {
    public static void main(String args[]) {
        Course c1 = new Course("c001", "SADI", 12);
        Student s1 = new Student("s001", "Minh", "1/1/2020");

        System.out.println(c1);
        System.out.println(s1);
    }
}
