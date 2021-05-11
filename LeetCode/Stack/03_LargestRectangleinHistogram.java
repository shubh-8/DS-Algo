// https://leetcode.com/problems/largest-rectangle-in-histogram/

class Solution {
    public int largestRectangleArea(int[] heights) {
        
        int lsi[] = nextSmallLeft(heights);
        int rsi[] = nextSmallRight(heights);
        int maxArea=0;
        for(int i=0; i<heights.length; i++)
        {
            int width = (rsi[i]-lsi[i]-1) ;
            int ht = heights[i];
            int area = width * ht;
            maxArea = Math.max(maxArea,area);
        }
        return (maxArea);
    }
    
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
    
}
