package com.sysbot32.ncalc;

import lombok.Getter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Getter
@ToString
public class NCalculator {
    private final List<Person> people;
    private final List<Round> rounds;

    public NCalculator() {
        this.people = new ArrayList<>();
        this.rounds = new ArrayList<>();
    }
}
