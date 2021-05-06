import java.io.*;
import java.util.*;

public class Main {

  public static void radixSort(int[] arr) {
    // write code here    
    int max=0, exp=1;
    for(int i=0; i<arr.length; i++){
        if(arr[i]>max){
            max = arr[i];
        }
    }
    while(max>exp){
        countSort(arr,exp);
        exp *= 10;
    }
  }

  public static void countSort(int[] arr, int exp) {
    // write code here
    int fmap[] = new int[10];
    //fill fmap
    for(int i=0; i<arr.length;i++){
        int val = (arr[i]/exp) % 10;
        fmap[val]++;
    }
    //prefix sum
    fmap[0]--;
    for(int i=1; i<fmap.length;i++)
    {
        fmap[i] += fmap[i-1];
    }
    //fill original arr
    int narr[] = new int[arr.length];
    for(int i=arr.length-1; i>=0; i--){
        int val = (arr[i]/exp) % 10;
        narr[fmap[val]] = arr[i];
        fmap[val]--;
    }
    
    for(int i=0; i<arr.length; i++){
        arr[i] = narr[i];
    }
    System.out.print("After sorting on " + exp + " place -> ");
    print(arr);
  }

  public static void print(int[] arr) {
    for (int i = 0; i < arr.length; i++) {
      System.out.print(arr[i] + " ");
    }
    System.out.println();
  }

  public static void main(String[] args) throws Exception {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int[] arr = new int[n];
    for (int i = 0; i < n; i++) {
      arr[i] = scn.nextInt();
    }
    radixSort(arr);
    print(arr);
  }

}
