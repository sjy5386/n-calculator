package com.sysbot32.ncalc;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString
public class Round {
    private String name;
    private BigInteger amount;
    private Person payer;
    private final List<Person> participants;

    public Round(String name, BigInteger amount, Person payer) {
        this.name = name;
        this.amount = amount;
        this.payer = payer;
        this.participants = new ArrayList<>();
    }

    public int getN() {
        return participants.size() + 1;
    }

    public BigInteger[] divideAndRemainder() {
        return amount.divideAndRemainder(BigInteger.valueOf(this.getN()));
    }
}
