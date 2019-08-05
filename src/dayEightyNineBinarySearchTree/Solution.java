package dayEightyNineBinarySearchTree;


public class Solution {
    public static class Tree {
        int value;
        Tree left;
        Tree rigth;
        
        public Tree(int value) {
        	this.value = value;
        }
    }


    public static void main(String[] args) {
        Tree a = new Tree(4);
        Tree a_left = new Tree(2);
        Tree a_rigth = new Tree(5);
        Tree a_left_left = new Tree(1);
        Tree a_left_rigth = new Tree(3);
        a.left = a_left;
        a.rigth = a_rigth;

        
        a_left.left = a_left_left;
        a_left.rigth = a_left_rigth;

        System.out.format("isBST? %b", isBST(a, 0, 9999));
    }

    public static boolean isBST(Tree root, int min, int max) {
        
        if(root == null) {
            return true;
        }

        if(root.value >= min && root.value <= max) {
            return  isBST(root.left, min, root.value)
                 && isBST(root.rigth, root.value, max);
        } else {
            return false;
        }
    }

}


