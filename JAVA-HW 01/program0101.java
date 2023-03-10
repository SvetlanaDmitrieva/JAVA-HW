// Вычислить n-ое треугольного число(сумма чисел от 1 до n), а так же n!
// (произведение чисел от 1 до n)
import java.util.Scanner;
public class program0101 {
    public static void main(String[] args){
        int number1 = readNumber();
        System.out.printf("треугольное число : %d", sum(number1));
        System.out.printf("; факториал числа : %d", factorialN(number1));
    }
    static int sum (int number){
        int summa = 0;
        for( int  i = 1; i < number + 1 ; i++){
            summa += i;
        }
        return summa;
    }
    
    static int factorialN ( int number){
        int factNumber = 1;
        for( int  i = 2; i < number + 1 ; i++) {
            factNumber *= i;
        }
        return factNumber;
    }

    public static int readNumber(){
        Scanner iScanner = new Scanner(System.in);
        System.out.print("Введите число n :");
        try {
            int number1 = iScanner.nextInt();
            iScanner.close();
            return number1;
        } catch (Exception e) {
            System.out.println(" Ошибка. Повторите ввод числа");
            return readNumber();
        } 
    }
 }