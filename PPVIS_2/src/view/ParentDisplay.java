package view;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.*;
import org.eclipse.swt.widgets.*;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Table;

public class ParentDisplay {

    public static Display display = new Display();
    public static Shell shell = new Shell(display,SWT.SHELL_TRIM | SWT.CENTER);
    public static Table table = new Table(shell, SWT.SINGLE | SWT.FULL_SELECTION | SWT.V_SCROLL | SWT.H_SCROLL);

    public ParentDisplay(){
        shell.setBackground(display.getSystemColor(SWT.COLOR_GRAY));
        shell.setText("PPVIS #2 Dialog windows");

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

        Button buttonOpenFile = new Button(shell, SWT.PUSH);
        buttonOpenFile.setBounds(5,5,40,40);
        buttonOpenFile.setBackground(display.getSystemColor(SWT.COLOR_WHITE));
        buttonOpenFile.setImage(new Image(display, "images/openFileIcon.png" ));

        Button buttonSaveFile = new Button(shell, SWT.PUSH);
        buttonSaveFile.setBounds(48,5,40,40);
        buttonSaveFile.setBackground(display.getSystemColor(SWT.COLOR_WHITE));
        buttonSaveFile.setImage(new Image(display, "images/saveFileIcon.png" ));

        Button buttonAddNewStudent = new Button(shell, SWT.PUSH);
        buttonAddNewStudent.setBounds(91,5,40,40);
        buttonAddNewStudent.setBackground(display.getSystemColor(SWT.COLOR_WHITE));
        buttonAddNewStudent.setImage(new Image(display, "images/add.png" ));
        buttonAddNewStudent.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                AddDisplay addDisplay = new AddDisplay();
            }
        });

        Button buttonDeleteStudent = new Button(shell, SWT.PUSH);
        buttonDeleteStudent.setBounds(134,5,40,40);
        buttonDeleteStudent.setBackground(display.getSystemColor(SWT.COLOR_WHITE));
        buttonDeleteStudent.setImage(new Image(display, "images/delete.png" ));
        buttonDeleteStudent.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                DeleteDisplay deleteDisplay = new DeleteDisplay();
            }
        });

        Button buttonSearchStudent = new Button(shell, SWT.PUSH);
        buttonSearchStudent.setBounds(177,5,40,40);
        buttonSearchStudent.setBackground(display.getSystemColor(SWT.COLOR_WHITE));
        buttonSearchStudent.setImage(new Image(display, "images/search.png" ));
        buttonSearchStudent.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                SearchDisplay searchDisplay = new SearchDisplay();
            }
        });

        Label hseparatorT = new Label(shell, SWT.HORIZONTAL | SWT.SEPARATOR);
        hseparatorT.setBounds(1,50,1007,3);

        table.setBounds(3,105, 1003, 233);
        table.setHeaderVisible(true);
        table.setLinesVisible(true);
        StudentsTable studentsTable = new StudentsTable(shell, table);

    }

    public void popupMenu(){
        Menu menubar = new Menu(shell, SWT.BAR);
        Menu submenu = new Menu(shell, SWT.DROP_DOWN);
        Menu submenu1 = new Menu(shell, SWT.DROP_DOWN);
        MenuItem fileitem = new MenuItem(menubar, SWT.CASCADE);
        MenuItem edititem = new MenuItem(menubar, SWT.CASCADE);
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
        openitem.setText("Открыть");
        openitem.addListener(SWT.Selection, new Listener() {
            @Override
            public void handleEvent(Event event) {

            }
        });
        saveitem.setText("Сохранить");
        saveitem.addListener(SWT.Selection, new Listener() {
            @Override
            public void handleEvent(Event event) {

            }
        });
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
                new AddDisplay();
            }
        });
        finditem.setText("Найти");
        finditem.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                new SearchDisplay();
            }
        });
        removeitem.setText("Удалить");
        removeitem.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                new DeleteDisplay();
            }
        });
    }
}
