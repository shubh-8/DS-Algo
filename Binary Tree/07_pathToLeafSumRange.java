public static void pathToLeafFromRoot(Node node, String path, int sum, int lo, int hi){
  // write your code here
  if(node == null){
      return;
  }
  if(node.left != null && node.right != null){
      pathToLeafFromRoot(node.left,path+node.data+" ",sum+node.data,lo,hi);
      pathToLeafFromRoot(node.right,path+node.data+" ",sum+node.data,lo,hi);
  }
  else if (node.left != null){
      pathToLeafFromRoot(node.left,path+node.data+" ",sum+node.data,lo,hi);
  }
  else if (node.right != null){
      pathToLeafFromRoot(node.right,path+node.data+" ",sum+node.data,lo,hi);
  }
  else{
      if((sum + node.data) <= hi && (sum + node.data) >= lo){
          System.out.println(path + node.data+" ");
      }
  }
  }
