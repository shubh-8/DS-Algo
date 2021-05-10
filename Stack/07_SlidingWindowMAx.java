
import java.io.*;
import java.util.*;

public class Main{
  
    public static int[] ngi(int a[]){
        Stack<Integer> st = new Stack();
        int res[]  = new int[a.length];
        st.push(0);
        
        for(int i=1; i<a.length; i++){
            while(st.size()>0 && a[st.peek()] < a[i])
            {
                res[st.pop()] = i;
            }
            st.push(i);
        }
        
        while(st.size()>0){
            res[st.pop()] = a.length;
        }
        return res;
    }
    
    public static void slidingMax(int a[], int k){
        int ngri[] = ngi(a);
        
        int j=0;
        for(int i=0; i<=a.length-k; i++){
            // j pichhe reh gya
            if(i>j){
                j = i;
            }
            while(i+k > ngri[j]){
                j = ngri[j];
            }
            System.out.println(a[j]);
        }
    }
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
        int n = Integer.parseInt(br.readLine());
        int[] a = new int[n];
        for(int i = 0; i < n; i++){
           a[i] = Integer.parseInt(br.readLine());
        }
        int k = Integer.parseInt(br.readLine());
    
        // code
        slidingMax(a,k);
     }
}
