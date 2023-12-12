package src.Tree;

public class RedBlackTree<T extends Comparable<T>> extends AbstractTree<T, RedBlackNode<T>> {

    private static final int RED = 0;
    private static final int BLACK = 1;

    public RedBlackTree() {
        this.root = null;
    }

    @Override
    public void insert(T data) {
        RedBlackNode<T> newNode = new RedBlackNode<>(data);
        if (root == null) {
            root = newNode;
            root.color = BLACK;
        } else {
            insertRecursive(root, newNode);
            fixInsert(newNode);
        }
    }

    @Override
    public void deleteElement(T data) {
        RedBlackNode<T> nodeToDelete = searchElement(data);
        if (nodeToDelete != null) {
            root = deleteNode(root, data);
        }
    }

    private void fixInsert(RedBlackNode<T> node) {
        while (node != root && (node.parent == null || node.parent.color == RED)) {
            if (node.parent != null) {
                RedBlackNode<T> parent = node.parent;
                RedBlackNode<T> grandparent = parent.parent;

                if (parent.isLeft) {
                    RedBlackNode<T> uncle = grandparent.rightChild;

                    if (uncle != null && uncle.color == RED) {
                        parent.color = BLACK;
                        uncle.color = BLACK;
                        grandparent.color = RED;
                        node = grandparent;
                    } else {
                        if (!node.isLeft) {
                            node = parent;
                            rotateLeft(node);
                        }
                        parent.color = BLACK;
                        grandparent.color = RED;
                        rotateRight(grandparent);
                    }
                } else {
                    RedBlackNode<T> uncle = grandparent.leftChild;

                    if (uncle != null && uncle.color == RED) {
                        parent.color = BLACK;
                        uncle.color = BLACK;
                        grandparent.color = RED;
                        node = grandparent;
                    } else {
                        if (node.isLeft) {
                            node = parent;
                            rotateRight(node);
                        }
                        parent.color = BLACK;
                        grandparent.color = RED;
                        rotateLeft(grandparent);
                    }
                }
            }
        }

        root.color = BLACK;
    }

    private void rotateLeft(RedBlackNode<T> node) {
        RedBlackNode<T> rightChild = node.rightChild;
        node.rightChild = rightChild.leftChild;
        if (rightChild.leftChild != null) {
            rightChild.leftChild.parent = node;
        }
        rightChild.parent = node.parent;
        if (node.parent == null) {
            root = rightChild;
        } else if (node == node.parent.leftChild) {
            node.parent.leftChild = rightChild;
        } else {
            node.parent.rightChild = rightChild;
        }
        rightChild.leftChild = node;
        node.parent = rightChild;
    }

    private void rotateRight(RedBlackNode<T> node) {
        RedBlackNode<T> leftChild = node.leftChild;
        node.leftChild = leftChild.rightChild;
        if (leftChild.rightChild != null) {
            leftChild.rightChild.parent = node;
        }
        leftChild.parent = node.parent;
        if (node.parent == null) {
            root = leftChild;
        } else if (node == node.parent.rightChild) {
            node.parent.rightChild = leftChild;
        } else {
            node.parent.leftChild = leftChild;
        }
        leftChild.rightChild = node;
        node.parent = leftChild;
    }

    @Override
    public void insertRecursive(RedBlackNode<T> current, RedBlackNode<T> newNode) {
        super.insertRecursive(current, newNode);
        newNode.color = RED;
    }

    @Override
    public RedBlackNode<T> deleteNode(RedBlackNode<T> root, T data) {
        RedBlackNode<T> node = super.deleteNode(root, data);
        if (node != null) {
            fixDelete(node);
        }
        return node;
    }

    private void fixDelete(RedBlackNode<T> node) {
        while (node != root && (node.color == BLACK || (node.parent != null && node.parent.color == BLACK))) {
            if (node.parent != null) {
                if (node == node.parent.leftChild) {
                    RedBlackNode<T> sibling = node.parent.rightChild;
                    if (sibling != null) {
                        if (sibling.color == RED) {
                            sibling.color = BLACK;
                            node.parent.color = RED;
                            rotateLeft(node.parent);
                            sibling = node.parent.rightChild;
                        }
                        if ((sibling.leftChild == null || sibling.leftChild.color == BLACK) &&
                                (sibling.rightChild == null || sibling.rightChild.color == BLACK)) {
                            sibling.color = RED;
                            node = node.parent;
                        } else {
                            if (sibling.rightChild == null || sibling.rightChild.color == BLACK) {
                                if (sibling.leftChild != null) {
                                    sibling.leftChild.color = BLACK;
                                }
                                sibling.color = RED;
                                rotateRight(sibling);
                                sibling = node.parent.rightChild;
                            }
                            sibling.color = node.parent.color;
                            node.parent.color = BLACK;
                            if (sibling.rightChild != null) {
                                sibling.rightChild.color = BLACK;
                            }
                            rotateLeft(node.parent);
                            node = root;
                        }
                    } else {
                        break; // Adicionando uma verificação extra para evitar NPE
                    }
                } else {
                    // Código semelhante para o caso em que node é um filho à direita
                }
            } else {
                break; // Adicionando uma verificação extra para evitar NPE
            }
        }
        if (node != null) {
            node.color = BLACK;
        }
    }
}