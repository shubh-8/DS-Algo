
  static int tilt = 0;
  
  public static int sumOfTilt(Node node){
      if(node == null){
          return 0;
      }
      int ls = sumOfTilt(node.left);
      int rs = sumOfTilt(node.right);
      
      tilt += Math.abs(ls-rs);
      
      return ls+rs+node.data;
  }
  public static int tilt(Node node){
    // write your code here to set the tilt data member
    sumOfTilt(node);
    return tilt;
  }
