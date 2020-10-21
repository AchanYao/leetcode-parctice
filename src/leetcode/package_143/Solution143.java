package leetcode.package_143;

import leetcode.ds.ListNode;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

/**
 * @author Achan
 * @date 2020/10/20
 */
public class Solution143 {

    public void reorderList(ListNode head) {
        if (head == null) return;
        ArrayList<ListNode> list = new ArrayList<>();
        ListNode t = head;
        while (t != null) {
            list.add(t);
            t = t.next;
        }

        int i = 0, j = list.size() - 1;
        while (i < j) {
            list.get(i).next = list.get(j);
            i++;
            if (i == j) {
                break;
            }
            list.get(j).next = list.get(i);
            j--;
        }
        list.get(i).next = null;
    }

    @Test
    void reorderListTest() {
        ListNode listNode = ListNode.buildList(1,2,3,4);
        reorderList(listNode);
        while (listNode != null) {
            System.out.print(listNode + " ");
            listNode = listNode.next;
        }
    }
}
