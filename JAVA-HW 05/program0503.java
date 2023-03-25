// На шахматной доске расставить 8 ферзей так, чтобы они не били друг друга. И вывести Доску. 
// Пример вывода доски 8x8
// 0x000000
// 0000x000
// 00x00000

public class program0503 {
    public static void main(String[] args) {
        int size = 8; 
        int num = 8;
        int board[][] = new int[size][size];
        placementQueens(0, num, board, size );
        printBoard(board);
    }
        public static boolean check(int row, int col, int board[][], int size  ){
        for (int i = 0; i < col; i++) {
            if (board[row][i] == 1) {
                return false;
            }
            if (row - 1 - i >= 0 && board[row - 1 - i][col - 1 - i] == 1) {
                return false;
            }
            if (row + 1 + i < size && board[row + 1 + i][col - 1 - i] == 1) {
                return false;
            }
        }
        return true;
    }

    public static boolean placementQueens(int N, int num, int board[][], int size  ){
          if (N == num) {
            return true;
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                board[j][N] = 0;
            }
            if (check(i, N, board, size)) {
                board[i][N] = 1;
                if (placementQueens(N+1, num, board, size )) {
                    return true;
                }
            }
        }
        return false;
    }
    public static void printBoard(int board[][] ){
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                System.out.print(board[i][j]);
            }
            System.out.println();
        }
    }
}