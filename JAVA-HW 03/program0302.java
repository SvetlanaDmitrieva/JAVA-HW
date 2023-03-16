// Задан целочисленный список ArrayList. Найти минимальное, максимальное 
// и среднее ариф. из этого списка.
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Iterator;

public class program0302 {
    public static void main(String args[]) {
        int minNumber = 100000000;
        int maxNumber = -100000000;
        int sumNumber = 0;
        ArrayList <Integer> list01 =   new ArrayList<Integer>
            (Arrays.asList(25, 18, 6, -21, 1, 12, 35, 2, 78, 102 ,33, -5, 1002));
        System.out.println("Анализируемый список :" + list01);
        for (Iterator<Integer> iterator = list01.iterator(); iterator.hasNext();) {
            Integer number = iterator.next();
            if (number > maxNumber) {maxNumber = number;}
            if (number < minNumber) {minNumber = number;}
            sumNumber += number;
            }
        System.out.println("Минимальное число списка: " + minNumber);
        System.out.println("Максимальное число списка: " + maxNumber);
        int len = list01.size();
        System.out.printf("Среднее арифметическое списка: %.2f " , (float)sumNumber/len);
    }   
 }