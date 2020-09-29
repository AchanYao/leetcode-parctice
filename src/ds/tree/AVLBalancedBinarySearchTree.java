package ds.tree;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * AVL树
 *
 * @author Achan
 * @date 2020/9/28
 */
public class AVLBalancedBinarySearchTree<E extends Comparable<E>> extends BinarySearchTree<E> {

    @Override
    public boolean insert(E e) {
        if (super.insert(e)) {
            balancePath(e);
            return true;
        } else {
            return false;
        }
    }

    @Override
    protected AVLTreeNode<E> createNewNode(E e) {
        return new AVLTreeNode<>(e);
    }

    /**
     * 更新节点高度
     *
     * @param node 需要被更新的节点
     */
    private void updateHeight(AVLTreeNode<E> node) {
        AVLTreeNode<E> left = (AVLTreeNode<E>) node.left;
        AVLTreeNode<E> right = (AVLTreeNode<E>) node.right;
        if (TreeNode.isLeaf(node)) {
            node.height = 0;
        } else if (left == null) {
            node.height = 1 + right.height;
        } else if (right == null) {
            node.height = 1 + left.height;
        } else {
            node.height = 1 + Math.max(right.height, left.height);
        }
    }

    /**
     * 从该元素的节点到根重新进行平衡操作
     *
     * @param e 需要平衡的元素
     */
    @Override
    public void balancePath(E e) {
        List<TreeNode<E>> path = path(e);
        for (int i = 0; i < path.size(); i++) {
            AVLTreeNode<E> a = (AVLTreeNode<E>) (path.get(i));
            updateHeight(a);
            AVLTreeNode<E> parentOfA = a.equals(root) ? null : (AVLTreeNode<E>) path.get(i - 1);

            switch (balanceFactor(a)) {
                case -2:
                    if (balanceFactor((AVLTreeNode<E>) a.left) <= 0) {
                        leftLeftRoute(a, parentOfA);
                    } else {
                        leftRightRoute(a, parentOfA);
                    }
                    break;
                case 2:
                    if (balanceFactor((AVLTreeNode<E>) a.right) >= 0) {
                        rightRightRoute(a, parentOfA);
                    } else {
                        rightLeftRoute(a, parentOfA);
                    }
                    break;
                default:
                    break;
            }
        }
    }

    public int balanceFactor(AVLTreeNode<E> node) {
        if (node == null || !node.hasChild()) {
            return 0;
        }
        AVLTreeNode<E> left = (AVLTreeNode<E>) node.left;
        AVLTreeNode<E> right = (AVLTreeNode<E>) node.right;
        if (left != null && right == null) {
            return -left.height;
        }
        if (left == null && right != null) {
            return right.height;
        }
        return right.height - left.height;
    }

    private void leftLeftRoute(AVLTreeNode<E> node, AVLTreeNode<E> nodeParent) {
        AVLTreeNode<E> nodeLeft = (AVLTreeNode<E>) node.left;
        if (node.equals(root)) {
            root = nodeLeft;
        } else {
            if (nodeParent.left == node) {
                nodeParent.left = nodeLeft;
            } else {
                nodeParent.right = nodeLeft;
            }
        }
        node.left = nodeLeft.right;
        nodeLeft.right = node;
        updateHeight(node);
        updateHeight(nodeLeft);
        updateHeight(nodeParent);
    }

    private void rightRightRoute(AVLTreeNode<E> node, AVLTreeNode<E> nodeParent) {
        AVLTreeNode<E> nodeRight = (AVLTreeNode<E>) node.right;
        if (node == root) {
            root = nodeRight;
        } else {
            if (nodeParent.right == node) {
                nodeParent.right = nodeRight;
            } else {
                nodeParent.left = nodeRight;
            }
        }
        node.right = nodeRight.left;
        nodeRight.left = node;
        updateHeight(node);
        updateHeight(nodeRight);
        updateHeight(nodeParent);
    }

    private void leftRightRoute(AVLTreeNode<E> node, AVLTreeNode<E> nodeParent) {
        AVLTreeNode<E> nodeLeft = (AVLTreeNode<E>) node.left;
        AVLTreeNode<E> nodeLeftRight = (AVLTreeNode<E>) nodeLeft.right;

        if (node == root) {
            root = nodeLeftRight;
        } else {
            if (nodeParent.left == node) {
                nodeParent.left = nodeLeftRight;
            } else {
                nodeParent.right = nodeLeftRight;
            }
        }

        node.left = nodeLeftRight.right;
        nodeLeft.right = nodeLeftRight.left;
        nodeLeftRight.left = nodeLeft;
        nodeLeftRight.right = node;

        updateHeight(node);
        updateHeight(nodeLeft);
        updateHeight(nodeLeftRight);
    }

    private void rightLeftRoute(AVLTreeNode<E> node, AVLTreeNode<E> nodeParent) {
        AVLTreeNode<E> nodeRight = (AVLTreeNode<E>) node.right;
        AVLTreeNode<E> nodeRightLeft = (AVLTreeNode<E>) nodeRight.left;

        if (node == root) {
            root = nodeRightLeft;
        } else {
            if (nodeParent.left == node) {
                nodeParent.left = nodeRightLeft;
            } else {
                nodeParent.right = nodeRightLeft;
            }
        }

        node.right = nodeRightLeft.left;
        nodeRight.left = nodeRightLeft.right;
        nodeRightLeft.left = node;
        nodeRightLeft.right = nodeRight;

        updateHeight(node);
        updateHeight(nodeRight);
        updateHeight(nodeRightLeft);
    }

    /**
     * AVL树节点
     *
     * @param <T> 类型
     */
    static class AVLTreeNode<T> extends TreeNode<T> {
        int height;

        public AVLTreeNode(T t) {
            this.element = t;
        }
    }
}

class AVLBalancedBinarySearchTreeTest {


    @Test
    void insertTest() {
        AVLBalancedBinarySearchTree<Integer> avlBalancedBinarySearchTree = new AVLBalancedBinarySearchTree<>();
        Arrays.asList(75, 98, 2, 58, 3, 12, 4, 71, 5, 6, 55, 25, 85).forEach(avlBalancedBinarySearchTree::insert);
        avlBalancedBinarySearchTree.bfs().stream().flatMap(integer -> Stream.of(integer + ",")).forEach(System.out::print);
    }

    @Test
    void deleteTest() {
        AVLBalancedBinarySearchTree<Integer> avlBalancedBinarySearchTree = new AVLBalancedBinarySearchTree<>();
        Arrays.asList(75, 98, 2, 58, 3, 12, 4, 71, 5, 6, 55, 25, 85).forEach(avlBalancedBinarySearchTree::insert);
        Assertions.assertTrue(avlBalancedBinarySearchTree.delete(75));
        Assertions.assertFalse(avlBalancedBinarySearchTree.delete(-1));
        avlBalancedBinarySearchTree.bfs().stream().flatMap(integer -> Stream.of(integer + ",")).forEach(System.out::print);
    }
}