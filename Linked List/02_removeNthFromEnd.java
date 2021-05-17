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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode temp = head;
        int i=1;
        while(i<n){
            temp = temp.next;
            i++;
        }
        ListNode prev=null, curr=head;
        while(temp.next != null){
            prev = curr;
            curr = curr.next;
            temp = temp.next;
        }
        if(prev==null){
            return head.next;
        }
        prev.next = curr.next;
        return head;
    }
}
