package com.sysbot32.ncalc;

import org.junit.jupiter.api.Test;

import java.math.BigInteger;

import static org.junit.jupiter.api.Assertions.*;

class PaymentTest {
    private final Person person1 = new Person("Alice");
    private final Person person2 = new Person("Bob");

    @Test
    void mergeSuccessTest1() {
        Payment payment1 = new Payment(person1, person2, BigInteger.ONE);
        Payment payment2 = new Payment(person1, person2, BigInteger.ONE);

        payment1.merge(payment2);

        assertEquals(person1, payment1.getPayer());
        assertEquals(person2, payment1.getPayee());
        assertEquals(0, payment1.getAmount().compareTo(BigInteger.TWO));
    }

    @Test
    void mergeSuccessTest2() {
        Payment payment1 = new Payment(person1, person2, BigInteger.TWO);
        Payment payment2 = new Payment(person2, person1, BigInteger.ONE);

        payment1.merge(payment2);

        assertEquals(person1, payment1.getPayer());
        assertEquals(person2, payment1.getPayee());
        assertEquals(0, payment1.getAmount().compareTo(BigInteger.ONE));
    }

    @Test
    void mergeSuccessTest3() {
        Payment payment1 = new Payment(person1, person2, BigInteger.ONE);
        Payment payment2 = new Payment(person2, person1, BigInteger.TWO);

        payment1.merge(payment2);

        assertEquals(person2, payment1.getPayer());
        assertEquals(person1, payment1.getPayee());
        assertEquals(0, payment1.getAmount().compareTo(BigInteger.ONE));
    }

    @Test
    void swapSuccessTest1() {
        Payment payment = new Payment(person1, person2, BigInteger.ONE);
        payment.swap();

        assertEquals(person2, payment.getPayer());
        assertEquals(person1, payment.getPayee());
        assertEquals(0, payment.getAmount().compareTo(BigInteger.valueOf(-1)));
    }

    @Test
    void swapSuccessTest2() {
        Payment payment = new Payment(person1, person2, BigInteger.valueOf(-1));
        payment.swap();

        assertEquals(person2, payment.getPayer());
        assertEquals(person1, payment.getPayee());
        assertEquals(0, payment.getAmount().compareTo(BigInteger.ONE));
    }
}