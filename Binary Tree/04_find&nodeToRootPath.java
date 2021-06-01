
  public static boolean find(Node node, int data){
    // write your code here
    if(node == null){
        return false;
    }
    if(node.data == data){
        return true;
    }
    boolean res = false;
    res = find(node.left,data);
    res = res || find(node.right,data);//if res is true, do not make call for right node
    return res;
  }

  public static ArrayList<Integer> nodeToRootPath(Node node, int data){
    // write your code here
    if(node == null){
        return new ArrayList();
    }
    if(node.data == data){
        ArrayList<Integer> bres = new ArrayList();
        bres.add(data);
        return bres;
    }
    ArrayList<Integer> lres = nodeToRootPath(node.left, data);
    if(lres.size()>0){
        lres.add(node.data);
        return lres;
    }
    ArrayList<Integer> rres = nodeToRootPath(node.right, data);
    if(rres.size()>0){
        rres.add(node.data);
        return rres;
    }
    return new ArrayList();
  }
