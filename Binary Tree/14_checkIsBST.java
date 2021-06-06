static class BSTPair{
      int min, max;
      boolean isBST;
      BSTPair(){
          min = Integer.MAX_VALUE;
          max = Integer.MIN_VALUE;
          isBST = true;
      }
  }
  
  public static BSTPair checkBST(Node root){
      if(root == null){
          return new BSTPair();
      }
      
      BSTPair lres = checkBST(root.left);
      BSTPair rres = checkBST(root.right);
      
      BSTPair mres = new BSTPair();
      boolean status = (lres.max < root.data) && (rres.min > root.data);
      
      if(mres.isBST == false){
          return new BSTPair();
      }
      
      mres.min = Math.min(lres.min, Math.min(rres.min,root.data));
      mres.max = Math.max(lres.max, Math.max(rres.max,root.data));
      mres.isBST = lres.isBST && rres.isBST && status;
      
      return mres;
  }
