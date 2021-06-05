
  public static void printSingleChildNodes(Node node, Node parent){
    // write your code here
    if(node == null){
        return;
    }
    if(parent != null){
        if((parent.left == null && parent.right != null ) || (parent.left != null && parent.right == null )){
            System.out.println(node.data);
        }
    }
    
    printSingleChildNodes(node.left,node);
    printSingleChildNodes(node.right,node);
  }
