package ds.tree;

/**
 * @author Achan
 * @date 2020/9/22
 */
public class TreeNode<E extends Comparable<E>> implements Comparable<TreeNode<E>> {

    E element;
    TreeNode<E> left;
    TreeNode<E> right;

    public TreeNode() {}

    public TreeNode(E element) {
        this.element = element;
    }

    @Override
    public int compareTo(TreeNode<E> o) {
        return this.element.compareTo(o.element);
    }

    @Override
    public String toString() {
        return String.valueOf(element);
    }
}
