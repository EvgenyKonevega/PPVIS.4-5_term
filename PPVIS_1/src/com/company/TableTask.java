package com.company;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.layout.RowData;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.*;

public class TableTask {
    private Group group;
    public void start(Shell shell){
        group = new Group(shell, SWT.SHADOW_IN);
        group.setText("Table Task:");
        group.setLayoutData(new RowData(210,150));
        RowLayout rowLayout = new RowLayout();
        group.setLayout(rowLayout);
        rowLayout.wrap = true;
        rowLayout.pack = true;
        rowLayout.justify = false;

        MessageBox warning = new MessageBox(shell);
        warning.setMessage("Input text!");

        Text text = new Text(group, SWT.NO);
        Button button1 = new Button(group, SWT.PUSH);
        button1.setText("To the first column");
        Button button2 = new Button(group, SWT.PUSH);
        button2.setText("From the first to the second column");
        Button button3 = new Button(group, SWT.PUSH);
        button3.setText("Back to the first column");

        Table table = new Table(group, SWT.BORDER);
        table.setLayoutData(new RowData(185,20));
        table.setLinesVisible(true);
        TableColumn column1 = new TableColumn(table, SWT.NULL);
        TableColumn column2 = new TableColumn(table, SWT.NULL);
        column1.setWidth(100);
        column2.setWidth(100);

        TableItem tableItem = new TableItem(table, SWT.CHECK);

        button1.addSelectionListener(new SelectionListener() {
            @Override
            public void widgetSelected(SelectionEvent selectionEvent) {
                if(!text.getText().isEmpty()){
                    tableItem.setText(0, text.getText());
                    text.setText("");
                }
                else warning.open();
            }
            @Override
            public void widgetDefaultSelected(SelectionEvent selectionEvent) {
            }
        });

        button2.addSelectionListener(new SelectionListener() {
            @Override
            public void widgetSelected(SelectionEvent selectionEvent) {
                if(!tableItem.getText(0).isEmpty()){
                    tableItem.setText(1, tableItem.getText(0));
                    tableItem.setText(0, "");
                }
                else warning.open();
            }
            @Override
            public void widgetDefaultSelected(SelectionEvent selectionEvent) {
            }
        });
        button3.addSelectionListener(new SelectionListener() {
            @Override
            public void widgetSelected(SelectionEvent selectionEvent) {
                if(!tableItem.getText(1).isEmpty()){
                    tableItem.setText(0,tableItem.getText(1));
                    tableItem.setText(1, "");
                }
                else warning.open();
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

