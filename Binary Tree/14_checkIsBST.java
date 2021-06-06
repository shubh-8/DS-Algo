class Solution {
    class BSTPair{
      long min, max;
      boolean isBST;
      BSTPair(){
          min = Long.MAX_VALUE;
          max = Long.MIN_VALUE;
          isBST = true;
      }
  }
  
  public BSTPair checkBST(TreeNode root){
      if(root == null){
          return new BSTPair();
      }
      
      BSTPair lres = checkBST(root.left);
      BSTPair rres = checkBST(root.right);
      
      BSTPair mres = new BSTPair();
      boolean status = (lres.max < root.val) && (rres.min > root.val);
      
      if(mres.isBST == false){
          return new BSTPair();
      }
      
      mres.min = Math.min(lres.min, Math.min(rres.min,root.val));
      mres.max = Math.max(lres.max, Math.max(rres.max,root.val));
      mres.isBST = lres.isBST && rres.isBST && status;
      
      return mres;
  }
    public boolean isValidBST(TreeNode root) {
        BSTPair res = checkBST(root);
        return res.isBST;
    }
}
