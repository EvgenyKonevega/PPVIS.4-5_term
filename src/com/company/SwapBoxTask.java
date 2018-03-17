package com.company;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.RowData;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.*;

public class SwapBoxTask {

    public void start(Shell shell){

        Group group = new Group(shell, SWT.SHADOW_IN);
        group.setText("SwapBox Task:");
        RowLayout rowLayout = new RowLayout(SWT.HORIZONTAL);
        group.setLayoutData(new RowData(260,75));
        rowLayout.wrap = true;
        rowLayout.justify = true;
        rowLayout.pack = true;
        group.setLayout(rowLayout);

        Button button1 = new Button(group, SWT.PUSH), button2 = new Button(group, SWT.PUSH);
        Text text = new Text(group, SWT.NO);

        button1.setLayoutData(new RowData(60,25));
        button2.setLayoutData(new RowData(60,25));

        button1.addSelectionListener(new SelectionListener() {
            @Override
            public void widgetSelected(SelectionEvent selectionEvent) {
                if(!text.getText().isEmpty()){
                    button2.setText(text.getText());
                    text.setText("");
                }
                else{
                    MessageBox warningText = new MessageBox(shell);
                    warningText.setMessage("Input text!");
                    warningText.open();
                }
            }
            @Override
            public void widgetDefaultSelected(SelectionEvent selectionEvent) {
            }
        });

        button2.addSelectionListener(new SelectionListener() {
            @Override
            public void widgetSelected(SelectionEvent selectionEvent) {
                if (!button2.getText().isEmpty()) {
                    String swap_text = button1.getText();
                    button1.setText(button2.getText());
                    button2.setText(swap_text);
                } else {
                    MessageBox warningBut = new MessageBox(shell);
                    warningBut.setMessage("The button has no name!");
                    warningBut.open();
                }
            }
            @Override
            public void widgetDefaultSelected(SelectionEvent selectionEvent) {
            }
        });
    }
}
