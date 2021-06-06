
  public static Node add(Node node, int data) {
    // write your code here
    if(node == null){
        Node nn = new Node(data,null,null);
        return nn;
    }
    if(data < node.data){
        node.left = add(node.left,data);
    }
    if(data > node.data){
        node.right = add(node.right,data);
    }
    return node;
  }
