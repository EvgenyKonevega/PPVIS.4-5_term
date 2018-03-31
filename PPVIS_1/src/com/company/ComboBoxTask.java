package com.company;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.layout.RowData;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.*;

import java.util.Vector;

public class ComboBoxTask {
    private Group group;
    private RowLayout rowLayout = new RowLayout(SWT.HORIZONTAL);
    public void start(Shell shell){

        group = new Group(shell, SWT.SHADOW_IN);
        group.setText("ComoBox Task:");

        group.setLayoutData(new RowData(260,75));
        rowLayout.wrap = true;
        rowLayout.pack = true;
        rowLayout.justify = true;
        group.setLayout(rowLayout);

        MessageBox warning = new MessageBox(shell);
        warning.setMessage("TEXT IS ALREDY EXIST!");

        MessageBox textwarn = new MessageBox(shell);
        textwarn.setMessage("There is nothing to insert!");

        Vector<String> vector = new Vector<>();

        Text text = new Text(group,SWT.NO);
        Combo combo = new Combo(group,SWT.READ_ONLY);
        Button button = new Button(group,SWT.PUSH);
        button.setText("Add this word");

        button.addSelectionListener(new SelectionListener() {
            @Override
            public void widgetSelected(SelectionEvent selectionEvent) {
                if (!text.getText().isEmpty()) {
                    if (!vector.contains(text.getText())) {
                        combo.add(text.getText());
                        vector.add(text.getText());
                        text.setText("");
                    } else {
                        warning.open();
                        text.setText("");
                    }
                } else {
                    textwarn.open();
                }
            }
            @Override
            public void widgetDefaultSelected(SelectionEvent selectionEvent) {
            }
        });
    }

    public void changeColor(Color color){ group.setBackground(color); }
}
