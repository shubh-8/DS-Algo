  public static Node createLeftCloneTree(Node node){
    // write your code here
    if(node == null){
        return null;
    }
    
    Node lcn = createLeftCloneTree(node.left);
    Node rcn = createLeftCloneTree(node.right);
    
    Node nn = new Node(node.data,lcn,null);
    node.left = nn;
    
    return node;
  }
