import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int chess[][] = new int[n][n];
        printNQueens(chess,0,"",0,0);
    }

    public static void printNQueens(int[][] chess, int qsf, String ans, int r, int c) {
        if(r==chess.length){
            if(qsf==chess.length)
            {
                System.out.println(ans+".");
                
            }
            return;
        }
        
        if(c+1 < chess[0].length)
        {
            //yes call
            if(isValid(chess,r,c)){
                chess[r][c] = 1;
                printNQueens(chess,qsf+1,ans+r+"-"+c+", ",r+1,0);
                chess[r][c] = 0;
            }
            //no call
            printNQueens(chess,qsf,ans,r,c+1);
        }else
        {
            //yes call
            if(isValid(chess,r,c)){
                chess[r][c] = 1;
                printNQueens(chess,qsf+1,ans+r+"-"+c+", ",r+1,0);
                chess[r][c] = 0;
            }
            //no call
            printNQueens(chess,qsf,ans,r+1,0);
        }
    }
    public static boolean isValid(int [][]chess, int r, int c)
    {
        int dir[][] = {
            {-1,0},
            {-1,1},
            {-1,-1}
        };
        int radius = chess.length;
        for(int rad=1; rad<radius; rad++)
        {
            for(int d=0; d<dir.length; d++)
            {
                int rr = r + rad * dir[d][0];
                int cc = c + rad * dir[d][1];
                
                if(rr >= 0 && rr < radius && cc >= 0 && cc < radius){
                    if( chess[rr][cc]==1)
                        return false;
                }
            }
        }
        return true;
    }
}


