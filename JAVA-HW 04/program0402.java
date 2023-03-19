// Реализуйте очередь с помощью LinkedList со следующими методами:
// enqueue() - помещает элемент в конец очереди,
// dequeue() - возвращает первый элемент из очереди и удаляет его,
// first() - возвращает первый элемент из очереди, не удаляя.
import java.util.LinkedList;
import java.util.Scanner;

public class program0402 {
    public static void main(String args[]) {
        LinkedList <String> list01 = new LinkedList<String>();
        String numb ;
        boolean fl = true;
        System.out.println("Запущена программа реализации очереди\n" +
                 "-------------------------------------");
        System.out.println("Поддерживаются следующие операции : \n" +
                "1 : Помещает элемент в конец очереди \n" +
                "2 : Возвращает первый элемент из очереди и удаляет его \n" +
                "3 : Возвращает первый элемент из очереди, не удаляя \n" +
                "4 : Выход из программы \n");
        Scanner iScanner = new Scanner(System.in,"utf8" );
        while(fl){
            System.out.println("Введите номер операции: ");
            numb = iScanner.nextLine();
            if (list01.isEmpty() && !numb.equals("1") && !numb.equals("4"))
                {System.out.println("Очередь пуста. Добавьте новый элемент(1)");
                numb = "5";
                }
            switch (numb) {
                case "1":
                    list01 = enqueue(list01, iScanner);
                    break;
                case "2":
                    list01 = dequeue(list01);
                    break;
                case "3":
                    list01 = first (list01);
                    break;
                case "4":
                    System.out.println("Завершение программы");
                    fl = false;
                    break;
                default:
                    System.err.println("Указан недопустимый номер операции.");
                    break;
            }
        }
        iScanner.close();
    }   
    public static LinkedList <String> enqueue(LinkedList<String> list, Scanner iSc){
        System.out.println("Введите новый элемент :");
        String str = iSc.nextLine();
        list.add(str);
        System.out.println("Добавлен в конец очереди: " +  str );
        System.out.println(list);
        return list;
    }
    public static LinkedList <String> dequeue(LinkedList<String> list){
        System.out.println("Удален первый элемент " + list.remove(0) +" очереди: " + list);
        return list; 
    }
    public static LinkedList <String> first (LinkedList<String> list){
        System.out.println("Первый элемент " + list.get(0) + " очереди: " + list);
        return list; 
    }
 }