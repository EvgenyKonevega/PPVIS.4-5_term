package com.company;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.layout.RowData;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.*;

public class CheckBoxTask {
    private Group group;
    public void start(Shell shell){
        group = new Group(shell, SWT.SHADOW_IN);
        group.setText("CheckBox Task:");
        group.setLayoutData(new RowData(130,75));
        RowLayout rowLayout = new RowLayout(SWT.HORIZONTAL);
        group.setLayout(rowLayout);
        rowLayout.wrap = true;
        rowLayout.pack = true;
        rowLayout.justify = true;

        Text text = new Text(group, SWT.NO);
        Button button = new Button(group, SWT.PUSH);
        button.setText("Click");
        Button checkbutton[] = new Button[3];
        checkbutton[0] = new Button(group, SWT.CHECK);
        checkbutton[1] = new Button(group, SWT.CHECK);
        checkbutton[2] = new Button(group, SWT.CHECK);

        checkbutton[0].setText("Check");
        checkbutton[1].setText("Button");
        checkbutton[2].setText("Task");

        button.addSelectionListener(new SelectionListener() {
            @Override
            public void widgetSelected(SelectionEvent selectionEvent) {
                if(!text.getText().isEmpty()){
                    if(text.getText().equals(checkbutton[0].getText())){
                        checkbutton[0].setSelection(!checkbutton[0].getSelection());
                    }
                    else if(text.getText().equals(checkbutton[1].getText())) {
                        checkbutton[1].setSelection(!checkbutton[1].getSelection());
                    }
                    else if(text.getText().equals(checkbutton[2].getText())) {
                        checkbutton[2].setSelection(!checkbutton[2].getSelection());
                    }
                    else {
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

    public void changeColor(Color color){
        group.setBackground(color);
    }
}
