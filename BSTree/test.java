package BSTree;

import tree.BinaryTree;

import java.util.Arrays;

public class test {
    public static void main(String[] args) {
        int[]  array = {10,8,19,2,39,12,33};
        BinarySearchTree binaryTree = new BinarySearchTree();
        for (int i = 0; i < array.length; i++) {
            binaryTree.insert(array[i]);
        }
        binaryTree.inOrder(binaryTree.root);
    }
}
