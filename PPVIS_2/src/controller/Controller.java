package controller;

import model.Student;
import model.StudentsInfo;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableItem;

public class Controller {

    private StudentsInfo studentsInfo = new StudentsInfo();
    private Student student = new Student();

    public void add(Student student){
        studentsInfo.AddStudent(student);
    }

    public void showNotes(Table table, int numOfNontes){
        TableItem tableItem = new TableItem(table, SWT.PUSH);
        for(int i = 0; i <= numOfNontes; i++){
        tableItem.setText(0, String.valueOf(i));
        tableItem.setText(1, student.getSurname()+ " " + student.getName()+ " " + student.getSecondname());
        tableItem.setText(2, student.address.getAddress());
//        tableItem.setText(3, student.getSurname()+ " " + student.getName()+ " " + student.getSecondname());
//        tableItem.setText(4, student.getSurname()+ " " + student.getName()+ " " + student.getSecondname());



        }

    }
}
