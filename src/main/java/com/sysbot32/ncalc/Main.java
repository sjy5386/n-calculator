package com.sysbot32.ncalc;

import com.sysbot32.ncalc.gui.NCalculatorFrame;

public class Main {
    public static NCalculator nCalculator;

    public static void main(String[] args) {
        nCalculator = new NCalculator();

        new NCalculatorFrame().setVisible(true);
    }
}
