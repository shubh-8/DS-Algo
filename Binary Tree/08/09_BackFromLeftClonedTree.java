
  public static Node transBackFromLeftClonedTree(Node node){
    // write your code here
    if(node == null){
        return null;
    }
    Node lcn = transBackFromLeftClonedTree(node.left.left);
    Node rcn = transBackFromLeftClonedTree(node.right);
    node.left = lcn;
    return node;
  }
