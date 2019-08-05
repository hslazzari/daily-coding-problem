package dayFourtyEightInOrderPreOrder;

public class Solution {
	static int preIndex;
	public static class Tree {
		char value;
		Tree left;
		Tree rigth;
		
		public Tree(char value) {
			this.value = value;
		}
	}
	
	public static Tree createTree(char[] preorder, char[] inorder, int start, int end) {
		
		if(start > end) {
			return null;
		}
		
		
		int middle = -1;
		int idx = start;
		while(idx <= end && middle == -1) {
			if(inorder[idx] == preorder[preIndex]) {
				middle = idx;
			}
			idx++;
		}
		
		if(middle == -1) {
			return null;
		}
		
		Tree root = new Tree(preorder[preIndex++]);
		
		if(start == end) {
			return root;
		}

		root.left = createTree(preorder, inorder, start, middle - 1);
		root.rigth = createTree(preorder, inorder, middle+1, end);
		return root;
	}
	
	public static void printInOrder(Tree t) {
		if(t == null) {
			return;
		}
		printInOrder(t.left);
		System.out.format("%c ", t.value);
		printInOrder(t.rigth);
	}
	
	public static void printPreOrder(Tree t) {
		if(t == null) {
			return;
		}
		System.out.format("%c ", t.value);
		printInOrder(t.left);
		printInOrder(t.rigth);
	}
	
	public static void main(String[] args) {
		char[] preorder = {'a', 'b', 'd', 'e', 'c', 'f', 'g'};
		char[] inorder = {'d', 'b', 'e', 'a', 'f', 'c', 'g'};
		Tree t = createTree(preorder, inorder, 0, preorder.length-1);
		printInOrder(t);
		System.out.println("");
		printPreOrder(t);
		
	}
}
