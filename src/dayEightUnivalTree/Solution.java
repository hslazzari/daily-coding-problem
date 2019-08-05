package dayEightUnivalTree;

public class Solution {
	static class Tree {
		public int value;
		public Tree left;
		public Tree right;
		
		public Tree() {
			
		}
		
		public Tree(int value) {
			this.value = value;
		}
	}
	
	static class Unival {
		public int count;
		public boolean isUnival;
		
		public Unival(int count, boolean isUnival) {
			this.count = count;
			this.isUnival = isUnival;
		}
		
		public Unival() {
			
		}
	}
	
	public static void main(String[] args) {
		Tree r = new Tree(0);
		Tree r1 = new Tree(1);
		Tree r2 = new Tree(0);
		Tree r2_1 = new Tree(1);
		Tree r2_2 = new Tree(0);
		Tree r2_1_1 = new Tree(1);
		Tree r2_1_2 = new Tree(1);
		
		r.left = r1;
		r.right = r2;
		r2.left = r2_1;
		r2.right = r2_2;
		r2_1.left = r2_1_1;
		r2_1.right = r2_1_2;
		
		Unival l = totUnival(r);
		System.out.println(l.count);
		
	}
	
	public static Unival totUnival(Tree t) {
		if(t == null) {
			return new Unival(0, false); 
		}
		
		if(t.left == null && t.right == null) {
			return new Unival(1, true);
		}
		
		Unival univalLeft = totUnival(t.left);
		Unival univalRight = totUnival(t.right);
		
		Unival treeUnival = new Unival();
		
		treeUnival.count    = univalLeft.count + univalRight.count;
		treeUnival.isUnival = univalLeft.isUnival && univalRight.isUnival;
		
		if(treeUnival.isUnival && t.left.value == t.right.value && t.left.value == t.value) {
			treeUnival.count++;
		} else {
			treeUnival.isUnival = false;
		}
		
		return treeUnival;
		
	}

}
