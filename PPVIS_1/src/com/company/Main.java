package com.company;

import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

public class Main {

    private static int horizontal = 400;
    private static int vertical = 200;

    public static void main(String[] args){

        Display display = new Display();
        Shell shell = new Shell(display);
        shell.setText("PPVIS_1");
        shell.setBounds(horizontal, vertical, 560, 340);
        RowLayout rowLayout = new RowLayout();
        shell.setLayout(rowLayout);
        rowLayout.wrap = true;
        rowLayout.pack = true;
        rowLayout.justify = false;

        //Image image = new Image(display, "res/background.jpg");
        new SwapColors().start(shell);

        shell.open();
        while(!shell.isDisposed()) {
            if (!display.readAndDispatch())
                display.sleep();
        }
        display.dispose();
    }
}
