package view;

import controller.Controller;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;

public class SearchDisplay {

    private Display display = ParentDisplay.display;
    private Shell shell = new Shell(display);
    public Table table = new Table(shell, SWT.SINGLE | SWT.FULL_SELECTION | SWT.V_SCROLL | SWT.H_SCROLL);

    public SearchDisplay() {

        shell.setText("Search students");
        shell.setBackground(ParentDisplay.display.getSystemColor(SWT.COLOR_GRAY));

        Rectangle rectangle = shell.getDisplay().getBounds();

        Point p = shell.getSize();
        int Left = (rectangle.width - p.x) / 2;
        int Top = (rectangle.height - p.y) / 2;
        shell.setBounds(Left, Top, p.x, p.y);
        search();
        shell.open();
    }

    public void search(){
        Criterions criterions = new Criterions();
        criterions.setCriterions(shell);
        StudentsTable studentsTable = new StudentsTable(shell, table);
    }
}
