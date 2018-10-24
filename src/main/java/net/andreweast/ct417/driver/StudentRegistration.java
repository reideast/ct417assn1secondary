package net.andreweast.ct417.driver;

import net.andreweast.ct417.Course;
import net.andreweast.ct417.DuplicateRegistrationException;
import net.andreweast.ct417.Module;
import net.andreweast.ct417.Student;
import org.joda.time.DateTime;

import java.util.ArrayList;

public class StudentRegistration {
    public static void main(String[] args) {
        Course cs = new Course("CS & IT", new DateTime(2015, 9, 22, 12, 0), new DateTime(2019, 6, 1, 12, 0));
        Course ece = new Course("ECE", new DateTime(2017, 9, 26, 12, 0), new DateTime(2021, 6, 1, 12, 0));

        Module ct101 = new Module("CT101");
        Module ct102 = new Module("CT102");
        Module ct301 = new Module("CT301");
        Module ee101 = new Module("EE101");
        Module ee102 = new Module("EE102");

        ArrayList<Student> csStudents = new ArrayList<>();
        csStudents.add(new Student("Jane", "Smith", new DateTime(1996, 1, 1, 12, 0), "55667788"));
        csStudents.add(new Student("Jack", "Doe", new DateTime(1995, 3, 15, 12, 0), "66778899"));
        csStudents.add(new Student("Lane", "Jones", new DateTime(1998, 10, 30, 12, 00), "77889900"));
        ArrayList<Student> eceStudents = new ArrayList<>();
        eceStudents.add(new Student("Samantha", "Brown", new DateTime(2000, 8, 10, 12, 0), "88990011"));
        eceStudents.add(new Student("Catherine", "Miller", new DateTime(1999, 9, 20, 12, 0), "99001122"));

        try {
            // Register students in courses
            cs.registerStudents(csStudents);
            ece.registerStudents(eceStudents);

            // Register modules in courses
            cs.addModule(ct101);
            cs.addModule(ct102);
            cs.addModule(ct301);

            ece.addModule(ee101);
            ece.addModule(ee102);
            ece.addModule(ct101); // This course is cross-listed on both courses

            // Register students in modules
            ct101.enrollStudent(csStudents.get(1));
            ct101.enrollStudents(eceStudents);

            ct102.enrollStudents(csStudents);

            ct301.enrollStudent(csStudents.get(0));
            ct301.enrollStudent(csStudents.get(2));

            ee101.enrollStudent(eceStudents.get(0));

            ee102.enrollStudent(eceStudents.get(1));
        } catch (DuplicateRegistrationException e) {
            System.err.println("Duplicate registration encountered even though no duplicates should have been pushed");
            e.printStackTrace();
            System.exit(1);
        }
    }
}
