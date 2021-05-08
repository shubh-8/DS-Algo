/*
input: (a + b) + ((c + d))
output:true

input: (a + b) + (c + d)
output:false
*/

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        String str  = sc.nextLine();
        
        Stack<Character> st = new Stack();
        
        for(int i=0;i<str.length(); i++){
            if(str.charAt(i)!=')'){
                st.push(str.charAt(i));
            }else{
                // System.out.println(st.peek());
                if(st.peek()=='(')
                {
                    System.out.println("true");
                    return;
                }
                
                while(st.peek()!='('){
                    st.pop();
                }
                
                st.pop();
                
            }
        }
        System.out.println("false");
    }
}
