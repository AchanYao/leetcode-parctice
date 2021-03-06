package ds.tree;

import java.util.List;

/**
 * @author Achan
 * @date 2020/9/22
 */
public interface Tree<E> extends Iterable<E> {

    /**
     * 查找元素所在节点
     * @param e 需要查找的元素
     * @return 元素节点，不存在为null
     */
    TreeNode<E> search(E e);

    /**
     * 是否包含该元素
     * @param e 需要查找的元素
     * @return 是否存在
     */
    default boolean contains(E e) {
        return search(e) != null;
    }

    /**
     * insert a new element
     * @param e new element
     * @return success or fail
     */
    boolean insert(E e);

    /**
     * delete an element
     * @param e element will be deleted
     * @return success or fail
     */
    boolean delete(E e);

    /**
     * in order traverse
     * @return be accessed element in traverse
     */
    List<E> inTraverse();

    /**
     * in pre order traverse
     * @return be accessed element in traverse
     */
    List<E> preTraverse();

    /**
     * in post order traverse
     * @return be accessed element in traverse
     */
    List<E> postTraverse();

    /**
     * get the num of elements in this tree
     * @return the num of all elements
     */
    int getSize();

    /**
     * judge the tree is it empty
     * @return is it empty
     */
    default boolean isEmpty() {
        return getSize() == 0;
    }

    /**
     * clear all element
     */
    void clear();
}
