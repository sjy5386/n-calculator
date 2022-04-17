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
        list.setListData(Main.nCalculator.getPeople().toArray(new Person[0]));
        JScrollPane scrollPane = new JScrollPane(list);
        scrollPane.setPreferredSize(new Dimension(320, 180));

        textField = new JTextField(16);
        addButton = new JButton("추가");
        removeButton = new JButton("제거");

        contentPane.add(scrollPane);
        contentPane.add(textField);
        contentPane.add(addButton);
        contentPane.add(removeButton);
    }
}
