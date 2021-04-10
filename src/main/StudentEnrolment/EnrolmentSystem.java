package StudentEnrolment;

import java.io.BufferedReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;


public class EnrolmentSystem {
    private static final String COMMA_DELIMITER = ",";
    private static final String NEW_LINE_SEPARATOR = "\n";
    private static final String FILE_HEADER = "sID,Name,Birthdate,cID,Course,Credits,Semester";

    private static List<Enrolment> readEnrolmentsFromCSV (String fileName) {
        List<Enrolment> enrolments = new ArrayList<>();
        Path pathToFile = Paths.get(fileName);

        try (BufferedReader br = Files.newBufferedReader(pathToFile, StandardCharsets.US_ASCII)) {
            //get lines from csv file
            String line = br.readLine();
            while (line != null) {
                String[] attributes = line.split(",");
                Enrolment enrolment = createEnrolments(attributes);
                enrolments.add(enrolment);
                line = br.readLine();
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        return enrolments;
    }

    private static Enrolment createEnrolments(String[] metadata) {
        String sID = metadata[0];
        String name = metadata[1];
        String Birthdate = metadata[2];
        String cID = metadata[3];
        String Course = metadata[4];
        int Credits = Integer.parseInt(metadata[5]);
        String Semester = metadata[6];
        // create and return book of this metadata
        return new Enrolment(sID, name, Birthdate, cID, Course, Credits, Semester);
    }

    public static void main(String args[]) {


        Boolean stop = false;
        Boolean quit = false;
        Scanner myObj = new Scanner(System.in);
        Student currentStudent;
        Course currentCourse;
        ArrayList<Student> AllStudent = new ArrayList<Student>();
        ArrayList<Course> AllCourse = new ArrayList<Course>();
        Course c1 = new Course("SADI", "c001", 12);
        Student s1 = new Student("Minh", "s001", "1/1/2020");
        Student s2 = new Student("Ben", "s002", "2/3/2020");

        AllStudent.add(s1);
        AllStudent.add(s2);
        AllCourse.add(c1);

        if (c1.enroll(s1)) {
            System.out.println("Successfully enrolled");
        } else {
            System.out.println("Already in there");
        }
        if (c1.enroll(s2)) {
            System.out.println("Successfully enrolled");
        } else {
            System.out.println("Already in there");
        }

        while (quit == false) {
            //program starts and asks for enrolment file
            System.out.println("Which enrolment file do you want to load (default.csv will be automatically loaded if no inputs): ");
            //load default.csv
            List<Enrolment> enrolments = readEnrolmentsFromCSV("C:\\Users\\admin\\IdeaProjects\\COSC2440A1\\src\\main\\StudentEnrolment\\default.csv");
            for (Enrolment e : enrolments) {
                System.out.println(e);
            }
            while (stop == false) {
                System.out.println("Enter ID:");
                String sID = myObj.nextLine();
                //check if studentID is registered
                for (int i = 0; i < AllStudent.size(); i++) {
                    currentStudent = AllStudent.get(i);
                    if (sID.contains(s1.getStudentID())) {
                        System.out.println("StudentID is: " + sID);
                        System.out.println("Enter Semester:");
                        String semester = myObj.nextLine();
                        System.out.println("Sem is: " + semester);
                        System.out.println("Enter Course:");
                        String cID = myObj.nextLine();
                        i = AllStudent.size();
                        //Check if this course has already registered on the system
                        for (int e = 0; e < AllCourse.size(); e++) {
                            currentCourse = AllCourse.get(e);
                            if (cID.contains(c1.getCID())) {
                                System.out.println("Course is: " + cID);
                                Enrolment SEnrol = new Enrolment(sID, cID, semester);
                                EnrolmentList.add(SEnrol);
                                System.out.println("Enrolment List: " + EnrolmentList);
                                e = AllCourse.size();
                                stop = true;
                            }
                        }
                    }
                }
            }
        }
    }
}
