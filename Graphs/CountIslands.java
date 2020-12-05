import java.util.*;
public class CountIslands
{
    public static void countIsland(int i, int j, int M[][], boolean[][] vis)
    {
        int n = M.length;
        int m = M[0].length;
        if(i<0 || j<0 || i>=n || j>=m || M[i][j]==0 || vis[i][j]==true)
        {
            return;
        }
        
        vis[i][j] = true;
        
        countIsland(i-1, j, M, vis);
        countIsland(i, j-1, M, vis);
        countIsland(i, j+1, M, vis);
        countIsland(i+1, j, M, vis);
    
    }
    public static void main(String[] args)
    {
        int M[][] = new int[][] { { 1, 1, 0, 0, 0 }, 
                                  { 0, 1, 0, 0, 1 }, 
                                  { 0, 0, 0, 1, 1 }, 
                                  { 0, 0, 0, 0, 0 }, 
                                  { 1, 0, 1, 0, 1 } }; 
        int n = M.length;
        int m = M[0].length;
        boolean vis[][] = new boolean[n][m];
        int count=0;
        for(int i=0;i<n;i++)
        {
            for(int j=0; j<m; j++)
            {
                if(M[i][j] == 1 && vis[i][j] == false)
                {
                    count+=1;
                    countIsland(i, j, M, vis);
                }
            }
        }
        System.out.println(count);
    }
}
