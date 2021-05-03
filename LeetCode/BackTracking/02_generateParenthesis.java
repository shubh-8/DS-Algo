/*
Input: n = 3
Output: ["((()))","(()())","(())()","()(())","()()()"]
*/
class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList();
        if(n>0)
        {
            helper(n,0,0,ans,"");
        }
        return ans;
    }
    public void helper(int n, int ob, int cb, List<String> ans, String asf){
        if(asf.length()==2*n)
        {
            ans.add(asf);
            return;
        }
        if(ob<n){
            helper(n,ob+1,cb,ans,asf+"(");
        }
        if(cb<ob){
            helper(n,ob,cb+1,ans,asf+")");
        }
    }
}
