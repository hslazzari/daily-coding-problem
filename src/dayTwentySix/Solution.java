package dayTwentySix;

public class Solution {
	public static class Node {
		public int value;
		public Node next;
		
		public Node(int value) {
			this.value = value;
		}
	}
	
	public static Node lastElement(Node head, int k) {
		int i = 0;
		Node kElement = head;
		while(i < k) {
			kElement = kElement.next;
			i++;
		}
		
		while(kElement != null) {
			kElement = kElement.next;
			head = head.next;
		}
		 
		return head;
	}
	
	public static void main(String[] args) {
		Node a1 = new Node(1);
		Node a2 = new Node(2);
		a1.next = a2;
		Node a3 = new Node(3);
		a2.next = a3;
		Node a4 = new Node(4);
		a3.next = a4;
		Node a5 = new Node(5);
		a4.next = a5;
		
		System.out.println(lastElement(a1, 3).value);
	}
}
