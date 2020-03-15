/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import form.MainForm;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import javax.swing.Action;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;

/**
 *
 * @author Lenovo
 */
public class FileController {

    public void controller(MainForm mainForm) {
        JFileChooser chooser = new JFileChooser();

        newFile(mainForm, chooser);
        openFile(mainForm, chooser);
        saveFile(mainForm, chooser);
        saveAsFile(mainForm, chooser);
        exitNote(mainForm, chooser);
        checkClose(mainForm, chooser);

        checkSaved(mainForm);

    }

    private void newFile(MainForm mainForm, JFileChooser chooser) {
        mainForm.getjNew().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainForm.setInFile(false);
                if (!isFileSaved(mainForm, chooser)) {
                    return;
                }
                mainForm.getjTextArea1().setText("");
                mainForm.setSaved(true);
                mainForm.setTextCheckSaved("");
            }
        });
    }

    private void checkSaved(MainForm mainForm) {
        mainForm.getjTextArea1().addCaretListener(new CaretListener() {
            @Override
            public void caretUpdate(CaretEvent e) {
                if (!mainForm.getTextCheckSaved().equals(mainForm.getjTextArea1().getText())) {
                    mainForm.setInFile(true);
                    mainForm.setSaved(false);
                }
            }
        });
    }

    private boolean isFileSaved(MainForm mainForm, JFileChooser chooser) {
        String message = "<html><div style = 'color:blue'>Do you want to save the changes to file </div><html>";
        boolean checkSaved = mainForm.isSaved();
        if (checkSaved == false) {
            int x = JOptionPane.showConfirmDialog(mainForm, message, "Confirm", JOptionPane.YES_NO_CANCEL_OPTION);
            if (x == JOptionPane.YES_OPTION) {
                if (mainForm.getFile() == null) {
                    saveAsFunction(mainForm, chooser);
                } else {
                    writeTextAreaToFile(mainForm, chooser);
                }
            }
            if (x == JOptionPane.CANCEL_OPTION || x == -1) {
                return false;
            }
        }
        return true;
    }

    private void saveAsFunction(MainForm mainForm, JFileChooser chooser) {
        try {
            File file = null;
            while (true) {
                chooser.showSaveDialog(mainForm);
                file = chooser.getSelectedFile();
                if (!file.exists()) {
                    break;
                }
                int option = JOptionPane.showConfirmDialog(mainForm, "Do you want to replace it?", "Save As", JOptionPane.YES_NO_OPTION);
                if (option == JOptionPane.YES_OPTION) {
                    break;
                } else {
                    return;
                }
            }
            mainForm.setFile(file);
            mainForm.setTextCheckSaved("");
            writeTextAreaToFile(mainForm, chooser);
        } catch (Exception e) {
        }
    }

    private void writeTextAreaToFile(MainForm mainForm, JFileChooser chooser) {
        if (mainForm.getFile() == null) {
            saveAsFunction(mainForm, chooser);
            return;
        }
        try (FileWriter fw = new FileWriter(mainForm.getFile());
                BufferedWriter bw = new BufferedWriter(fw)) {
            bw.write(mainForm.getjTextArea1().getText());
            mainForm.setTextCheckSaved(mainForm.getjTextArea1().getText());
            mainForm.setSaved(true);
        } catch (Exception e) {
        }
    }

    private void saveFile(MainForm mainForm, JFileChooser chooser) {
        mainForm.getjSave().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                writeTextAreaToFile(mainForm, chooser);
                mainForm.setSaved(true);
            }
        });
    }

    private void saveAsFile(MainForm mainForm, JFileChooser chooser) {
        mainForm.getjSaveAs().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // check user continue or cancel
                if (!isFileSaved(mainForm, chooser)) {
                    return;
                }
                saveAsFunction(mainForm, chooser);
            }
        });
    }

    private void openFile(MainForm mainForm, JFileChooser chooser) {
        mainForm.getjOpen().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // check user continue or cancel
                if (!isFileSaved(mainForm, chooser)) {
                    return;
                }
                // loop until user click file .txt or .java 
                File fileCheck = null;
                try {
                    while (true) {
                        chooser.showOpenDialog(mainForm);
                        fileCheck = chooser.getSelectedFile();
                        if (fileCheck.exists()) {
                            break;
                        }
                        JOptionPane.showMessageDialog(mainForm, "File not found", "Open", JOptionPane.INFORMATION_MESSAGE);
                    }
                } catch (Exception ex) {
                }

                mainForm.setFile(fileCheck);
                // clear text area
                mainForm.getjTextArea1().setText("");
                // write content file to text area
                writeFileToTextArea(mainForm);
                mainForm.setSaved(true);
            }

        });
    }

    private void writeFileToTextArea(MainForm mainForm) {
        try (FileReader fr = new FileReader(mainForm.getFile());
                BufferedReader br = new BufferedReader(fr)) {
            //TODO check save file old
            String str = "";
            while (true) {
                str = br.readLine();
                if (str == null) {
                    break;
                }
                mainForm.getjTextArea1().append(str + "\n");
            }
            // when user open, not change then file save
            mainForm.setTextCheckSaved(mainForm.getjTextArea1().getText());
            mainForm.setSaved(true);
            mainForm.getjTextArea1().setCaretPosition(0);
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private void checkClose(MainForm mainForm, JFileChooser chooser) {
        mainForm.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        mainForm.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent we) {
                String message = "<html><div style = 'color:blue'>Do you want to save the changes to file </div><html>";
                // check user choose yes or no
                boolean checkSaved = mainForm.isSaved();
                if (checkSaved == false) {
                    int x = JOptionPane.showConfirmDialog(mainForm, message, "Confirm", JOptionPane.YES_NO_CANCEL_OPTION);
                    if (x == JOptionPane.YES_OPTION) {
                        if (mainForm.getFile() == null) {
                            saveAsFunction(mainForm, chooser);
                        } else {
                            writeTextAreaToFile(mainForm, chooser);
                        }
                    }
                    // user click close
                    if (x == JOptionPane.CANCEL_OPTION) {
                        return;
                    }
                    // user click no
                    if (x == JOptionPane.NO_OPTION) {
                        System.exit(0);
                    }
                } else {
                    System.exit(0);
                }
            }
        });
    }

    private void exitNote(MainForm mainForm, JFileChooser chooser) {
        mainForm.getjExit().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // check user continue or cancel
                if (!isFileSaved(mainForm, chooser)) {
                    return;
                }
                System.exit(0);
            }
        });
    }
}
