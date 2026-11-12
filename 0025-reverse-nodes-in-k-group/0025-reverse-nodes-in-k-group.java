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
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null || k == 1){
            return head;
        }
        int groups = 0;
        boolean firstPass = false;
        for(ListNode curr = head;curr != null;curr = curr.next){
            groups++;
        }
        ListNode curr = head;
        ListNode prevFirst = null;
        ListNode res = null;
        while(groups>=k){
            int count = 0;
            ListNode prev = null;
            ListNode next = null;
            ListNode first = curr;
            while(curr != null && count<k){
                next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
                count++;
            }
            if(firstPass == false){
                res = prev;
                firstPass = true;
            }
            else{
                prevFirst.next = prev;
            }
            first.next = curr;
            prevFirst = first;
            groups = groups-k;
        }
        return firstPass ? res : head;
    }
}