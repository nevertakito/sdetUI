package ru.UI.helpers;

import java.util.Comparator;
import java.util.List;

public class FindDeleteCustomer {
    /**
     * @param customers - список покупателей
     * @return покупателя, длина имени которого приближена к среднему значению длин всех имен
     */
    public static String findCustomer(List<String> customers){
        double averageLength = customers.stream()
                .mapToInt(String::length)
                .average()
                .orElse(0.0);
        return customers.stream()
                .min(Comparator.comparingDouble(
                        name -> Math.abs(name.length() - averageLength)
                ))
                .orElse(null);
    }
}
