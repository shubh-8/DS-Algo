  public static void levelOrder(Node node){
    // write your code here
    Queue<Node> que = new ArrayDeque();
    que.add(node);
    while(que.size()>0){
        Node rem = que.remove();
        System.out.print(rem.data+" ");
        for(Node child: rem.children){
            que.add(child);
        }
    }
    System.out.println(".");
  }
