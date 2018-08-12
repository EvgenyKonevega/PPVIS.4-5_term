package model;

import java.util.ArrayList;

public class StudentsInfo {
    private ArrayList<Student> students = new ArrayList<>();

    public ArrayList<Student> getStudents() {
        return students;
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public void addStudents(ArrayList<Student> students){
        this.students = students;
    }
}




