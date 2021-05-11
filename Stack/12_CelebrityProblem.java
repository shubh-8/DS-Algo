import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        // write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][n];

        for (int j = 0; j < n; j++) {
            String line = br.readLine();
            for (int k = 0; k < n; k++) {
                arr[j][k] = line.charAt(k) - '0';
            }
        }

        findCelebrity(arr);

    }

    public static void findCelebrity(int[][] arr) {
        // if a celebrity is there print it's index (not position), if there is not then
        // print "none"
        Stack<Integer> celeb = new Stack();
        
        for(int i=0; i<arr.length; i++){
            celeb.push(i);
        }
        while(celeb.size()>1){
            int c1 = celeb.pop();
            int c2 = celeb.pop();
            if(arr[c1][c2] == 0){
                celeb.push(c1);
            }
            else{
                celeb.push(c2);
            }
        }
        int c = celeb.pop();
        for(int i=0;i<arr[0].length;i++){
            if(arr[c][i]==1){
                System.out.println("none");
                return;
            }
        }
        System.out.println(c);
    }

}
