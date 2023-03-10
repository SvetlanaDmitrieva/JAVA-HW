// Задано уравнение вида q + w = e, q, w, e >= 0.
// Некоторые цифры могут быть заменены знаком вопроса, например 2? + ?5 = 69 (пользователь).
// Требуется восстановить выражение до верного равенства.
// Предложить хотя бы одно решение или сообщить, что его нет.
// Ввод: 2? + ?5 = 69
// Вывод: 24 + 45 = 69
public class program0104 {
    public static void main(String[] args){
        String equation = "?6 + 3? = 91";// ?6 + 3? = 91;  2? + 43 = ?9; 4? + ?2 = 97
        System.out.printf("Восстановить выражение до верного равенства: %s \n", equation);
        String nequation = equation.replace('+', ' ')
            .replace('=', ' ');
        String[] arrStr = nequation.split("\\s+");
        String[] narrStr = arrStr.clone();
        int left = 0;
        int right = 0;
        for ( int i = 0; i < 2; i++){
            left = left + isHereSymbol(narrStr[i]);
            narrStr[i] = narrStr[i].replace("?", "0");
            }
        right += isHereSymbol(narrStr[2]);
        narrStr[2] = narrStr[2].replace("?", "0");
        int intDifference = Math.abs(Integer.parseInt(narrStr[0]) + Integer.parseInt(narrStr[1])
                            - Integer.parseInt(narrStr[2]));
        int leftRight = Math.abs(left - right);
        String searchNumber = Integer.toString(intDifference/leftRight);
        String []marrStr = arrStr.clone();
        for ( int i = 0; i < marrStr.length; i++){
            marrStr[i] = marrStr[i].replace("?", searchNumber);
        };
        int result1 = Integer.parseInt(marrStr[2]) - Integer.parseInt(marrStr[0]) 
                        - Integer.parseInt(marrStr[1]);
        if (result1 == 0.0){
            System.out.printf("Найдено решение: %s + %s = %s", marrStr[0] ,marrStr[1], marrStr[2]);
        } else {
            System.out.println("Уравнение не имеет решения");
        }
    }
    
        public static int isHereSymbol(String arr) {
            boolean start = arr.startsWith("?"); 
            boolean end = arr.endsWith("?"); 
            int result = 0;
            if (start) result += 10;
            if (end) result += 1 ;
            return result;
    }
}