// Lowest Common Ancestor (generic Tree)

  public static ArrayList<Integer> nodeToRootPath(Node node, int data) {
    if (node.data == data) {
      ArrayList<Integer> path = new ArrayList<>();
      path.add(node.data);
      return path;
    }

    for (Node child : node.children) {
      ArrayList<Integer> ptc = nodeToRootPath(child, data);
      if (ptc.size() > 0) {
        ptc.add(node.data);
        return ptc;
      }
    }

    return new ArrayList<>();
  }

  public static int lca(Node node, int d1, int d2) {
    // write your code here
    ArrayList<Integer> path1 = nodeToRootPath(node,d1);
    ArrayList<Integer> path2 = nodeToRootPath(node,d2);
    int i= path1.size()-1, j= path2.size()-1;
    int res=-1;
    while(i>=0 && j>=0 && path1.get(i)==path2.get(j))
    {
        res = path1.get(i);
        i--;
        j--;
    }
    return res;
  }
