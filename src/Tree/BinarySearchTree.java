package src.Tree;

import java.util.LinkedList;
import java.util.Queue;

public class BinarySearchTree {


    private NodeTree root;

    public BinarySearchTree() {
        this.root = null;
    }

    public NodeTree search(int data) {
        NodeTree current = new NodeTree(data);
        while (current.data != data) {
            if (current != null) {
                if (current.data > data) {
                    current = current.leftChild;
                } else {
                    current = current.rightChild;
                }
                if (current == null) {
                    return null;
                }
            }
        }
        return current;
    }

    void insert(int data) {
        NodeTree tempNodeTree = new NodeTree(data);
        NodeTree current;
        NodeTree parent;

        tempNodeTree.data = data;
        tempNodeTree.leftChild = null;
        tempNodeTree.rightChild = null;

        if (root == null) {
            root = tempNodeTree;
        } else {
            current = root;
            parent = null;

            while (true) {
                parent = current;

                if (data < parent.data) {
                    current = current.leftChild;
                    if (current == null) {
                        parent.leftChild = tempNodeTree;
                        break;
                    }
                } else {
                    current = current.rightChild;

                    if (current == null) {
                        parent.rightChild = tempNodeTree;
                        break;
                    }
                }
            }
        }

    }

    public void deleteNode(int data) {
        root = deleteNode(root, data);
    }

    private NodeTree deleteNode(NodeTree root, int data) {
        if (root == null) {
            System.out.println("Valor não encontrado");
            return null;
        }

        if (data < root.data) {
            root.leftChild = deleteNode(root.leftChild, data);
        } else if (data > root.data) {
            root.rightChild = deleteNode(root.rightChild, data);
        } else {
            // Caso 1: Nó sem ou com apenas um filho
            if (root.leftChild == null) {
                return root.rightChild;
            } else if (root.rightChild == null) {
                return root.leftChild;
            }

            // Caso 2: Nó com dois filhos
            root.data = minValue(root.rightChild);
            root.rightChild = deleteNode(root.rightChild, root.data);
        }

        return root;
    }

    private int minValue(NodeTree node) {
        int minValue = node.data;
        while (node.leftChild != null) {
            minValue = node.leftChild.data;
            node = node.leftChild;
        }
        return minValue;
    }
    public void inOrderTraversal() {
        inOrder(root);
    }
    public void preOrderTraversal() {
        preOrder(root);
    }

    private void preOrder(NodeTree root) {
        if (root == null) {
            return;
        }

        System.out.print(root.data + " ");
        preOrder(root.leftChild);
        preOrder(root.rightChild);
    }

    private void inOrder(NodeTree root) {
        if (root == null) {
            return;
        }
        inOrder(root.leftChild);

        System.out.print(root.data + " ");

        inOrder(root.rightChild);
    }

    public void postOrderTraversal() {
        postOrder(root);
    }

    private void postOrder(NodeTree root) {
        if (root == null) {
            return;
        }
        postOrder(root.rightChild);

        System.out.print(root.data + " ");

        postOrder(root.leftChild);
    }
    public void inLevel(){
        inLevel(root);
    }
    private void inLevel(NodeTree root){
        if (root == null) {
            return;
        }

        Queue<NodeTree> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            NodeTree current = queue.poll();
            System.out.print(current.data + " ");

            if (current.leftChild != null) {
                queue.add(current.leftChild);
            }

            if (current.rightChild != null) {
                queue.add(current.rightChild);
            }
        }
    }
}