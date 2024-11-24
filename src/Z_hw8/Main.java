package Z_hw8;

import L_trees.BinaryTreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Main {
    public static <E> List<E> preorderList(BinaryTreeNode<E> root) {
        List<E> list = new ArrayList<>();
        preorderListHelper(root, list);
        return list;
    }

    private static <E> void preorderListHelper(BinaryTreeNode<E> root, List<E> list) {
        if (root != null) {
            list.add(root.data);
            preorderListHelper(root.left, list);
            preorderListHelper(root.right, list);
        }
    }

    public static <E> List<E> inorderList(BinaryTreeNode<E> root) {
        List<E> list = new ArrayList<>();
        inorderListHelper(root, list);
        return list;
    }

    private static <E> void inorderListHelper(BinaryTreeNode<E> root, List<E> list) {
        if (root != null) {
            inorderListHelper(root.left, list);
            list.add(root.data);
            inorderListHelper(root.right, list);
        }
    }

    public static <E> List<E> postorderList(BinaryTreeNode<E> root) {
        List<E> list = new ArrayList<>();
        postorderListHelper(root, list);
        return list;
    }

    private static <E> void postorderListHelper(BinaryTreeNode<E> root, List<E> list) {
        if (root != null) {
            postorderListHelper(root.left, list);
            postorderListHelper(root.right, list);
            list.add(root.data);
        }
    }

    public static int countLeaves(BinaryTreeNode<?> root) {
        if (root == null) {
            return 0;
        } else  {
            return (isLeaf(root) ? 1 : 0) + countLeaves(root.left) + countLeaves(root.right);
        }
    }

    private static boolean isLeaf(BinaryTreeNode<?> node) {
        return node.left == null && node.right == null;
    }

    public static boolean isProper(BinaryTreeNode<?> root) {
        if (root == null) {
            return true;
        } else {
            return hasZeroOrTwoChildren(root) && isProper(root.left) && isProper(root.right);
        }
    }

    private static boolean hasZeroOrTwoChildren(BinaryTreeNode<?> node) {
        return (node.left == null) == (node.right == null);
    }

    public static <E> boolean contains(BinaryTreeNode<E> root, E element) {
        if (root == null) {
            return false;
        } else {
            return Objects.equals(root.data, element) || contains(root.left, element) || contains(root.right, element);
        }
    }

    public static <E> int count(BinaryTreeNode<E> root, E e) {
        if (root == null) {
            return 0;
        } else {
            return (Objects.equals(root.data, e) ? 1 : 0) + count(root.left, e) + count(root.right, e);
        }
    }

    public static int sum(BinaryTreeNode<Integer> root) {
        if (root == null) {
            return 0;
        } else {
            return root.data + sum(root.left) + sum(root.right);
        }
    }

    public static int maxPathSum(BinaryTreeNode<Integer> root) {
        if (root == null) {
            return 0;
        } else {
            return root.data + Math.max(maxPathSum(root.left), maxPathSum(root.right));
        }
    }
}