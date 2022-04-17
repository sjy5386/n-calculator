package com.sysbot32.ncalc;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class Person {
    private String name;

    @Override
    public String toString() {
        return name;
    }
}
