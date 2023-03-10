// Вывести все простые числа от 1 до 1000
// import java.util.Scanner;
public class program0102 {
    public static void main(String[] args){
        int highBorder = 1000;
        double dhigh = (double)highBorder;
        boolean [] arrNumbers = new boolean [highBorder];
        int maximStep = (int)(Math.sqrt(dhigh)); 
        int step = 0;
        for ( int i = 1; i < maximStep; i++){
            if (arrNumbers[i] == false) {
                for ( int j = i +i + 1; j < highBorder; j = j + i + 1){
                    arrNumbers[j] = true;
                }
            }
        }
        for ( int i = 0; i < highBorder; i++){
            if (arrNumbers[i] == false){
                System.out.printf("%d ",i+1);
                step++;
                if ((step)%10 == 0) {
                    System.out.println("");
                    step = 0;
                }
            }
        }
    }
}
