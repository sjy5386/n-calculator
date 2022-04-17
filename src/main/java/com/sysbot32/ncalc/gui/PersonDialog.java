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

    public PersonDialog(JFrame owner) {
        super(owner);
        setTitle("인원");
        setLayout(new FlowLayout());
        setMinimumSize(new Dimension(355, 265));
        setResizable(false);

        JPanel contentPane = (JPanel) this.getContentPane();

        list = new JList<>();
        JPopupMenu componentPopupMenu = new JPopupMenu();
        JMenuItem removeMenuItem = new JMenuItem("제거");
        JScrollPane scrollPane = new JScrollPane(list);
        textField = new JTextField(23);
        addButton = new JButton("추가");

        list.setListData(Main.nCalculator.getPeople().toArray(new Person[0]));
        removeMenuItem.addActionListener(e -> {
            Main.nCalculator.getPeople().removeAll(list.getSelectedValuesList());
            list.setListData(Main.nCalculator.getPeople().toArray(new Person[0]));
        });
        componentPopupMenu.add(removeMenuItem);
        list.setComponentPopupMenu(componentPopupMenu);
        scrollPane.setPreferredSize(new Dimension(320, 180));
        textField.addActionListener(e -> addButton.doClick());
        addButton.addActionListener(e -> {
            Main.nCalculator.getPeople().add(new Person(textField.getText()));
            list.setListData(Main.nCalculator.getPeople().toArray(new Person[0]));
            textField.setText("");
        });

        contentPane.add(scrollPane);
        contentPane.add(textField);
        contentPane.add(addButton);
    }
}
