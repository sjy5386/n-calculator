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
}
