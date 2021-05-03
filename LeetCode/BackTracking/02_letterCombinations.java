/*
Input: digits = "23"
Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]
*/
class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList();
        if(digits.length() > 0)
        {
            helper(digits, "", ans);
        }
        return ans;
    }
    
    String map[] = {"", "","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};

    public void helper(String digits, String asf, List<String> ans)
    {
        if(digits.length() == 0){
            ans.add(asf);
            return;
        }
        
        char ch = digits.charAt(0);
        int idx = ch - '0';
        for(char x: map[idx].toCharArray()){
            helper(digits.substring(1),asf+x,ans);
        }
    }
}
