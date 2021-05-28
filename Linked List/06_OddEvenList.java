
    public void oddEven(){
      // write your code here
      Node ehead = new Node();
      Node ohead = new Node();
      Node itr = this.head, t1 = ehead,t2 = ohead;
      
      while(itr!=null){
          if(itr.data % 2 == 0){
              t1.next = itr;
              itr = itr.next;
              t1 = t1.next;
          }else{
              t2.next = itr;
              itr = itr.next;
              t2 = t2.next;
          }
      }
      
      t2.next = ehead.next;
      t1.next = null;
      this.head = ohead.next;
      this.tail = (t2.next==null)?t2:t1;// if even is empty, tail is odd's tail
    }
