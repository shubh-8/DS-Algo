/*
Input: n = 2
Output: [0,1,3,2]
Explanation:
00 - 0
01 - 1
11 - 3
10 - 2
*/

class Solution {
    public List<Integer> grayCode(int n) {
        List<String> ans = helper(n);
        // System.out.println(ans);
        List<Integer> res = new ArrayList();
        for(int i=0; i<ans.size(); i++){
            res.add(Integer.parseInt(ans.get(i),2));
        }
        return res;
    }
    public List<String> helper(int n)
    {
        if(n==1){
            List<String> ans = new ArrayList();
            ans.add("0");
            ans.add("1");
            return ans;
        }
        List<String> rres = helper(n-1);
        List<String> mres = new ArrayList();
        for(int i=0;i<rres.size();i++){
            mres.add(rres.get(i)+"0");
        }
        for(int i=rres.size()-1;i>=0;i--){
            mres.add(rres.get(i)+"1");
        }
        return mres;
    }
}
