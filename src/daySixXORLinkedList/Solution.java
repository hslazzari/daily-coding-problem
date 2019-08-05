package daySixXORLinkedList;

import java.util.HashMap;
import java.util.Random;

public class Solution {

	static HashMap<Node, Integer> nodePointer = new HashMap<Solution.Node, Integer>();
	static HashMap<Integer, Node> pointerNode = new HashMap<Integer, Solution.Node>();
	
	static class Node {
		public int value;
		public int xor;
		
		public Node(int value) {
			this.value = value;
			createPointer(this);
		}
		
		
		
		public Node addElement(Node list, Node element) {
			if(list == null) {
				return element;
			}
			
			int  prevPointer = 0;
			Node currNode = list;
			int nextNodePointer = currNode.xor ^ prevPointer;

			while(nextNodePointer != 0) {
				prevPointer = getPointer(currNode);
				currNode = getElement(nextNodePointer);
				nextNodePointer = currNode.xor ^ prevPointer;
			}
			
			currNode.xor = prevPointer ^ getPointer(element);
			element.xor = getPointer(currNode) ^ 0;
			
			return list;
		}
		
		public void printList(Node list) {
			if(list == null) {
				return;
			}
			
			int  prevPointer = 0;
			Node currNode = list;
			int nextNodePointer = currNode.xor ^ prevPointer;
			while(nextNodePointer != 0) {
				System.out.format("%d, ", currNode.value);
				prevPointer = getPointer(currNode);
				currNode = getElement(nextNodePointer);
				nextNodePointer = currNode.xor ^ prevPointer;
			}
			System.out.format("%d\n", currNode.value);
			
			return;
		}
	}
	
	
	public static void main(String[] args) {
		Node n = new Node(5);
		Node n1 = new Node(3);
		Node n2 = new Node(4);
		Node n3 = new Node(5);
		
		n = n.addElement(null, n);
		n.addElement(n, n1);
		n.addElement(n, n2);
		n.addElement(n, n3);
		n.printList(n);
		
		
	}
	
	public static void createPointer(Node n) {
		Random r = new Random();
		Integer pointer;
		do {
			pointer = r.nextInt(9999999) + 1;
		} while(pointerNode.containsKey(pointer));
		
		pointerNode.put(pointer, n);
		nodePointer.put(n, pointer);		
	}
	
	public static Integer getPointer(Node n) {
		if(n == null) {
			return 0;
		}
		
		return nodePointer.get(n);
	}
	
	public static Node getElement(Integer pointer) {
		
		if(pointer == 0) {
			return null;
		}
		
		return pointerNode.get(pointer);
	}
	
}
