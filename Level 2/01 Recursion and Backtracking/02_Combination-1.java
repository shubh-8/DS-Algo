import java.io.*;
import java.util.*;

public class Main {

  public static void combinations(int cb, int tb, int isf, int ti, String asf){
    // write your code here
    if(cb > tb){
        if(isf == ti){
            System.out.println(asf);
        }
        return;
    }
    
    //yes call
    if(isf+1 <= ti){
        combinations(cb+1, tb, isf+1, ti, asf+"i");
    }
    // no call
    combinations(cb+1, tb, isf, ti, asf+"-");
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int nboxes = Integer.parseInt(br.readLine());
    int ritems = Integer.parseInt(br.readLine());
    combinations(1, nboxes, 0, ritems, "");
  }

}
