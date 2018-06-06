package model;

import java.util.ArrayList;

public class StudentsInfo {
    private ArrayList<Student> students = new ArrayList<>();
    private ArrayList<Phone> phones = new ArrayList<>();
    private ArrayList<Address> addresses = new ArrayList<>();

//    public void AddPhone(Phone phone){
//        phones.add(phone);
//    }
//    public void AddAddress(Address address){
//        addresses.add(address);
//    }

    public void AddStudent(Student student){
        students.add(student);
    }
//    public void addInfo(){
//    }
}

