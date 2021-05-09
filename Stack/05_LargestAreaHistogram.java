// [6 2 5 4 5 1 6] -> 12

import java.io.*;
import java.util.*;

public class Main{
  
    public static int[] nextSmallLeft(int a[]){
        int res[] = new int[a.length];
        Stack<Integer> st = new Stack();
        st.push(a.length-1);
        
        for(int i=a.length-2; i>=0; i--){
            while(st.size()>0 && a[st.peek()]>a[i]){
                res[st.pop()] = i;
            }
            st.push(i);
        }
        while(st.size()>0){
            res[st.pop()]  = -1;
        }
        return res;
    }
    public static int[] nextSmallRight(int a[]){
        int res[] = new int[a.length];
        Stack<Integer> st = new Stack();
        st.push(0);
        
        for(int i=0; i<a.length; i++){
            while(st.size()>0 && a[st.peek()]>a[i]){
                res[st.pop()] = i;
            }
            st.push(i);
        }
        while(st.size()>0){
            res[st.pop()]  = a.length;
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
    
        // code
        int lsi[] = nextSmallLeft(a);
        int rsi[] = nextSmallRight(a);
        int maxArea=0;
        for(int i=0; i<a.length; i++)
        {
            int width = (rsi[i]-lsi[i]-1) ;
            int ht = a[i];
            int area = width * ht;
            maxArea = Math.max(maxArea,area);
        }
        System.out.println(maxArea);
     }
}
