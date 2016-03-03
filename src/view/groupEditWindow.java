package view;

import model.JGroup;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by eroshin on 03.03.2016.
 */
public class groupEditWindow {

    public biatlonWindow bW;

    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JButton buttonAdd;
    public JPanel panelGroupEdit;
    private JButton buttonCansel;

    public groupEditWindow(biatlonWindow w,JFrame fr) {
        bW = w;
        buttonAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JGroup gr = new JGroup(textField1.getText(),Integer.valueOf(textField2.getText()),Integer.valueOf(textField3.getText()));
                bW.addGroup(gr);
                biatlonWindow.localFrame.setVisible(true);
                fr.dispose();
            }
        });
        buttonCansel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                biatlonWindow.localFrame.setVisible(true);
                fr.dispose();
            }
        });
    }
}
