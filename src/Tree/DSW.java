package src.Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class DSW {
    BinarySearchTree currentTree;

    public BinarySearchTree getBalancedTree() {
        return currentTree;
    }

    DSW(BinarySearchTree currentTree) {
        this.currentTree = currentTree;
        LinkedList<Integer> newList = transformTreeInList(currentTree.getRoot());
        currentTree.deleteAllElements();
        reconstruct(rotation(newList));
    }

    public void reconstruct(LinkedList<Integer> treeList) {
        if (treeList == null || treeList.isEmpty()) {
            return;
        }

        for (int node : treeList) {
            currentTree.insert(node);
        }
    }

    public LinkedList<Integer> rotation(LinkedList<Integer> listTree) {
        LinkedList<Integer> rotationList = new LinkedList<>();
        for (int i = 0; i < listTree.size(); i += 2) {
            if (i + 1 < listTree.size()) {
                int node1 = listTree.get(i);
                int node2 = listTree.get(i + 1);
                rotationList.add(node2);
                rotationList.add(node1);
            }
        }
        return rotationList;
    }

    public LinkedList<Integer> transformTreeInList(NodeTree root) {
        LinkedList<Integer> listTree = new LinkedList<>();
        if (root == null) {
            return listTree;
        }
        listTree.addAll(transformTreeInList(root.leftChild));
        listTree.add(root.data);
        listTree.addAll(transformTreeInList(root.rightChild));
        return listTree;
    }
}
