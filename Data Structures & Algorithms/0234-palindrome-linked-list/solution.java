/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */class Solution {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        ListNode p1 = head;
        ListNode p2 = head;
        while (p1 != null && p1.next != null) {
            p2 = p2.next;
            p1 = p1.next.next;
        }
        if (p1 != null) {
            p2 = p2.next;
        }
        ListNode prev = null;
        while (p2 != null) {
            ListNode next = p2.next;
            p2.next = prev;
            prev = p2;
            p2 = next;
        }
        p1 = head;
        p2 = prev;
        while (p2 != null) {
            if (p1.val != p2.val) {
                return false;
            }
            p1 = p1.next;
            p2 = p2.next;
        }
        return true;
    }
}
