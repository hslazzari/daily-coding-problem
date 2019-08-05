package dayFourtyThreeStackMax;

public class Solution {
	static class MaxStack {
		int[] stack;
		int[] max;
		int count;
		
		public MaxStack(int size) {
			this.stack = new int[size];
			count = 0;
			this.max = new int[size];
		}
		
		public void push(int element) {
			this.stack[count] = element;
			
			if(count == 0) {
				this.max[count] = element;
			} else {
				this.max[count] = Math.max(this.max[count-1], this.stack[count]);
			}			
			count++;
		}
		
		public int max() {
			if(count == 0) {
				return -1;
			} else {
				return this.max[count-1];
			}
		}
		
		public int pop() {
			if(count == 0) {
				return -1;
			} else {
				return this.stack[count--];				
			}
		}
	}
	
	
	public static void main(String[] args) {
		MaxStack stack = new MaxStack(10);
		
		stack.push(3);
		stack.push(2);
		stack.push(1);
		
		
		System.out.println(stack.max());
		stack.push(10);
		System.out.println(stack.max());
		stack.pop();
		System.out.println(stack.max());
	}
}
