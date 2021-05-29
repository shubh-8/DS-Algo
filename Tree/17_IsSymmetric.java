
  public static boolean isMirror(Node n1, Node n2){
      if(n1.children.size() != n2.children.size()){
          return false;
      }
      int sz = n1.children.size();
      for(int i=0; i<sz;i++){
          Node c1 = n1.children.get(i);
          Node c2 = n2.children.get(sz-i-1);
          boolean res = isMirror(c1,c2);
          if(res==false){
              return false;
          }
      }
      return true;
  }

  public static boolean IsSymmetric(Node node) {
    // write your code here
    boolean res = isMirror(node,node);
    return res;
  }
