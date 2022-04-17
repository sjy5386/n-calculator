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

    public BigInteger divide() {
        return amount.divide(BigInteger.valueOf(this.getN()));
    }

    public List<Payment> getPayments() {
        List<Payment> payments = new ArrayList<>();
        BigInteger amount = divide();
        for (Person participant : participants) {
            payments.add(new RoundPayment(participant, payer, amount, this));
        }
        return payments;
    }
}
