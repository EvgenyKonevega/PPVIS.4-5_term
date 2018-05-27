package model;

import java.util.ArrayList;

public class StudentsInfo {
    private ArrayList<Student> students = new ArrayList<>();
    private ArrayList<Phone> phones = new ArrayList<>();
    private ArrayList<Adress> adresses = new ArrayList<>();

    private StudentsInfo studentsInfo;

    private int counter = 0;

    public void AddPhone(Phone phone){
        phones.add(phone);
    }
    public void AddAdress(Adress adress){
        adresses.add(adress);
    }
    public void AddStudent(Student student){
        students.add(student);
    }
    public void addInfo(){
        counter++;

    }
}

