// https://leetcode.com/problems/evaluate-reverse-polish-notation/submissions/

class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> vstack = new Stack();
        for(int i=0; i<tokens.length; i++){
            String ch = tokens[i];
            if(ch.equals("*") || ch.equals("/")|| ch.equals("+") || ch.equals("-") ){
                int val2 = vstack.pop();
                int val1 = vstack.pop();
                int res = evaluate(val1,val2,ch);
                vstack.push(res);
            }
            else{
                vstack.push(Integer.parseInt(ch));
            }
        }
        return vstack.pop();
    }
    public int evaluate(int v1, int v2, String op){
        if(op.equals("*")){
            return v1*v2;
        }
        else if(op.equals("/")){
            return v1/v2;
        }
        else if(op.equals("+")){
            return v1+v2;
        }
        else if(op.equals("-")){
            return v1-v2;
        }
        else{
            return 0;
        }  
    }
}
