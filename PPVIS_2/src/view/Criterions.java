package view;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.*;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

public class Criterions {

    public void setCriterions(Shell shell){

        Label hseparatorT = new Label(shell, SWT.HORIZONTAL | SWT.SEPARATOR);
        hseparatorT.setBounds(1,20,1007,3);

        Label surname = new Label(shell,SWT.NONE);
        surname.setText("Фамилия:");
        surname.setBounds(5,25,55,15);
        surname.setBackground(ParentDisplay.display.getSystemColor(SWT.COLOR_GRAY));

        Text textSurname = new Text(shell, SWT.CENTER);
        textSurname.setBounds(65,25,80,15);

        Label phone = new Label(shell,SWT.NONE);
        phone.setText("Телефон:");
        phone.setBounds(155,25,60,15);
        phone.setBackground(ParentDisplay.display.getSystemColor(SWT.COLOR_GRAY));

        Text textPhone = new Text(shell, SWT.CENTER);
        textPhone.setBounds(220,25,80,15);

        Label country = new Label(shell,SWT.NONE);
        country.setText("Страна:");
        country.setBounds(5,43,45,15);

        Text textCountry = new Text(shell, SWT.CENTER);
        textCountry.setBounds(55,43,80,15);
        country.setBackground(ParentDisplay.display.getSystemColor(SWT.COLOR_GRAY));

        Label state = new Label(shell,SWT.NONE);
        state.setText("Область/Штат/Округ:");
        state.setBounds(140,43,125,15);
        state.setBackground(ParentDisplay.display.getSystemColor(SWT.COLOR_GRAY));

        Text textState = new Text(shell, SWT.CENTER);
        textState.setBounds(270,43,100,15);

        Label city = new Label(shell,SWT.NONE);
        city.setText("Город:");
        city.setBounds(375,43,45,15);
        city.setBackground(ParentDisplay.display.getSystemColor(SWT.COLOR_GRAY));

        Text textCity = new Text(shell, SWT.CENTER);
        textCity.setBounds(425,43,100,15);

        Label street = new Label(shell,SWT.NONE);
        street.setText("Улица:");
        street.setBounds(530,43,45,15);
        street.setBackground(ParentDisplay.display.getSystemColor(SWT.COLOR_GRAY));

        Text textStreet = new Text(shell, SWT.CENTER);
        textStreet.setBounds(580,43,100,15);

        Label houseNumber = new Label(shell,SWT.NONE);
        houseNumber.setText("Дом:");
        houseNumber.setBounds(685,43,30,15);
        houseNumber.setBackground(ParentDisplay.display.getSystemColor(SWT.COLOR_GRAY));

        Text textHouseNumber = new Text(shell, SWT.CENTER);
        textHouseNumber.setBounds(720,43,30,15);

        Label flatNumber = new Label(shell,SWT.NONE);
        flatNumber.setText("Квартира:");
        flatNumber.setBounds(755,43,55,15);
        flatNumber.setBackground(ParentDisplay.display.getSystemColor(SWT.COLOR_GRAY));

        Text textFlatNubmer = new Text(shell, SWT.CENTER);
        textFlatNubmer.setBounds(815,43,30,15);

        Label digits = new Label(shell, SWT.NONE);
        digits.setText("Цифры одного из номеров:");
        digits.setBounds(315,25,155,15);
        digits.setBackground(ParentDisplay.display.getSystemColor(SWT.COLOR_GRAY));

        Text textDigits = new Text(shell, SWT.CENTER);
        textDigits.setBounds(475,25,80,15);

        Label hseparatorB = new Label(shell, SWT.HORIZONTAL | SWT.SEPARATOR);
        hseparatorB.setBounds(1,60,1007,3);

        Button radiobutton[] = new Button[3];
        radiobutton[0] = new Button(shell, SWT.RADIO);
        radiobutton[1] = new Button(shell, SWT.RADIO);
        radiobutton[2] = new Button(shell, SWT.RADIO);

        radiobutton[0].setText("Номер телефона и фамилия");
        radiobutton[0].setBounds(5,3,200,15);
        radiobutton[0].setBackground(ParentDisplay.display.getSystemColor(SWT.COLOR_GRAY));

        radiobutton[1].setText("Номер телефона и адрес");
        radiobutton[1].setBounds(300,3,200,15);
        radiobutton[1].setBackground(ParentDisplay.display.getSystemColor(SWT.COLOR_GRAY));

        radiobutton[2].setText("Фамилии и цифры встречающиеся в одном из номеров");
        radiobutton[2].setBounds(530,3,350,15);
        radiobutton[2].setBackground(ParentDisplay.display.getSystemColor(SWT.COLOR_GRAY));

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
    }
}
