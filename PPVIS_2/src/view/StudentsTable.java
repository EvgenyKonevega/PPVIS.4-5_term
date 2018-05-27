package view;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.*;

public class StudentsTable {

    private Display display = ParentDisplay.display;

    public StudentsTable(Shell shell, Table table){

        Label numOfNotes = new Label(shell, SWT.NONE);
        numOfNotes.setBounds(5,55,85,15);
        numOfNotes.setText("Всего записей: ");

        Label num = new Label(shell, SWT.CENTER);
        num.setBounds(95,55,20,15);

        Label showNotes = new Label(shell, SWT.NONE);
        showNotes.setBounds(5,75,120,15);
        showNotes.setText("Отображать записей: ");

        Text numCurrNotes = new Text(shell, SWT.CENTER);
        numCurrNotes.setBounds(130,75,20,15);

        Label page = new Label(shell, SWT.NONE);
        page.setFont(new Font(display,"Cambria", 22, SWT.ITALIC));
        page.setText("Страница:");
        page.setBounds(400,62,145,33);

        Label of = new Label(shell, SWT.NONE);
        of.setFont(new Font(display,"Cambria", 22, SWT.ITALIC));
        of.setText("из:");
        of.setBounds(600,62,40,33);

        Text currentPage = new Text(shell, SWT.CENTER);
        currentPage.setBounds(555,62,30,33);
        currentPage.setFont(new Font(display,"Cambria", 22, SWT.ITALIC));

        Label pages = new Label(shell, SWT.NONE);
        pages.setFont(new Font(display,"Cambria", 22, SWT.ITALIC));
        pages.setBounds(653,62,30,33);

        Button prevPage = new Button(shell, SWT.PUSH);
        prevPage.setBounds(346,62,46,33);
        prevPage.setImage(new Image(display, "images/backIcon.gif"));
        prevPage.setBackground(display.getSystemColor(SWT.COLOR_WHITE));

        Button nextPage = new Button(shell, SWT.PUSH);
        nextPage.setBounds(690,62,46,33);
        nextPage.setImage(new Image(display, "images/nextIcon.gif"));
        nextPage.setBackground(display.getSystemColor(SWT.COLOR_WHITE));

        Label hseparatorB = new Label(shell, SWT.HORIZONTAL | SWT.SEPARATOR);
        hseparatorB.setBounds(1,100,1007,3);

        TableColumn n = new TableColumn(table,SWT.CENTER);
        n.setText("№");
        n.setWidth(25);

        TableColumn fio = new TableColumn(table, SWT.CENTER);
        fio.setText("ФИО Студента");
        fio.setWidth(325);

        TableColumn adress = new TableColumn(table, SWT.CENTER);
        adress.setText("Адрес прописки");
        adress.setWidth(325);

        TableColumn mobilePhone = new TableColumn(table, SWT.RIGHT);
        mobilePhone.setText("Мобильный телефон");
        mobilePhone.setWidth(164);

        TableColumn phone = new TableColumn(table, SWT.RIGHT);
        phone.setText("Городской телефон");
        phone.setWidth(164);
    }

}
