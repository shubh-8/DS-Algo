
    public Node getMid(Node head){
        Node s = head;
        Node f = head.next;
        while(f != null && f.next != null){
            s = s.next;
            f = f.next.next;
        }
        return s;
    }
    
    public Node reverseLL(Node head){
        Node prev = null, curr = head;
        while(curr != null){
            Node next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
    
    public void fold() {
      // write your code here
      Node head1 = this.head;
      Node mid= getMid(head1);
      Node head2 = mid.next;
      mid.next = null;
      head2 = reverseLL(head2);
      
      Node t1 = head1, t2 = head2, prev = head1;
      while(t1 != null && t2 != null){
          Node next1 =  t1.next;
          Node next2 = t2.next;
          
          t1.next = t2;
          t1 = next1;
          prev = (t1 == null) ? prev : t1;
          
          t2.next = t1;
          t2 = next2;
          prev = (t2 == null) ? prev : t2;
      }
      this.head = head1;
      this.tail = prev;
    }
