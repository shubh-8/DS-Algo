/*
e.g.
for the array [2 5 9 3 1 12 6 8 7]
Next greater for 2 is 5
Next greater for 5 is 9
Next greater for 9 is 12
Next greater for 3 is 12
Next greater for 1 is 12
Next greater for 12 is -1
Next greater for 6 is 8
Next greater for 8 is -1
Next greater for 7 is -1
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
   st.push(0);//index
   
   for(int i =1; i<arr.length; i++){
       while(st.size()>0 && arr[st.peek()]<arr[i])
       {
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
