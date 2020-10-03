package offer;

import leetcode.ds.ListNode;

/**
 * @author Achan
 * @date 2020/10/3
 */
public class SwordFinger52 {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode pa = headA;
        ListNode pb = headB;
        while (pa != pb) {
            pa = pa == null ? headB : pa.next;
            pb = pb == null ? headA : pb.next;
        }
        return pa;
    }

}
