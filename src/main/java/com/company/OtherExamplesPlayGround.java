package com.company;

import lombok.ToString;
import org.jooq.lambda.Seq;

import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class OtherExamplesPlayGround {
    static List<ObjectWithNumber> list = List.of(new ObjectWithNumber(5), new ObjectWithNumber(1), new ObjectWithNumber(3), new ObjectWithNumber(9));

    public static void sumAListOfNumbersJava8() {
        int result = list.stream()
                .reduce(0, (acc,current) -> acc + current.number, Integer::sum );

        System.out.println(result);
    }

    public static void sumAListOfNumbersJool() {
        int result = Seq.seq(list).sumInt(current -> current.number);

        System.out.println(result);
    }


    public static void printStreamToConsoleJava8() {
        Stream<ObjectWithNumber> result = list.stream();

        String stringResult = result.reduce(new StringBuilder(),
                                            (acc, current) -> acc.append(current),
                                            StringBuilder::append)
                                    .toString();

        System.out.println(stringResult);
    }

    public static void printStreamToConsoleJool() {
        String stringResult = Seq.seq(list).toString(",");

        System.out.println(stringResult);
    }


    public static void splitListIntoPagesOfSizeNJava8() {
        int pageSize = 2;

        var result = IntStream.range(0, list.size()-pageSize+1)
                        .mapToObj(start -> list.subList(start, start+pageSize));

        System.out.println(result);
    }

    public static void splitListIntoPagesOfSizeNJool() {
        int pageSize = 2;

        var result =Seq.seq(list).sliding(pageSize);

        System.out.println(result);

    }
}

@ToString
class ObjectWithNumber {
    int number;


    public ObjectWithNumber(int i) {
        number = i;
    }
}
