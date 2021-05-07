/*
Input: n = 2
Output: 15
Explanation: The 15 sorted strings that consist of vowels only are
["aa","ae","ai","ao","au","ee","ei","eo","eu","ii","io","iu","oo","ou","uu"].
Note that "ea" is not a valid string since 'e' comes after 'a' in the alphabet.
*/

class Solution {
    public int countVowelStrings(int n) {
        String vowel [] = {"a","e","i","o","u"};
        return helper(n,0,"",vowel);
    }
    public int helper(int n, int idx, String asf, String vowel[]){
        if(asf.length() == n){
            // System.out.println(asf);
            return 1;
        }
        int count = 0;
        for(int i=idx; i<5; i++){
            count += helper(n,i,asf+vowel[i],vowel);
        }
        return count;
    }
}
