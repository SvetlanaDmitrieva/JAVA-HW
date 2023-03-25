
// Реализуйте структуру телефонной книги с помощью HashMap, 
//учитывая, что 1 человек может иметь несколько телефонов.
// Добавить функции 1) Добавление номера
// 2) Вывод всего справочника
import java.util.Map;
import java.util.HashMap;
import java.util.Scanner;

public class program0501 {
    public static void main(String args[]) {
      Map<String, String> db = new HashMap<>();
      Scanner iSc = new Scanner(System.in, "UTF-8");
      System.out.println("Запущена программа телефонного справочника \n" +
      "------------------------------------------");
      boolean fl = true;
      String str = "";
      String numbersAll = "";
      String numbPhone = "";
      int number1 = 0;
      while(fl){
        System.out.println("Введите код операции(1,2,3): ");
        System.out.println("1. Добавление номера (1) \n" +
        "2. Вывод всего справочника (2) \n" +
        "3. Завершение программы (3) " );
        str = iSc.nextLine();
        number1 = Integer.parseInt (str);
        switch (number1) {
          case 1:
            System.out.println("Введите фамилию абонента :");
            str = iSc.nextLine();
            str = str.substring(0, 1).toUpperCase() + str.substring(1).toLowerCase();
            System.out.println("Введена фамилия :" + str);
            System.out.println("Введите номер телефона абонента :");
            numbPhone = iSc.nextLine();
            if (db.containsKey(str)){
              numbersAll = db.get(str);
              numbPhone = numbersAll + ", " + numbPhone;
            }
            db.put(str, numbPhone);
            break;
          case 2:
            if (!db.isEmpty()){
              for (var item : db.entrySet()) {
                System.out.printf("[%s: %s]\n", item.getKey(), item.getValue());
              } 
            } else { 
                System.out.println("Справочник пуст. ");
            }
            break;
          case 3:
            fl = false;
            System.out.println("Программа завершена.");
            break;
          default:
            System.err.println("Указан недопустимый код операции.");
            break;
        }
      }
      iSc.close();
    }
}