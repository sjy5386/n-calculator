package com.sysbot32.ncalc;

import lombok.Getter;
import lombok.ToString;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@ToString
public class NCalculator {
    private final List<Person> people;
    private final List<Round> rounds;

    public NCalculator() {
        this.people = new ArrayList<>();
        this.rounds = new ArrayList<>();
    }

    public List<Payment> calculate() {
        List<Payment> payments = new ArrayList<>();
        for (int i = 0; i < people.size(); i++) {
            Person payer = people.get(i);
            for (int j = i + 1; j < people.size(); j++) {
                Person payee = people.get(j);
                payments.add(new Payment(payer, payee, BigInteger.ZERO));
            }
        }
        for (Round round : rounds) {
            List<Payment> roundPayments = round.getPayments();
            for (Payment payment : payments) {
                for (Payment roundPayment : roundPayments) {
                    payment.merge(roundPayment);
                }
            }
        }
        return payments.stream().filter(e -> e.getAmount().compareTo(BigInteger.ZERO) > 0).collect(Collectors.toList());
    }
}
