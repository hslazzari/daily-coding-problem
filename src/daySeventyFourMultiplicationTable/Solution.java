package daySeventyFourMultiplicationTable;

public class Solution {
    public static void main(String[] args) {
        System.out.println(multiplicationTable(6, 12));
    }

    public static int multiplicationTable(int n, int x) {
        int tot = 0;
        for(int i = 1; i <= n; i++) {
            if(x % i == 0 && x / i <= n) {
                tot++;
            }
        }
        return tot;
    }
}
