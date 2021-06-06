
  public static int kthLargest(Node node, int k){
    // write your code here
    int data = Integer.MAX_VALUE;
    for(int i=0; i<k; i++){
        floor = Integer.MIN_VALUE;
        ceilAndFloor(node,data);
        data = floor;
    }
    return data;
  }


  static int ceil;
  static int floor;
  public static void ceilAndFloor(Node node, int data) {
    if(node.data > data){
      if(node.data < ceil){
        ceil = node.data;
      }
    }

    if(node.data < data){
      if(node.data > floor){
        floor = node.data;
      }
    }

    for (Node child : node.children) {
      ceilAndFloor(child, data);
    }
  }
