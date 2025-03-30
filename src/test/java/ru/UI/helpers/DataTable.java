package ru.UI.helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.stream.Collectors;

public class DataTable {
    /**
     * @param table - таблица, из которой берутся данные
     * @return список данных
     */
    public static List<String> getColumnData(WebElement table) {
        return table.findElements(By.cssSelector("tbody tr")).stream()
                .map(row -> row.findElements(By.tagName("td")))
                .filter(cells -> !cells.isEmpty())
                .map(cells -> cells.get(0).getText())
                .collect(Collectors.toList());
    }
}
