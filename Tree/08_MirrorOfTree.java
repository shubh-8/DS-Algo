// input: Root of a generic Tree

  public static void mirror(Node node){
    // write your code here
    for(Node child: node.children){
        mirror(child);
    }
    
    int left = 0, right = node.children.size()-1;
    while(left<right){
        Node temp = node.children.get(left);
        node.children.set(left,node.children.get(right));
        node.children.set(right,temp);
        left++;
        right--;
    }
  }
