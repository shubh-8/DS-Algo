
  static class BSTpair{
      int size, max, min;
      boolean isBST ;
      BSTpair(){
          size = 0;
          max = Integer.MIN_VALUE;
          min = Integer.MAX_VALUE;
          isBST = true;
      }
  }
  public static int sz = 0;
  public static Node bstNode = null;
  public static BSTpair largestBST(Node node){
      if(node == null){
          return new BSTpair();
      }
      BSTpair lres = largestBST(node.left);
      BSTpair rres = largestBST(node.right);
      
      boolean status = (lres.max < node.data && rres.min > node.data);
      
      BSTpair mres = new BSTpair();
      mres.max = Math.max(node.data, Math.max(lres.max,rres.max));
      mres.min = Math.min(node.data, Math.min(lres.min,rres.min));
      mres.size = lres.size + rres.size + 1;
      mres.isBST = lres.isBST && rres.isBST && status;
      
      if(mres.isBST == true && mres.size > sz){
          sz = mres.size;
          bstNode = node;
      }
      return mres;
  }
  

    // write your code here
    BSTpair res = largestBST(root);
    System.out.println(bstNode.data+"@"+sz);

