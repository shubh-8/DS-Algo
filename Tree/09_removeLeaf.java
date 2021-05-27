  public static void removeLeaves(Node node) {
    // write your code here
    for(int i=node.children.size()-1; i>=0; i--){
        Node child = node.children.get(i);
        if(child.children.size()==0){
            //leaf node
            node.children.remove(i);
        }else{
            removeLeaves(child);
        }
    }
  }
