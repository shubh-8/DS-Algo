// check if two generic tree have same shape or not
  public static boolean areSimilar(Node n1, Node n2) {
    // write your code here
    if(n1==null && n2!=null){
        return false;
    }
    if(n2==null && n1!=null){
        return false;
    }
    if(n1==null && n2==null){
        return true;
    }
    if(n1.children.size()!= n2.children.size()){
        return false;
    }
    boolean res = true;
    for(int i=0; i<n1.children.size(); i++)
    {
        Node c1 =n1.children.get(i), c2=n2.children.get(i);
        res = areSimilar(c1,c2);
        if(res==false){
            return false;
        }
    }
    return res;
  }
