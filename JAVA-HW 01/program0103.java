// Реализовать простой калькулятор (+ - / *)
// Ввод числа ->
// Ввод знака ->
// Ввод числа ->
import java.util.Scanner;
public class program0103 {
    public static void main(String[] args) {
        System.out.println("Запущена программа Калькулятор  \n" +
                 "------------------------------");
        System.out.println("Поддерживаются следующие операции : \n" +
                "1. Сложение (+) \n" +
                "2. Вычитание (-) \n" +
                "3. Умножение (*) \n" +
                "4. Деление (/) \n");
        Scanner iScanner = new Scanner(System.in);
        System.out.println("Введите первое число: ");
        double number1 = iScanner.nextDouble();
        System.out.println("Введите один из следующих опреторов: (+ , - , * , /) ");
        char operation = iScanner.next().charAt(0);
        System.out.println("Введите второе число: ");
        double number2 = iScanner.nextDouble();
        if (!(operation == '+' || operation == '-' || operation == '*' || operation == '/')) {
            System.err.println("Неверный оператор. Введите + или - или * или /");
        }
        if (operation == '/' && number2 == 0.0) {
            System.err.println("Второе число при делении не может быть равно 0.0 .");
        }
        switch (operation) {
            case '+':
                System.out.println(number1 + " + " + number2 + " = " + (number1 + number2));
                break;
            case '-':
                System.out.println(number1 + " - " + number2 + " = " + (number1 - number2));
                break;
            case '*':
                System.out.println(number1 + " x " + number2 + " = " + (number1 * number2));
                break;
            case '/':
                System.out.println(number1 + " / " + number2 + " = " + (number1 / number2));
                break;
            default:
                System.err.println("Указан недопустимый оператор.");
                break;
        }
        iScanner.close();
    }
}