package Q_bst.C_our.set;

import java.util.*;

public class TreeSet3130<E> implements NavigableSet3130<E> {
    // Representation: a binary search tree.
    // Methods add and contains run in O(h) time, where h is the height of the tree.
    // However, since this BST is not balanced, h might be as great as n - 1, where
    // n is the number of nodes in the tree. So the methods run in O(n) time.
    // In the JCF's TreeSet, however, the BST is balanced. Thus, in the JCF's TreeSet,
    // methods add and contains (and remove, and some more) run in O(log n) time,
    // which is very efficient.

    private static class Node<E> {
        private final E data;
        private Node<E> left, right;

        public Node(E data, Node<E> left, Node<E> right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }

        public Node(E data) {
            this(data, null, null);
        }
    }

    private class NaturalOrderComparator implements Comparator<E> {
        @Override
        public int compare(E e1, E e2) {
            return ((Comparable<E>) e1).compareTo(e2);
        }
    }

    private Node<E> root = null;
    private int size = 0;
    private final Comparator<E> comparator;

    public TreeSet3130() {
        this.comparator = new NaturalOrderComparator();
    }

    public TreeSet3130(Comparator<E> comparator) {
        this.comparator = comparator;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean add(E element) {
        if (root == null) {
            root = new Node<>(element);
            size++;
            return true;
        }

        Node<E> parent = null, current = root;

        while (current != null) {
            int comparisonResult = comparator.compare(element, current.data);

            if (comparisonResult == 0) {
                return false; // element is already in the tree
            } else if (comparisonResult < 0) {
                parent = current;
                current = current.left;
            } else { // comparisonResult > 0
                parent = current;
                current = current.right;
            }
        }

        if (comparator.compare(element, parent.data) < 0) {
            parent.left = new Node<>(element);
        } else {
            parent.right = new Node<>(element);
        }

        size++;
        return true;
    }

    @Override
    public boolean contains(Object o) {
        Node<E> current = root;

        while (current != null) {
            int comparisonResult = comparator.compare((E) o, current.data);

            if (comparisonResult == 0) {
                return true;
            } else if (comparisonResult < 0) {
                current = current.left;
            } else {
                current = current.right;
            }
        }

        return false;
    }

    @Override
    public boolean remove(Object o) {
        throw new UnsupportedOperationException("not implemented in this course");
    }

    @Override
    public E getFirst() {
        if (root == null) {
            throw new NoSuchElementException();
        }

        Node<E> current = root;

        while (current.left != null) {
            current = current.left;
        }

        return current.data;
    }

    @Override
    public E getLast() {
        if (root == null) {
            throw new NoSuchElementException();
        }

        Node<E> current = root;

        while (current.right != null) {
            current = current.right;
        }

        return current.data;
    }

    @Override
    public E lower(E e) {
        Node<E> curr = root;
        E result = null;

        while (curr != null) {
            if (comparator.compare(e, curr.data) <= 0) {
                curr = curr.left;
            } else {
                result = curr.data;
                curr = curr.right;
            }
        }

        return result;
    }

    @Override
    public E higher(E e) {
        Node<E> curr = root;
        E result = null;

        while (curr != null) {
            if (comparator.compare(e, curr.data) >= 0) {
                curr = curr.right;
            } else {
                result = curr.data;
                curr = curr.left;
            }
        }

        return result;
    }

    @Override
    public Iterator<E> iterator() { // can be done much more efficiently
        List<E> list = new ArrayList<>();
        fillInorder(list, root);
        return list.iterator();
    }

    private static <E> void fillInorder(List<E> list, Node<E> root) {
        if (root != null) {
            fillInorder(list, root.left);
            list.add(root.data);
            fillInorder(list, root.right);
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        int count = 0;

        for (E element : this) {
            sb.append(element);

            if (count < size) {
                sb.append(", ");
            }

            count++;
        }

        return sb.append("]").toString();
    }
}