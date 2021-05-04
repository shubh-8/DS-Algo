/*
Input: candidates = [2,3,5], target = 8
Output: [[2,2,2,2],[2,3,3],[3,5]]
*/
class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList();
        helper(candidates,target,0,ans,new ArrayList());
        return ans;
    }
    public void helper(int [] candidates, int target, int idx, List<List<Integer>> ans, List<Integer> asf){
    
        if(target==0){
            ans.add(new ArrayList(asf));
            return;
        }
        //We want combination not permutation -> (idx)
        for(int i=idx; i<candidates.length; i++){
            if(target-candidates[i] >= 0){
                asf.add(candidates[i]);
                helper(candidates,target-candidates[i],i,ans,asf);
                asf.remove(asf.size()-1);    
            }
        }
    }
}
