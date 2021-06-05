
  	  int dia = 0;
  	  public int height(TreeNode root) {
  	      if(root == null){
  	          return -1;
  	      }
  	      
  	      int lh = height(root.left);
  	      int rh = height(root.right);
  	      
  	      dia = Math.max(dia,lh+rh+2);
  	      
  	      return Math.max(lh,rh) + 1;
  	  }
  	  
  	  public int diameterOfBinaryTree(TreeNode root) {
  	      height(root);
  	      return dia;
  	  }
  
