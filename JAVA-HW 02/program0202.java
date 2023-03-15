// Дана строка (получение через обычный текстовый файл!!!)
// "фамилия":"Иванов","оценка":"5","предмет":"Математика"
// "фамилия":"Петрова","оценка":"4","предмет":"Информатика"
// Написать метод(ы), который распарсит строку и, используя StringBuilder, создаст строки вида:
// Студент [фамилия] получил [оценка] по предмету [предмет].
// Пример вывода:
// Студент Иванов получил 5 по предмету Математика.
// Студент Петрова получил 4 по предмету Информатиpка.
// Студент Краснов получил 5 по предмету Физика.

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;

 public class program0202 {
     public static void main(String[] args) throws Exception {
        try {
            File file = new File("file.txt");
            File file02 = new File("file02.txt");
            BufferedReader br = new BufferedReader(new FileReader(file));
            String ru;
            StringBuilder sb = new StringBuilder();
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file02,false));
            PrintStream ps = new PrintStream(System.out, true, "UTF8");
            while((ru = br.readLine())!=null) {  
                ps.println(ru);
                String[] subLines = ru.replace(":", " ")
                .replaceAll("\"", "").replace(",", " ").split(" ");
                sb.append("Студент ").append(subLines[1]).append(" получил ")
                .append(subLines[3]).append(" по предмету ").append(subLines[5]).append("\n");
                ru = sb.toString();
                System.out.println(ru);
                bufferedWriter.write(ru); 
                sb.setLength(0);
            }
            br.close();
            ps.close();
            bufferedWriter.close();

        } catch (IOException e) {
            System.out.println("Ошибки при чтении/записи файла ");
        } 
    }
 }