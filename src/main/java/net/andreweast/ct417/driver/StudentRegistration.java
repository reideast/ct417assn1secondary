package net.andreweast.ct417.driver;

import net.andreweast.ct417.Student;
import org.joda.time.DateTime;

import java.util.ArrayList;

public class StudentRegistration {
    public static void main(String[] args) {
        ArrayList<Student> students;

        students = new ArrayList<>();

        students.add(new Student("Jane", "Smith", 23, new DateTime(), "55667788"));
        students.add(new Student("Jack", "Doe", 21, new DateTime(), "66778899"));

        for(Student item : students) {
            System.out.println(item.getUsername() + ": " + item.getLastName() + ", " + item.getFirstName());
        }
    }
}
