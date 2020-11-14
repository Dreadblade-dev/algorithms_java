package com.dreadblade.datastructures.tree;

import java.util.*;

/**
 * @author Dreadblade- (https://github.com/Dreadblade-dev)
 * @param <T> type of content (extends Comparable)
 *
 * In computer science, a binary search tree (BST), also called
 * an ordered or sorted binary tree, is a rooted binary tree whose
 * internal nodes each store a key greater than all the keys in the
 * node's left subtree and less than those in its right subtree.
 * A binary tree is a type of data structure for storing data such
 * as numbers in an organized way.
 *
 * Time complexity:
 * ┌────────────┬───────────┬──────────┬──────────┬──────────┐
 * │            │ Insertion │ Deletion │  Access  │  Search  │
 * ├────────────┼───────────┼──────────┼──────────┼──────────┤
 * │ Best case: │    O(1)   │   O(1)   │   O(1)   │   O(1)   │
 * ├────────────┼───────────┼──────────┼──────────┼──────────┤
 * │  Average:  │  O(log n) │ O(log n) │ O(log n) │ O(log n) │
 * ├────────────┼───────────┼──────────┤──────────┼──────────┤
 * │ Worst case:│    O(n)   │   O(1)   │   O(1)   │   O(n)   │
 * └────────────┴───────────┴──────────┴──────────┴──────────┘
 *
 * Source: https://en.wikipedia.org/wiki/Binary_search_tree
 */
public class BinarySearchTree<T extends Comparable<T>> implements Tree<T> {
    private Node root;
    private int nodeCount;

    /**
     * Class representing node of the tree
     */
    private class Node {
        private T data;
        private Node left;
        private Node right;

        public Node(T data, Node left, Node right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }

    public BinarySearchTree() {
        this.root = null;
        nodeCount = 0;
    }

    /**
     * Adds a <code>T item</code> to the tree
     * @param item
     */
    @Override
    public void add(T item) {
        if (contains(item)) {
            return;
        }

        add(root, item);
        nodeCount++;
    }

    // private method for recursive tree traversal
    private Node add(Node node, T item) {

        // Base case: leaf node
        if (node == null) {
            node = new Node(item, null, null);
        } else {
            if (node.data.compareTo(item) > 0) {
                node.left = add(node.left, item);
            } else {
                node.right = add(node.right, item);
            }
        }

        if (root == null) {
            root = node;
        }

        return node;
    }

    /**
     * @param item - the <code>T item</code> to be removed from the tree
     * @return <code>true</code> if <code>T item</code> was removed from the tree, <code>false</code> otherwise
     */
    @Override
    public boolean remove(T item) {
        if (contains(item)) {
            root = remove(root, item);
            nodeCount--;
            return true;
        }
        return false;
    }

    // private method for recursive tree traversal
    private Node remove(Node node, T item) {
        if (node == null) {
            return null;
        }

        int cmp = item.compareTo(node.data);

        if (cmp < 0) {
            node.left = remove(node.left, item);
        } else if (cmp > 0) {
            node.right = remove(node.right, item);
        } else {
            if (node.left == null) {
                return node.right;
            } if (node.right == null) {
                return node.left;
            } else {
                Node tmp = findMin(node.right);
                node.data = tmp.data;

                node.right = remove(node.right, tmp.data);
            }
        }

        return node;
    }

    // finds node with min value
    private Node findMin(Node node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }

    // finds node with max value
    private Node findMax(Node node) {
        while (node.right != null) {
            node = node.right;
        }
        return node;
    }

    /**
     * @param item the <code>T item</code> to be found
     * @return true if <code>T item</code> was found, <code>false</code> otherwise
     */
    @Override
    public boolean contains(T item) {
        return contains(root, item);
    }

    // private method for recursive tree traversal
    private boolean contains(Node node, T item) {
        // Base case: item not found
        if (node == null) {
            return false;
        }

        int cmpResult = item.compareTo(node.data);

        if (cmpResult < 0) {
            return contains(node.left, item);
        } else if (cmpResult > 0) {
            return contains(node.right, item);
        } else {
            return true;
        }
    }

    /**
     * @return <code>int height</code> of the tree
     */
    @Override
    public int height() {
        if (!isEmpty()) {
            throw new EmptyTreeException();
        }
        return height(root);
    }

    // private method for recursive tree traversal
    private int height(Node node) {
        if (node == null) {
            return 0;
        }
        return Math.max(height(node.left), height(node.right)) + 1;
    }

    /**
     * Clears the tree
     */
    @Override
    public void clear() {
        root = null;
        nodeCount = 0;
    }

    /**
     * @return <code>true</code> if tree is empty, <code>false</code> otherwise
     */
    @Override
    public boolean isEmpty() {
        return nodeCount == 0 && root == null;
    }

    /**
     * @return <code>int size</code> of the tree (amount of nodes)
     */
    @Override
    public int size() {
        return nodeCount;
    }

    /**
     * @return an <code>Iterator&lt;T&gt;</code> to traverse the tree in pre order
     */
    public Iterator<T> preOrderTraversal() {
        final int expectedNodeCount = nodeCount;
        final Stack<Node> stack = new Stack<>();
        stack.push(root);

        return new Iterator<T>() {
            @Override
            public boolean hasNext() {
                if (expectedNodeCount != nodeCount) {
                    throw new ConcurrentModificationException();
                }
                return root != null && !stack.isEmpty();
            }

            @Override
            public T next() {
                if (expectedNodeCount != nodeCount) {
                    throw new ConcurrentModificationException();
                }

                Node node = stack.pop();

                if (node.right != null) {
                    stack.push(node.right);
                }
                if (node.left != null) {
                    stack.push(node.left);
                }

                return node.data;
            }
        };
    }

    /**
     * @return an <code>Iterator&lt;T&gt;</code> to traverse the tree in order
     */
    public Iterator<T> inOrderTraversal() {
        final int expectedNodeCount = nodeCount;
        final Stack<Node> stack = new Stack<>();
        stack.push(root);

        return new Iterator<T>() {
            Node traversal = root;

            @Override
            public boolean hasNext() {
                if (expectedNodeCount != nodeCount) {
                    throw new ConcurrentModificationException();
                }
                return root != null && !stack.isEmpty();
            }

            @Override
            public T next() {
                if (expectedNodeCount != nodeCount) {
                    throw new ConcurrentModificationException();
                }

                while (traversal != null && traversal.left != null) {
                    stack.push(traversal.left);
                    traversal = traversal.left;
                }

                Node node = stack.pop();

                if (node.right != null) {
                    stack.push(node.right);
                    traversal = node.right;
                }

                return node.data;
            }
        };
    }

    /**
     * @return an <code>Iterator&lt;T&gt;</code> to traverse the tree in post order
     */
    public Iterator<T> postOrderTraversal() {
        final int expectedNodeCount = nodeCount;
        final Stack<Node> stack1 = new Stack<>();
        final Stack<Node> stack2 = new Stack<>();
        stack1.push(root);

        while (!stack1.isEmpty()) {
            Node node = stack1.pop();
            if (node != null) {
                stack2.push(node);
                if (node.left != null) {
                    stack1.push(node.left);
                }
                if (node.right != null) {
                    stack1.push(node.right);
                }
            }
        }

        return new Iterator<T>() {
            @Override
            public boolean hasNext() {
                if (expectedNodeCount != nodeCount) {
                    throw new ConcurrentModificationException();
                }
                return root != null && !stack2.isEmpty();
            }

            @Override
            public T next() {
                if (expectedNodeCount != nodeCount) {
                    throw new ConcurrentModificationException();
                }
                return stack2.pop().data;
            }
        };
    }

    /**
     * @return an <code>Iterator&lt;T&gt;</code> to traverse the tree in level
     */
    public Iterator<T> levelOrderTraversal() {
        final int expectedNodeCount = nodeCount;
        final Queue<Node> queue = new LinkedList<>();
        queue.offer(root);

        return new Iterator<T>() {
            @Override
            public boolean hasNext() {
                if (expectedNodeCount != nodeCount) {
                    throw new ConcurrentModificationException();
                }
                return root != null && !queue.isEmpty();
            }

            @Override
            public T next() {
                if (expectedNodeCount != nodeCount) {
                    throw new ConcurrentModificationException();
                }
                Node node = queue.poll();
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }

                return node.data;
            }
        };
    }
}