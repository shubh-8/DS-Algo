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
    
    public static int evaluate(int val1, int val2, char op){
        if(op=='*'){
            return val1 * val2;
        }
        else if(op=='/'){
            return val1 / val2;
        }
        else if(op=='+'){
            return val1 + val2;
        }
        else if(op=='-'){
            return val1 - val2;
        }
        else{
            return 0;
        }
    }
    
    public static void infixEvaluation(String exp){
        Stack<Character> ostack = new Stack();
        Stack<Integer> vstack = new Stack();
        
        for(int i=0; i<exp.length(); i++){
            char ch = exp.charAt(i);
            if(ch==' '){
                continue;
            }
            // assuming exp has only single digit numbers
            else if(ch>='0' && ch <= '9'){
                vstack.push((int)ch-'0');
            }
            else if(ch == '('){
                ostack.push(ch);
            }
            else if(ch==')'){
                while(ostack.peek() != '(')
                {
                    int val2 = vstack.pop();
                    int val1 = vstack.pop();
                    char op = ostack.pop();
                    
                    int res = evaluate(val1,val2,op);
                    vstack.push(res);
                }
                ostack.pop(); // pop '('
            }
            else{
                // ch is operator
                while(ostack.size()>0 && ostack.peek() != '(' && priority(ch)<=priority(ostack.peek()))
                {
                    int val2 = vstack.pop();
                    int val1 = vstack.pop();
                    char op = ostack.pop();
                    
                    int res = evaluate(val1,val2,op);
                    vstack.push(res);
                }
                ostack.push(ch);
            }
        }
        // may be stack is still not empty
        while(ostack.size() > 0)
        {
            int val2 = vstack.pop();
            int val1 = vstack.pop();
            char op = ostack.pop();
            
            int res = evaluate(val1,val2,op);
            vstack.push(res);
        }
        System.out.println(vstack.pop());
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String exp = br.readLine();
    
        // code
        infixEvaluation(exp);
    }
}
