package view;

import controller.Controller;
import model.Student;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.*;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.*;

import java.util.ArrayList;

public class StudentsTable {

    private Display display = ParentDisplay.display;

    //public void setTable(Shell shell, int notes, Table table, Controller controller) {
    public void setTable(Shell shell, Table table, Controller controller) {

        Label numOfNotes = new Label(shell, SWT.NONE);
        numOfNotes.setFont(new Font(display, "Cambria", 22, SWT.ITALIC));
        numOfNotes.setBackground(display.getSystemColor(SWT.COLOR_GRAY));
        numOfNotes.setBounds(15, 95, 245, 40);
        numOfNotes.setText("Всего записей: ");

        Label num = new Label(shell, SWT.CENTER);
        num.setFont(new Font(display, "Cambria", 22, SWT.ITALIC));
        num.setBackground(display.getSystemColor(SWT.COLOR_GRAY));
        num.setBounds(275, 95, 40, 40);

        Label showNotes = new Label(shell, SWT.NONE);
        showNotes.setFont(new Font(display, "Cambria", 22, SWT.ITALIC));
        showNotes.setBounds(15, 150, 380, 45);
        showNotes.setBackground(display.getSystemColor(SWT.COLOR_GRAY));
        showNotes.setText("Отображать записей: ");

        Text numCurrNotes = new Text(shell, SWT.CENTER);
        numCurrNotes.setFont(new Font(display, "Cambria", 22, SWT.ITALIC));
        numCurrNotes.setBounds(395, 150, 55, 40);

        Label page = new Label(shell, SWT.NONE);
        page.setFont(new Font(display, "Cambria", 22, SWT.ITALIC));
        page.setBackground(display.getSystemColor(SWT.COLOR_GRAY));
        page.setText("Страница");
        page.setBounds(700, 122, 180, 45);

        Label of = new Label(shell, SWT.NONE);
        of.setBackground(display.getSystemColor(SWT.COLOR_GRAY));
        of.setFont(new Font(display, "Cambria", 22, SWT.ITALIC));
        of.setText("из");
        of.setBounds(940, 122, 40, 45);

        Label currentPage = new Label(shell, SWT.CENTER);
        currentPage.setBackground(display.getSystemColor(SWT.COLOR_GRAY));
        currentPage.setBounds(890, 122, 40, 45);
        currentPage.setFont(new Font(display, "Cambria", 22, SWT.ITALIC));

        Label pages = new Label(shell, SWT.NONE);
        pages.setBackground(display.getSystemColor(SWT.COLOR_GRAY));
        pages.setFont(new Font(display, "Cambria", 22, SWT.ITALIC));
        pages.setBounds(1000, 122, 45, 45);

        Button update = new Button(shell, SWT.PUSH);
        update.setBounds(335,95,100,40);
        update.setText("Обновить");
        update.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                //num.setText(String.valueOf(notes));
                num.setText(String.valueOf(controller.studentsInfo.getStudents().size()));
            }
        });

        Button updateTable = new Button(shell, SWT.PUSH);
        updateTable.setBounds(460, 150, 150, 40);
        updateTable.setText("Запись в таблицу");
        updateTable.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                //if(numCurrNotes.getText().matches("[1-9]?|10")){
                    showNotes(table, controller, Integer.parseInt(numCurrNotes.getText()), 1);
                    currentPage.setText("1");
                    pages.setText(String.valueOf(Integer.parseInt(num.getText())/Integer.parseInt(numCurrNotes.getText())));
                //}
            }
        });

        Button prevPage = new Button(shell, SWT.PUSH);
        prevPage.setBounds(640, 128, 46, 33);
        prevPage.setImage(new Image(display, "images/backIcon.gif"));
        prevPage.setBackground(display.getSystemColor(SWT.COLOR_WHITE));

        Button nextPage = new Button(shell, SWT.PUSH);
        nextPage.setBounds(1055, 128, 46, 33);
        nextPage.setImage(new Image(display, "images/nextIcon.gif"));
        nextPage.setBackground(display.getSystemColor(SWT.COLOR_WHITE));

        Label hseparatorB = new Label(shell, SWT.HORIZONTAL | SWT.SEPARATOR);
        hseparatorB.setBounds(1, 200, 1410, 3);

        table.setBounds(3,215, 1410, 268);
        table.setHeaderVisible(true);
        table.setLinesVisible(true);

        TableColumn n = new TableColumn(table, SWT.CENTER);
        n.setText("№");
        n.setWidth(35);

        TableColumn fio = new TableColumn(table, SWT.CENTER);
        fio.setText("ФИО Студента");
        fio.setWidth(276);

        TableColumn adress = new TableColumn(table, SWT.CENTER);
        adress.setText("Адрес прописки");
        adress.setWidth(576);

        TableColumn mobilePhone = new TableColumn(table, SWT.CENTER);
        mobilePhone.setText("Мобильный телефон");
        mobilePhone.setWidth(261);

        TableColumn phone = new TableColumn(table, SWT.CENTER);
        phone.setText("Городской телефон");
        phone.setWidth(261);
    }

     public void showNotes(Table table, ArrayList<Student> students, int numOfNontes, int page) {
            table.removeAll();
         int counter = 1+numOfNontes*page;
         for (Student student : students){
             if(counter <= numOfNontes*page){
             TableItem tableItem = new TableItem(table, SWT.PUSH);
             tableItem.setText(0, String.valueOf(counter));
             tableItem.setText(1, student.getSurname() + " " + student.getName() + " " + student.getSecondName());
             tableItem.setText(2, String.valueOf(student.address.getAddress()));
             tableItem.setText(3, String.valueOf(student.phone.getPhoneNumMob()));
             tableItem.setText(4, String.valueOf(student.phone.getPhoneNumber()));
             }
             counter++;
         }
     }
}
