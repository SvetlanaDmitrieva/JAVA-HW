// Реализовать простой калькулятор (+ - / *)
// Ввод числа ->
// Ввод знака ->
// Ввод числа ->
//К калькулятору из предыдущего дз добавить логирование.
import java.io.IOException;
import java.util.logging.*;
import java.util.Scanner;
public class program0203 {
    public static void main(String[] args) throws IOException {
        Logger logger = Logger.getLogger(program0203.class.getName());
        logger.setLevel(Level.ALL);
        FileHandler fh = new FileHandler("log03.xml",true);
        logger.addHandler(fh);
        XMLFormatter xml = new XMLFormatter();
        fh.setFormatter(xml);

        logger.info("Запущена программа Калькулятор ");
        System.out.println( "------------------------------------");
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
        logger.info("Введено: " + number1 + " " + operation + " " +  number2);
        if (!(operation == '+' || operation == '-' || operation == '*' || operation == '/')) {
            logger.info("Введен неверный знак операции:" +  operation + ". Введите + или - или * или /");
        }
        if (operation == '/' && number2 == 0.0) {
            logger.info("Второе число при делении не может быть равно 0.0 .");
        }
        switch (operation) {
            case '+':
                logger.info("Результат оперции: " + number1 + " + " + number2 +  " = " + (number1 + number2));
                break;
            case '-':
                logger.info("Результат оперции: " + number1 + " - " + number2  +  " = " + (number1 - number2));
                break;
            case '*':
                logger.info("Результат оперции: " + number1 + " x " + number2 +  " = " + (number1 * number2));
                break;
            case '/':
                logger.info("Результат оперции: " + number1 + " / " + number2 +  " = " + (number1 / number2));
                break;
            default:
                logger.info("Указан недопустимый оператор: " +  operation);
                break;
        }
        iScanner.close();
    }
}