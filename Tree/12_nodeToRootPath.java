
 public static ArrayList<Integer> nodeToRootPath(Node node, int data){
    // write your code here
    if(node.data == data){
        ArrayList<Integer> bres = new ArrayList<Integer>();
        bres.add(node.data);
        return bres;
    }
    ArrayList<Integer> res = new ArrayList<Integer>();
    for(Node child: node.children){
        res = nodeToRootPath(child,data);
        if(res.size()>0){
            res.add(node.data);
            return res;
        }
    }
    return res;
 }
