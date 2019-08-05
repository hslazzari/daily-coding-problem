package dayTwenty;

public class Solution {
	public static class Node {
		int value;
		Node next;
		
		public Node(int value) {
			this.value = value;
		}
		
		
	}
	
	public static int intersection(Node a, Node b) {
		Node aux = null;
		int length_a = 0;
		int length_b = 0;
		
		aux = a;
		while(aux != null) {
			aux = aux.next;
			length_a++;
		}
		
		aux = b;
		while(aux != null) {
			aux = aux.next;
			length_b++;
		}
		
		while(a != null && length_a > length_b) {
			a = a.next;
			length_a--;
		}
		
		while(b != null && length_b > length_a) {
			b = b.next;
			length_b--;
		}
		
		if(length_a != length_b) {
			return -1;
		}
		
		while(a != null || b != null) {
			if(a.value == b.value) {
				return a.value;
			}
			a = a.next;
			b = b.next;
		}
		
		return -1;
	}
	
	
	public static void main(String[] args) {
		Node a = new Node(3);
		Node b = new Node(7);
		Node c = new Node(9);
		Node d = new Node(11);
		Node e = new Node(12);
		
		a.next = b;
		b.next = c;
		c.next = d;
		d.next = e;
		
		Node a1 = new Node(99);
		Node b1 = new Node(1);
		Node c1 = new Node(8);
		Node d1 = new Node(10);
		
		a1.next = b1;
		b1.next = c1;
		c1.next = d1;
		
		System.out.println(intersection(a, a1));
	}
}
