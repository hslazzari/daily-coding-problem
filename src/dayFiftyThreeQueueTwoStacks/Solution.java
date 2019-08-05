package dayFiftyThreeQueueTwoStacks;
import java.util.Stack;

public class Solution {
    private static class CustomQueue {
        private Stack<Integer> enqueueStack;
        private Stack<Integer> dequeueStack;
        public CustomQueue() {
            enqueueStack = new Stack<Integer>();
            dequeueStack = new Stack<Integer>();
        }

        public void enqueue(Integer v) {
            enqueueStack.push(v);
        }

        public int dequeue() {
            if(enqueueStack.isEmpty() && dequeueStack.isEmpty()) {
                return -1;
            }

            if(!dequeueStack.isEmpty()) {
                return dequeueStack.pop();
            }

            while(!enqueueStack.isEmpty()) {
                dequeueStack.push(enqueueStack.pop());
            }

            return dequeueStack.pop();
        }
    }


    public static void main(String[] args) {
        CustomQueue cq = new CustomQueue();
        cq.enqueue(1);
        cq.enqueue(2);
        System.out.println(cq.dequeue());
        cq.enqueue(3);
        System.out.println(cq.dequeue());
        System.out.println(cq.dequeue());
    }


}
