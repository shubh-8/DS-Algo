
    public static LinkedList addTwoLists(LinkedList one, LinkedList two) {
      // write your code here
      LinkedList res = new LinkedList();
      int carry = helper(one.head,one.size(),two.head,two.size(),res);
      if(carry>0){
          res.addFirst(carry);
      }
      return res;
    }
    public static int helper(Node h1, int i1, Node h2, int i2, LinkedList res) {
        if(h1 == null && h2 == null){
            return 0;
        }
        
        int sum = 0;
        if(i1 > i2){
            int carry = helper(h1.next, i1-1, h2, i2, res);
            sum = carry + h1.data;
        }
        else if( i1 < i2){
            int carry = helper(h1, i1, h2.next, i2-1, res);
            sum = carry + h2.data;
        }else{
            
            int carry = helper(h1.next, i1-1, h2.next, i2-1, res);
            sum = carry + h1.data + h2.data;
        }
        res.addFirst(sum%10);
        return sum/10;
    }
