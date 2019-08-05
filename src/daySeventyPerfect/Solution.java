package daySeventyPerfect;

public class Solution {
	public static void main(String[] args) {
		System.out.println(nPerfect(2));
	}
	
	public static int nPerfect(int n) {
		int i = 0;
		while(n > 0) {
			if(isPerfect(i)) {
				n--;
			}
			i++;
		}
		
		return i-1;
	}
	
	public static boolean isPerfect(int n) {
		int tot = 0;
		while(n > 0) {
			
			tot+=n%10;
			n = n / 10;
			
		}
		
		if(tot == 10) {
			return true;
		}
		return false;
	}
	

}
