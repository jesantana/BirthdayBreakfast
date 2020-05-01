package com.company.employee;

import org.jooq.lambda.Seq;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class EmployeeRepository {

    public static List<Employee> findAll() {
        Random random = new Random();
        Stream<Integer> days = IntStream.generate(()-> random.nextInt(27) + 1)
                .mapToObj(i-> new Integer(i))
                .limit(500);

        Stream<Integer> months = IntStream.generate(()-> random.nextInt(11) + 1)
                .mapToObj(i-> new Integer(i))
                .limit(500);

        return Seq.seq(days).zip(months, (d, m) -> new Employee(m, d))
                .collect(Collectors.toList());

    }
}
