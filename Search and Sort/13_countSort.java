import java.io.*;
import java.util.*;

public class Main {

  public static void countSort01(int[] arr, int min, int max) {
   //write your code here
   int fmap[] = new int[max-min+1];
   //fill fmap
   for(int i=0;i<arr.length;i++)
   {
       int val = arr[i];
       fmap[val-min]++;
   }
   //fill original array
   int idx=0;
   for(int i=0;i<fmap.length;i++)
   {
       int freq = fmap[i];
       int val = i + min;
       for(int j=0; j<freq; j++){
           arr[idx]=val;
           idx++;
       }
   }
  }
    
    public static void countSort(int[] arr, int min, int max) {
        int fmap[] = new int[max-min+1];
        //step 1: get freq
        for(int i=0; i<arr.length; i++)
        {
            int val = arr[i];
            fmap[val-min]++;
        }
        //step 2: get prefix sum
        fmap[0]--; //to get position from prefix sum
        for(int i=1; i<fmap.length; i++)
        {
            fmap[i] += fmap[i-1];
        }
        //step 3: fill new array in sorted order
        // also reduce positions in fmap
        int narr[] = new int[arr.length];
        for(int i=arr.length-1; i>=0; i--)
        {
            int val = arr[i];
            int pos = fmap[val-min];
            narr[pos] = arr[i];
            fmap[val-min]--;
        }
        //step 4: place narr element in original arr
        for(int i=0; i<arr.length; i++)
        {
            arr[i] = narr[i];
        }
    }
  
  public static void print(int[] arr) {
    for (int i = 0; i < arr.length; i++) {
      System.out.println(arr[i]);
    }
  }

  public static void main(String[] args) throws Exception {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int[] arr = new int[n];
    int max = Integer.MIN_VALUE;
    int min = Integer.MAX_VALUE;
    for (int i = 0; i < n; i++) {
      arr[i] = scn.nextInt();
      max = Math.max(max, arr[i]);
      min = Math.min(min, arr[i]);
    }
    countSort(arr,min,max);
    print(arr);
  }

}
