package com.company;

import com.company.employee.Employee;

import java.util.List;

public class MailSender {


    public static void sendMail(int dayOfMonth, List<Employee> employees) {
        System.out.print("The employees ");

        employees.forEach(current -> System.out.print(current.getName()+ " "));

        System.out.print("were all born the day "+ dayOfMonth +" so they need to bring the breakfast that day");
        System.out.println();
    }
}
