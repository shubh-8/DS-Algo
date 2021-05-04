/*
Input: nums = [1,2,3]
Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
*/
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans  = new ArrayList();
        boolean vis[] = new boolean[nums.length];
        helper(nums,vis,ans,new ArrayList());
        return ans;         
    }
    public void helper(int nums[], boolean vis[],List<List<Integer>> ans, List<Integer> asf)
    {
        if(asf.size()==nums.length){
            ans.add(new ArrayList(asf));
            return;
        }
        
        for(int i=0; i<nums.length; i++){
            if(vis[i]==false){
                asf.add(nums[i]);
                vis[i]= true;
                helper(nums,vis,ans,asf);
                asf.remove(asf.size()-1);
                vis[i]= false;
            }
        }
    }
}
