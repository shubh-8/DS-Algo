/*
Input: n = 4, k = 2
Output:
[
  [2,4],
  [3,4],
  [2,3],
  [1,2],
  [1,3],
  [1,4],
]
*/
public void combine(int n, int k, int i, List<List<Integer>> ans,List<Integer> asf){
    if(i==n+1){
        if(k==0){
            ans.add(new ArrayList(asf));
            System.out.println(asf);
        }
        return;
    }
    // yes call
    asf.add(i);
    combineUtil(n,k-1,i+1,ans,asf);
    asf.remove(asf.size()-1);
    // no call
    combineUtil(n,k,i+1,ans,asf);
}
