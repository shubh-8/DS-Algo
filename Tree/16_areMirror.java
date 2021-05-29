
public static boolean areMirror(Node n1, Node n2) {
  // write your code here
  if(n1.children.size() != n2.children.size()){
      return false;
  }
  int sz = n1.children.size();
  for(int i=0; i<sz; i++){
      Node child1 = n1.children.get(i);
      Node child2 = n2.children.get(sz-i-1);
      boolean res = areMirror(child1,child2);
      if(res==false){
          return false;
      }
  }
  return true;
}
