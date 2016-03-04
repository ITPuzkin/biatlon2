package view;

import com.alee.laf.WebLookAndFeel;
import com.alee.laf.button.WebButton;
import com.alee.laf.button.WebButtonStyle;
import com.alee.laf.table.WebTable;
import model.JGroup;
import model.JPerson;
import model.JTableModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/**
 * Created by eroshin on 03.03.2016.
 */
public class biatlonWindow {
    private JTextField textYear;
    private JTextField textSurName;
    private JTextField textName;
    private JTextField textTown;
    private JTextField textNumber;
    private JTabbedPane tabbedPane1;
    private JButton buttonRedactor;
    private JButton buttonAdd;
    private JPanel panelWindow;
    private JRadioButton radioM;
    private JRadioButton radioZ;
    private JLabel curCount;

    public biatlonWindow local;
    public static JFrame localFrame;

    private HashMap<String, JGroup> groups;
    private HashMap<Integer, JPerson> particiants;


    public HashMap<String,JTable> tables;
    public HashMap<String,JTableModel> tmodels;

    public String[] params = {"Фаилия",
            "Имя",
            "Город",
            "Номер",
            "Год",
            "Время",};

    public biatlonWindow(){
        tables = new HashMap<>();
        tmodels = new HashMap<>();
        local = this;
        groups = new HashMap<>();
        particiants = new HashMap<>();

        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(radioM);
        buttonGroup.add(radioZ);

        buttonRedactor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new JFrame("groupWindow");
                frame.setBounds(localFrame.getBounds());
                frame.setContentPane(new groupEditWindow(local,frame).panelGroupEdit);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.pack();
                frame.setVisible(true);
                localFrame.setVisible(false);
            }
        });

        buttonAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addPerson(Integer.valueOf(textYear.getText()),textName.getText(),
                        textSurName.getText(),textTown.getText(),Integer.valueOf(textNumber.getText()));
            }
        });

    }

    public void addPerson(int year,
                          String name,
                          String surName,
                          String town,
                          int number){
        boolean b = false;
        if(radioM.isSelected()) b=true;
        else b=false;
        JPerson p = new JPerson(name,surName,town,year,number,b);
        boolean flag = false;
        for(Map.Entry<String,JGroup> entry : groups.entrySet()){

            if(p.getpYear() >= entry.getValue().getlYear() && p.getpYear() <= entry.getValue().gethYear()){
                if(entry.getValue().isMale() == p.isMale()) {
                    p.setpGroup(entry.getValue());
                    flag = true;
                    break;
                }
                else continue;
            }
        }
        if(!flag){
            JOptionPane.showMessageDialog(null, "Нет подходящей группы!\nПроверьте год рождения или создайте новую группу", "Ошибка", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        particiants.put(p.getpNumber(),p);
        tmodels.get(p.getpGroup().getgName()).addData(p);
        tables.get(p.getpGroup().getgName()).revalidate();
        tables.get(p.getpGroup().getgName()).updateUI();
        clearInputs();
    }

    public void clearInputs(){
        textNumber.setText("");
        textName.setText("");
        textSurName.setText("");
        textTown.setText("");
        textYear.setText("");
    }

    public void addGroup(JGroup g){
        groups.put(g.getgName(),g);
        drawGoup(g);
    }

    public void drawGoup(JGroup g){
        if(tabbedPane1.indexOfTab(g.getgName())==-1){
            addTab(g.getgName());
        }
    }

    public void addTab(String n){
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout());
        JTableModel model = new JTableModel(n,params);
        tmodels.put(n,model);

        //WebTable table = new WebTable(model);
        JTable table = new JTable(model);
        table.setAutoCreateRowSorter(true);


        JScrollPane sPane = new JScrollPane(table);
        sPane.setSize(panel.getSize());
        table.setFillsViewportHeight(true);
        tables.put(n,table);
        panel.add(sPane);
        tabbedPane1.addTab(n,panel);
    }

    public static void main(String[] args) {
        WebLookAndFeel.install ();

        JFrame frame = new JFrame("biatlonWindow");
        localFrame = frame;
        frame.setContentPane(new biatlonWindow().panelWindow);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
