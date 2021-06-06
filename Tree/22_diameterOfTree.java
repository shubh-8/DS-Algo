// APPROACH 2
// O(N)

static int dia = 0;
  public static int heightForDiameter(Node node){
      int maxHt = -1;
      int smaxHt = -1;
      
      for(Node child: node.children){
          int ht = heightForDiameter(child);
          if(ht > maxHt){
              smaxHt = maxHt;
              maxHt = ht;
          }
          else if (ht>smaxHt){
              smaxHt = ht;
          }
      }
      
      int dfc = maxHt + smaxHt + 2;
      if(dfc > dia){
          dia = dfc;
      }
      return maxHt + 1;
  }

  
// APPROACH 1
// O(N^2)

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
