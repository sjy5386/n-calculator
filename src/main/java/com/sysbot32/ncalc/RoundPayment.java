package com.sysbot32.ncalc;

import lombok.Getter;
import lombok.ToString;

import java.math.BigInteger;

@Getter
@ToString
public class RoundPayment extends Payment {
    private Round round;

    public RoundPayment(Person payer, Person payee, BigInteger amount, Round round) {
        super(payer, payee, amount);
        this.round = round;
    }
}
