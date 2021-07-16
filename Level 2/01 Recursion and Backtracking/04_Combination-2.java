import java.io.*;
import java.util.*;

public class Main {

  public static void combinations(int[] boxes, int ci, int ti, int lb){
    // write your code here
    if(ci > ti){
        for(int i: boxes){
            if(i == 0){
                System.out.print("-");
                continue;
            }
            System.out.print("i");
        }
        System.out.println();
        return;
    }
    
    for(int b=lb+1; b<boxes.length; b++){
        if(boxes[b] == 0){
            boxes[b] = ci;
            combinations(boxes, ci+1, ti, b);
            boxes[b] = 0;
        }
    }
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int nboxes = Integer.parseInt(br.readLine());
    int ritems = Integer.parseInt(br.readLine());
    combinations(new int[nboxes], 1, ritems, -1);
  }

}
