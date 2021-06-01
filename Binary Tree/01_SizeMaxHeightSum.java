
  public static int size(Node node) {
    // write your code here
    if(node == null){
        return 0;
    }
    int ls = size(node.left);
    int rs = size(node.right);
    return ls+rs+1;
  }

  public static int sum(Node node) {
    // write your code here
    if(node == null){
        return 0;
    }
    
    int ls = sum(node.left);
    int rs = sum(node.right);
    return ls+rs+node.data;
  }

  public static int max(Node node) {
    // write your code here
    if(node == null){
        return Integer.MIN_VALUE;
    }
    
    int ls = max(node.left);
    int rs = max(node.right);
    return Math.max(ls,Math.max(rs,node.data));
  }

  public static int height(Node node) {
    // write your code here
    if(node == null){
        return -1; //edge based
    }
    
    int ls = height(node.left);
    int rs = height(node.right);
    return Math.max(ls, rs) + 1;
  }
