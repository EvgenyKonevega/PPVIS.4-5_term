package controller;

import model.InputData;
import model.ReadData;
import model.Student;
import model.StudentsInfo;

import org.xml.sax.SAXException;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.transform.TransformerException;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Controller {

    public StudentsInfo studentsInfo = new StudentsInfo();
    private ReadData readData = new ReadData();

    public void add(Student student) {
        studentsInfo.addStudent(student);
    }

    public void set(ArrayList<Student> students) {
        studentsInfo.addStudents(students);
    }

    public int delete(Student stud, int criterion, boolean typeOfPhone){
        ArrayList<Student> listToDelete = new ArrayList<>();
        switch (criterion){
            case 1: {
                listToDelete = searchFirst(stud);
            }break;
            case 2: {
                listToDelete = searchSecond(stud);
            }break;
            case 3: {
                listToDelete = searchThird(stud, typeOfPhone);
            }break;
        }
        for (Student student : listToDelete){
            studentsInfo.deleteStudent(student);
        }
        return listToDelete.size();
    }

    public void saveFile(File file) throws TransformerException {
        InputData inputData = new InputData(studentsInfo.getStudents());
        inputData.setFile(file);
        try {
            inputData.write();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }
    }

    public void openFile(File file) throws TransformerException, SAXException, ParserConfigurationException {
        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser parser = factory.newSAXParser();
            parser.parse(file, readData);
            set(readData.getStudents());
        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Student> searchFirst(Student s) {
        ArrayList<Student> students = new ArrayList<>();
        for (Student student : studentsInfo.getStudents()) {
            if (student.getSurname().equals(s.getSurname()) && student.phone.getPhoneNumMob().equals(s.phone.getPhoneNumMob())) {
                students.add(student);
            }
        }
        return students;
    }

    public ArrayList<Student> searchSecond(Student s){
        ArrayList<Student> students = new ArrayList<>();
        for (Student student : studentsInfo.getStudents()) {
            if (student.address.getAddress().equals(s.address.getAddress()) && student.phone.getPhoneNumMob().equals(s.phone.getPhoneNumMob())){
                students.add(student);
            }
        }
        return students;
    }

    public ArrayList<Student> searchThird(Student s, boolean typeOfPhone){
        ArrayList<Student> students = new ArrayList<>();
        for (Student student : studentsInfo.getStudents()) {
            if (typeOfPhone) {
                if (student.getSurname().equals(s.getSurname()) && student.phone.getPhoneNumMob().matches("\\d*" + s.phone.getPhoneNumMob() + "\\d*")){
                    students.add(student);
                }
            }
            else {
                if (student.getSurname().equals(s.getSurname()) && student.phone.getPhoneNumber().matches("\\d*" + s.phone.getPhoneNumMob() + "\\d*")){
                    students.add(student);
                }
            }
        }
        return students;
    }
}