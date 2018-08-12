package model;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import java.io.File;
import java.util.ArrayList;

public class InputData {
    private ArrayList<Student> students;
    private Document document;
    private File file;

    public InputData(ArrayList<Student> students) throws TransformerException {
        this.students = students;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public void write() throws TransformerException, ParserConfigurationException {
            document = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
            Element elementStudentsList = document.createElement("studentslist");
            document.appendChild(elementStudentsList);

            for (Student student : students) {
                Element elementStudent = document.createElement("student");
                elementStudentsList.appendChild(elementStudent);

                Element elementSurname = document.createElement("surname");
                elementStudent.appendChild(elementSurname);
                elementSurname.setTextContent(student.getSurname());

                Element elementName = document.createElement("name");
                elementStudent.appendChild(elementName);
                elementName.setTextContent(student.getName());

                Element elementSecondName = document.createElement("secondname");
                elementStudent.appendChild(elementSecondName);
                elementSecondName.setTextContent(student.getSecondName());

                Element elementPhone = document.createElement("phone");
                elementStudent.appendChild(elementPhone);

                Element elementPhoneNumMob = document.createElement("mobile_phone_number");
                elementPhone.appendChild(elementPhoneNumMob);
                elementPhoneNumMob.setTextContent(String.valueOf(student.phone.getPhoneNumMob()));

                Element elementPhoneNumber = document.createElement("phone_number");
                elementPhone.appendChild(elementPhoneNumber);
                elementPhoneNumber.setTextContent(String.valueOf(student.phone.getPhoneNumber()));

                Element elementAddress = document.createElement("address");
                elementStudent.appendChild(elementAddress);

                Element elementCountry = document.createElement("country");
                elementAddress.appendChild(elementCountry);
                elementCountry.setTextContent(student.address.getCountry());

                Element elementState = document.createElement("state");
                elementAddress.appendChild(elementState);
                elementState.setTextContent(student.address.getState());

                Element elementCity = document.createElement("city");
                elementAddress.appendChild(elementCity);
                elementCity.setTextContent(student.address.getCity());

                Element elementStreet = document.createElement("street");
                elementAddress.appendChild(elementStreet);
                elementStreet.setTextContent(student.address.getStreet());

                Element elementHouse = document.createElement("house");
                elementAddress.appendChild(elementHouse);
                elementHouse.setTextContent(String.valueOf(student.address.getHouseNumber()));

                Element elementFlat = document.createElement("flat");
                elementAddress.appendChild(elementFlat);
                elementFlat.setTextContent(String.valueOf(student.address.getFlatNumber()));
            }
            Transformer transformer = TransformerFactory.newInstance().newTransformer();
            DOMSource domSource = new DOMSource(document);
            StreamResult streamResult = new StreamResult(file);
            transformer.transform(domSource, streamResult);
    }
}