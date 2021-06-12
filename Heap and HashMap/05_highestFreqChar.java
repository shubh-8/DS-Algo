import java.io.*;
import java.util.*;

public class Main {
    
    public static char highestFreq(String s){
        HashMap<Character,Integer> map = new HashMap();
        for(char c: s.toCharArray()){
            if(map.containsKey(c) == false)
                map.put(c,0);
            else
                map.put(c,map.get(c)+1);
        }
        char chr = 'a';
        int freq = 0;
        for(char c: map.keySet()){
            if(map.get(c) > freq){
                chr = c;
                freq = map.get(c);
            }
        }
        return chr;
    }

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        
        System.out.println(highestFreq(s));
    }

}
