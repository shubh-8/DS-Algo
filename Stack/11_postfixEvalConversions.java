import java.io.*;
import java.util.*;

public class Main{
  
    public static int evaluate(int val1, int val2, char op) {
        if(op == '*') {
            return val1 * val2;
        } else if(op == '/') {
            return val1 / val2;
        } else if(op == '+') {
            return val1 + val2;
        } else if(op == '-') {
            return val1 - val2;
        } else {
            return 0;
        }
    }
    
    public static void preFixEvaluation(String exp){
        Stack<Integer> vstack  = new Stack();
        
        for(int i=exp.length()-1; i>=0; i--){
            char ch = exp.charAt(i);
            if(ch>='0' && ch<='9'){
                vstack.push((int)(ch-'0'));
            }
            else{
                int val1 = vstack.pop();
                int val2 = vstack.pop();
                int res = evaluate(val1,val2,ch);
                vstack.push(res);
            }
        }
        System.out.println(vstack.pop());
    }
    
    public static void preFixToInfix(String exp){
        Stack<String> vstack  = new Stack();
        
        for(int i=exp.length()-1; i>=0; i--){
            char ch = exp.charAt(i);
            if(ch>='0' && ch<='9'){
                vstack.push(""+ch);
            }
            else{
                String val1 = vstack.pop();
                String val2 = vstack.pop();
                String res = "(" + val1 + ch + val2 + ")";
                vstack.push(res);
            }
        }
        System.out.println(vstack.pop());
        
    }
    
    public static void preFixToPostfix(String exp){
        Stack<String> vstack  = new Stack();
        
        for(int i=exp.length()-1; i>=0; i--){
            char ch = exp.charAt(i);
            if(ch>='0' && ch<='9'){
                vstack.push(""+ch);
            }
            else{
                String val1 = vstack.pop();
                String val2 = vstack.pop();
                String res = val1 + val2 + ch ;
                vstack.push(res);
            }
        }
        System.out.println(vstack.pop());
    }
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String exp = br.readLine();
    
        // code
        preFixEvaluation(exp);
        preFixToInfix(exp);
        preFixToPostfix(exp);
     }
}
