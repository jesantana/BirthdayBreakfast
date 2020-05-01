package com.company.employee;

import org.apache.commons.lang3.RandomStringUtils;

import java.time.LocalDateTime;



public class Employee {

    public Employee(int month, int dayOfBirthday) {
        birthDay = LocalDateTime.of(1990, month,dayOfBirthday, 12,00);
        name = RandomStringUtils.random(5, "abcdefghijklmnopqrstopvwxyz");
    }

    LocalDateTime birthDay;
    String name;


    public String getName() {
        return name;
    }
}
