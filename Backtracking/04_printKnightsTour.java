import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[][] = new int [n][n];
        int r = sc.nextInt();
        int c = sc.nextInt();
        arr[r][c] = 1;
        printKnightsTour01(arr, r, c, 1);
    }
    
  
    static int dir[][]={{-2,1}, {-1,2}, {1,2}, {2,1}, {2,-1}, {1,-2}, {-1,-2}, {-2,-1}};
    
    public static void printKnightsTour01(int[][] board, int r, int c, int count) {
        if(count == (board.length * board.length))
        {
            display(board);
            System.out.println();
            return;
        }
        
        for(int d=0; d<dir.length; d++)
        {
            int rr = r+dir[d][0];
            int cc = c+dir[d][1];
            if(rr >= 0 && rr < board.length && cc >= 0 && cc < board.length && board[rr][cc] == 0)
            {
                board[rr][cc] = count+1;
                printKnightsTour01(board,rr,cc,count+1);
                board[rr][cc] = 0;
            }
        }
    }

    public static void display(int[][] board) {
        for(int[] arr : board) {
            for(int val : arr) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }

}





