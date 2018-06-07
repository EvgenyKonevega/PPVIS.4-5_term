package view;

import controller.Controller;
import model.Address;
import model.Phone;
import model.Student;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.widgets.*;

public class AddDisplay {

    private Display display = ParentDisplay.display;
    private Shell shell = new Shell(display);
    private Controller controller = new Controller();

    public AddDisplay() {

        shell.setSize(600,550);
        shell.setText("Add student");
        addDisplay();
        shell.open();
    }

    public void addDisplay(){

        Group groupBIO = new Group(shell, SWT.NONE);
        groupBIO.setText("Информация о студенте: ");
        groupBIO.setBounds(10,8,530,500);

        Label surname = new Label(groupBIO,SWT.NONE);
        surname.setText("Фамилия: ");
        surname.setBounds(15,15,150,30);
        surname.setFont(new Font(display,"Cambria", 18, SWT.NORMAL));

        Text textSurname = new Text(groupBIO, SWT.CENTER);
        textSurname.setFont(new Font(display,"Cambria", 18, SWT.NORMAL));
        textSurname.setBounds(330,15,170,30);

        Label name = new Label(groupBIO,SWT.NONE);
        name.setText("Имя: ");
        name.setBounds(15,50,150,30);
        name.setFont(new Font(display,"Cambria", 18, SWT.NORMAL));

        Text textName = new Text(groupBIO, SWT.CENTER);
        textName.setFont(new Font(display,"Cambria", 18, SWT.NORMAL));
        textName.setBounds(330,50,170,30);

        Label secondName = new Label(groupBIO,SWT.NONE);
        secondName.setText("Отчество: ");
        secondName.setBounds(15,85,150,30);
        secondName.setFont(new Font(display,"Cambria", 18, SWT.NORMAL));

        Text textSecondName = new Text(groupBIO, SWT.CENTER);
        textSecondName.setFont(new Font(display,"Cambria", 18, SWT.NORMAL));
        textSecondName.setBounds(330,85,170,30);

        Label phoneNumMob = new Label(groupBIO,SWT.NONE);
        phoneNumMob.setText("Мобильный телефон(80...): ");
        phoneNumMob.setBounds(15,150,300,30);
        phoneNumMob.setFont(new Font(display,"Cambria", 18, SWT.NORMAL));

        Text textPhoneNummMob = new Text(groupBIO, SWT.CENTER);
        textPhoneNummMob.setFont(new Font(display,"Cambria", 18, SWT.NORMAL));
        textPhoneNummMob.setBounds(330,150,170,30);

        Label phone = new Label(groupBIO,SWT.NONE);
        phone.setText("Городской телефон(80...): ");
        phone.setBounds(15,185,300,30);
        phone.setFont(new Font(display,"Cambria", 18, SWT.NORMAL));

        Text textPhoneNumber = new Text(groupBIO, SWT.CENTER);
        textPhoneNumber.setFont(new Font(display,"Cambria", 18, SWT.NORMAL));
        textPhoneNumber.setBounds(330,185,170,30);

        Label country = new Label(groupBIO,SWT.NONE);
        country.setText("Страна:");
        country.setBounds(15,250,300,30);
        country.setFont(new Font(display,"Cambria", 18, SWT.NORMAL));

        Text textCountry = new Text(groupBIO, SWT.CENTER);
        textCountry.setFont(new Font(display,"Cambria", 18, SWT.NORMAL));
        textCountry.setBounds(330,250,170,30);

        Label state = new Label(groupBIO,SWT.NONE);
        state.setText("Область/Штат/Округ:");
        state.setBounds(15,285,300,30);
        state.setFont(new Font(display,"Cambria", 18, SWT.NORMAL));

        Text textState = new Text(groupBIO, SWT.CENTER);
        textState.setFont(new Font(display,"Cambria", 18, SWT.NORMAL));
        textState.setBounds(330,285,170,30);

        Label city = new Label(groupBIO,SWT.NONE);
        city.setText("Город:");
        city.setBounds(15,320,300,30);
        city.setFont(new Font(display,"Cambria", 18, SWT.NORMAL));

        Text textCity = new Text(groupBIO, SWT.CENTER);
        textCity.setFont(new Font(display,"Cambria", 18, SWT.NORMAL));
        textCity.setBounds(330,320,170,30);

        Label street = new Label(groupBIO,SWT.NONE);
        street.setText("Улица:");
        street.setBounds(15,355,300,30);
        street.setFont(new Font(display,"Cambria", 18, SWT.NORMAL));

        Text textStreet = new Text(groupBIO, SWT.CENTER);
        textStreet.setFont(new Font(display,"Cambria", 18, SWT.NORMAL));
        textStreet.setBounds(330,355,170,30);

        Label houseNumber = new Label(groupBIO,SWT.NONE);
        houseNumber.setText("Дом:");
        houseNumber.setBounds(15,390,300,30);
        houseNumber.setFont(new Font(display,"Cambria", 18, SWT.NORMAL));

        Text textHouseNumber = new Text(groupBIO, SWT.CENTER);
        textHouseNumber.setFont(new Font(display,"Cambria", 18, SWT.NORMAL));
        textHouseNumber.setBounds(330,390,170,30);

        Label flatNubmer = new Label(groupBIO,SWT.NONE);
        flatNubmer.setText("Квартира:");
        flatNubmer.setBounds(15,425,300,30);
        flatNubmer.setFont(new Font(display,"Cambria", 18, SWT.NORMAL));

        Text textFlatNubmer = new Text(groupBIO, SWT.CENTER);
        textFlatNubmer.setFont(new Font(display,"Cambria", 18, SWT.NORMAL));
        textFlatNubmer.setBounds(330,425,170,30);

        Button buttonAdd = new Button(groupBIO, SWT.PUSH);
        buttonAdd.setBounds(375,465,70,25);
        buttonAdd.setText("Добавить");
        buttonAdd.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e){
                if(textName.getText().length()==0 || textSurname.getText().length()==0 ||
                        textSecondName.getText().length()==0 || textCountry.getText().length()==0 ||
                        textCity.getText().length()==0 || textState.getText().length()==0 ||
                        textStreet.getText().length()==0 || textPhoneNumber.getText().length()==0 ||
                        textPhoneNummMob.getText().length()==0||textHouseNumber.getText().length()==0 ||
                        textFlatNubmer.getText().length()==0){
                    MessageBox WAR = new MessageBox(shell);
                    WAR.setMessage("Остались незаполненные поля!");
                    WAR.open();
                }
                else if(!textFlatNubmer.getText().matches("\\d+") || !textHouseNumber.getText().matches("\\d+") ||
                        !textPhoneNumber.getText().matches("\\d+") || !textPhoneNummMob.getText().matches("\\d+")){
                    MessageBox warning = new MessageBox(shell);
                    warning.setMessage("Некорректный ввод!");
                    warning.open();
                    }
                else{
                Student student = new Student();
                student.setName(textName.getText());
                student.setSurname(textSurname.getText());
                student.setSecondname(textSecondName.getText());
                Phone phone = new Phone();
                student.phone = phone;
                phone.setPhoneNumber(Integer.parseInt(textPhoneNumber.getText()));
                phone.setPhoneNumMob(Integer.parseInt(textPhoneNummMob.getText()));
                Address address = new Address();
                student.address = address;
                address.setCountry(textCountry.getText());
                address.setState(textState.getText());
                address.setCity(textCity.getText());
                address.setStreet(textStreet.getText());
                address.setHouseNumber(Integer.parseInt(textHouseNumber.getText()));
                address.setFlatNumber(Integer.parseInt(textFlatNubmer.getText()));

                controller.add(student);

                MessageBox message = new MessageBox(shell);
                message.setMessage("Запись успешно добавлена");
                message.open();
                shell.close();
                }
            }
        });

        Button buttonAbort = new Button(groupBIO, SWT.PUSH);
        buttonAbort.setBounds(75,465,70,25);
        buttonAbort.setText("Отмена");
        buttonAbort.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                shell.close();
            }
        });
    }
}
