package com.company;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Device;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

import java.util.ArrayList;
import java.util.List;

public class SwapColors {

    private boolean isStopPressed;
    private boolean isStartPressed = false;
    private ComboBoxTask combbt = new ComboBoxTask();
    private SwapBoxTask sbt = new SwapBoxTask();
    private RadioTask rt = new RadioTask();
    private CheckBoxTask checkbt = new CheckBoxTask();
    private TableTask tt = new TableTask();
    private Thread th;
    private int num = 1;

    public void start(Shell shell){
        combbt.start(shell);
        sbt.start(shell);
        rt.start(shell);
        checkbt.start(shell);
        tt.start(shell);

        Button buttonStart = new Button(shell, SWT.PUSH);
        Button buttonStop = new Button(shell,SWT.PUSH);
        buttonStart.setText("START");
        buttonStop.setText("STOP");

        Device device = Display.getCurrent();
        List<Color> colors = new ArrayList<>();
        colors.add(device.getSystemColor(SWT.COLOR_BLUE));
        colors.add(device.getSystemColor(SWT.COLOR_GREEN));
        colors.add(device.getSystemColor(SWT.COLOR_DARK_MAGENTA));
        colors.add(device.getSystemColor(SWT.COLOR_DARK_CYAN));
        colors.add(device.getSystemColor(SWT.COLOR_YELLOW));

        tt.changeColor(colors.get(0));
        checkbt.changeColor(colors.get(1));
        rt.changeColor(colors.get(2));
        sbt.changeColor(colors.get(3));
        combbt.changeColor(colors.get(4));

        buttonStart.addSelectionListener(new SelectionListener() {
            @Override
            public void widgetSelected(SelectionEvent selectionEvent) {
                if (!isStartPressed) {
                    isStartPressed = true;
                    isStopPressed = false;
                    th = new Thread(new Runnable() {
                        @Override
                        public void run() {
                            while ((!isStopPressed) & (isStartPressed)) {
                                try {
                                    Thread.sleep(1000);
                                } catch (InterruptedException ex) {
                                }
                                Display.getDefault().asyncExec(new Runnable() {
                                    @Override
                                    public void run() {
                                        tt.changeColor(colors.get((num) % 5));
                                        checkbt.changeColor(colors.get((num + 1) % 5));
                                        rt.changeColor(colors.get((num + 2) % 5));
                                        sbt.changeColor(colors.get((num + 3) % 5));
                                        combbt.changeColor(colors.get((num + 4) % 5));
                                        num = (num + 1) % 5;
                                    }
                                });
                            }
                        }
                    });
                    th.start();
                }
            }
            @Override
            public void widgetDefaultSelected(SelectionEvent selectionEvent) {
            }
        });

        buttonStop.addSelectionListener(new SelectionListener() {
            @Override
            public void widgetSelected(SelectionEvent selectionEvent) {
                isStopPressed = true;
                isStartPressed = false;
                th.interrupt();
            }
            @Override
            public void widgetDefaultSelected(SelectionEvent selectionEvent) {
            }
        });
    }
}
