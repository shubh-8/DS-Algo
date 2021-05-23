
    public void reverseDI() {
      // write your code here
      int left = 0;
      int right = this.size-1;
      while(left<right){
          Node l_node = getNthNode(left);
          Node r_node = getNthNode(right);
          
          int temp = l_node.data;
          l_node.data = r_node.data;
          r_node.data = temp;
          left++;
          right--;
      }
    }
    
    public Node getNthNode(int idx){
        Node temp = this.head;
        int c = 0;
        while(temp!=null && idx!=c){
            temp = temp.next;
            c++;
        }
        return temp;
    }
  }
