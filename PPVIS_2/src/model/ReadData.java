package model;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;

public class ReadData extends DefaultHandler{
    static final String STUDENTLIST_TAG = "studentslist";
    static final String STUDENT_TAG = "student";
    static final String SURNAME_TAG = "surname";
    static final String NAME_TAG = "name";
    static final String SECONDNAME_TAG = "secondname";
    static final String MOBILE_PHONE_NUMBER_TAG = "mobile_phone_number";
    static final String PHONE_NUMBER_TAG = "phone_number";
    static final String COUNTRY_TAG = "country";
    static final String STATE_TAG = "state";
    static final String CITY_TAG = "city";
    static final String STREET_TAG = "street";
    static final String HOUSE_TAG = "house";
    static final String FLAT_TAG = "flat";

    private ArrayList<Student> students;
    private Student student;
    private String currentElement;

    public ArrayList<Student> getStudents() {
        return students;
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        currentElement = qName;
        System.out.println(qName);
        switch (currentElement){
            case STUDENTLIST_TAG: {
                students = new ArrayList<>();
            }break;
            case STUDENT_TAG: {
                student = new Student();
            }break;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        switch (qName) {
            case STUDENT_TAG: {
                students.add(student);
            }break;
            case SURNAME_TAG: {
                currentElement = null;
            }break;
            case NAME_TAG: {
                currentElement = null;
            }break;
            case SECONDNAME_TAG: {
                currentElement = null;
            }break;
            case MOBILE_PHONE_NUMBER_TAG: {
                currentElement = null;
            }break;
            case PHONE_NUMBER_TAG: {
                currentElement = null;
            }break;
            case COUNTRY_TAG: {
                currentElement = null;
            }break;
            case STATE_TAG: {
                currentElement = null;
            }break;
            case CITY_TAG: {
                currentElement = null;
            }break;
            case STREET_TAG: {
                currentElement = null;
            }break;
            case HOUSE_TAG: {
                currentElement = null;
            }break;
            case FLAT_TAG: {
                currentElement = null;
            }break;
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException, NumberFormatException{
        String text = new String(ch, start, length);
        System.out.println(text);
        if(text.contains("<") || currentElement == null){
            return;
        }
        switch (currentElement) {
            case SURNAME_TAG:{
                student.setSurname(text);
            }break;

            case NAME_TAG:{
                student.setName(text);
            }break;

            case SECONDNAME_TAG:{
                student.setSecondName(text);
            }break;

            case MOBILE_PHONE_NUMBER_TAG:{
                student.phone.setPhoneNumMob(text);
            }break;

            case PHONE_NUMBER_TAG:{
                student.phone.setPhoneNumber(text);
            }break;

            case COUNTRY_TAG:{
                student.address.setCountry(text);
            }break;

            case STATE_TAG:{
                student.address.setState(text);
            }break;

            case CITY_TAG:{
                student.address.setCity(text);
            }break;

            case STREET_TAG:{
                student.address.setStreet(text);
            }break;

            case HOUSE_TAG:{
                student.address.setHouseNumber(text);
            }break;

            case FLAT_TAG:{
                student.address.setFlatNumber(text);
            }break;
        }
    }
}
