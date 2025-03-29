package ru.UI.helpers;

import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Generate {
    public static String generatePostCode() {
        Random random = new Random();
        return IntStream.generate(() -> random.nextInt(10))
                .limit(10)
                .mapToObj(String::valueOf)
                .collect(Collectors.joining());
    }

    public static String generateName(String postCode){
        return IntStream.range(0, 5)
                .map(i -> i * 2)
                .mapToObj(i -> postCode.substring(i, i + 2))
                .mapToInt(Integer::parseInt)
                .map(n -> n % 26)
                .mapToObj(n -> String.valueOf((char) ('a' + n)))
                .collect(Collectors.joining());
    }
}
