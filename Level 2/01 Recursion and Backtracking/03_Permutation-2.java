import java.io.*;
import java.util.*;

public class Main {

  public static void permutations(int cb, int tb, int[] items, int isf, int ti, String asf){
    // write your code here
    if(cb > tb){
        if(isf == ti){
            System.out.println(asf);
        }
        return;
    }
    
    // yes call
    for(int i=1; i<=ti && isf<ti; i++){
        if(items[i-1] == 0){
            items[i-1] = 1;
            permutations(cb+1, tb, items, isf+1, ti, asf+i+"");
            items[i-1] = 0;
        }
    }
    // no call
    permutations(cb+1, tb, items, isf, ti, asf+"0");
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int nboxes = Integer.parseInt(br.readLine());
    int ritems = Integer.parseInt(br.readLine());
    permutations(1, nboxes, new int[ritems], 0, ritems, "");
  }

}
