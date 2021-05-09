
//https://leetcode.com/problems/maximal-rectangle/submissions/
class Solution {
    public int maximalRectangle(char[][] matrix) {
        if(matrix.length==0){
            return 0;
        }
        int row[] = new int[matrix[0].length];
        int maxArea=0;
        for(int i=0; i<matrix.length; i++){
            for(int j=0; j<matrix[0].length; j++){
                if(matrix[i][j] == '0'){
                    row[j] = 0;
                }else{
                    row[j] += 1;
                }
            }
            maxArea = Math.max(maxArea,largestAreaHistogram(row));
        }
        return maxArea;
    }  
    public static int largestAreaHistogram(int a[]){
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
