package view;

import controller.Controller;
import model.Student;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.*;

import java.util.ArrayList;

public class SearchDisplay {

    private Display display = ParentDisplay.display;
    private Shell shell = new Shell(display);
    public Table table = new Table(shell, SWT.SINGLE | SWT.FULL_SELECTION | SWT.V_SCROLL | SWT.H_SCROLL);

    public SearchDisplay(Controller controller) {

        shell.setText("Search students");
        shell.setBackground(ParentDisplay.display.getSystemColor(SWT.COLOR_GRAY));

        Rectangle rectangle = shell.getDisplay().getBounds();

        Point p = shell.getSize();
        int Left = (rectangle.width - p.x) / 2;
        int Top = (rectangle.height - p.y) / 2;
        shell.setBounds(Left, Top, p.x, p.y);
        search(controller);
        shell.open();
    }

    public void search(Controller controller){


        Label hseparatorT = new Label(shell, SWT.HORIZONTAL | SWT.SEPARATOR);
        hseparatorT.setBounds(1,23,1410,3);

        Label surname = new Label(shell,SWT.NONE);
        surname.setText("Фамилия:");
        surname.setBounds(10,30,75,20);
        surname.setBackground(ParentDisplay.display.getSystemColor(SWT.COLOR_GRAY));

        Text textSurname = new Text(shell, SWT.CENTER);
        textSurname.setBounds(95,30,120,20);

        Label phone = new Label(shell,SWT.NONE);
        phone.setText("Телефон:");
        phone.setBounds(230,30,60,20);
        phone.setBackground(ParentDisplay.display.getSystemColor(SWT.COLOR_GRAY));

        Text textPhone = new Text(shell, SWT.CENTER);
        textPhone.setBounds(305,30,100,20);

        Label country = new Label(shell,SWT.NONE);
        country.setText("Страна:");
        country.setBounds(10,60,55,20);

        Text textCountry = new Text(shell, SWT.CENTER);
        textCountry.setBounds(75,60,80,20);
        country.setBackground(ParentDisplay.display.getSystemColor(SWT.COLOR_GRAY));

        Label state = new Label(shell,SWT.NONE);
        state.setText("Область/Штат/Округ:");
        state.setBounds(175,60,145,20);
        state.setBackground(ParentDisplay.display.getSystemColor(SWT.COLOR_GRAY));

        Text textState = new Text(shell, SWT.CENTER);
        textState.setBounds(335,60,100,20);

        Label city = new Label(shell,SWT.NONE);
        city.setText("Город:");
        city.setBounds(450,60,45,20);
        city.setBackground(ParentDisplay.display.getSystemColor(SWT.COLOR_GRAY));

        Text textCity = new Text(shell, SWT.CENTER);
        textCity.setBounds(505,60,100,20);

        Label street = new Label(shell,SWT.NONE);
        street.setText("Улица:");
        street.setBounds(620,60,45,20);
        street.setBackground(ParentDisplay.display.getSystemColor(SWT.COLOR_GRAY));

        Text textStreet = new Text(shell, SWT.CENTER);
        textStreet.setBounds(675,60,100,20);

        Label houseNumber = new Label(shell,SWT.NONE);
        houseNumber.setText("Дом:");
        houseNumber.setBounds(790,60,33,20);
        houseNumber.setBackground(ParentDisplay.display.getSystemColor(SWT.COLOR_GRAY));

        Text textHouseNumber = new Text(shell, SWT.CENTER);
        textHouseNumber.setBounds(833,60,30,20);

        Label flatNumber = new Label(shell,SWT.NONE);
        flatNumber.setText("Квартира:");
        flatNumber.setBounds(878,60,68,20);
        flatNumber.setBackground(ParentDisplay.display.getSystemColor(SWT.COLOR_GRAY));

        Text textFlatNubmer = new Text(shell, SWT.CENTER);
        textFlatNubmer.setBounds(956,60,30,20);

        Label digits = new Label(shell, SWT.NONE);
        digits.setText("Цифры одного из номеров:");
        digits.setBounds(450,30,195,20);
        digits.setBackground(ParentDisplay.display.getSystemColor(SWT.COLOR_GRAY));

        Text textDigits = new Text(shell, SWT.CENTER);
        textDigits.setBounds(655,30,100,20);

        Label hseparatorB = new Label(shell, SWT.HORIZONTAL | SWT.SEPARATOR);
        hseparatorB.setBounds(1, 85, 1410, 3);

        Button radiobutton[] = new Button[5];
        radiobutton[0] = new Button(shell, SWT.RADIO);
        radiobutton[1] = new Button(shell, SWT.RADIO);
        radiobutton[2] = new Button(shell, SWT.RADIO);

        radiobutton[0].setText("Номер телефона и фамилия");
        radiobutton[0].setBounds(5,5,260,15);
        radiobutton[0].setBackground(ParentDisplay.display.getSystemColor(SWT.COLOR_GRAY));

        radiobutton[1].setText("Номер телефона и адрес");
        radiobutton[1].setBounds(400,5,200,15);
        radiobutton[1].setBackground(ParentDisplay.display.getSystemColor(SWT.COLOR_GRAY));

        radiobutton[2].setText("Фамилии и цифры встречающиеся в одном из номеров");
        radiobutton[2].setBounds(680,5,420,15);
        radiobutton[2].setBackground(ParentDisplay.display.getSystemColor(SWT.COLOR_GRAY));

        Button check[] = new Button[2];
        check[0] = new Button(shell, SWT.CHECK);
        check[1] = new Button(shell, SWT.CHECK);

        check[0].setText("Цифры мобильного телеофна");
        check[0].setBounds(1000,30, 250, 20);
        check[0].setBackground(ParentDisplay.display.getSystemColor(SWT.COLOR_GRAY));

        check[1].setText("Цифры городского телефона");
        check[1].setBounds(1000,60, 250, 20);
        check[1].setBackground(ParentDisplay.display.getSystemColor(SWT.COLOR_GRAY));


        radiobutton[0].addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                textCountry.setEditable(false);
                textState.setEditable(false);
                textCity.setEditable(false);
                textStreet.setEditable(false);
                textDigits.setEditable(false);
                textFlatNubmer.setEditable(false);
                textHouseNumber.setEditable(false);
                textSurname.setEditable(true);
                textPhone.setEditable(true);
            }
        });
        radiobutton[1].addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                textCountry.setEditable(true);
                textState.setEditable(true);
                textCity.setEditable(true);
                textStreet.setEditable(true);
                textDigits.setEditable(false);
                textFlatNubmer.setEditable(true);
                textHouseNumber.setEditable(true);
                textSurname.setEditable(false);
                textPhone.setEditable(true);
            }
        });
        radiobutton[2].addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                textCountry.setEditable(false);
                textState.setEditable(false);
                textCity.setEditable(false);
                textStreet.setEditable(false);
                textDigits.setEditable(true);
                textFlatNubmer.setEditable(false);
                textHouseNumber.setEditable(false);
                textSurname.setEditable(true);
                textPhone.setEditable(false);
            }
        });

        Button search = new Button(shell, SWT.PUSH);
        search.setText("Найти");
        search.setBounds(1300, 35, 90, 40);
        search.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent selectionEvent) {
                ArrayList<Student> students = new ArrayList<>();
                Student student = new Student();
                if(radiobutton[0].getSelection()){
                    student.setSurname(textSurname.getText());
                    student.phone.setPhoneNumMob(textPhone.getText());

                }
                else if(radiobutton[1].getSelection()){
                    student.phone.setPhoneNumMob(textPhone.getText());
                    student.address.setCountry(textCountry.getText());
                    student.address.setState(textState.getText());
                    student.address.setCity(textCity.getText());
                    student.address.setStreet(textStreet.getText());
                    student.address.setHouseNumber(textHouseNumber.getText());
                    student.address.setFlatNumber(textFlatNubmer.getText());

                }
                else if(radiobutton[2].getSelection()) {
                    student.setSurname(textSurname.getText());
                    student.phone.setPhoneNumMob(textDigits.getText());


                }
            }
        });

//        StudentsTable studentsTable = new StudentsTable();
//        studentsTable.setTable(shell, table, controller);
    }

}
