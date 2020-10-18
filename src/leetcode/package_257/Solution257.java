package leetcode.package_257;

import leetcode.ds.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Achan
 * @date 2020/10/16
 */
public class Solution257 {

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> list = new ArrayList<>();
        helper(list,"",root);
        return list;
    }
    public void helper(List<String> list,String str,TreeNode root){
        if(root == null)    return;
        StringBuffer strsb = new StringBuffer(str);
        strsb.append(root.val);
        if(root.left == null && root.right == null){
            list.add(strsb.toString());
        }
        strsb.append("->");
        helper(list,strsb.toString(),root.left);
        helper(list,strsb.toString(),root.right);
    }
}
