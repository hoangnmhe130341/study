/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import form.ChangeFontForm;
import form.MainForm;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 *
 * @author Lenovo
 */
public class ChangeFormController {

    public void setupUIListForm(ChangeFontForm changeFontForm) {
        String fonts[] = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
        changeFontForm.getListFont().setListData(fonts);
        String styles[] = {"Regular", "Bold", "Italic", "Bold Italic"};
        changeFontForm.getListStyle().setListData(styles);
        String sizes[] = {"8", "9", "10", "11", "12", "14", "16", "18", "20", "22", "24", "36", "40", "72"};
        changeFontForm.getListSize().setListData(sizes);
    }

    public void setupChangeFont(MainForm mainForm, ChangeFontForm changeFontForm) {
        String fontCurrent = mainForm.getjTextArea1().getFont().getFamily();
        int styleCurrent = mainForm.getjTextArea1().getFont().getStyle();
        int sizeCurrent = mainForm.getjTextArea1().getFont().getSize();
        changeFontForm.getListFont().setSelectedValue(fontCurrent, true);
        changeFontForm.getListStyle().setSelectedIndex(styleCurrent);
        changeFontForm.getListSize().setSelectedValue(Integer.toString(sizeCurrent), true);
        changeFontForm.getTxtSize().setText(Integer.toString(sizeCurrent));
        changeFontForm.getTextFont().setText(fontCurrent);
        changeFontForm.getTextStyle().setText(changeFontForm.getListStyle().getSelectedValue());
    }

    public void changeFont(ChangeFontForm changeFontForm) {
        changeFontForm.getListFont().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                String fontChoose = changeFontForm.getListFont().getSelectedValue();
                changeFontForm.getTextFont().setText(fontChoose);
                int currentStyle = changeFontForm.getTextReview().getFont().getStyle();
                int currentSize = changeFontForm.getTextReview().getFont().getSize();
                changeFontForm.getTextReview().setFont(new Font(fontChoose, currentStyle, currentSize));
            }
        });
    }

    public void changeStyle(ChangeFontForm changeFontForm) {
        changeFontForm.getListStyle().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                int styleChoose = changeFontForm.getListStyle().getSelectedIndex();
                changeFontForm.getTextStyle().setText(changeFontForm.getListStyle().getSelectedValue());
                String currentFont = changeFontForm.getTextReview().getFont().getFamily();
                int currentSize = changeFontForm.getTextReview().getFont().getSize();
                changeFontForm.getTextReview().setFont(new Font(currentFont, styleChoose, currentSize));
            }
        });
    }

    public void changeSize(ChangeFontForm changeFontForm) {
        changeFontForm.getListSize().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                int sizeChoose = Integer.parseInt(changeFontForm.getListSize().getSelectedValue());
                String fontCurrent = changeFontForm.getTextReview().getFont().getFontName();
                int styleCurrent = changeFontForm.getTextReview().getFont().getStyle();
                changeFontForm.getTextSize().setText(String.valueOf(sizeChoose));
                changeFontForm.getTextReview().setFont(new Font(fontCurrent, styleCurrent, sizeChoose));
            }
        });
        changeFontForm.getTextSize().addCaretListener(new CaretListener() {
            @Override
            public void caretUpdate(CaretEvent e) {
                try {
                    int sizeChoose = Integer.parseInt(changeFontForm.getTextSize().getText());
                    if (sizeChoose != 0) {
                        String fontCurrent = changeFontForm.getTextReview().getFont().getFontName();
                        int styleCurrent = changeFontForm.getTextReview().getFont().getStyle();
                        changeFontForm.getTextReview().setFont(new Font(fontCurrent, styleCurrent, sizeChoose));
                    }
                } catch (NumberFormatException ex) {
                }

            }
        });
    }

    public void clickButton(MainForm mainForm, ChangeFontForm changeFontForm) {
        changeFontForm.getBtnOk().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Integer.parseInt(changeFontForm.getTextSize().getText());
                    String currentFont = changeFontForm.getTextReview().getFont().getFamily();
                    int currentStyle = changeFontForm.getTextReview().getFont().getStyle();
                    int currentSize = changeFontForm.getTextReview().getFont().getSize();
                    mainForm.getjTextArea1().setFont(new Font(currentFont, currentStyle, currentSize));
                    changeFontForm.setVisible(false);
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(changeFontForm, "This is not a valid number", "Notepad", 2);
                }
            }
        });

        changeFontForm.getBtnCancel().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                changeFontForm.setVisible(false);
            }
        });
    }
}
