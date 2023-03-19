import java.util.LinkedList;
import java.util.ListIterator;
// Пусть дан LinkedList с несколькими элементами.
// Реализуйте метод(не void), который вернет “перевернутый” список.
public class program0401 {
    public static void main(String args[]) {
      LinkedList <String> list01 = new LinkedList<String>();
      list01.add("String 01");
      list01.add("String 02");
      list01.add("String 03");
      list01.add("String 04");
      list01.add("String 05");
      System.out.println("Исходный список: " + list01);
      LinkedList <String> newList = new LinkedList<String>();
      newList = reverseList (list01);
      System.out.println("Перевернутый список: " + newList);
    }
    public static LinkedList<String> reverseList (LinkedList<String> listOld ) {
      ListIterator<String> listIterator = listOld.listIterator(listOld.size());
      LinkedList <String> listNew = new LinkedList<String>();
      while (listIterator.hasPrevious())  {
          listNew.add(listIterator.previous());
        }
        return listNew;
    }

    // public static LinkedList reverseList (LinkedList listOld ) {
    //   ListIterator<String> listIterator = listOld.listIterator(listOld.size());
    //   LinkedList <String> listNew = new LinkedList<String>();
    //   while (listIterator.hasPrevious())  {
    //       listNew.add(listIterator.previous());
    //     }
    //     return listNew;
    // }
  }