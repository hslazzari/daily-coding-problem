

package dayFiftySumTree;

/*   *
   / \
  +    +
 / \  / \
3  2  4  5
*/

public class Solution {
    public static class ArithmeticTree {
        String value;
        ArithmeticTree left;
        ArithmeticTree right;

        public ArithmeticTree(String value) {
            this.value = value;
        }
    }

    public static Integer eval(ArithmeticTree root) {
    	
        if(root.left == null && root.right == null) {
            return Integer.valueOf(root.value);
        }

        Integer left = eval(root.left);
        Integer right = eval(root.right);

        switch(root.value) {
            case "+":
                return left + right;
            case "-":
                return left - right;
            case "*":
                return left * right;
            default:
                return left / right;
        }
    }
    
    public static void main(String[] args) {
    	ArithmeticTree r = new ArithmeticTree("*");
        ArithmeticTree r1 = new ArithmeticTree("+");
        ArithmeticTree r2 = new ArithmeticTree("+");
        ArithmeticTree r1_1 = new ArithmeticTree("3");
        ArithmeticTree r1_2 = new ArithmeticTree("2");
        ArithmeticTree r2_1 = new ArithmeticTree("4");
        ArithmeticTree r2_2 = new ArithmeticTree("5");
        
        r1.left = r1_1;
        r1.right = r1_2;
        r2.left = r2_1;
        r2.right = r2_2;
        r.left = r1;
        r.right = r2;

        System.out.println(eval(r));

    }

}
