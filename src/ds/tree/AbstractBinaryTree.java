package ds.tree;

import java.util.*;

/**
 * @author Achan
 * @date 2020/9/23
 */
public abstract class AbstractBinaryTree<E extends Comparable<E>> implements Tree<E> {


    protected TreeNode<E> root;
    protected int size;

    public TreeNode<E> getRoot() {
        return root;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public void clear() {
        this.root = null;
        this.size = 0;
    }

    @Override
    public List<E> inTraverse() {
        List<E> list = new ArrayList<>(size);
        return inTraverse(root, list);
    }

    protected List<E> inTraverse(TreeNode<E> root, List<E> result) {
        if (root == null) {
            return result;
        }
        inTraverse(root.left, result);
        result.add(root.element);
        inTraverse(root.right, result);
        return result;
    }

    @Override
    public List<E> preTraverse() {
        List<E> list = new ArrayList<>(size);
        return preTraverse(root, list);
    }

    protected List<E> preTraverse(TreeNode<E> root, List<E> result) {
        if (root == null) {
            return result;
        }
        result.add(root.element);
        preTraverse(root.left, result);
        preTraverse(root.right, result);
        return result;
    }

    @Override
    public List<E> postTraverse() {
        List<E> list = new ArrayList<>(size);
        return postTraverse(root, list);
    }

    protected List<E> postTraverse(TreeNode<E> root, List<E> result) {
        if (root == null) {
            return null;
        }
        postTraverse(root.left, result);
        postTraverse(root.right, result);
        result.add(root.element);
        return result;
    }

    @Override
    public Iterator<E> iterator() {
        return inTraverse().iterator();
    }

    protected List<E> bfs() {
        Queue<TreeNode<E>> queue = new LinkedList<>();
        List<E> list = new ArrayList<>(this.size);
        queue.offer(this.root);
        while (!queue.isEmpty()) {
            TreeNode<E> current = queue.poll();
            list.add(current.element);
            if (current.left != null) {
                queue.offer(current.left);
            }
            if (current.right != null) {
                queue.offer(current.right);
            }
        }
        return list;
    }

    protected List<E> dfs() {
        return dfs(this.root, new ArrayList<>(this.size));
    }

    private List<E> dfs(TreeNode<E> root, List<E> result) {
        if (root == null) {
            return null;
        }
        result.add(root.element);
        dfs(root.left, result);
        dfs(root.right, result);
        return result;
    }

    public boolean hasChildren(TreeNode<E> root) {
        return root != null && (root.right != null || root.left != null);
    }
}
