
  public static Node removeLeaves(Node node){
    // write your code here
    if(node == null)
    {
        return null;
    }
    if(node.left == null && node.right == null){
        return null;
    }
    // if(node.left != null)
        node.left = removeLeaves(node.left);
    // if(node.right != null)
        node.right = removeLeaves(node.right);
        
    return node;
  }
