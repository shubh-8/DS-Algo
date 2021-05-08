/*
input:  [5 3 8 -2 7]
output: [-1 5 -1 8 8]
*/
import java.io.*;
import java.util.*;

public class Main{
  public static void display(int[] a){
    StringBuilder sb = new StringBuilder();

    for(int val: a){
      sb.append(val + "\n");
    }
    System.out.println(sb);
  }

 public static int[] solve(int[] arr){
   // store result
   int res[] = new int[arr.length];
   
   Stack<Integer> st = new Stack();
   st.push(arr.length-1);//index
   
   for(int i =arr.length-2; i>=0; i--){
       while(st.size()>0 && arr[st.peek()]<arr[i])
       {
           //pop idex with small values and place arr[i] on them
           res[st.pop()] = arr[i];
       }
       st.push(i);
   }
   // all the left indices will have -1
   while(st.size()>0){
       res[st.pop()] = -1;
   }
   return res;
 }
 
public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());
    int[] a = new int[n];
    for(int i = 0; i < n; i++){
       a[i] = Integer.parseInt(br.readLine());
    }

    int[] nge = solve(a);
    display(nge);
 }


}
