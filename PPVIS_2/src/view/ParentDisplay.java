package view;

import controller.Controller;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.*;
import org.eclipse.swt.widgets.*;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Table;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.File;

public class ParentDisplay {

    public static Display display = new Display();
    public static Shell shell = new Shell(display,SWT.SHELL_TRIM | SWT.CENTER);
    public Table table = new Table(shell, SWT.SINGLE | SWT.FULL_SELECTION | SWT.V_SCROLL | SWT.H_SCROLL);
    private Controller controller = new Controller();

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
        buttonOpenFile.setBounds(15,15,60,60);
        buttonOpenFile.setBackground(display.getSystemColor(SWT.COLOR_WHITE));
        buttonOpenFile.setImage(new Image(display, "images/openFileIcon.png" ));
        buttonOpenFile.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                openFile();
            }
        });

        Button buttonSaveFile = new Button(shell, SWT.PUSH);
        buttonSaveFile.setBounds(93,15,60,60);
        buttonSaveFile.setBackground(display.getSystemColor(SWT.COLOR_WHITE));
        buttonSaveFile.setImage(new Image(display, "images/saveFileIcon.png" ));
        buttonSaveFile.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                saveFile();
            }
        });

        Button buttonAddNewStudent = new Button(shell, SWT.PUSH);
        buttonAddNewStudent.setBounds(171,15,60,60);
        buttonAddNewStudent.setBackground(display.getSystemColor(SWT.COLOR_WHITE));
        buttonAddNewStudent.setImage(new Image(display, "images/add.png" ));
        buttonAddNewStudent.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                AddDisplay addDisplay = new AddDisplay(controller);
            }
        });

        Button buttonDeleteStudent = new Button(shell, SWT.PUSH);
        buttonDeleteStudent.setBounds(249,15,60,60);
        buttonDeleteStudent.setBackground(display.getSystemColor(SWT.COLOR_WHITE));
        buttonDeleteStudent.setImage(new Image(display, "images/delete.png" ));
        buttonDeleteStudent.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                DeleteDisplay deleteDisplay = new DeleteDisplay(controller);
            }
        });

        Button buttonSearchStudent = new Button(shell, SWT.PUSH);
        buttonSearchStudent.setBounds(327,15,60,60);
        buttonSearchStudent.setBackground(display.getSystemColor(SWT.COLOR_WHITE));
        buttonSearchStudent.setImage(new Image(display, "images/search.png" ));
        buttonSearchStudent.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                SearchDisplay searchDisplay = new SearchDisplay(controller);
            }
        });

        Label hseparatorT = new Label(shell, SWT.HORIZONTAL | SWT.SEPARATOR);
        hseparatorT.setBounds(1,85,1410,3);

        StudentsTable studentsTable = new StudentsTable();
        studentsTable.setTable(shell, table, controller);

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

        Label num = new Label(shell, SWT.CENTER);
        num.setFont(new Font(display, "Cambria", 22, SWT.ITALIC));
        num.setBackground(display.getSystemColor(SWT.COLOR_GRAY));
        num.setBounds(275, 95, 40, 40);

        Text numCurrNotes = new Text(shell, SWT.CENTER);
        numCurrNotes.setFont(new Font(display, "Cambria", 22, SWT.ITALIC));
        numCurrNotes.setBounds(395, 150, 55, 40);

        update.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                num.setText(String.valueOf(controller.studentsInfo.getStudents().size()));
            }
        });

        Button updateTable = new Button(shell, SWT.PUSH);
        updateTable.setBounds(460, 150, 150, 40);
        updateTable.setText("Запись в таблицу");
        updateTable.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                if(Integer.parseInt(numCurrNotes.getText()) <= Integer.parseInt(num.getText()) && Integer.parseInt(numCurrNotes.getText()) > 0){
                currentPage.setText("1");
                studentsTable.showNotes(table, controller.studentsInfo.getStudents(), Integer.parseInt(numCurrNotes.getText())*(Integer.parseInt(currentPage.getText())-1), Integer.parseInt(numCurrNotes.getText())*Integer.parseInt(currentPage.getText()));
                int page = (int) Math.ceil(Double.parseDouble(num.getText())/Double.parseDouble(numCurrNotes.getText()));
                pages.setText(String.valueOf(page));
                }
            }
        });

        Button prevPage = new Button(shell, SWT.PUSH);
        prevPage.setBounds(640, 128, 46, 33);
        prevPage.setImage(new Image(display, "images/backIcon.gif"));
        prevPage.setBackground(display.getSystemColor(SWT.COLOR_WHITE));

        prevPage.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent selectionEvent) {
                if(Integer.parseInt(currentPage.getText()) >= 2) {
                    currentPage.setText(String.valueOf(Integer.parseInt(currentPage.getText()) - 1));
                }
                if(Integer.parseInt(currentPage.getText()) < Integer.parseInt(pages.getText())) {
                    studentsTable.showNotes(table, controller.studentsInfo.getStudents(), Integer.parseInt(numCurrNotes.getText())*(Integer.parseInt(currentPage.getText())-1), Integer.parseInt(numCurrNotes.getText())*(Integer.parseInt(currentPage.getText())));
                }
                else if(Integer.parseInt(currentPage.getText()) == Integer.parseInt(pages.getText())){
                    studentsTable.showNotes(table, controller.studentsInfo.getStudents(), Integer.parseInt(numCurrNotes.getText())*(Integer.parseInt(currentPage.getText())-1), 50);
                    //currentPage.setText(String.valueOf(Integer.parseInt(currentPage.getText()) + 1));
                }
            }
        });

        Button nextPage = new Button(shell, SWT.PUSH);
        nextPage.setBounds(1055, 128, 46, 33);
        nextPage.setImage(new Image(display, "images/nextIcon.gif"));
        nextPage.setBackground(display.getSystemColor(SWT.COLOR_WHITE));

        nextPage.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent selectionEvent) {
                if(Integer.parseInt(currentPage.getText()) < Integer.parseInt(pages.getText())) {
                    currentPage.setText(String.valueOf(Integer.parseInt(currentPage.getText()) + 1));
                }
                if(Integer.parseInt(currentPage.getText()) < Integer.parseInt(pages.getText())) {
                    studentsTable.showNotes(table, controller.studentsInfo.getStudents(), Integer.parseInt(numCurrNotes.getText())*(Integer.parseInt(currentPage.getText())-1), Integer.parseInt(numCurrNotes.getText())*(Integer.parseInt(currentPage.getText())));
                }
                else if(Integer.parseInt(currentPage.getText()) == Integer.parseInt(pages.getText())){
                    studentsTable.showNotes(table, controller.studentsInfo.getStudents(), Integer.parseInt(numCurrNotes.getText())*(Integer.parseInt(currentPage.getText())-1), 50);
                }
            }
        });
    }

    public void openFile(){
        FileDialog fileDialog = new FileDialog(shell, SWT.SAVE);
        fileDialog.setText("Open File");
        fileDialog.setFilterPath("E:\\");
        String[] fileExtension = {"*.xml"};
        fileDialog.setFilterExtensions(fileExtension);
        String file = fileDialog.open();
        if(file == null){
            MessageBox warning = new MessageBox(shell);
            warning.setMessage("Не выбран файл");
            warning.setText("Ошибка!");
            warning.open();
        }
        else {
            try {
                controller.openFile(new File(file));
            } catch (ParserConfigurationException e) {
                e.printStackTrace();
            } catch (SAXException e) {
                e.printStackTrace();
            } catch (TransformerException e) {
                e.printStackTrace();
            }
        }
    }

    public void saveFile(){
        FileDialog fileDialog = new FileDialog(shell, SWT.SAVE);
        fileDialog.setText("Save File");
        fileDialog.setFilterPath("E:\\");
        String[] fileExtension = {"*.xml"};
        String[] fileName = {"Students List"};
        fileDialog.setFilterNames(fileName);
        fileDialog.setFilterExtensions(fileExtension);
        String file = fileDialog.open();
        if (file == null){
            MessageBox messageBox = new MessageBox(shell);
            messageBox.setMessage("Выберите файл");
            messageBox.setText("Ошибка!");
            messageBox.open();
        }
        else{
            try {
                controller.saveFile(new File(file));
            } catch (TransformerException e1) {
                e1.printStackTrace();
            }
        }
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
                openFile();
            }
        });
        saveitem.setText("Сохранить");
        saveitem.addListener(SWT.Selection, new Listener() {
            @Override
            public void handleEvent(Event event) {
                saveFile();
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
                new AddDisplay(controller);

            }
        });
        finditem.setText("Найти");
        finditem.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                new SearchDisplay(controller);
            }
        });
        removeitem.setText("Удалить");
        removeitem.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                new DeleteDisplay(controller);
            }
        });
    }
}
