// (Дополнительное) Реализовать алгоритм сортировки слиянием

import java.util.Arrays;
public class program0303 {
    public static void main(String args[]) {
        int[] arrayForSort = new int[]{25, 18, 6, -21, 1002, 1, 12, 35, 2, 78, 102 ,33, -5};
        System.out.println("Исходный список :" + Arrays.toString(arrayForSort));
        sortMerge(arrayForSort, 0, arrayForSort.length-1);
        System.out.println("Отсортированный список :" + Arrays.toString(arrayForSort));
    }

    public static void sortMerge(int[] sortArr, int indLeft, int indRight) {
        if (indLeft >= indRight) return;
        int indMiddle = (indRight - indLeft) / 2 + indLeft;
        sortMerge(sortArr, indLeft, indMiddle);
        sortMerge(sortArr, indMiddle + 1, indRight);
        merge(sortArr, indLeft, indMiddle, indRight);
    }

    private static void merge(int[] mergeArr, int indLeft, int indMiddle, int indRight) {
        int[] copyArr = Arrays.copyOf(mergeArr, mergeArr.length);
        int i = indLeft;
        int j = indMiddle + 1;
        int k = indLeft;
        while (i <= indMiddle && j <= indRight) {
            if (copyArr[i] <= copyArr[j]) mergeArr[k++] = copyArr[i++];
            else mergeArr[k++] = copyArr[j++];
        }
        while (i <= indMiddle) mergeArr[k++] = copyArr[i++];
    }
}