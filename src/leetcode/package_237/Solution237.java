package leetcode.package_237;

import leetcode.ds.ListNode;

/**
 * @author Achan
 * @date 2020/10/16
 */
public class Solution237 {

    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
