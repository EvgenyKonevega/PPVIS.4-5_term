package Veiw;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.*;
import org.eclipse.swt.widgets.*;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;

public class ParentDisplay {

    public static Display display = new Display();
    public static Shell shell;
    private Table table;

    public ParentDisplay(){
        shell = new Shell(display,SWT.SHELL_TRIM | SWT.CENTER);
        shell.setBackground(display.getSystemColor(SWT.COLOR_GRAY));
        shell.setText("PPVIS #2 Dialog windows");
        shell.setLayout(new FormLayout());

        disposeWindow();
        parentWindow();

        shell.open();
        while(!shell.isDisposed()){
            if(!display.readAndDispatch()){
                display.sleep();
            }
        }
        display.dispose();
    }

    public void disposeWindow() {

        Rectangle rectangle = shell.getDisplay().getBounds();

        Point p = shell.getSize();
        int Left = (rectangle.width - p.x) / 2;
        int Top = (rectangle.height - p.y) / 2;
        shell.setBounds(Left, Top, p.x, p.y);
    }

    public void parentWindow() {

        popupMenu();

        FormData fd = new FormData();
        Button buttonNewFile = new Button(shell, SWT.PUSH);
        fd.top = new FormAttachment(0, 3);
        fd.left = new FormAttachment(0, 1);
        buttonNewFile.setLayoutData(fd);
        buttonNewFile.setBackground(display.getSystemColor(SWT.COLOR_WHITE));
        buttonNewFile.setImage(new Image(display, "images/newIcon.png" ));

        Button buttonOpenFile = new Button(shell, SWT.PUSH);
        fd = new FormData();
        fd.top = new FormAttachment(0, 3);
        fd.left = new FormAttachment(buttonNewFile, 3);
        buttonOpenFile.setLayoutData(fd);
        buttonOpenFile.setBackground(display.getSystemColor(SWT.COLOR_WHITE));
        buttonOpenFile.setImage(new Image(display, "images/openFileIcon.png" ));

        Button buttonSaveFile = new Button(shell, SWT.PUSH);
        fd = new FormData();
        fd.top = new FormAttachment(0, 3);
        fd.left = new FormAttachment(buttonOpenFile, 3);
        buttonSaveFile.setLayoutData(fd);
        buttonSaveFile.setBackground(display.getSystemColor(SWT.COLOR_WHITE));
        buttonSaveFile.setImage(new Image(display, "images/saveFileIcon.png" ));

        Button buttonAddNewStudent = new Button(shell, SWT.PUSH);
        fd = new FormData();
        fd.top = new FormAttachment(0, 3);
        fd.left = new FormAttachment(buttonSaveFile, 3);
        buttonAddNewStudent.setLayoutData(fd);
        buttonAddNewStudent.setBackground(display.getSystemColor(SWT.COLOR_WHITE));
        buttonAddNewStudent.setImage(new Image(display, "images/add.png" ));

        Button buttonDeleteStudent = new Button(shell, SWT.PUSH);
        fd = new FormData();
        fd.top = new FormAttachment(0, 3);
        fd.left = new FormAttachment(buttonAddNewStudent, 3);
        buttonDeleteStudent.setLayoutData(fd);
        buttonDeleteStudent.setBackground(display.getSystemColor(SWT.COLOR_WHITE));
        buttonDeleteStudent.setImage(new Image(display, "images/delete.png" ));

        Button buttonSearchStudent = new Button(shell, SWT.PUSH);
        fd = new FormData();
        fd.top = new FormAttachment(0, 3);
        fd.left = new FormAttachment(buttonDeleteStudent, 3);
        buttonSearchStudent.setLayoutData(fd);
        buttonSearchStudent.setBackground(display.getSystemColor(SWT.COLOR_WHITE));
        buttonSearchStudent.setImage(new Image(display, "images/search.png" ));

        Label hseparator = new Label(shell, SWT.HORIZONTAL | SWT.SEPARATOR | SWT.FILL);

        fd = new FormData();
        fd.top = new FormAttachment(buttonNewFile, 5);
        fd.left = new FormAttachment(50, 3);

        hseparator.setLayoutData(fd);

        table = new Table(shell,SWT.SINGLE | SWT.FULL_SELECTION | SWT.V_SCROLL | SWT.H_SCROLL);
        fd = new FormData();
        fd.top = new FormAttachment(hseparator, 3);
        fd.left = new FormAttachment(0, 3);
        fd.bottom = new FormAttachment(57, 0);
        table.setLayoutData(fd);
        table.setHeaderVisible(true);
        table.setLinesVisible(true);

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




        Label shownotes = new Label(shell, SWT.NONE);
        shownotes.setBackground(display.getSystemColor(SWT.COLOR_GRAY));
        shownotes.setText("Отображать записей на странице:");



    }

    public void popupMenu(){
        Menu menubar = new Menu(shell, SWT.BAR);
        Menu submenu = new Menu(shell, SWT.DROP_DOWN);
        Menu submenu1 = new Menu(shell, SWT.DROP_DOWN);
        MenuItem fileitem = new MenuItem(menubar, SWT.CASCADE);
        MenuItem edititem = new MenuItem(menubar, SWT.CASCADE);
        MenuItem newitem = new MenuItem(submenu, SWT.PUSH);
        MenuItem openitem = new MenuItem(submenu, SWT.PUSH);
        MenuItem saveitem = new MenuItem(submenu, SWT.PUSH);
        MenuItem separator = new MenuItem(submenu,SWT.SEPARATOR);
        MenuItem exititem = new MenuItem(submenu, SWT.PUSH);
        MenuItem additem = new MenuItem(submenu1, SWT.PUSH);
        MenuItem finditem = new MenuItem(submenu1, SWT.PUSH);
        MenuItem removeitem = new MenuItem(submenu1, SWT.PUSH);
        shell.setMenuBar(menubar);

        fileitem.setText("Файл");
        fileitem.setMenu(submenu);
        /**
         * Добавить слушатели для кнопок вкладки file
         */
        newitem.setText("Создать");
        openitem.setText("Открыть");
        saveitem.setText("Сохранить");


        exititem.setText("Выход");
        exititem.addListener(SWT.Selection, new Listener() {
            @Override
            public void handleEvent(Event event) {
                System.exit(0);
            }
        });

        edititem.setText("Редактировать");
        edititem.setMenu(submenu1);
        additem.setText("Добавить");
        additem.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                AddDisplay addDisplay = new AddDisplay();
            }
        });
        finditem.setText("Найти");
        finditem.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                SearchDisplay searchDisplay = new SearchDisplay();
            }
        });
        removeitem.setText("Удалить");
        removeitem.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                DeleteDisplay deleteDisplay = new DeleteDisplay();
            }
        });
    }
}
