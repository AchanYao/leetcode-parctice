package ds.tree;

/**
 * @author Achan
 * @date 2020/9/22
 */
public class TreeNode<E> {

    E element;
    TreeNode<E> left;
    TreeNode<E> right;

    public TreeNode() {}

    public TreeNode(E element) {
        this.element = element;
    }

    @Override
    public String toString() {
        return String.valueOf(element);
    }

    public static boolean isLeaf(TreeNode<?> root) {
        return root.right == null && root.left == null;
    }

    public boolean hasChild() {
        return this.left != null || this.right != null;
    }
}
