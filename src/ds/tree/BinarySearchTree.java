package ds.tree;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * @author Achan
 * @date 2020/9/24
 */
public class BinarySearchTree<E extends Comparable<E>> extends AbstractBinaryTree<E> {

    public BinarySearchTree() {
        this.root = null;
        this.size = 0;
    }

    @Override
    public boolean insert(E e) {
        if (this.root == null) {
            size++;
            this.root = createNewNode(e);
            return true;
        }
        return insert(e, this.root);
    }

    private boolean insert(E e, TreeNode<E> root) {
        if (root.element.compareTo(e) > 0) {
            if (root.left == null) {
                root.left = createNewNode(e);
                size++;
                return true;
            } else {
                return insert(e, root.left);
            }
        } else {
            if (root.right == null) {
                root.right = createNewNode(e);
                size++;
                return true;
            } else {
                return insert(e, root.right);
            }
        }
    }

    @Override
    public boolean delete(E e) {
        if (this.root == null) {
            return false;
        }
        TreeNode<E> current = root;
        TreeNode<E> parent = null;
        while (current != null) {
            if (current.element.equals(e)) {
                break;
            } else if (current.element.compareTo(e) > 0) {
                parent = current;
                current = current.left;
            } else {
                parent = current;
                current = current.right;
            }
        }
        if (current == null) {
            return false;
        }
        if (current.left == null) {
            if (parent == null) {
                // 根节点
                root = current.right;
            } else {
                if (parent.element.compareTo(e) < 0) {
                    parent.left = current.right;
                } else {
                    parent.right = current.right;
                }
            }
        } else if (current.right == null) {
            if (parent == null) {
                root = current.left;
            } else {
                if (parent.element.compareTo(e) < 0) {
                    parent.left = current.left;
                } else {
                    parent.right = current.left;
                }
            }
        } else {
            TreeNode<E> rightMostMinParent = current;
            TreeNode<E> rightMostMin = current.right;
            E element = current.element;
            while (!TreeNode.isLeaf(rightMostMin)) {
                rightMostMinParent = rightMostMin;
                if (rightMostMin.element.compareTo(element) > 0) {
                    rightMostMin = rightMostMin.left;
                } else {
                    rightMostMin = rightMostMin.right;
                }
            }
            current.element = rightMostMin.element;
            if (rightMostMin.element.compareTo(rightMostMinParent.element) > 0) {
                rightMostMinParent.right = rightMostMin.left;
            } else {
                rightMostMinParent.left = rightMostMin.left;
            }
            balancePath(rightMostMinParent.element);
        }
        size--;
        return true;
    }

    protected void balancePath(E e) {
    }

    @Override
    protected TreeNode<E> createNewNode(E e) {
        return new TreeNode<>(e);
    }

    @Override
    protected TreeNode<E> search(TreeNode<E> root, E e) {
        if (root == null) {
            return null;
        }
        if (root.element.equals(e)) {
            return root;
        }
        if (root.element.compareTo(e) > 0) {
            return search(root.left, e);
        } else {
            return search(root.right, e);
        }
    }

    /**
     * the path from root to e
     * @param e element need to arrive
     * @return the path from to root if the tree not contains the element will return null
     */
    public List<TreeNode<E>> path(E e) {
        List<TreeNode<E>> list = new ArrayList<>(size);
        TreeNode<E> current = this.root;
        while (current != null) {
            list.add(current);
            if (current.element.compareTo(e) > 0) {
                current = current.left;
            } else if (current.element.equals(e)) {
                return list;
            } else {
                current = current.right;
            }
        }
        return null;
    }
}

class BinarySearchTreeTest {
    private static final int TREE_TEST_SIZE = 10;

    @Test
    public void insertTest() {
        BinarySearchTree<Integer> binarySearchTree = getRandomBinarySearchTree(TREE_TEST_SIZE);
        binarySearchTree.bfs().forEach(i -> System.out.printf("%d ", i));
    }

    @Test
    public void deleteTest() {
        BinarySearchTree<Integer> binarySearchTree = new BinarySearchTree<>();
        Arrays.asList(75, 98, 2, 58, 3, 12, 4, 71, 5, 6, 55, 25, 85).forEach(binarySearchTree::insert);
        binarySearchTree.bfs().forEach(i -> System.out.printf("%d ", i));
        System.out.println();
        Assertions.assertTrue(binarySearchTree.delete(12));
        binarySearchTree.bfs().forEach(i -> System.out.printf("%d ", i));
    }

    private BinarySearchTree<Integer> getRandomBinarySearchTree(int size) {
        BinarySearchTree<Integer> binarySearchTree = new BinarySearchTree<>();
        Random random = new Random();
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(100);
            System.out.printf("%d,", array[i]);
            binarySearchTree.insert(array[i]);
        }
        System.out.println();
        return binarySearchTree;
    }
}
