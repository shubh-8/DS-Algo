
  public static int maxSum = Integer.MIN_VALUE;
  public static int maxNode = 0;
  public static int maxSubtreeSum(Node node){
      int sum = 0;
      for(Node child: node.children){
          sum += maxSubtreeSum(child);
      }
      sum += node.data;
      if(maxSum < sum){
          maxSum = sum;
          maxNode = node.data;
      }
      return sum;
  }


    // write your code here
    maxSubtreeSum(root);
    System.out.println(maxNode+"@"+maxSum);
