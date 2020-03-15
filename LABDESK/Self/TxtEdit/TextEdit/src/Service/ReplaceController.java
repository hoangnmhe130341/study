/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import form.MainForm;
import form.ReplaceForm;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Action;
import javax.swing.JOptionPane;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;

/**
 *
 * @author Lenovo
 */
public class ReplaceController {

    public void replace(MainForm mainForm, ReplaceForm replaceForm) {
        replaceForm.getBtnReplace().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String txtFind = replaceForm.getjTextField1().getText();
                String txtReplace = replaceForm.getjTextField2().getText();
                if (mainForm.getjTextArea1().getText().contains(txtFind)) {
                    mainForm.getjTextArea1().setText(mainForm.getjTextArea1().getText().replaceFirst(txtFind, txtReplace));
                } else {
                    JOptionPane.showMessageDialog(replaceForm, "Cannot find \"" + txtFind + "\"", "Result", 2);
                }
            }
        });
    }

    public void replaceAll(MainForm mainForm, ReplaceForm replaceForm) {
        replaceForm.getBtnReplaceAll().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String txtFind = replaceForm.getjTextField1().getText();
                String txtReplace = replaceForm.getjTextField2().getText();
                if (mainForm.getjTextArea1().getText().contains(txtFind)) {
                    mainForm.getjTextArea1().setText(mainForm.getjTextArea1().getText().replaceAll(txtFind, txtReplace));
                } else {
                    JOptionPane.showMessageDialog(replaceForm, "Cannot find \"" + txtFind + "\"", "Result", 2);
                }
            }
        });
    }

    public void checkEmptyTextReplace(ReplaceForm replaceForm) {
        replaceForm.getjTextField1().addCaretListener(new CaretListener() {
            @Override
            public void caretUpdate(CaretEvent e) {
                if (replaceForm.getjTextField1().getText().trim().isEmpty()) {
                    replaceForm.getBtnReplace().setEnabled(false);
                    replaceForm.getBtnReplaceAll().setEnabled(false);
                } else {
                    replaceForm.getBtnReplace().setEnabled(true);
                    replaceForm.getBtnReplaceAll().setEnabled(true);
                }
            }
        });
    }

    public void cancel(ReplaceForm replaceForm) {
        replaceForm.getBtnCancel().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                replaceForm.setVisible(false);
            }
        });
    }
}
