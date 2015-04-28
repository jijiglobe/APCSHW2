import java.util.*;
import java.io.*;

publicclass  TreeNode<E> {
    private TreeNode<E> left, right;
    private E data;

    public TreeNode() {
        left = null;
        right = null;
    }

    public TreeNode(E d) {
        this();
        data = d;
    }

    public add(E d) {
        this.add(new TreeNode<E>(d));
    }

    public add(TreeNode<E> node) {
        if (left == null) {
            left = node;
        } else if (right == null) {
            right = node;
        } else {
            if (random.nextInt(2) == 0) {
                left.add(node);
            } else {
                right.add(node);
            }
        }
    }

    public E getData(){
        return data;
    }

    public void setData(E d){
        data = d;
    }

    public TreeNode<E> getLeft() {
        return left;
    }

    public TreeNode<E> getRight() {
        return right;
    }
}
