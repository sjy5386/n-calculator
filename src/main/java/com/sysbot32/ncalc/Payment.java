package com.sysbot32.ncalc;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.math.BigInteger;

@AllArgsConstructor
@Getter
@ToString
public class Payment {
    private Person payer;
    private Person payee;
    private BigInteger amount;

    public void merge(Payment payment) {
        if (payer == payment.payer && payee == payment.payee) {
            amount = amount.add(payment.amount);
        } else if (payer == payment.payee && payee == payment.payer) {
            amount = amount.subtract(payment.amount);
        }

        if (amount.compareTo(BigInteger.ZERO) < 0) {
            swap();
        }
    }

    public void swap() {
        Person tmp = payee;
        payee = payer;
        payer = tmp;
        amount = amount.multiply(BigInteger.valueOf(-1));
    }
}
