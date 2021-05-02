import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int m = scn.nextInt();
        int[][] arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] = scn.nextInt();
            }
        }
        floodfill(arr,0,0,"");
    }

    static int rdir[] = {-1,0,1,0};
    static int cdir[] = {0,-1,0,1};
    static char dirn[] = {'t','l','d','r'};
    
    public static void floodfill(int[][] maze, int sr, int sc, String ans) {
        if(sr==maze.length-1 && sc == maze[0].length-1)
        {
            System.out.println(ans);
            return;
        }
        
        maze[sr][sc] = 1;
        
        for(int d=0; d<dirn.length; d++){
            int rr = sr + rdir[d];
            int cc = sc + cdir[d];
            if(rr>=0 && cc>=0 && rr<maze.length && cc<maze[0].length && maze[rr][cc]!=1)
            {
                floodfill(maze,rr,cc,ans+dirn[d]);
            }
        }
        
        maze[sr][sc] = 0;
    }
}
