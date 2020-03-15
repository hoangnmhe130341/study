/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import form.FindTextForm;
import form.MainForm;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Action;
import javax.swing.JOptionPane;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;
import javax.swing.text.BadLocationException;

/**
 *
 * @author Lenovo
 */
public class FindController {
    public void find(MainForm mainForm, FindTextForm findForm){
        findForm.getBtnFind().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String textFind = findForm.getjTextField1().getText();
                int indexCurrent;
                int indexTextFind =-1;
                if(findForm.getIsDown().isSelected()){
                    indexCurrent= mainForm.getjTextArea1().getSelectionEnd();
                    indexTextFind = mainForm.getjTextArea1().getText().indexOf(textFind, indexCurrent);
                }
                else {
                    try {
                        indexCurrent= mainForm.getjTextArea1().getSelectionStart();
                        String txtCurrentCheck = mainForm.getjTextArea1().getText(0, indexCurrent);
                        indexTextFind=txtCurrentCheck.lastIndexOf(textFind);
                    } catch (BadLocationException ex) {
                        Logger.getLogger(FindController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    
                }
                if (indexTextFind != -1) {
                    mainForm.getjTextArea1().setSelectionStart(indexTextFind);
                    mainForm.getjTextArea1().setSelectionEnd(indexTextFind + textFind.length());
                } else {
                    JOptionPane.showMessageDialog(findForm, "Cannot find \"" + textFind+ "\"", "Result", 2);
                }
            }
        });
    }
    
    public void cancelFind(FindTextForm findForm) {
        findForm.getBtnCancel().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                findForm.setVisible(false);
            }
        });
    }

    // check user not input
    public void checkEmptyFind(FindTextForm findForm) {
        findForm.getjTextField1().addCaretListener(new CaretListener() {
            @Override
            public void caretUpdate(CaretEvent e) {
                if (findForm.getjTextField1().getText().trim().isEmpty()) {
                    findForm.getBtnFind().setEnabled(false);
                } else {
                    findForm.getBtnFind().setEnabled(true);
                }
            }
        });
    }
}
