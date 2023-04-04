// Подумать над структурой класса Ноутбук для магазина техники - выделить поля и методы.
// Реализовать в java.
// Создать множество ноутбуков.Написать метод, который будет запрашивать у пользователя
// критерий фильтрации и выведет  ноутбуки, отвечающие фильтру.
// NoteBook notebook1 = new NoteBook
// NoteBook notebook2 = new NoteBook
// NoteBook notebook3 = new NoteBook
// NoteBook notebook4 = new NoteBook
// NoteBook notebook5 = new NoteBook
// Например: “Введите цифру, соответствующую необходимому критерию:
// 1 - ОЗУ
// 2 - Объем ЖД
// 3 - Операционная система
// 4 - Цвет

// Далее нужно запросить минимальные значения для указанных критериев - сохранить параметры фильтрации можно также в Map.
// Отфильтровать ноутбуки их первоначального множества и вывести проходящие по условиям.
// Класс сделать в отдельном файле
// приветствие
// Выбор параметра
// выбор конкретнее
// вывод подходящих
// import java.util.Map;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;
import java.util.ArrayList;

public class program0604 {
    public static void main(String[] args) {
        Laptop NB1 = new Laptop("Huawei MateBook D15 BoD-WFH9", 16, 512, "Windows 11 Home","Черный");
        Laptop NB2 = new Laptop("HIPER EXPERTBOOK MTL 1577", 8, 256, "Windows 11 Home","Серый");
        Laptop NB3 = new Laptop("GHUWI Corebook Xpro", 16, 1024, "Windows 11 Home","Серый");
        Laptop NB4 = new Laptop("MSI Pulse GL 76 12UEK-072RU", 16, 1024, "Windows 11 Home","Черный");
        Laptop NB5 = new Laptop("ITEL Spirit 2", 16, 512, "Linux","Синий");
        Laptop NB6 = new Laptop("HPZ ZBook Fury 15G8", 32, 1024, "Linux", "Серый");
        Laptop NB7 = new Laptop("DELL Vostro 5401", 8, 512, "Linux","Золотистый");
        Laptop NB8 = new Laptop("Apple MacBook Pro  A2442", 32, 1024, "Mac OS","Серый");
        Laptop NB9 = new Laptop("Apple MacBook Pro 2485", 16, 1024, "Mac OS", "Серебристый");
  
        Set<Integer> setRAM = new TreeSet<Integer>();
        Set<Integer> setSSD = new TreeSet<Integer>();
        Set<String> setOS = new TreeSet<String>();
        Set<String> setColor = new TreeSet<String>();

        ArrayList<Laptop> listNB = new ArrayList<Laptop>();
        listNB.add(NB1);
        listNB.add(NB2);
        listNB.add(NB3);
        listNB.add(NB4);
        listNB.add(NB5);
        listNB.add(NB6);
        listNB.add(NB7);
        listNB.add(NB8);
        listNB.add(NB9);
        for (Laptop NB: listNB){
            setRAM.add(NB.getRAM());
            setSSD.add(NB.getSSD());
            setOS.add(NB.getOS());
            setColor.add(NB.getColor());
        }
        boolean fl = true;
        System.out.println("Запущена программа поиска ноутбука по техническим характеристикам\n" +
                 "-----------------------------------------------------------------");
        Scanner iScanner = new Scanner(System.in);
        int number1 = 0;             
        while(fl){
            System.out.println("Введите цифру, соответствующую необходимому критерию : \n" +
                "1 - ОЗУ \n" +
                "2 - Объем ЖД \n" +
                "3 - Операционная система\n" +
                "4 - Цвет\n" + 
                "5 - Завершение поиска");
            number1 = iScanner.nextInt();
            switch (number1) {
                case 1:
                    searchRAM_SSD(listNB, setRAM, iScanner, 1);
                    break;
                case 2 :
                    searchRAM_SSD(listNB, setSSD, iScanner, 2);
                    break;
                case 3 :
                    searchOS_Color(listNB, setOS, iScanner, 1);
                    break;
                case 4 :
                    searchOS_Color(listNB, setColor, iScanner, 2);
                    break;
                case 5 :
                    System.out.println("Завершение программы");
                    fl = false;
                    break;
                default:
                    System.err.println("Указан недопустимый оператор.");
                    break;
            }
        }
        iScanner.close();
    }
    public static void searchRAM_SSD(ArrayList<Laptop> listNB, Set<Integer> setRAM,Scanner iSc,int num ){
        int str = 0;
        int item = 0;
        boolean flag = true;
        int count = 1;
        int itrNext = 0;
        ArrayList<Integer> list = new ArrayList<Integer>();
        System.out.println("Выберите указанный параметр из следующих вариантов:");
        Iterator<Integer> itr = setRAM.iterator();
        while (itr.hasNext()) {
            itrNext = (Integer)itr.next();
            System.out.println(count + " - " + itrNext);
            list.add(itrNext);
            count ++;
        }
        System.out.println("Введите номер  выбранного параметра :");
        while(flag){
            str = iSc.nextInt();
            if ( str <= 0 || str > setRAM.size()){
                System.err.println("Указан неверный номер выбранного параметра. Повторите ввод:");
            } else{
                for ( Laptop el:listNB){
                    if (num == 1) {item = el.getRAM();
                        } else {item = el.getSSD();} 
                    if (item == list.get(str-1)) {
                        printString(el.getName(), el.getRAM(), el.getSSD(), el.getOS(), el.getColor());
                    }
                flag = false;
                }
            }
        }
        return;
    }
    public static void searchOS_Color(ArrayList<Laptop> listNB, Set<String> setAny,Scanner iSc,int num ){
        int str = 0;
        String item = "";
        boolean flag = true;
        int count = 1;
        String itrNext = "";
        ArrayList<String> list = new ArrayList<String>();
        System.out.println("Выберите указанный параметр из следующих вариантов:");
        Iterator <String>itr = setAny.iterator();
        while (itr.hasNext()) {
            itrNext = (String)itr.next();//
            System.out.println(count + " - " + itrNext);
            list.add(itrNext);
            count ++;
        }
        System.out.println("Введите номер  выбранного параметра :");
        while(flag){
            str = iSc.nextInt();
            if ( str <= 0 || str > setAny.size()){
                System.err.println("Указан неверный номер выбранного параметра. Повторите ввод:");
            } else{
                for ( Laptop el:listNB){
                    if (num == 1) {item = el.getOS();
                        } else {item = el.getColor();} 
                    if (item == list.get(str-1)) {
                        printString(el.getName(), el.getRAM(), el.getSSD(), el.getOS(), el.getColor());
                    }
                flag = false;
                }
            }
        }
        return;
    }
    
    public static void printString(String A, int B, int C,String D, String E ) {
        System.out.println("Наименование: " + A + "|ОЗУ: " + B + " Гб" +
                          "|Объем ЖД: " + C + " Гб" + "|ОС: " + D + "|Цвет: " + E);
    }
}