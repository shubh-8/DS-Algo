
  static int ceil = Integer.MAX_VALUE;
  static int floor = Integer.MIN_VALUE;
  public static void ceilAndFloor(Node node, int data) {
    // Write your code here
    if(node.data < data){
        floor = Math.max(floor,node.data);
    }else if(node.data > data){
        ceil = Math.min(ceil,node.data);
    }
    for(Node child: node.children){
        ceilAndFloor(child,data);
    }
  }
