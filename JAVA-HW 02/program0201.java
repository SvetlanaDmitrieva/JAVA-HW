// Реализуйте алгоритм сортировки пузырьком числового массива (введён вами), 
//результат после каждой итерации запишите в лог-файл.
import java.io.IOException;
import java.util.logging.*;
import java.util.Arrays;

public class program0201 {
    public static void main(String args[]) throws IOException{
        Logger logger = Logger.getLogger(program0201.class.getName());
        logger.setLevel(Level.ALL);
        FileHandler fh = new FileHandler("log.xml",true);
        logger.addHandler(fh);
        XMLFormatter xml = new XMLFormatter();
        fh.setFormatter(xml);
        logger.log(Level.WARNING, "Тестовое логирование 1");
        logger.info("Сортировка пузырьком числового массива ");

        int[] arrForSort = {25, 18, 6, 21, 1, 12, 35, 2};
        LogRecord record1 = new LogRecord(Level.INFO,"Исходный массив" + Arrays.toString(arrForSort));
        logger.log(record1);                                 
        String str1 = "";
        for (int i = 0; i < arrForSort.length - 1; i++) {
            for(int j = 0; j < arrForSort.length - i - 1; j++) {
                if(arrForSort[j + 1] < arrForSort[j]) {
                    int work = arrForSort[j];
                    arrForSort[j] = arrForSort[j + 1];
                    arrForSort[j + 1] = work;
                    str1 = "Отсортированный массив" + Arrays.toString(arrForSort);
                    LogRecord record2 = new LogRecord(Level.INFO,str1);
                    logger.log(record2);
                }   
            }
        }

        for(int i = 0; i < arrForSort.length; i++){
            System.out.print(arrForSort[i] + "\n");
            }
        logger.info("Конец сортировки ");
    }   
 }
