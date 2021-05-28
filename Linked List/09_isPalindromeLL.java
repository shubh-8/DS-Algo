public boolean IsPalindrome02() {
  // write your code here
  int left = 0, right = this.size-1;
  while(left<right){
      Node lnode = getNodeAt(left);
      Node rnode = getNodeAt(right);
      if(lnode.data!=rnode.data){
          return false;
      }
      left++;
      right--;
  }
  return true;
}


/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public boolean isPalindrome(ListNode head) {
        /* write your code here */
        if(head == null){
            return false;
        }
        ListNode mid = findMid(head);
        ListNode head2 = mid.next;
        mid.next = null;
        head2 = reverseLL(head2);
        while(head!=null && head2!=null){
            if(head.val != head2.val){
                return false;
            }
            head = head.next;
            head2 = head2.next;
        }
        return true;
    }
    public static ListNode findMid(ListNode head){
        ListNode slow = head;
        ListNode fast = head.next;
        while(fast !=null && fast.next !=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    } 
    public static ListNode reverseLL(ListNode head){
        ListNode prev = null, curr = head;
        while(curr!=null){
            ListNode nex = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nex;
        }
        return prev;
    }

}
