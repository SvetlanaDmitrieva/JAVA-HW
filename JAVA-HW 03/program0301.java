// Пусть дан произвольный список целых чисел, удалить из него чётные числа
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Iterator;

public class program0301 {
    public static void main(String args[]) {
        ArrayList <Integer> list01 = new ArrayList<Integer>(Arrays.asList(25, 18, 6, 21, 1, 12, 35, 2));
        System.out.println("Исходный список :" + list01);
        for (Iterator<Integer> iterator = list01.iterator(); iterator.hasNext();) {
            Integer number = iterator.next();
            if (number % 2 == 0) {
                System.out.println("Удаляем четное число: " + number);
                iterator.remove();
            }
        }
        System.out.println("Получившийся список :" + list01);
    }   
 }
