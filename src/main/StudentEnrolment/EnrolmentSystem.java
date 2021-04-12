package StudentEnrolment;

import java.io.BufferedReader;
import java.io.File;
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

    private static List<Enrolment> readEnrolmentsFromCSV(String fileName) {
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
        String userInput;
        String fileName;
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
            //load default.csv if no input
            fileName = myObj.nextLine();
            if (fileName.isEmpty()) {
                List<Enrolment> enrolments = readEnrolmentsFromCSV("C:\\Users\\admin\\IdeaProjects\\COSC2440A1\\src\\main\\StudentEnrolment\\default.csv");
                for (Enrolment e : enrolments) {
                    System.out.println(e);
                }
            } else {
                //Check if there is any file that user inputted - load default.csv if the filename is not found in the destination
                try {
                    List<Enrolment> enrolments = readEnrolmentsFromCSV(fileName);
                } catch (Exception e) {
                    System.out.println("File not found - loading default.csv.");
                    List<Enrolment> enrolments = readEnrolmentsFromCSV("C:\\Users\\admin\\IdeaProjects\\COSC2440A1\\src\\main\\StudentEnrolment\\default.csv");
                }
            }
            while (quit == false) {
                System.out.println("What do you want to do with this file (input 1-7): \n1.Add new data\n2.Update existed data\n3.Delete a data\n4.Print all courses for 1 student in 1 semester\n5.Print all students of 1 course in 1 semester\n6.Print all students of 1 course in 1 semester\n7.Quit");
                userInput = myObj.nextLine();
                //Add data
                if (userInput.contains("1")) {
                    System.out.println("Enter Student ID:");
                    String sID = myObj.nextLine();
                    System.out.println("Enter Student Name:");
                    String sName = myObj.nextLine();
                    System.out.println("Enter Student Birthdate:");
                    String birth = myObj.nextLine();
                    System.out.println("Enter Course ID:");
                    String cID = myObj.nextLine();
                    System.out.println("Enter Course Name:");
                    String cName = myObj.nextLine();
                    System.out.println("Enter Credits:");
                    String sCredits = myObj.nextLine();
                    System.out.println("Enter Semester for the enrolment:");
                    String semester = myObj.nextLine();
                    int credits = Integer.parseInt(sCredits);

                    List<Enrolment> enrolments = readEnrolmentsFromCSV("C:\\Users\\admin\\IdeaProjects\\COSC2440A1\\src\\main\\StudentEnrolment\\default.csv");
                    Enrolment e1 = new Enrolment(sID, sName, birth, cID, cName, credits, semester);
                    enrolments = e1.add(enrolments, e1);
                    for (Enrolment e : enrolments) {
                        System.out.println(e);
                    }
                }
                //Update data
                if (userInput.contains("2")) {
                    List<Enrolment> enrolments = readEnrolmentsFromCSV("C:\\Users\\admin\\IdeaProjects\\COSC2440A1\\src\\main\\StudentEnrolment\\default.csv");
                    while (quit == false) {
                        System.out.println("Enter row number that you want to edit (start from 0):");
                        String index = myObj.nextLine();
                        //check if input String can be convert to integer
                        try {
                            Integer.parseInt(index);
                            //check if input number is larger than the size of the enrolment list
                            if (Integer.parseInt(index) > enrolments.size()) {
                                System.out.println("Please enter a number (in range of Enrolment list): ");
                            }
                        } catch (Exception e) {
                            System.out.println("Please enter a number (in range of Enrolment list): ");
                        }
                        //input updated data
                        System.out.println("Enter Student ID:");
                        String sID = myObj.nextLine();
                        System.out.println("Enter Student Name:");
                        String sName = myObj.nextLine();
                        System.out.println("Enter Student Birthdate:");
                        String birth = myObj.nextLine();
                        System.out.println("Enter Course ID:");
                        String cID = myObj.nextLine();
                        System.out.println("Enter Course Name:");
                        String cName = myObj.nextLine();
                        System.out.println("Enter Credits:");
                        String sCredits = myObj.nextLine();
                        System.out.println("Enter Semester for the enrolment:");
                        String semester = myObj.nextLine();
                        //Update a row by following index
                        Enrolment e1 = new Enrolment(sID, sName, birth, cID, cName, Integer.parseInt(sCredits), semester);
                        e1.Update(enrolments, e1, Integer.parseInt(index));

                        for (Enrolment e : enrolments) {
                            System.out.println(e);
                        }

                        FileWriter fileWriter = null;

                        try {
                            fileWriter = new FileWriter("new1.csv");

                            //Write the CSV file header
                            fileWriter.append(FILE_HEADER.toString());

                            //Add a new line separator after the header
                            fileWriter.append(NEW_LINE_SEPARATOR);

                            //Write a new student object list to the CSV file
                            for (Enrolment e : enrolments) {
                                fileWriter.append(e.getEnrolledSID());
                                fileWriter.append(COMMA_DELIMITER);
                                fileWriter.append(e.getEnrolledSName());
                                fileWriter.append(COMMA_DELIMITER);
                                fileWriter.append(e.getEnrolledBirthdate());
                                fileWriter.append(COMMA_DELIMITER);
                                fileWriter.append(e.getEnrolledCID());
                                fileWriter.append(COMMA_DELIMITER);
                                fileWriter.append(e.getEnrolledCourse());
                                fileWriter.append(COMMA_DELIMITER);
                                fileWriter.append(String.valueOf(e.getEnrolledCredits()));
                                fileWriter.append(COMMA_DELIMITER);
                                fileWriter.append(e.getEnrolledSemester());
                                fileWriter.append(NEW_LINE_SEPARATOR);
                            }
                            System.out.println("CSV file was created successfully!");

                        } catch (Exception e) {
                            System.out.println("Error in CsvFileWriter!");
                            e.printStackTrace();
                        }
                        quit = true;
                    }
                }
                //Delete data
                if (userInput.contains("3")) {
                    List<Enrolment> enrolments = readEnrolmentsFromCSV("C:\\Users\\admin\\IdeaProjects\\COSC2440A1\\src\\main\\StudentEnrolment\\default.csv");
                    System.out.println("Enter row number that you want to delete\nEnter row number:");
                    userInput=myObj.nextLine();
                    Enrolment e1 = enrolments.get(Integer.parseInt(userInput));
                    enrolments = e1.Delete(enrolments,Integer.parseInt(userInput));
                    for (Enrolment e : enrolments) {
                        System.out.println(e);
                    }
                }
                //Print all courses for 1 student in 1 semester
                if (userInput.contains("4")) {

                }
                //Print all students of 1 course in 1 semester
                if (userInput.contains("5")) {

                }
                //Print all students of 1 course in 1 semester
                if (userInput.contains("6")) {

                }
                //Quit
                if (userInput.contains("7")) {
                    quit = true;
                } else {
                    System.out.println("No operation found. Please input again!");
                    quit = true;
                }
            }
        }
    }
}