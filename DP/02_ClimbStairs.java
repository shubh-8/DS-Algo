import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        // write your code here
    Scanner sc = new Scanner(System.in);
    
    int n = sc.nextInt();
    int dp [] = new int[n+1];
    
    int res = climbStairsTab(n);
    
    System.out.println(res);
    }
    
    public static int climbStairs(int n){
        if(n == 0){
            return 1;
        }
        int c = 0;
        for(int i=1; i<=3; i++){
            if(n-i >= 0){
                c += climbStairs(n-i);
            }
        }
        return c;
    }
    
    public static int climbStairsMem(int n, int dp[]){
        if(n == 0){
            return dp[0] = 1;
        }
        
        if(dp[n] != 0){
            return dp[n];
        }
        
        int c = 0;
        for(int i=1; i<=3; i++){
            if(n-i >= 0){
                c += climbStairsMem(n-i, dp);
            }
        }
        return dp[n] = c;
    }
    
    public static int climbStairsTab(int n)
    {
        int dp[] = new int[n+1];
        dp[0] = 1;
        
        if(dp[n] != 0){
            return dp[n];
        }
        
        int c = 0;
        for(int i=1; i<=3; i++){
            if(n-i >= 0){
                c += climbStairsMem(n-i, dp);
            }
        }
        return dp[n] = c;
    }
    
    
}
