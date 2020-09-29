package offer;

import leetcode.ds.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Achan
 * @date 2020/9/27
 */
public class SwordFinger07 {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        //把前序遍历的值和中序遍历的值放到list中
        List<Integer> preorderList = new ArrayList<>();
        List<Integer> inorderList = new ArrayList<>();
        for (int i = 0; i < preorder.length; i++) {
            preorderList.add(preorder[i]);
            inorderList.add(inorder[i]);
        }
        return helper(preorderList, inorderList);
    }

    private TreeNode helper(List<Integer> preorderList, List<Integer> inorderList) {
        if (inorderList.size() == 0) {
            return null;
        }
        //前序遍历的第一个值就是根节点
        int rootVal = preorderList.remove(0);
        //创建跟结点
        TreeNode root = new TreeNode(rootVal);
        //查看根节点在中序遍历中的位置，然后再把中序遍历的数组劈两半，前面部分是
        //根节点左子树的所有值，后面部分是根节点右子树的所有值
        int mid = inorderList.indexOf(rootVal);
        //[0，mid)是左子树的所有值，inorderList.subList(0, mid)表示截取inorderList
        //的值，截取的范围是[0，mid)，包含0不包含mid。
        root.left = helper(preorderList, inorderList.subList(0, mid));
        //[mid+1，inorderList.size())是右子树的所有值，
        // inorderList.subList(mid + 1, inorderList.size())表示截取inorderList
        //的值，截取的范围是[mid+1，inorderList.size())，包含mid+1不包含inorderList.size()。
        root.right = helper(preorderList, inorderList.subList(mid + 1, inorderList.size()));
        return root;
    }

}

