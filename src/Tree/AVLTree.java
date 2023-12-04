package src.Tree;

import src.algorithms.SortingAlgorithm;

import java.util.LinkedList;

public class AVLTree<T extends  Comparable<T>> extends AbstractTree<T, AVLNode<T>> implements SortingAlgorithm<T> {
    public AVLTree(){
        super.root = null;
    }
    int height(AVLNode<T> node){
        if(node == null){
            return  0;
        }
        return node.height;
    }
    int max(int a, int b){
        return a > b ? a : b;
    }
    AVLNode<T> rightRotate(AVLNode<T> node){
        AVLNode<T> auxiliar = node.leftChild;
        AVLNode<T> auxiliar2 = auxiliar.rightChild;
        auxiliar.rightChild = node;
        node.leftChild = auxiliar2;
        node.height = max(height(node.leftChild), height(node.rightChild)) + 1;
        auxiliar2.height = max(height(auxiliar.leftChild), height(auxiliar.rightChild)) +1;
        return auxiliar;
    }
    AVLNode<T> leftRotate(AVLNode<T> node){
        AVLNode<T> auxiliar = node.rightChild;
        AVLNode<T> auxiliar2 = auxiliar.leftChild;
        auxiliar.rightChild = node;
        node.leftChild = auxiliar2;
        node.height = max(height(node.leftChild), height(node.rightChild)) + 1;
        auxiliar2.height = max(height(auxiliar.leftChild), height(auxiliar.rightChild)) +1;
        return auxiliar;
    }
    int getBalanceFactor(AVLNode<T> node){
        if(node == null){
            return 0;
        }
        return height(node.leftChild) - height(node.rightChild);
    }
    private void balance(AVLNode<T> node,T data){
        node.height = 1 + max(height(node.leftChild), height(node.rightChild));
        int balanceFactor = getBalanceFactor(node);
        if (balanceFactor > 1) {
            if (data.compareTo(node.leftChild.data) > 0) {
                rightRotate(node);
            } else if (data.compareTo(node.leftChild.data) < 0) {
                node.leftChild = leftRotate(node.leftChild);
                rightRotate(node);
            }
        }
        if (balanceFactor < -1) {
            if (data.compareTo(node.rightChild.data) > 0) {
                leftRotate(node);
            } else if (data.compareTo(node.rightChild.data) <0) {
                node.rightChild = rightRotate(node.rightChild);
                leftRotate(node);
            }
        }
    }


    @Override
    public void insert(T data) {
        AVLNode<T> node = new AVLNode<>(data);
        if(root == null){
            root = node;
            return;
        }
        insertRecursive(root,node);
        balance(node, data);
    }

    @Override
    public void deleteElement(T data) {
        deleteNode(root, data);
        balance(root, data);
    }
    public void printTree(String ident, boolean last){
        super.printTree(root, ident, last);
    }

    @Override
    public LinkedList<T> sort(LinkedList<T> lista) {
        return new LinkedList<>(inOrderList(root));
    }
}
