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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head=null, prev = null;
        int carry = 0;
        boolean flag = true;
        while(l1!=null || l2!=null){
            int v1 = (l1!=null) ? l1.val : 0;
            int v2 = (l2!=null) ? l2.val : 0;
            ListNode item = new ListNode();
            item.val = v1 + v2 + carry;
            if(item.val > 9){
                item.val = item.val % 10;
                carry = 1;
            }else{
                carry = 0;
            }
            if(flag==true){
                head = item;
                flag = false;
            }
            else{
                prev.next = item;
            }
            if(l1 != null)
                l1 = l1.next;
            if(l2 != null)
                l2 = l2.next;
            prev = item;
        }
        if(carry == 1){
            ListNode item = new ListNode();
            item.val = 1;
            prev.next = item;
        }
        return head;
    }
}
