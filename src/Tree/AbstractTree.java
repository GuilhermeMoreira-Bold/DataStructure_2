package src.Tree;

import java.util.LinkedList;
import java.util.Queue;

public abstract class AbstractTree<T extends Comparable<T>, N extends Node<T, N>>{
private LinkedList <T> result = new LinkedList<>();

  N root;
    public  N searchElement(T data){
      N current = root;
      while (current != null) {
        if (current.data.equals(data)) {
          return current;
        } else if (current.data.compareTo(data) > 0) {
          current = current.leftChild;
        }else{
          current = current.rightChild;
        }
      }
      return null;
  };
    public int findAllEqualElements(T element){
      return findEqualElementsHelper(this.root, element);
    }
  private int findEqualElementsHelper(N current, T element) {
    if (current == null) {
      return 0;
    }

    int count = 0;

    // Verifica o valor do nó atual
    if (current.data.equals(element)) {
      count++;
    }

    // Recursivamente chama a função para a subárvore esquerda e direita
    count += findEqualElementsHelper(current.leftChild, element);
    count += findEqualElementsHelper(current.rightChild, element);

    return count;
  }
  /**
   * Use insert to insert element's in the tree and add new logic
   *
   * @param data
   */
  public abstract void insert(T data);
  public abstract void deleteElement(T data);
  protected void insertRecursive(N current, N newNode){
    if (newNode.data.compareTo(current.data) < 0) {
      if (current.leftChild == null) {
        current.leftChild = newNode;
      } else {
        insertRecursive(current.leftChild, newNode);
      }
    } else if (newNode.data.compareTo(current.data) > 0) {
      if (current.rightChild == null) {
        current.rightChild = newNode;
      } else {
        insertRecursive(current.rightChild, newNode);
      }
    }else if(current.rightChild != null){
      insertRecursive(current.rightChild, newNode);
    }
  }
  protected N deleteNode(N root, T data){
    if (root == null) {
      System.out.println("Value not found");
      return null;
    }

    if (data.compareTo(root.data) < 0) {
      root.leftChild = deleteNode(root.leftChild, data);
    } else if (data.compareTo(root.data) > 0) {
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
  private T minValue(N node) {
    T minValue = node.data;
    while (node.leftChild != null) {
      minValue = node.leftChild.data;
      node = node.leftChild;
    }
    return minValue;
  }
  public void inOrder(){
    inOrder(root);
  }
  private void inOrder(N root){
    if (root == null) {
      return;
    }
    inOrder(root.leftChild);

    System.out.print(root.data + " ");
    result.add(root.data);

    inOrder(root.rightChild);
  };
  public LinkedList<T> inOrderList(N root){
    inOrder(root);
    return result;
  };
  public void postOrder(){
    postOrder(root);
  }
  private   void postOrder(N root){
    if (root == null) {
      return;
    }
    postOrder(root.rightChild);

    System.out.print(root.data + " ");

    postOrder(root.leftChild);
  };
  public  void preOrder(){
    preOrder(root);
  }
  private   void preOrder(N root){
    if (root == null) {
      return;
    }

    System.out.print(root.data + " ");
    preOrder(root.leftChild);
    preOrder(root.rightChild);
  };
  public void inLevel(){
    inLevel(root);
  }
  private  void inLevel(N root){
    if (root == null) {
      return;
    }

    Queue<N> queue = new LinkedList<>();
    queue.add(root);


    while (!queue.isEmpty()) {
      N current = queue.poll();
      System.out.print(current.data + " ");

      if (current.leftChild != null) {
        queue.add(current.leftChild);
      }

      if (current.rightChild != null) {
        queue.add(current.rightChild);
      }

    }
  };
  // Print the tree
  protected void printTree(N currPtr, String indent, boolean last) {
    if (currPtr != null) {
      System.out.print(indent);
      if (last) {
        System.out.print("R----");
        indent += "   ";
      } else {
        System.out.print("L----");
        indent += "|  ";
      }
      System.out.println(currPtr.data);
      printTree(currPtr.leftChild, indent, false);
      printTree(currPtr.rightChild, indent, true);
    }
  }

  @Override
  public String toString() {
    return "AbstractTree{" +
            "data=" + root +
            '}';
  }
}