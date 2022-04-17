package com.sysbot32.ncalc.gui;

import com.sysbot32.ncalc.Main;
import com.sysbot32.ncalc.Person;
import lombok.Getter;

import javax.swing.*;
import java.awt.*;

@Getter
public class PersonDialog extends JDialog {
    private final JList<Person> list;
    private final JTextField textField;
    private final JButton addButton;
    private final JButton removeButton;

    public PersonDialog(JFrame owner) {
        super(owner);
        setTitle("인원");
        setLayout(new FlowLayout());
        setMinimumSize(new Dimension(355, 265));
        setResizable(false);

        JPanel contentPane = (JPanel) this.getContentPane();

        list = new JList<>();
        JScrollPane scrollPane = new JScrollPane(list);
        textField = new JTextField(16);
        addButton = new JButton("추가");
        removeButton = new JButton("제거");

        list.setListData(Main.nCalculator.getPeople().toArray(new Person[0]));
        scrollPane.setPreferredSize(new Dimension(320, 180));
        textField.addActionListener(e -> addButton.doClick());
        addButton.addActionListener(e -> {
            Main.nCalculator.getPeople().add(new Person(textField.getText()));
            list.setListData(Main.nCalculator.getPeople().toArray(new Person[0]));
            textField.setText("");
        });
        removeButton.addActionListener(e -> {
            Main.nCalculator.getPeople().remove(list.getSelectedValue());
            list.setListData(Main.nCalculator.getPeople().toArray(new Person[0]));
        });

        contentPane.add(scrollPane);
        contentPane.add(textField);
        contentPane.add(addButton);
        contentPane.add(removeButton);
    }
}
