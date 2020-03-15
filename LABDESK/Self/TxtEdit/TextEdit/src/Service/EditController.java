/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

/**
 *
 * @author Lenovo
 */
import form.ChangeFontForm;
import form.FindTextForm;
import form.MainForm;
import form.ReplaceForm;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.FlavorEvent;
import java.awt.datatransfer.FlavorListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Action;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;
import javax.swing.text.DefaultEditorKit;
import javax.swing.undo.UndoManager;

public class EditController {

    public void service(MainForm mainForm) {
        UndoManager manager = new UndoManager();
        mainForm.getjTextArea1().getDocument().addUndoableEditListener(manager);

        canEdit(mainForm);
        canUndoRedo(mainForm, manager);
        
        undo(mainForm, manager);
        redo(mainForm, manager);
        selectAll(mainForm);
        copyPasteCut(mainForm);
        
        find(mainForm);
        replace(mainForm);
        changeFont(mainForm);
    }

    private void canEdit(MainForm mainForm) {
        mainForm.getjCopy().setEnabled(false);
        mainForm.getjCut().setEnabled(false);
        mainForm.getjFind().setEnabled(false);
        mainForm.getjReplace().setEnabled(false);

        mainForm.getjTextArea1().addCaretListener(new CaretListener() {
            @Override
            public void caretUpdate(CaretEvent e) {
                String currentText = mainForm.getjTextArea1().getText();
                if (currentText.length() > 0) {
                    mainForm.getjFind().setEnabled(true);
                    mainForm.getjReplace().setEnabled(true);
                }
                if (mainForm.getjTextArea1().getSelectedText() != null) {
                    mainForm.getjCopy().setEnabled(true);
                    mainForm.getjCut().setEnabled(true);
                } else {
                    mainForm.getjCut().setEnabled(true);
                    mainForm.getjCopy().setEnabled(true);
                }
            }
        });
        
        Clipboard c=Toolkit.getDefaultToolkit().getSystemClipboard();
        c.addFlavorListener(new FlavorListener() {
            @Override
            public void flavorsChanged(FlavorEvent e) {
                if(c.isDataFlavorAvailable(DataFlavor.stringFlavor)){
                    mainForm.getjPaste().setEnabled(true);
                } else {
                    mainForm.getjPaste().setEnabled(false);
                }
            }
        });
    }

    private void canUndoRedo(MainForm mainForm, UndoManager manager) {
        mainForm.getjUndo().setEnabled(false);
        mainForm.getjRedo().setEnabled(false);

        mainForm.getjTextArea1().addCaretListener(new CaretListener() {
            @Override
            public void caretUpdate(CaretEvent e) {
                if (manager.canUndo() && mainForm.isInFile()) {
                    mainForm.getjUndo().setEnabled(true);
                } else {
                    mainForm.getjUndo().setEnabled(false);
                }
                if (manager.canRedo() && mainForm.isInFile()) {
                    mainForm.getjRedo().setEnabled(true);
                } else {
                    mainForm.getjRedo().setEnabled(false);
                }
            }
        });
    }

    private void undo(MainForm mainForm, UndoManager manager) {
        mainForm.getjUndo().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                manager.undo();
            }
        });
    }
    
    private void redo(MainForm mainForm, UndoManager manager) {
        mainForm.getjRedo().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                manager.redo();
            }
        });
    }

    private void selectAll(MainForm mainForm) {
        mainForm.getjTextArea1().selectAll();
    }

    private void copyPasteCut(MainForm mainForm) {
        Action copy = new DefaultEditorKit.CopyAction();
        Action cut = new DefaultEditorKit.CutAction();
        Action paste = new DefaultEditorKit.PasteAction();
        
        mainForm.getjCut().addActionListener(cut);
        mainForm.getjCopy().addActionListener(copy);
        mainForm.getjPaste().addActionListener(paste);
    }

    private void find(MainForm mainForm) {
        mainForm.getjFind().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FindTextForm findTextForm = new FindTextForm(mainForm, false);
                findTextForm.setVisible(true);
                findTextForm.getBtnFind().setEnabled(false);
                
                FindController findService = new FindController();
                findService.checkEmptyFind(findTextForm);
                findService.find(mainForm, findTextForm);
                findService.cancelFind(findTextForm);
            }
        });      
    }

    private void replace(MainForm mainForm) {
        mainForm.getjReplace().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ReplaceForm replaceForm = new ReplaceForm(mainForm, false);
                replaceForm.setVisible(true);
                replaceForm.getBtnReplace().setEnabled(false);
                replaceForm.getBtnReplaceAll().setEnabled(false);
                
                ReplaceController replaceController = new ReplaceController();
                replaceController.checkEmptyTextReplace(replaceForm);
                replaceController.replace(mainForm, replaceForm);
                replaceController.replaceAll(mainForm, replaceForm);
                replaceController.cancel(replaceForm);
            }
        });
    }

    private void changeFont(MainForm mainForm) {
        mainForm.getjChangeFont().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ChangeFontForm cff = new ChangeFontForm();
                cff.setVisible(true);
                
                ChangeFormController cfc = new ChangeFormController();
                cfc.setupUIListForm(cff);
                cfc.setupChangeFont(mainForm, cff);
                cfc.changeFont(cff);
                cfc.changeSize(cff);
                cfc.changeStyle(cff);
                cfc.clickButton(mainForm, cff);
            }
        });
    }
    
    
    
}
