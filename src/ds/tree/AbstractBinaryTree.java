package ds.tree;

import java.util.*;

/**
 * @author Achan
 * @date 2020/9/23
 */
public abstract class AbstractBinaryTree<E> implements Tree<E> {


    protected TreeNode<E> root;
    protected int size;

    /**
     * 创建一个值为e的树节点
     * @param e 节点元素
     * @return 所创建的节点
     */
    protected abstract TreeNode<E> createNewNode(E e);

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
    public TreeNode<E> search(E e) {
        return search(getRoot(), e);
    }

    /**
     * 以指定节点作为根节点查找元素并返回所在节点
     * @param root 根节点
     * @param e 需要查找的元素
     * @return 元素所在节点，不存在返回null
     */
    protected abstract TreeNode<E> search(TreeNode<E> root, E e);

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

    private List<E> preTraverse(TreeNode<E> root, List<E> result) {
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

    private List<E> postTraverse(TreeNode<E> root, List<E> result) {
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
        return bfs().iterator();
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
}
