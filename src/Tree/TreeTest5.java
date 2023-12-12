package src.Tree;

public class TreeTest5 {
    public static void main(String[] args) {
        AVLTree<String> todo = new AVLTree<>();
        todo.insert("UIIIII");
        todo.insert("QUE ISSO MEU FILHO CALME");
        todo.insert("TOMIIIII");
        todo.insert("RAPAZZZZ");

        System.out.println(todo.searchElement("RAPAZZZZZZZ"));

    }
}
