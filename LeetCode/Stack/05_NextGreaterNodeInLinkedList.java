// https://leetcode.com/problems/next-greater-node-in-linked-list/

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
    public int[] nextLargerNodes(ListNode head) {
        Stack<ListNode> st = new Stack();
        int [] res;
        int count = 0;
        st.push(head);
        ListNode temp = head.next;
        while(temp!=null){
            while(st.size()>0 && temp.val > st.peek().val){
                ListNode item = st.pop();
                item.val = temp.val;
                count++;
            }
            st.push(temp);
            temp = temp.next;
        }
        while(st.size()>0){
            ListNode item = st.pop();
            item.val = 0;
            count++;
        }
        int i=0;
        res = new int[count];
        temp = head;
        while(temp!=null){
            res[i] = temp.val;
            temp = temp.next;
            i++;
        }
        return res;
    }
}
