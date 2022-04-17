package com.sysbot32.ncalc;

import org.junit.jupiter.api.Test;

import java.math.BigInteger;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RoundTest {
    private final Round round;

    RoundTest() {
        Person payer = new Person("Alice");
        round = new Round("Party", BigInteger.TEN, payer);
        String[] names = {"Bob", "Carol"};
        for (String name : names) {
            round.getParticipants().add(new Person(name));
        }
    }

    @Test
    void getNSuccessTest1() {
        int n = round.getN();

        assertEquals(3, n);
    }

    @Test
    void dividedSuccessTest1() {
        BigInteger quotient = round.divide();
        BigInteger remainder = round.getAmount().remainder(BigInteger.valueOf(round.getN()));

        assertEquals(0, quotient.compareTo(BigInteger.valueOf(3)));
        assertEquals(0, remainder.compareTo(BigInteger.ONE));
        assertEquals(0, round.getAmount().compareTo(quotient.multiply(BigInteger.valueOf(round.getN())).add(remainder)));
    }

    @Test
    void getPaymentsSuccessTest1() {
        List<Payment> payments = round.getPayments();
        BigInteger amount = round.divide();

        for (int i = 0; i < payments.size(); i++) {
            assertEquals(round.getPayer(), payments.get(i).getPayee());
            assertEquals(round.getParticipants().get(i), payments.get(i).getPayer());
            assertEquals(amount, payments.get(i).getAmount());
        }
    }
}