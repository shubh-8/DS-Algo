
  public static int height(Node node) {
    // write your code here
    int ht = -1;
    for(Node child: node.children){
        ht = Math.max(ht,height(child));
    }
    return  ht+1;
  }
  
  public static int diameter(Node node){
      int maxHt = -1;
      int smaxHt = -1;
      
      for(Node child: node.children){
          int ht = height(child);
          if(ht > maxHt){
              smaxHt = maxHt;
              maxHt = ht;
          }
          else if(smaxHt < ht){
              smaxHt = ht;
          }
      }
      
      int dfc = 0;
      
      for(Node child: node.children){
          dfc = Math.max(dfc,diameter(child));
      }
      
      return Math.max(dfc, maxHt + smaxHt + 2);
  }
