/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package student;

import java.util.Vector;

/**
 *
 * @author Robert
 */
public class Group {

    private final Vector<Student> students;
    public Group(int size) {
        students = new Vector<>(size);
    }
    
    public void addStudent(int studentNumber, String firstName, String lastName) {
        Student student = new Student(studentNumber, firstName, lastName);
        students.add(student);
    }
    
    public void changeStudent(int studentNumber, String firstName, String lastName) {
        for (int i = 0; i < students.capacity(); i++) {
            Student currentStudent = students.get(i);
            if (currentStudent.getStudentNumber() == studentNumber) {
                currentStudent.setFirstName(firstName);
                currentStudent.setLastName(lastName);
            }
        }
    }
    
    public String groupContents() {
        String groupContents = "";
        for (int i = 0; i < students.capacity(); i++) {
            Student currentStudent = students.get(i);
            String currentStudentString = currentStudent.getFirstName() + " " +
                    currentStudent.getLastName() + ", s" +
                    currentStudent.getStudentNumber() + "\n";
            groupContents = groupContents.concat(currentStudentString);
        }
        return groupContents;
    }
}
