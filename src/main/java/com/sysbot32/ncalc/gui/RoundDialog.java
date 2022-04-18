package com.sysbot32.ncalc.gui;

import com.sysbot32.ncalc.Main;
import com.sysbot32.ncalc.Person;
import com.sysbot32.ncalc.Round;
import lombok.Getter;

import javax.swing.*;
import java.awt.*;
import java.math.BigInteger;
import java.util.List;

@Getter
public class RoundDialog extends JDialog {
    private final JList<Round> roundList;
    private final JTextField textField;
    private final JSpinner spinner;
    private final JComboBox<Person> comboBox;
    private final JList<Person> participantList;
    private final JButton addButton;

    public RoundDialog(JFrame owner) {
        super(owner);
        setTitle("차례");
        setLayout(new FlowLayout());
        setMinimumSize(new Dimension(505, 660));
        setResizable(false);

        JPanel contentPane = (JPanel) this.getContentPane();

        roundList = new JList<>(Main.nCalculator.getRounds().toArray(new Round[0]));
        JScrollPane scrollPane1 = new JScrollPane(roundList);
        textField = new JTextField(12);
        spinner = new JSpinner();
        comboBox = new JComboBox<>(Main.nCalculator.getPeople().toArray(new Person[0]));
        participantList = new JList<>();
        JScrollPane scrollPane2 = new JScrollPane(participantList);
        addButton = new JButton("추가");

        scrollPane1.setPreferredSize(new Dimension(480, 360));
        ((JSpinner.DefaultEditor) spinner.getEditor()).getTextField().setColumns(8);
        scrollPane2.setPreferredSize(new Dimension(440, 180));
        comboBox.setPrototypeDisplayValue(new Person(".............................."));
        comboBox.setSelectedItem(null);
        comboBox.addActionListener(e -> {
            participantList.setListData(Main.nCalculator.getPeople().stream().filter(f -> f != comboBox.getSelectedItem()).toArray(Person[]::new));
        });
        addButton.addActionListener(e -> {
            String name = textField.getText();
            BigInteger amount = BigInteger.valueOf((Integer) spinner.getValue());
            Person payer = (Person) comboBox.getSelectedItem();
            List<Person> participants = participantList.getSelectedValuesList();
            Main.nCalculator.getRounds().add(new Round(name, amount, payer, participants));
            roundList.setListData(Main.nCalculator.getRounds().toArray(new Round[0]));

            JScrollBar scrollBar = scrollPane1.getVerticalScrollBar();
            scrollBar.setValue(scrollBar.getMaximum());

            textField.setText("");
            spinner.setValue(0);
            comboBox.setSelectedItem(null);
            participantList.setListData(new Person[0]);
        });

        contentPane.add(scrollPane1);
        contentPane.add(new JLabel("이름"));
        contentPane.add(textField);
        contentPane.add(new JLabel("금액"));
        contentPane.add(spinner);
        contentPane.add(new JLabel("주최자"));
        contentPane.add(comboBox);
        contentPane.add(new JLabel("참가자"));
        contentPane.add(scrollPane2);
        contentPane.add(addButton);
    }
}
