
  public static boolean find(Node node, int data) {
    // write your code here
    if(node.data == data){
        return true;
    }
    boolean res = false;
    for(Node child: node.children){
        res = find(child,data);
        if(res == true){// do not check for child
            return true;
        }
    }
    return res;
  }
