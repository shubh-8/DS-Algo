// https://leetcode.com/problems/daily-temperatures/
class Solution {
    public int[] dailyTemperatures(int[] T) {
        Stack<Integer> st = new Stack();
        int res[] = new int[T.length];
        st.push(0);
        
        for(int i=1; i<T.length; i++){
            while(st.size()>0 && T[st.peek()]<T[i]){
                res[st.peek()] = i-st.pop();
            }
            st.push(i);
        }
        while(st.size()>0){
            res[st.pop()] = 0;
        }
        return res;
    }
}
