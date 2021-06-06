
  public static int max(Node node) {
    // write your code here
    if(node == null){
        return Integer.MIN_VALUE;
    }
    
    if(node.right == null){
        return node.data;
    }
    
    return max(node.right);
  }

  public static int min(Node node) {
    // write your code here
    if(node == null){
        return Integer.MAX_VALUE;
    }
    
    if(node.left == null){
        return node.data;
    }
    
    return min(node.left);
  }

  public static boolean find(Node node, int data){
    // write your code here
    if(node == null){
        return false;
    }
    if(node.data > data){
        return find(node.left,data);
    }
    else if(node.data < data){
        return find(node.right,data);
    }
    else{
        return true;
    }
  }  
  
