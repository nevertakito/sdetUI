package ru.UI.helpers;

import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Generate {
    /**
     * @return произвольные 10 цифр в виде строки
     */
    public static String generatePostCode() {
        Random random = new Random();
        return IntStream.generate(() -> random.nextInt(10))
                .limit(10)
                .mapToObj(String::valueOf)
                .collect(Collectors.joining());
    }

    /**
     * Метод генерирует имя по правилу: Post Code условно разбиваем на двузначные числа
     * (получится 5 чисел) и каждое число преобразовываем в букву английского алфавита по порядку от 0 до 25.
     * Если число больше 25, то начинаем с 26 как с 0. То есть 0 - a, 26 - тоже a, 52 – тоже a, и так далее.
     * @param postCode - строка из 10 цифр
     * @return сгенерированное имя
     */
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
