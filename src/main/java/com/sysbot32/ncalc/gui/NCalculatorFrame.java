package com.sysbot32.ncalc.gui;

import com.sysbot32.ncalc.Main;
import com.sysbot32.ncalc.Payment;
import lombok.Getter;

import javax.swing.*;
import java.awt.*;

@Getter
public class NCalculatorFrame extends JFrame {
    private final JList<Payment> paymentList;
    private final JButton calculateButton;

    public NCalculatorFrame() {
        super("N Calculator");
        setSize(480, 720);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel contentPane = (JPanel) this.getContentPane();

        JMenuBar menuBar = new JMenuBar();
        paymentList = new JList<>();
        JScrollPane scrollPane = new JScrollPane(paymentList);
        calculateButton = new JButton("계산하기");

        JMenu calculatorMenu = new JMenu("계산기");
        JMenuItem personMenuItem = new JMenuItem("인원");
        JMenuItem roundMenuItem = new JMenuItem("차례");
        personMenuItem.addActionListener(e -> new PersonDialog(this).setVisible(true));
        roundMenuItem.addActionListener(e -> new RoundDialog(this).setVisible(true));
        calculatorMenu.add(personMenuItem);
        calculatorMenu.add(roundMenuItem);
        menuBar.add(calculatorMenu);
        paymentList.setListData(Main.nCalculator.calculate().toArray(new Payment[0]));

        setJMenuBar(menuBar);
        contentPane.add(scrollPane, BorderLayout.CENTER);
        contentPane.add(calculateButton, BorderLayout.SOUTH);
    }
}
