package StudentEnrolment;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;


class EnrolmentTest {

    @Test
    void add() {
        System.out.println("Test add function");
        ArrayList<Enrolment> eList = new ArrayList<Enrolment>();
        ArrayList<Enrolment> eList2 = new ArrayList<Enrolment>();

        Enrolment a1 = new Enrolment("S101312","Alex Mike","10/13/1998","BUS2232","Business Law",3,"2020C");
        Enrolment a2 = new Enrolment("S102732","Mark Duong","8/28/2001","COSC3321","Artificial Intelligence",3,"2021A");
        eList2.add(a1);
        eList2.add(a2);
        eList.add(a1);
        //check if the method add the corresponding enrolment
        assertEquals(eList2,a1.add(eList,a2));
    }

    @Test
    void update() {
        System.out.println("Test update function");
        System.out.println("Test delete");
        ArrayList<Enrolment> eList = new ArrayList<Enrolment>();
        Enrolment a1 = new Enrolment("S101312","Alex Mike","10/13/1998","BUS2232","Business Law",3,"2020C");
        Enrolment a2 = new Enrolment("S102732","Mark Duong","8/28/2001","COSC3321","Artificial Intelligence",3,"2021A");
        eList.add(a2);
        //check if the method update the first row of the list
        a2.Update(eList,a1,0);
        assertTrue(eList.get(0) == a1);
    }

    @Test
    void delete() {
        System.out.println("Test delete");
        ArrayList<Enrolment> eList = new ArrayList<Enrolment>();
        Enrolment a1 = new Enrolment("S101312","Alex Mike","10/13/1998","BUS2232","Business Law",3,"2020C");
        Enrolment a2 = new Enrolment("S102732","Mark Duong","8/28/2001","COSC3321","Artificial Intelligence",3,"2021A");
        eList.add(a1);
        //check if the method delete the only enrolment then return a blank list
        assertTrue((a2.Delete(eList,0)).isEmpty());
    }
}