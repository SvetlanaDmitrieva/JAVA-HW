// (Дополнительное) Реализовать простой калькулятор (+ - / *)
//В калькулятор добавьте возможность отменить последнюю операцию.

import java.util.Scanner;
import java.util.Stack;
public class program0403 {
    public static void main(String[] args) {
        boolean fl = true;
        int count = 0;
        System.out.println("Запущена программа Калькулятор  \n" +
                 "------------------------------");
        System.out.println("Поддерживаются следующие операции : \n" +
                "1. Сложение (+) \n" +
                "2. Вычитание (-) \n" +
                "3. Умножение (*) \n" +
                "4. Деление (/) \n" + 
                "5. Отмена последней операции (c)\n" +
                "6. Завершение расчетов (f)");
        Scanner iScanner = new Scanner(System.in);
        Stack <String> dStack = new Stack<String>();
        double number1 = 0.0, number2 = 0.0, res = 0.0;
        while(fl){
            if (count == 0) {
                System.out.println("Введите первое число: ");
                number1 = iScanner.nextDouble();
                dStack.push(Double.toString(number1));
                count ++;}   
            System.out.println("Введите один из следующих опреторов: (+ , - , * , /, c, f) ");
            char operation = iScanner.next().charAt(0);
            if (operation == '+' || operation == '-' || operation == '*' || operation == '/'){
                System.out.println("Введите второе число: ");
                number2 = iScanner.nextDouble();
            } else{
                if (!(operation == 'c' || operation == 'с' || operation == 'f' || operation == 'F')) {
                    System.err.println("Неверный оператор. Введите + или - или * или /");
                }
            }
            if (operation == '/' &&  number2 == 0.0) {
                System.err.println("Второе число при делении не может быть равно 0.0 .");
            }
            number1 = Double.parseDouble(dStack.peek());
            switch (operation) {
                case '+':
                    res = number1 + number2;
                    pushOperetion(dStack, operation, number2, res);
                    break;
                case '-':
                    res = number1 - number2;
                    pushOperetion(dStack, operation, number2, res);
                    break;
                case '*':
                    res = number1 * number2;
                    pushOperetion(dStack, operation, number2, res);
                    break;
                case '/':
                    res = number1 / number2;
                    pushOperetion(dStack, operation, number2, res);
                    break;
                case 'c':
                case 'с':
                    if(dStack.size()==1) {
                        System.out.println("Отмена невозможна.Калькулятор обнулен");
                        dStack.clear();
                        count = 0;
                    } else {
                        dStack.pop();
                        dStack.pop();
                        dStack.pop();
                        System.out.println("Текущее значение:  " + dStack.peek());
                    }
                    break;
                case 'f':
                case 'F':
                    fl = false;
                    System.out.println("Завершение работы программы");
                    break;
                default:
                    System.err.println("Указан недопустимый оператор.");
                    break;
            }
        }
        iScanner.close();
    }
    public static Stack<String> pushOperetion(Stack<String> stack1,  char sign, 
                                            Double num2,Double result) {
        System.out.println(Double.parseDouble(stack1.peek()) + " " + sign + " " + num2 + " = " + result);
        stack1.push(Character.toString(sign));
        stack1.push(Double.toString(num2));
        stack1.push(Double.toString(result));    
        return  stack1;
    }
}