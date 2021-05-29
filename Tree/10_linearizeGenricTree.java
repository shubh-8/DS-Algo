
  public static Node getTail(Node node){
      Node temp = node;
      while(temp.children.size()!=0){
          temp = temp.children.get(0);
      }
      return temp;
  }

  public static void linearize(Node node){
    // write your code here
    for(Node child: node.children){
        linearize(child);
    }
    
    for(int i=node.children.size()-2;i>=0; i--){
        Node last = node.children.get(i+1);
        Node slast = node.children.get(i);
        Node tail = getTail(slast);
        node.children.remove(i+1);
        tail.children.add(last);
    }
  }
