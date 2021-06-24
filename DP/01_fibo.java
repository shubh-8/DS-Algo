import java.io.*;
import java.util.*;

public class Main{

public static void main(String[] args) throws Exception {
    // write your code here
    Scanner sc = new Scanner(System.in);
    
    int n = sc.nextInt();
    int dp [] = new int[n+1];
    
    int res = fiboTab(n);
    
    System.out.println(res);
 }
 
 public static int fibo(int n){
     if(n == 0 || n == 1){
         return n;
     }
     
     int fib1 = fibo(n-1);
     int fib2 = fibo(n-2);
     
     return fib1 + fib2;
 }
 
  public static int fiboMem(int n, int dp[]){
     if(n == 0 || n == 1){
         return dp[n] = n;
     }
     
     if(dp[n] != 0)
     {
         return dp[n];
     }
     
     int fib1 = fiboMem(n-1,dp);
     int fib2 = fiboMem(n-2,dp);
     
     dp[n] = fib1 + fib2;
     
     return dp[n];
 }
 
  public static int fiboTab(int n){
     
     int dp[] = new int[n+1];
     dp[0] = 0;
     dp[1] = 1;
     
     for(int i=2; i<=n; i++){
         dp[i] = dp[i-1]+dp[i-2];
     }
     
     return dp[n];
 }

}
