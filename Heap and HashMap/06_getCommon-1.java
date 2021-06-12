import java.io.*;
import java.util.*;

public class Main{
    
    public static void getCommon(int [] arr1, int [] arr2){
        HashSet<Integer> set = new HashSet();
        for(int i: arr1){
            if(set.contains(i) == false){
                set.add(i);
            }
        }
        
        for(int i=0; i<arr2.length; i++){
            if(set.contains(arr2[i]) == true){
                System.out.println(arr2[i]);
                set.remove(arr2[i]);
            }
        }
    }

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner (System.in);
        int n1 = sc.nextInt();
        int arr1 [] = new int[n1];
        for(int i=0; i<n1; i++){
            arr1[i] = sc.nextInt();
        }
        int n2 = sc.nextInt();
        int arr2 [] = new int[n2];
        for(int i=0; i<n2; i++){
            arr2[i] = sc.nextInt();
        }
        getCommon(arr1,arr2);
    }

}
