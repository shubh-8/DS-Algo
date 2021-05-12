/*

E.g. Let us say there are 6 meetings
1 8
5 12
14 19
22 28
25 27
27 30

Then the output of merged meetings will belongs
1 12
14 19
22 30

*/

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        // write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][2];

        for (int j = 0; j < n; j++) {
            String line = br.readLine();
            arr[j][0] = Integer.parseInt(line.split(" ")[0]);
            arr[j][1] = Integer.parseInt(line.split(" ")[1]);
        }

        mergeOverlappingIntervals(arr);
    }
    
    static class Pair implements Comparable<Pair>{
        int st=0, end=0;
        Pair(int st, int end){
            this.st = st;
            this.end = end;
        }
        public int compareTo(Pair o){
            return this.st - o.st;
        }
    }

    public static void mergeOverlappingIntervals(int[][] arr) {
        // merge overlapping intervals and print in increasing order of start time
        
        Pair[] pairs = new Pair[arr.length];
        
        for(int i=0; i<arr.length; i++){
            pairs[i] = new Pair(arr[i][0], arr[i][1]);
        }
        
        Arrays.sort(pairs);
        
        Stack<Pair> stck = new Stack();
        stck.push(pairs[0]);
        for(int i=1; i<pairs.length; i++){
            if(pairs[i].st <= stck.peek().end){
                if(pairs[i].end > stck.peek().end){
                    stck.peek().end = pairs[i].end;
                }
            }else{
                stck.push(pairs[i]);
            }
        }
        
        Stack<Pair> nstck = new Stack();
        while(stck.size()>0){
            nstck.push(stck.pop());
        }
        
        while(nstck.size()>0){
            System.out.println(nstck.peek().st+" "+nstck.pop().end);
        }
        
        
    }

}
