package dayThreeSerializeDeserialize;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Solution {
	
	static class Node {
		public String value;
		public Node left;
		public Node right;
		
		public Node(String value) {
			this.value = value;
		}
		
		public Node(String value, Node left, Node right) {
			this.value = value;
		}	
		
	}
	
	public static void main(String[] args) {
		Node r = new Node("root");
		Node l1 = new Node("left");
		Node r1 = new Node("right");
		Node l1_1 = new Node("left.left");
		
		r.left = l1;
		r.right = r1;
		l1.left = l1_1;
		
		String str = serialize(r);
		
		System.out.println(str);
		Node n = deserialize(str);
		String str2 = serialize(n);
		System.out.println(str2);
	}
	
	public static String serialize(Node n) {
		Queue<Node> queue = new LinkedList<Node>();
		
		queue.add(n);
		
		String serializeTree = n.value;
		
		while(!queue.isEmpty()) {
			Node f = queue.remove();
			serializeTree+=",";
			if(f.left != null) {
				queue.offer(f.left);
				serializeTree+=f.left.value;
			}
			serializeTree+=",";
			if(f.right != null) {
				queue.offer(f.right);
				serializeTree+=f.right.value;
			}
			
		}
		
		return serializeTree;
	}
	
	public static Node deserialize(String s) {
		String[] node_array = s.split(",", -1);
		Deque<Node> stack = new LinkedList<Node>();
		Node n = new Node(node_array[0]);
		stack.offer(n);
		for(int i = 1; i < node_array.length; i+=2) {
			Node father = stack.remove();
			if(!node_array[i].equals("")) {
				Node left = new Node(node_array[i]);
				stack.offer(left);
				father.left = left;
			}
			
			if(!node_array[i+1].equals("")) {
				Node right = new Node(node_array[i+1]);
				stack.offer(right);
				father.right = right;
			}
			
		}
		
		return n;
	}
	
}
