// Пусть дан список сотрудников:
// Иван Иванов
// Светлана Петрова
// Кристина Белова
// Анна Мусина
// Анна Крутова
// Иван Юрин
// Петр Лыков
// Павел Чернов
// Петр Чернышов
// Мария Федорова
// Марина Светлова
// Мария Савина
// Мария Рыкова
// Марина Лугова
// Анна Владимирова
// Иван Мечников
// Петр Петин
// Иван Ежов

// Написать программу, которая найдет и выведет повторяющиеся имена с количеством повторений.
// Отсортировать по убыванию популярности Имени.
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Comparator;
import java.util.stream.Collectors;
import java.util.HashMap;
public class program0502 {
    public static void main(String args[]) { 
        String[][] names = { 
            {"Иван", "Иванов"},{"Светлана", "Петрова"},{"Кристина", "Белова"},
            {"Анна", "Мусина"},{"Анна", "Крутова"},{"Иван", "Юрин"},
            {"Петр", "Лыков"},{"Павел", "Чернов"},{"Петр", "Чернышов"},
            {"Мария", "Федорова"},{"Марина", "Светлова"},{"Мария", "Савина"},
            {"Мария", "Рыкова"},{"Марина", "Лугова"},{"Анна", "Владимирова"},
            {"Иван", "Мечников"},{"Петр", "Петин"},{"Иван", "Ежов"}
        };
        int numb = 1;
        Map<String, Integer> dbNames = new HashMap<>();
        for ( int i = 0; i < names.length; i++){
            if (dbNames.containsKey(names[i][0])){
                numb = dbNames.get(names[i][0]);
                numb ++ ;
              } else { numb = 1;}
            dbNames.put(names[i][0], numb);
        }
        Map<String, Integer> sortedbNames = dbNames.entrySet().stream() 
        .sorted(Comparator.comparingInt(e -> -e.getValue())) 
        .collect(Collectors.toMap( 
        Map.Entry::getKey, 
        Map.Entry::getValue, 
        (a, b) -> { throw new AssertionError(); }, 
        LinkedHashMap::new 
        )); 
        sortedbNames.entrySet().forEach(System.out::println); 
    }
 }