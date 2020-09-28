package ds.tree;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Random;

/**
 * @author Achan
 * @date 2020/9/22
 */
public class CompleteBinaryTree<E extends Comparable<E>> extends AbstractBinaryTree<E> {

    public CompleteBinaryTree() {
        size = 0;
    }

    @Override
    public boolean search(E e) {
        return search(getRoot(), e) != null;
    }

    protected TreeNode<E> search(TreeNode<E> treeNode, E e) {
        if (treeNode == null) {
            return null;
        }
        if (treeNode.element.equals(e)) {
            return treeNode;
        }
        if (treeNode.left == null && treeNode.right == null) {
            return null;
        }
        TreeNode<E> temp = search(treeNode.right, e);
        return temp == null ? search(treeNode.left, e) : temp;
    }

    @Override
    public boolean insert(E e) {
        if (size == 0) {
            root = new TreeNode<>(e);
            size++;
            return true;
        }
        byte[] bytes = new byte[size];
        int current = size;
        int i = 0;
        for (; current != 0; i++) {
            bytes[i] = (byte) (current & 1);
            current = (current - 1) / 2;
        }
        TreeNode<E> parent = null;
        TreeNode<E> currentNode = root;
        for (int j = i - 1; j >= 0; j--) {
            parent = currentNode;
            if (bytes[j] == 0) {
                currentNode = parent.right;
            } else {
                currentNode = parent.left;
            }
        }
        if (parent == null) {
            parent = root;
        }
        if (bytes[0] == 0) {
            parent.right = new TreeNode<>(e);
        } else {
            parent.left = new TreeNode<>(e);
        }
        size++;
        return true;
    }

    @Override
    public boolean delete(E e) {
        // 牵一发而动全身，我是不会写了，只有这么来了
        List<E> bfs = bfs();
        if (bfs.remove(e)) {
            size--;
            CompleteBinaryTree<E> tree = new CompleteBinaryTree<>();
            bfs.forEach(tree::insert);
            this.root = tree.root;
            return true;
        }
        return false;
    }
}

class CompleteBinaryTreeTest {

    @Test
    public void insertTest() {
        CompleteBinaryTree<Integer> completeBinaryTree = new CompleteBinaryTree<>();
        for (int i = 0; i < 10; i++) {
            Assertions.assertTrue(completeBinaryTree.insert(i));
        }

        List<Integer> result = completeBinaryTree.inTraverse();
        for (Integer integer : result) {
            System.out.printf("%d ", integer);
        }
    }

    @Test
    public void searchTest() {
        CompleteBinaryTree<Integer> completeBinaryTree = new CompleteBinaryTree<>();
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            completeBinaryTree.insert(random.nextInt(1000));
            completeBinaryTree.insert(i);
        }
        List<Integer> result = completeBinaryTree.inTraverse();
        for (Integer integer : result) {
            System.out.printf("%d ", integer);
        }
        int search = random.nextInt(1000);
        System.out.println("\nsearch " + search + ": " + completeBinaryTree.search(search));
        System.out.println("search 9: " + completeBinaryTree.search(9));
        System.out.println("search 10: " + completeBinaryTree.search(10));
    }

    @Test
    public void bfsTest() {
        CompleteBinaryTree<Integer> completeBinaryTree = new CompleteBinaryTree<>();
        for (int i = 0; i < 10; i++) {
            completeBinaryTree.insert(i);
        }
        completeBinaryTree.bfs().forEach(integer -> System.out.print(integer + " "));
    }

    @Test
    public void dfsTest() {
        CompleteBinaryTree<Integer> completeBinaryTree = new CompleteBinaryTree<>();
        for (int i = 0; i < 10; i++) {
            completeBinaryTree.insert(i);
        }
        completeBinaryTree.dfs().forEach(integer -> System.out.printf("%d ", integer));
    }
}
