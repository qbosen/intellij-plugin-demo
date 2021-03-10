package com.github.qbosen.intellijplugindemo.toolwindow;

import com.intellij.openapi.ui.DialogWrapper;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;
import java.awt.event.*;

public class SimpleDialogFormWrapper extends DialogWrapper {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JLabel labelField;

    public SimpleDialogFormWrapper() {
        super(true);
        init();
        setTitle("Simple Dialog Test");
    }

    @Override protected @Nullable JComponent createCenterPanel() {
        getRootPane().setDefaultButton(buttonOK);
        labelField.setText("testing!");
        buttonOK.addActionListener(e -> onOK());
        buttonCancel.addActionListener(e -> onCancel());
        contentPane.registerKeyboardAction(e -> onCancel(), KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
        return contentPane;
    }

    private void onOK() {
        // add your code he re
        System.out.println("user interact OK");
        dispose();
    }

    private void onCancel() {
        // add your code here if necessary
        System.out.println("user interact CANCEL");
        dispose();
    }
}
