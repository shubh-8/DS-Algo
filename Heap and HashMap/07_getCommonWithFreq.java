import java.io.*;
import java.util.*;

public class Main{
    
     public static void getCommonWithFreq(int [] arr1, int [] arr2){
        HashMap<Integer,Integer> map = new HashMap();
        // freq map
        for(int i: arr1){
            if(map.containsKey(i) == false){
                map.put(i,1);
            }else{
                map.put(i,map.get(i)+1);
            }
        }
        
        for(int i=0; i<arr2.length; i++){
            if(map.containsKey(arr2[i]) == true && map.get(arr2[i]) > 0){
                System.out.println(arr2[i]);
                map.put(arr2[i],map.get(arr2[i])-1);
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
        getCommonWithFreq(arr1,arr2);
    }

}
