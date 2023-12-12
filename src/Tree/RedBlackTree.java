package src.Tree;

public class RedBlackTree<T extends  Comparable<T>> extends AbstractTree<T, RedBlackNode<T>>  {
    private RedBlackNode root;
    private RedBlackNode TNULL;
    long size;
    public RedBlackTree() {
        TNULL = new RedBlackNode();
        TNULL.color = 0;
        TNULL.left = null;
        TNULL.right = null;
        root = TNULL;
    }
    private void preOrderHelper(RedBlackNode node){
        if(node != TNULL){
            System.out.println(node.data + "");
            preOrderHelper(node.left);
            preOrderHelper(node.right);
        }
    }

    private void inOrderHelper(RedBlackNode node){
        if(node != TNULL){
            inOrderHelper(node.left);
            System.out.println(node.data + "");
            inOrderHelper(node.right);
        }
    }

    private void postOrderHelper(RedBlackNode node){
        if(node != TNULL){
            postOrderHelper(node.left);
            postOrderHelper(node.right);
            System.out.println(node.data + "");
        }
    }

    private RedBlackNode searchTreeHelper(RedBlackNode<T> node, T key){
        if(node == TNULL || key.equals(node.data)){
            return  node;
        }
        if(key.compareTo(node.data) <  0){
            return  searchTreeHelper(node.left, key);
        }
        return searchTreeHelper(node.right, key);
    }

    private void fixDelete(RedBlackNode node){
        RedBlackNode auxiliar;
        while (node != root && node.color == 0){
            if(node == node.parent.left){
                auxiliar = node.parent.right;
                if(auxiliar.color == 1){
                    auxiliar.color = 0;
                    node.parent.color = 1;
                    leftRotate(node.parent);
                    auxiliar = node.parent.right;
                }
                if(auxiliar.left.color == 0 && auxiliar.right.color == 0){
                    auxiliar.color = 1;
                    node = node.parent;
                }else{
                    if(auxiliar.right.color == 0){
                        auxiliar.left.color = 0;
                        auxiliar.color = 1;
                        rightRotate(auxiliar);
                        auxiliar = node.parent.right;
                    }
                    auxiliar.color = node.parent.color;
                    node.parent.color = 0;
                    auxiliar.right.color = 0;
                    leftRotate(node.parent);
                    node = root;
                }
            }else{
                auxiliar = node.parent.left;
                if(auxiliar.color == 1){
                    auxiliar.color = 0;
                    node.parent.color = 1;
                    rightRotate(node.parent);
                    auxiliar = node.parent.left;
                }
                if(auxiliar.right.color == 0){
                    auxiliar.color = 1;
                    node = node.parent;
                }else{
                    if (auxiliar.left.color == 0){
                        auxiliar.right.color = 0;
                        auxiliar.color = 1;
                        leftRotate(auxiliar);
                        auxiliar = node.parent.left;
                    }
                    auxiliar.color = node.parent.color;
                    node.parent.color = 0;
                    auxiliar.left.color = 0;
                    rightRotate(node.parent);
                    node = root;
                }
            }
        }
        node.color = 0;
    }
    private void rbTransplant(RedBlackNode u, RedBlackNode v) {
        if (u.parent == null) {
            root = v;
        } else if (u == u.parent.left) {
            u.parent.left = v;
        } else {
            u.parent.right = v;
        }
        v.parent = u.parent;
    }

    private void deleteNodeHelper(RedBlackNode<T> node, T key) {
        RedBlackNode z = TNULL;
        RedBlackNode x, y;
        while (node != TNULL) {
            if (node.data.equals(key)) {
                z = node;
            }

            if (node.data.compareTo(key) <= 0) {
                node = node.right;
            } else {
                node = node.left;
            }
        }

        if (z == TNULL) {
            return;
        }

        y = z;
        long yOriginalColor = y.color;
        if (z.left == TNULL) {
            x = z.right;
            rbTransplant(z, z.right);
        } else if (z.right == TNULL) {
            x = z.left;
            rbTransplant(z, z.left);
        } else {
            y = minimum(z.right);
            yOriginalColor = y.color;
            x = y.right;
            if (y.parent == z) {
                x.parent = y;
            } else {
                rbTransplant(y, y.right);
                y.right = z.right;
                y.right.parent = y;
            }

            rbTransplant(z, y);
            y.left = z.left;
            y.left.parent = y;
            y.color = z.color;
        }
        if (yOriginalColor == 0) {
            fixDelete(x);
        }
    }

    // Balance the node after insertion
    private void fixInsert(RedBlackNode k) {
        RedBlackNode u;
        while (k.parent.color == 1) {
            if (k.parent == k.parent.parent.right) {
                u = k.parent.parent.left;
                if (u.color == 1) {
                    u.color = 0;
                    k.parent.color = 0;
                    k.parent.parent.color = 1;
                    k = k.parent.parent;
                } else {
                    if (k == k.parent.left) {
                        k = k.parent;
                        rightRotate(k);
                    }
                    k.parent.color = 0;
                    k.parent.parent.color = 1;
                    leftRotate(k.parent.parent);
                }
            } else {
                u = k.parent.parent.right;

                if (u.color == 1) {
                    u.color = 0;
                    k.parent.color = 0;
                    k.parent.parent.color = 1;
                    k = k.parent.parent;
                } else {
                    if (k == k.parent.right) {
                        k = k.parent;
                        leftRotate(k);
                    }
                    k.parent.color = 0;
                    k.parent.parent.color = 1;
                    rightRotate(k.parent.parent);
                }
            }
            if (k == root) {
                break;
            }
        }
        root.color = 0;
    }
    private void leftRotate(RedBlackNode node){
        RedBlackNode node2 = node.right;
        if(node.left != TNULL){
            node2.left.parent = node;
        }
        node2.parent = node.parent;
        if(node.parent == null){
            this.root = node2;
        } else if (node == node.parent.left) {
            node.parent.left = node2;
        }else {
            node.parent.right = node2;
        }
        node2.left = node;
        node.parent = node2;
    }
    private void rightRotate(RedBlackNode node){
        RedBlackNode node2 = node.left;
        node.left = node2.right;
        if(node2.right != TNULL){
            node2.right.parent = node;
        }
        node2.parent = node.parent;
        if(node.parent == null){
            this.root = node2;
        } else if (node == node.parent.right) {
            node.parent.right = node2;
        }else{
            node.parent.left = node2;
        }
        node2.right = node;
        node.parent = node2;
    }

    private void prlongHelper(RedBlackNode root, String indent, boolean last) {
        if (root != TNULL) {
            System.out.print(indent);
            if (last) {
                System.out.print("R----");
                indent += "   ";
            } else {
                System.out.print("L----");
                indent += "|  ";
            }

            String sColor = root.color == 1 ? "RED" : "BLACK";
            System.out.println(root.data + "(" + sColor + ")");
            prlongHelper(root.left, indent, false);
            prlongHelper(root.right, indent, true);
        }
    }


    public void preorder() {
        preOrderHelper(this.root);
    }

    public void inorder() {
        inOrderHelper(this.root);
    }

    public void postorder() {
        postOrderHelper(this.root);
    }

    public RedBlackNode searchTree(T k) {
        return searchTreeHelper(this.root, k);
    }

    public RedBlackNode minimum(RedBlackNode node) {
        while (node.left != TNULL) {
            node = node.left;
        }
        return node;
    }

    public RedBlackNode maximum(RedBlackNode node) {
        while (node.right != TNULL) {
            node = node.right;
        }
        return node;
    }

    public RedBlackNode successor(RedBlackNode x) {
        if (x.right != TNULL) {
            return minimum(x.right);
        }

        RedBlackNode y = x.parent;
        while (y != TNULL && x == y.right) {
            x = y;
            y = y.parent;
        }
        return y;
    }

    public RedBlackNode predecessor(RedBlackNode x) {
        if (x.left != TNULL) {
            return maximum(x.left);
        }

        RedBlackNode y = x.parent;
        while (y != TNULL && x == y.left) {
            x = y;
            y = y.parent;
        }

        return y;
    }

    public void insertRdb(long key) {
        RedBlackNode node = new RedBlackNode();
        node.parent = null;
        node.data = key;
        node.left = TNULL;
        node.right = TNULL;
        node.color = 1;

        RedBlackNode y = null;
        RedBlackNode x = this.root;

        while (x != TNULL) {
            y = x;
            if (node.data.compareTo(x.data) < 0) {
                x = x.left;
            } else {
                x = x.right;
            }
        }

        node.parent = y;
        if (y == null) {
            root = node;
        } else if (node.data.compareTo(y.data) < 0) {
            y.left = node;
        } else {
            y.right = node;
        }

        if (node.parent == null) {
            node.color = 0;
            return;
        }

        if (node.parent.parent == null) {
            return;
        }

        fixInsert(node);
        size++;
    }
    public RedBlackNode getRoot() {
        return this.root;
    }
    public void deleteNode(T data) {
        deleteNodeHelper(this.root, data); size--;
    }
        public void prlongTree() {
        prlongHelper(this.root, "", true);
    }

    @Override
    public void insert(T data) {
        deleteNode(data);

    }

    @Override
    public void deleteElement(T data) {
        deleteNode(data);
    }
}