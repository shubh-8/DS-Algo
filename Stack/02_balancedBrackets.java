import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner sc= new Scanner(System.in);
        String str = sc.nextLine();
        System.out.println(balancedBracket(str));
    }
    public static boolean balancedBracket(String str){
        Stack<Character> st =  new Stack();
        
        for(int i=0; i<str.length(); i++)
        {
            char ch = str.charAt(i);
            if(ch=='(' || ch=='{' || ch=='['){
                st.push(ch);
            }
            else if(ch==')'){
                if(st.size()==0 || st.peek()!='(')
                    return false;
                st.pop();
            }
            else if(ch=='}'){
                if(st.size()==0 || st.peek()!='{')
                    return false;
                st.pop();
            }
            else if(ch==']'){
                if(st.size()==0 || st.peek()!='[')
                    return false;
                st.pop();
            }
        }
        //check stack should be empty
        return st.size()==0;
    }
}
