 public static LinkedList mergeTwoSortedLists(LinkedList l1, LinkedList l2) {
  LinkedList ml = new LinkedList();

  Node one = l1.head;
  Node two = l2.head;
  while (one != null && two != null) {
    if (one.data < two.data) {
      ml.addLast(one.data);
      one = one.next;
    } else {
      ml.addLast(two.data);
      two = two.next;
    }
  }

  while (one != null) {
    ml.addLast(one.data);
    one = one.next;
  }

  while (two != null) {
    ml.addLast(two.data);
    two = two.next;
  }

  return ml;
}
public static Node mid02(Node head, Node tail){
    Node s = head, f = head;
    while(f!=tail && f.next != tail){
        s = s.next;
        f = f.next.next;
    }
    return s;
}

public static LinkedList mergeSort(Node head, Node tail){
  // write your code here
  if(head == tail){
      LinkedList bres = new LinkedList();
      bres.addFirst(head.data);
      return bres;
  }
  Node mid = mid02(head,tail);
  LinkedList L1 = mergeSort(head,mid);
  LinkedList L2 = mergeSort(mid.next,tail);
  LinkedList res = mergeTwoSortedLists(L1,L2);
  return res;
}
  
