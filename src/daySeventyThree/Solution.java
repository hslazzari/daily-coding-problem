package daySeventyThree;

public class Solution {
	/*
	 * reverse linkedlist 1 -> 2 -> 3 -> 4
	 * 
	 * */
    public static class Node {
        public int value;
        public Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    //Without loop
    public static Node reverseLinkedList(Node head) {
        if(head == null) {
            return head;
        }

        Node next = head.next;
        head.next = null;

        
        while(next != null) {
            Node aux = next.next;
            next.next = head;
            head = next;
            next = aux;
        }

        return head;

    }
    
    public static void print(Node n) {
    	while(n != null) {
    		System.out.print(n.value + " ");
    		n = n.next;    		
    	}
    	System.out.println("");
    }
    
    public static void main(String[] args) {
        Node a = new Node(1);
        Node b = new Node(2);
        Node c = new Node(3);
        Node d = new Node(4);
        a.next = b;
        b.next = c;
        c.next = d;
        print(a);
        Node h = reverseLinkedList(a);
        print(h);
        
    }

}