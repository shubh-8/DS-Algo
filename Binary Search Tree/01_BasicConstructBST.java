import java.io.*;
import java.util.*;

public class Main {
  static class Node {
    int data;
    Node left, right;
    Node(int d){
        data = d;
        left = null;
        right = null;
    }
  }

  public static void display(Node node) {
    if(node == null){
        return;
    }
    
    String str = "";
    
    if(node.left !=null)
        str += node.left.data+" ";
    else
        str+= " . ";
    
    str += node.data;
    if(node.right !=null)
        str += " " + node.right.data;
    else
        str+= " . ";
    
    System.out.println(str);
    
    display(node.left);
    display(node.right);
  }

  public static Node construct(int[] arr, int lo, int hi) {
      if(lo > hi){
          return null;
      }
      
      int mid = lo + (hi-lo)/2;
      
      Node nn = new Node(arr[mid]);
      
      nn.left = construct(arr,lo,mid-1);
      nn.right = construct(arr,mid+1,hi);
      
      return nn;
  }

  public static void main(String[] args) throws Exception {
    int[] arr = {10,20,30,40,50};
    
    Node root = construct(arr,0,arr.length-1);
    display(root);
  }

}
