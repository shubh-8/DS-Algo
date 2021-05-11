import java.io.*;
import java.util.*;

public class Main{
  
    
    public static int priority(char op){
        if(op=='*' || op=='/'){
            return 2;
        }
        else if(op=='+' || op=='-'){
            return 1;
        }
        else{
            return 0;
        }
    }
    
    public static void infixToPostfix(String exp){
        Stack<Character> ostack = new Stack();
        Stack<String> vstack = new Stack();
        
        for(int i=0; i<exp.length(); i++){
            char ch = exp.charAt(i);
            if(ch==' '){
                continue;
            }
            else if(ch>='a' && ch<='z'){
                vstack.push(ch+"");
            }
            else if(ch == '('){
                ostack.push(ch);
            }
            else if(ch==')'){
                while(ostack.peek()!='('){
                    String val2 = vstack.pop();
                    String val1 = vstack.pop();
                    char op = ostack.pop();
                    String res = val1 + val2 + op;
                    vstack.push(res);
                }
                ostack.pop();// ')'
            }
            else{
                while(ostack.size()>0 && ostack.peek()!='(' && priority(ch)<=priority(ostack.peek())){
                    String val2 = vstack.pop();
                    String val1 = vstack.pop();
                    char op = ostack.pop();
                    String res = val1 + val2 + op;
                    vstack.push(res);
                }
                ostack.push(ch);
            }
        }
        while(ostack.size()>0)
        {
            String val2 = vstack.pop();
            String val1 = vstack.pop();
            char op = ostack.pop();
            String res = val1 + val2 + op;
            vstack.push(res);
        }
        System.out.println(vstack.pop());
    }
    
    public static void infixToPrefix(String exp){
        Stack<Character> ostack = new Stack();
        Stack<String> vstack = new Stack();
        
        for(int i=0; i<exp.length(); i++){
            char ch = exp.charAt(i);
            if(ch==' '){
                continue;
            }
            else if(ch>='a' && ch<='z'){
                vstack.push(ch+"");
            }
            else if(ch == '('){
                ostack.push(ch);
            }
            else if(ch==')'){
                while(ostack.peek()!='('){
                    String val2 = vstack.pop();
                    String val1 = vstack.pop();
                    char op = ostack.pop();
                    String res = op + val1 + val2;
                    vstack.push(res);
                }
                ostack.pop();// ')'
            }
            else{
                while(ostack.size()>0 && ostack.peek()!='(' && priority(ch)<=priority(ostack.peek())){
                    String val2 = vstack.pop();
                    String val1 = vstack.pop();
                    char op = ostack.pop();
                    String res = op + val1 + val2;
                    vstack.push(res);
                }
                ostack.push(ch);
            }
        }
        while(ostack.size()>0)
        {
            String val2 = vstack.pop();
            String val1 = vstack.pop();
            char op = ostack.pop();
            String res = op + val1 + val2;
            vstack.push(res);
        }
        System.out.println(vstack.pop());
    }
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String exp = br.readLine();
    
        // code
        infixToPostfix(exp);
        infixToPrefix(exp);
     }
}
