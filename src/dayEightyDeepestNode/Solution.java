package dayEightyDeepestNode;

public class Solution {
    public static class Node {
        char value;
        Node left;
        Node rigth;

        public Node(char value) {
            this.value = value;
        }
    }

    public static class Deepest {
        char node;
        int height;
    }


    public static void main(String[] args) {
        Node a = new Node('a');
        Node b = new Node('b');
        Node c = new Node('c');
        Node d = new Node('d');
        Node e = new Node('e');
        
        a.left = b;
        a.rigth = c;
        b.left = d;
        d.left = e;

        Deepest d1 = new Deepest();
        deepestNode(a, d1, 1);
        System.out.println(d1.node);
    }

    public static void deepestNode(Node t, Deepest d, int height) {
        if(t == null) {
            return;
        }

        if(t.left == null && t.rigth == null) {
            if(d.height < height) {
                d.height = height;
                d.node = t.value;
                return;
            }
        }
        deepestNode(t.left, d, height+1);
        deepestNode(t.rigth, d, height+1);
    }
}    