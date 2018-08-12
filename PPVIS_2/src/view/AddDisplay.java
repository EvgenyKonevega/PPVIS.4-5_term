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

    public AddDisplay(Controller controller) {

        shell.setSize(800,800);
        shell.setText("Add student");
        addDisplay(controller);
        shell.open();
    }

    public void addDisplay(Controller controller){

        Group groupBIO = new Group(shell, SWT.NONE);
        groupBIO.setText("Информация о студенте: ");
        groupBIO.setBounds(10,8,680,700);

        Label surname = new Label(groupBIO,SWT.NONE);
        surname.setText("Фамилия: ");
        surname.setBounds(25,25,150,45);
        surname.setFont(new Font(display,"Cambria", 18, SWT.NORMAL));

        Text textSurname = new Text(groupBIO, SWT.CENTER);
        textSurname.setFont(new Font(display,"Cambria", 18, SWT.NORMAL));
        textSurname.setBounds(410,25,230,40);

        Label name = new Label(groupBIO,SWT.NONE);
        name.setText("Имя: ");
        name.setBounds(25,70,150,45);
        name.setFont(new Font(display,"Cambria", 18, SWT.NORMAL));

        Text textName = new Text(groupBIO, SWT.CENTER);
        textName.setFont(new Font(display,"Cambria", 18, SWT.NORMAL));
        textName.setBounds(410,70,230,40);

        Label secondName = new Label(groupBIO,SWT.NONE);
        secondName.setText("Отчество: ");
        secondName.setBounds(25,115,150,45);
        secondName.setFont(new Font(display,"Cambria", 18, SWT.NORMAL));

        Text textSecondName = new Text(groupBIO, SWT.CENTER);
        textSecondName.setFont(new Font(display,"Cambria", 18, SWT.NORMAL));
        textSecondName.setBounds(410,115,230,40);

        Label phoneNumMob = new Label(groupBIO,SWT.NONE);
        phoneNumMob.setText("Мобильный телефон(80...): ");
        phoneNumMob.setBounds(25,180,385,45);
        phoneNumMob.setFont(new Font(display,"Cambria", 18, SWT.NORMAL));

        Text textPhoneNummMob = new Text(groupBIO, SWT.CENTER);
        textPhoneNummMob.setFont(new Font(display,"Cambria", 18, SWT.NORMAL));
        textPhoneNummMob.setBounds(410,180,230,40);

        Label phone = new Label(groupBIO,SWT.NONE);
        phone.setText("Городской телефон(80...): ");
        phone.setBounds(25,225,380,45);
        phone.setFont(new Font(display,"Cambria", 18, SWT.NORMAL));

        Text textPhoneNumber = new Text(groupBIO, SWT.CENTER);
        textPhoneNumber.setFont(new Font(display,"Cambria", 18, SWT.NORMAL));
        textPhoneNumber.setBounds(410,225,230,40);

        Label country = new Label(groupBIO,SWT.NONE);
        country.setText("Страна:");
        country.setBounds(25,290,300,45);
        country.setFont(new Font(display,"Cambria", 18, SWT.NORMAL));

        Text textCountry = new Text(groupBIO, SWT.CENTER);
        textCountry.setFont(new Font(display,"Cambria", 18, SWT.NORMAL));
        textCountry.setBounds(410,290,230,40);

        Label state = new Label(groupBIO,SWT.NONE);
        state.setText("Область/Штат/Округ:");
        state.setBounds(25,335,300,45);
        state.setFont(new Font(display,"Cambria", 18, SWT.NORMAL));

        Text textState = new Text(groupBIO, SWT.CENTER);
        textState.setFont(new Font(display,"Cambria", 18, SWT.NORMAL));
        textState.setBounds(410,335,230,40);

        Label city = new Label(groupBIO,SWT.NONE);
        city.setText("Город:");
        city.setBounds(25,380,300,45);
        city.setFont(new Font(display,"Cambria", 18, SWT.NORMAL));

        Text textCity = new Text(groupBIO, SWT.CENTER);
        textCity.setFont(new Font(display,"Cambria", 18, SWT.NORMAL));
        textCity.setBounds(410,380,230,40);

        Label street = new Label(groupBIO,SWT.NONE);
        street.setText("Улица:");
        street.setBounds(25,425,300,45);
        street.setFont(new Font(display,"Cambria", 18, SWT.NORMAL));

        Text textStreet = new Text(groupBIO, SWT.CENTER);
        textStreet.setFont(new Font(display,"Cambria", 18, SWT.NORMAL));
        textStreet.setBounds(410,425,230,40);

        Label houseNumber = new Label(groupBIO,SWT.NONE);
        houseNumber.setText("Дом:");
        houseNumber.setBounds(25,470,300,45);
        houseNumber.setFont(new Font(display,"Cambria", 18, SWT.NORMAL));

        Text textHouseNumber = new Text(groupBIO, SWT.CENTER);
        textHouseNumber.setFont(new Font(display,"Cambria", 18, SWT.NORMAL));
        textHouseNumber.setBounds(410,470,230,40);

        Label flatNubmer = new Label(groupBIO,SWT.NONE);
        flatNubmer.setText("Квартира:");
        flatNubmer.setBounds(25,515,300,45);
        flatNubmer.setFont(new Font(display,"Cambria", 18, SWT.NORMAL));

        Text textFlatNubmer = new Text(groupBIO, SWT.CENTER);
        textFlatNubmer.setFont(new Font(display,"Cambria", 18, SWT.NORMAL));
        textFlatNubmer.setBounds(410,515,230,40);

        Button buttonAdd = new Button(groupBIO, SWT.PUSH);
        buttonAdd.setBounds(410,575,110,45);
        buttonAdd.setText("Добавить");
        buttonAdd.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e){
                if(textName.getText().isEmpty() || textSurname.getText().length()==0 ||
                        textSecondName.getText().length()==0 || textCountry.getText().length()==0 ||
                        textCity.getText().length()==0 || textState.getText().length()==0 ||
                        textStreet.getText().length()==0 || textPhoneNumber.getText().length()==0 ||
                        textPhoneNummMob.getText().length()==0||textHouseNumber.getText().length()==0 ||
                        textFlatNubmer.getText().length()==0){
                    MessageBox WAR = new MessageBox(shell);
                    WAR.setMessage("Остались незаполненные поля!");
                    WAR.open();
                }
                else{
                Student student = new Student();
                student.setName(textName.getText());
                student.setSurname(textSurname.getText());
                student.setSecondName(textSecondName.getText());
                Phone phone = new Phone();
                student.phone = phone;
                phone.setPhoneNumber(textPhoneNumber.getText());
                phone.setPhoneNumMob(textPhoneNummMob.getText());
                Address address = new Address();
                student.address = address;
                address.setCountry(textCountry.getText());
                address.setState(textState.getText());
                address.setCity(textCity.getText());
                address.setStreet(textStreet.getText());
                address.setHouseNumber(textHouseNumber.getText());
                address.setFlatNumber(textFlatNubmer.getText());
                controller.add(student);


                MessageBox message = new MessageBox(shell);
                message.setMessage("Запись успешно добавлена");
                message.open();
                shell.close();
                }
            }
        });

        Button buttonAbort = new Button(groupBIO, SWT.PUSH);
        buttonAbort.setBounds(530,575,110,45);
        buttonAbort.setText("Отмена");
        buttonAbort.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                shell.close();
            }
        });
    }
}
