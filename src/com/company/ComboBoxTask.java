package com.company;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.RowData;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.*;
import java.util.Vector;

public class ComboBoxTask {

    public void start(Shell shell){

        Group group = new Group(shell, SWT.SHADOW_IN);
        group.setText("ComoBox Task:");
        RowLayout rowLayout = new RowLayout(SWT.HORIZONTAL);
        group.setLayoutData(new RowData(260,75));
        rowLayout.wrap = true;
        rowLayout.pack = true;
        rowLayout.justify = true;
        group.setLayout(rowLayout);

        Vector<String> vector = new Vector<String>();

        Text text = new Text(group,SWT.NO);
        Combo combo = new Combo(group,SWT.READ_ONLY);
        Button button = new Button(group,SWT.PUSH);
        button.setText("Add this word");

     /*
        button.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent selectionEvent) {
                if (!text.getText().isEmpty()) {
                    if (!vector.contains(text.getText())) {
                        combo.add(text.getText());
                        vector.add(text.getText());
                        text.setText("");
                    } else {
                        MessageBox warning = new MessageBox(shell);
                        warning.setMessage("TEXT IS ALREDY EXIST!");
                        warning.open();
                        text.setText("");
                    }
                } else {
                    MessageBox textwarn = new MessageBox(shell);
                    textwarn.setMessage("There is nothing to insert!");
                    textwarn.open();
                }
            }
        });
    */
        button.addSelectionListener(new SelectionListener() {
            @Override
            public void widgetSelected(SelectionEvent selectionEvent) {
                if (!text.getText().isEmpty()) {
                    if (!vector.contains(text.getText())) {
                        combo.add(text.getText());
                        vector.add(text.getText());
                        text.setText("");
                    } else {
                        MessageBox warning = new MessageBox(shell);
                        warning.setMessage("TEXT IS ALREDY EXIST!");
                        warning.open();
                        text.setText("");
                    }
                } else {
                    MessageBox textwarn = new MessageBox(shell);
                    textwarn.setMessage("There is nothing to insert!");
                    textwarn.open();
                }
            }
            @Override
            public void widgetDefaultSelected(SelectionEvent selectionEvent) {
            }
        });
    }
}
