package dayEightyThreeInvertTree;

public class Solution {
    private static class Tree {
        char value;
        Tree left;
        Tree right;

        public Tree(char value) {
            this.value = value;
        }

    }

    public static void invertTree(Tree t) {
        if(t == null)
            return;

        Tree aux = t.left;
        t.left = t.right;
        t.right = aux;
        invertTree(t.left);
        invertTree(t.right);
    }


    public static void main(String[] args) {
        Tree a = new Tree('a');
        Tree b = new Tree('b');
        Tree c = new Tree('c');
        Tree d = new Tree('d');
        Tree e = new Tree('e');
        Tree f = new Tree('f');
        a.left = b;
        a.right = c;
        b.left = d;
        b.right = e;
        c.left = f;
        invertTree(a);
        System.out.println(a.left.value);
        System.out.println(a.right.value);
        System.out.println(c.right.value);
        System.out.println(b.left.value);
        System.out.println(b.right.value);
    }


}