package com.andrea.puccia;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class GridBagView extends JFrame {

    private JPanel mainPanel;

    private  JLabel idLabel;
    private  JLabel printLabel;
    private JLabel studentLabel;

    private JTextField idText;

    private JButton idButton;
    private JButton studentButton;

    private JScrollPane scrollPanel;
    private JList<Student> studentList;
    private DefaultListModel<Student> studentListModel;

    public GridBagView() {
        setTitle("My View");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1024, 512);
        mainPanel = new JPanel();
        setContentPane(mainPanel);
        mainPanel.setLayout(new GridBagLayout());

        idLabel = new JLabel("MyId");
        idLabel.setName("MyId");
        GridBagConstraints idLabelC = new GridBagConstraints();
        idLabelC.gridx=0;
        idLabelC.gridy=0;
        idLabelC.anchor= GridBagConstraints.EAST;
        mainPanel.add(idLabel,idLabelC);

        idText=new JTextField();
        idText.setName("TextId");
        GridBagConstraints idTextC = new GridBagConstraints();
        idTextC.gridx=1;
        idTextC.gridy=0;
        idTextC.weightx=0.5;
        idTextC.insets=new Insets(5, 20, 5, 20);
        idTextC.fill= GridBagConstraints.HORIZONTAL;
        mainPanel.add(idText,idTextC);
        KeyAdapter btnAddEnabler = new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                idButton.setEnabled(!idText.getText().trim().isEmpty());
            }
        };
        idText.addKeyListener(btnAddEnabler);


        idButton = new JButton("IdButton");
        idButton.setName("ButtonId");
        idButton.setEnabled(false);
        GridBagConstraints idButtonC = new GridBagConstraints();
        idButtonC.gridx=1;
        idButtonC.gridy=1;
        idButtonC.insets=new Insets(5, 20, 5, 20);
        mainPanel.add(idButton,idButtonC);

        idButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                printLabel.setText(idText.getText());
            }
        });

        printLabel = new JLabel("Printed text");
        printLabel.setName("PrintId");
        GridBagConstraints printLabelC = new GridBagConstraints();
        printLabelC.gridx=0;
        printLabelC.gridy=2;
        printLabelC.gridwidth=2;
        printLabelC.fill=GridBagConstraints.HORIZONTAL;
        mainPanel.add(printLabel,printLabelC);

        scrollPanel = new JScrollPane();
        GridBagConstraints scrollPanelC = new GridBagConstraints();
        scrollPanelC.gridx=0;
        scrollPanelC.gridy=3;
        scrollPanelC.gridheight=2;
        mainPanel.add(scrollPanel,scrollPanelC);

        studentListModel = new DefaultListModel<>();
        Student s = new Student();
        s.setMatricola(1);
        s.setCognome("andrea");
        s.setNome("puccia");
        studentListModel.addElement(s);
        studentList = new JList<>(studentListModel);
        studentList.setName("studentList");
        studentList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        studentList.setCellRenderer(new DefaultListCellRenderer() {
            private static final long serialVersionUID = 1L;

            @Override
            public Component getListCellRendererComponent(JList<?> list, Object value, int index,
                                                          boolean isSelected, boolean cellHasFocus) {
                Student student = (Student) value;
                return super.getListCellRendererComponent(list,
                        student.toString(),
                        index, isSelected, cellHasFocus);
            }
        });
        studentList.addListSelectionListener(
                e -> studentButton.setEnabled(studentList.getSelectedIndex() != -1));
        scrollPanel.setViewportView(studentList);


        studentButton = new JButton("PrintStudentInfo");
        studentButton.setName("studentButton");
        studentButton.setEnabled(false);
        GridBagConstraints studentButtonC = new GridBagConstraints();
        studentButtonC.gridx=1;
        studentButtonC.gridy=3;
        mainPanel.add(studentButton,studentButtonC);


        studentLabel = new JLabel("No Student Info");
        studentLabel.setName("studentLabel");
        GridBagConstraints studentLabelC = new GridBagConstraints();
        studentLabelC.gridx=1;
        studentLabelC.gridy=4;
        mainPanel.add(studentLabel,studentLabelC);

        studentButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                studentLabel.setText(studentList.getSelectedValue().toString());
            }
        });


    }
    public static void main(String[] args) {
        JFrame myFrame = new GridBagView();
        myFrame.setVisible(true);
    }
}
