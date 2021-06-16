
  public static boolean find(Node node, int data){
      if(node == null){
          return false;
      }
      
      if(node.data == data){
          return true;
      }
      boolean res = false;
      res= find(node.left,data);
      res = res || find(node.right,data);
      return res;
  }
  
  public static void targetSumPair(Node node, Node root, int target){
      if(node == null){
          return;
      }
      
      int n1 = node.data;
      int n2 = target - n1;
      
      targetSumPair(node.left, root, target);
      
      if(n1 < n2 && find(root,n2) == true){
          System.out.println(n1+" "+n2);
      }
      
      targetSumPair(node.right, root, target);
      
  }
