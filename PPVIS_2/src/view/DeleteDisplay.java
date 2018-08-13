package view;

import controller.Controller;
import model.Student;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.RowData;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.*;

public class DeleteDisplay {

    private Display display = ParentDisplay.display;
    private Shell shell = new Shell(display);

    public DeleteDisplay(Controller controller) {
        shell.setBounds(700, 400, 500, 230);
        shell.setText("Delete some students");
        shell.setLayout(new RowLayout(SWT.HORIZONTAL));
        deleteDisplay(controller);
        shell.open();
    }

    public void deleteDisplay(Controller controller) {

        Group group = new Group(shell, SWT.SHADOW_IN);
        group.setText("Удаление по:  ");
        group.setLayoutData(new RowData(450, 75));
        RowLayout rowLayout = new RowLayout(SWT.VERTICAL);
        rowLayout.justify = true;

        group.setLayout(rowLayout);

        Button check[] = new Button[2];

        check[0] = new Button(shell, SWT.CHECK);
        check[0].setText("Цифры мобильного телефона");

        check[1] = new Button(shell, SWT.CHECK);
        check[1].setText("Цифры городского телефона");

        Button next = new Button(shell, SWT.PUSH);
        next.setText("Далее");

        Button radios[] = new Button[3];

        radios[0] = new Button(group, SWT.RADIO);
        radios[0].setText("Номеру телефона и фамилии");

        radios[0].addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent selectionEvent) {
                check[0].setVisible(false);
                check[1].setVisible(false);
            }
        });

        radios[1] = new Button(group, SWT.RADIO);
        radios[1].setText("Нмеру телефона и адресу");

        radios[1].addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent selectionEvent) {
                check[0].setVisible(false);
                check[1].setVisible(false);
            }
        });

        radios[2] = new Button(group, SWT.RADIO);
        radios[2].setText("Фамилии и цифрам встречающимся в одном из номеров");

        radios[2].addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent selectionEvent) {
                check[0].setVisible(true);
                check[1].setVisible(true);
            }
        });

        next.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent selectionEvent) {
                if(radios[0].getSelection()){
                    inputDisplay1(controller);
                }
                else if(radios[1].getSelection()){
                    inputDisplay2(controller);
                }
                else if(radios[2].getSelection()){
                    if(check[0].getSelection() && !check[1].getSelection()){
                        inputDisplay3(controller, true);
                    }
                    else if(check[1].getSelection() && !check[0].getSelection()){
                        inputDisplay3(controller, false);
                    }
                }
            }
        });
    }

    public void inputDisplay1(Controller controller){

        Shell shell = new Shell(display);
        shell.setBackground(ParentDisplay.display.getSystemColor(SWT.COLOR_GRAY));
        shell.setText("Удаление #1");

        shell.setBounds(700, 400, 400, 140);
        shell.open();

        Label surname = new Label(shell,SWT.NONE);
        surname.setBounds(10,10,75,20);
        surname.setBackground(ParentDisplay.display.getSystemColor(SWT.COLOR_GRAY));
        surname.setText("Фамилия:");

        Text textSurname = new Text(shell, SWT.CENTER);
        textSurname.setBounds(95,10,120,20);

        Label phone = new Label(shell,SWT.NONE);
        phone.setBounds(10,40,70,20);
        phone.setBackground(ParentDisplay.display.getSystemColor(SWT.COLOR_GRAY));
        phone.setText("Телефон:");

        Text textPhone = new Text(shell, SWT.CENTER);
        textPhone.setBounds(95,40,120,20);

        Button delete = new Button(shell, SWT.PUSH);
        delete.setBounds(230, 5, 150, 60);
        delete.setBackground(ParentDisplay.display.getSystemColor(SWT.COLOR_GRAY));
        delete.setText("Удалить");

        delete.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent selectionEvent) {
                if(textPhone.getText().isEmpty() || textSurname.getText().isEmpty()){
                    MessageBox messageBox = new MessageBox(shell);
                    messageBox.setMessage("Остались незаполненные поля!");
                    messageBox.setText("Ошибка!");
                    messageBox.open();
                }else {
                    Student student = new Student();
                    student.setSurname(textSurname.getText());
                    student.phone.setPhoneNumMob(textPhone.getText());
                    confirmDecision(controller, student, 1, true);
                    shell.close();
                }
            }
        });
    }

    public void inputDisplay2(Controller controller){

        Shell shell = new Shell(display);
        shell.setBackground(ParentDisplay.display.getSystemColor(SWT.COLOR_GRAY));
        shell.setText("Удаление #2");

        shell.setBounds(500, 300, 600, 300);
        shell.open();

        Label phone = new Label(shell,SWT.NONE);
        phone.setBounds(10,10,145,20);
        phone.setBackground(ParentDisplay.display.getSystemColor(SWT.COLOR_GRAY));
        phone.setText("Телефон:");

        Text textPhone = new Text(shell, SWT.CENTER);
        textPhone.setBounds(170,10,120,20);

        Label country = new Label(shell,SWT.NONE);
        country.setText("Страна:");
        country.setBounds(10,40,145,20);
        country.setBackground(ParentDisplay.display.getSystemColor(SWT.COLOR_GRAY));

        Text textCountry = new Text(shell, SWT.CENTER);
        textCountry.setBounds(170,40,120,20);

        Label state = new Label(shell,SWT.NONE);
        state.setText("Область/Штат/Округ:");
        state.setBounds(10,70,145,20);
        state.setBackground(ParentDisplay.display.getSystemColor(SWT.COLOR_GRAY));

        Text textState = new Text(shell, SWT.CENTER);
        textState.setBounds(170,70,120,20);

        Label city = new Label(shell,SWT.NONE);
        city.setText("Город:");
        city.setBounds(10,100,145,20);
        city.setBackground(ParentDisplay.display.getSystemColor(SWT.COLOR_GRAY));

        Text textCity = new Text(shell, SWT.CENTER);
        textCity.setBounds(170,100,120,20);

        Label street = new Label(shell,SWT.NONE);
        street.setText("Улица:");
        street.setBounds(10,130,145,20);
        street.setBackground(ParentDisplay.display.getSystemColor(SWT.COLOR_GRAY));

        Text textStreet = new Text(shell, SWT.CENTER);
        textStreet.setBounds(170,130,120,20);

        Label houseNumber = new Label(shell,SWT.NONE);
        houseNumber.setText("Дом:");
        houseNumber.setBounds(10,160,145,20);
        houseNumber.setBackground(ParentDisplay.display.getSystemColor(SWT.COLOR_GRAY));

        Text textHouseNumber = new Text(shell, SWT.CENTER);
        textHouseNumber.setBounds(170,160,120,20);

        Label flatNumber = new Label(shell,SWT.NONE);
        flatNumber.setText("Квартира:");
        flatNumber.setBounds(10,190,145,20);
        flatNumber.setBackground(ParentDisplay.display.getSystemColor(SWT.COLOR_GRAY));

        Text textFlatNubmer = new Text(shell, SWT.CENTER);
        textFlatNubmer.setBounds(170,190,120,20);

        Button delete = new Button(shell, SWT.PUSH);
        delete.setBounds(350, 25, 150, 60);
        delete.setBackground(ParentDisplay.display.getSystemColor(SWT.COLOR_GRAY));
        delete.setText("Удалить");

        delete.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent selectionEvent) {
                if(textPhone.getText().isEmpty() || textCountry.getText().isEmpty() || textCity.getText().isEmpty() ||
                textFlatNubmer.getText().isEmpty() || textHouseNumber.getText().isEmpty() || textState.getText().isEmpty() ||
                textStreet.getText().isEmpty()){
                    MessageBox messageBox = new MessageBox(shell);
                    messageBox.setMessage("Остались незаполненные поля!");
                    messageBox.setText("Ошибка!");
                    messageBox.open();
                }else {
                    Student student = new Student();
                    student.phone.setPhoneNumMob(textPhone.getText());
                    student.address.setCountry(textCountry.getText());
                    student.address.setState(textState.getText());
                    student.address.setCity(textCity.getText());
                    student.address.setStreet(textStreet.getText());
                    student.address.setHouseNumber(textHouseNumber.getText());
                    student.address.setFlatNumber(textFlatNubmer.getText());
                    confirmDecision(controller, student, 2, true);
                    shell.close();
                }
            }
        });
    }

    public void inputDisplay3(Controller controller, boolean typeOfPhone){
        Shell shell = new Shell(display);
        shell.setBackground(ParentDisplay.display.getSystemColor(SWT.COLOR_GRAY));
        shell.setText("Удаление #3");

        shell.setBounds(500, 300, 600, 140);
        shell.open();

        Label surname = new Label(shell,SWT.NONE);
        surname.setBounds(10,10,230,20);
        surname.setBackground(ParentDisplay.display.getSystemColor(SWT.COLOR_GRAY));
        surname.setText("Фамилия:");

        Text textSurname = new Text(shell, SWT.CENTER);
        textSurname.setBounds(250,10,120,20);

        Label digits = new Label(shell,SWT.NONE);
        digits.setBounds(10,40,230,20);
        digits.setBackground(ParentDisplay.display.getSystemColor(SWT.COLOR_GRAY));
        if(typeOfPhone){
            digits.setText("Цифры мобильного телефона:");
        }
        else{
            digits.setText("Цифры городского телефона:");
        }

        Text textDigits = new Text(shell, SWT.CENTER);
        textDigits.setBounds(250,40,120,20);

        Button delete = new Button(shell, SWT.PUSH);
        delete.setBounds(400, 5, 150, 60);
        delete.setBackground(ParentDisplay.display.getSystemColor(SWT.COLOR_GRAY));
        delete.setText("Удалить");

        delete.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent selectionEvent) {
                if(textDigits.getText().isEmpty() || textSurname.getText().isEmpty()){
                    MessageBox messageBox = new MessageBox(shell);
                    messageBox.setMessage("Остались незаполненные поля!");
                    messageBox.setText("Ошибка!");
                    messageBox.open();
                }else {
                    Student student = new Student();
                    student.setSurname(textSurname.getText());
                    student.phone.setPhoneNumMob(textDigits.getText());
                    if(typeOfPhone) {
                        confirmDecision(controller, student, 3, true);
                    }
                    else if(!typeOfPhone){
                        confirmDecision(controller, student, 3, false);
                    }
                    shell.close();
                }
            }
        });

    }

    public void confirmDecision(Controller controller, Student student, int criterion, boolean typeOfPhone){

        Shell shell = new Shell(display);
        shell.setText("ВЫ ДЕЙСТВИТЕЛЬНО ХОТИТЕ УДАЛИТЬ ЗАПИСИ?");
        shell.setBounds(700,400, 450, 150);
        shell.open();

        Button confirm = new Button(shell, SWT.PUSH);
        confirm.setBounds(10,10, 200, 70);
        confirm.setText("Удалить");

        Button reject = new Button(shell, SWT.PUSH);
        reject.setBounds(220,10, 200, 70);
        reject.setText("Отмена");

        confirm.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent selectionEvent) {
                int count = controller.delete(student, criterion, typeOfPhone);
                MessageBox message = new MessageBox(shell);
                if (count == 0) {
                    message.setText("Ошибка!");
                    message.setMessage("Записи не найдены!");
                }else if(count ==1 ){
                    message.setText("Успех!");
                    message.setMessage("Удалена " + count + " запись!");
                }else if(count > 1 && count < 5){
                    message.setText("Успех!");
                    message.setMessage("Удалено " + count + " записи!");
                }else {
                    message.setText("Успех!");
                    message.setMessage("Удалено " + count + " записей!");
                }
                message.open();
                shell.close();
            }
        });

        reject.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent selectionEvent) {
                shell.close();
            }
        });
    }
}
