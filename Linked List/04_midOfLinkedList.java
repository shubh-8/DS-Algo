
    public int mid(){
      // write your code here
      if(this.head==null){
          return -1;
      }
      Node slow = this.head;
      Node fast = this.head.next;
      while(fast!=null && fast.next!=null){
          slow = slow.next;
          fast = fast.next.next;
      }
      return slow.data;
    }
  }
