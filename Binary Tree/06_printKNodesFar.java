  public static void kLevelDown(Node node, Node blockage, int k){
      if(node == null || node == blockage ){
          return;
      }
      
      if(k==0){
          System.out.println(node.data);
      }
      
      kLevelDown(node.left, blockage, k-1);
      kLevelDown(node.right, blockage, k-1);
  }
  
  public static ArrayList<Node> nodeToRootPath(Node node, int data){
      if(node == null){
          return new ArrayList();
      }
      
      if(node.data == data){
          ArrayList<Node> bres = new ArrayList();
          bres.add(node);
          return bres;
      }
      
      ArrayList<Node> lres = nodeToRootPath(node.left, data);
      if(lres.size()>0){
          lres.add(node);
          return lres;
      }
      
      ArrayList<Node> rres = nodeToRootPath(node.right, data);
      if(rres.size()>0){
          rres.add(node);
          return rres;
      }
      
      return new ArrayList();
  }


  public static void printKNodesFar(Node node, int data, int k) {
    // write your code here
    ArrayList<Node> node2root = nodeToRootPath(node,data);
    Node blockage = null;
    for(int i=0; i<node2root.size() && k>=0; i++){
        kLevelDown(node2root.get(i),blockage,k);
        k--;
        blockage = node2root.get(i);
    }
  }
