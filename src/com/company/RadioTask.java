package com.company;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.RowData;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.*;

public class RadioTask {

    public void start(Shell shell){

        Group group = new Group(shell, SWT.SHADOW_IN);
        group.setText("Radio Task:");
        RowLayout rowLayout = new RowLayout(SWT.HORIZONTAL);
        group.setLayoutData(new RowData(130,75));
        group.setLayout(rowLayout);
        rowLayout.wrap = true;
        rowLayout.pack = true;
        rowLayout.justify = true;

        Text text = new Text(group, SWT.NO);
        Button button = new Button(group,SWT.PUSH);
        button.setText("Click");

        Button radiobutton[] = new Button[3];
        radiobutton[0] = new Button(group, SWT.RADIO);
        radiobutton[1] = new Button(group, SWT.RADIO);
        radiobutton[2] = new Button(group, SWT.RADIO);

        radiobutton[0].setText("First");
        radiobutton[1].setText("Second");
        radiobutton[2].setText("Third");


        button.addSelectionListener(new SelectionListener() {
            @Override
            public void widgetSelected(SelectionEvent selectionEvent) {
                if (!text.getText().isEmpty()) {
                    if (text.getText().equals(radiobutton[0].getText())) {
                        radiobutton[0].setSelection(true);
                        radiobutton[1].setSelection(false);
                        radiobutton[2].setSelection(false);
                    } else if (text.getText().equals(radiobutton[1].getText())) {
                        radiobutton[0].setSelection(false);
                        radiobutton[1].setSelection(true);
                        radiobutton[2].setSelection(false);
                    } else if (text.getText().equals(radiobutton[2].getText())) {
                        radiobutton[0].setSelection(false);
                        radiobutton[1].setSelection(false);
                        radiobutton[2].setSelection(true);
                    } else{
                        MessageBox war = new MessageBox(shell);
                        war.setMessage("Wrong name!");
                        war.open();
                    }
                }
                else{
                    MessageBox WARNING = new MessageBox(shell);
                    WARNING.setMessage("Field is empty!");
                    WARNING.open();
                }
            }
            @Override
            public void widgetDefaultSelected(SelectionEvent selectionEvent) {
            }
        });
    }
}
