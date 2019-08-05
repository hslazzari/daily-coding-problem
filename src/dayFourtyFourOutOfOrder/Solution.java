package dayFourtyFourOutOfOrder;

public class Solution {
	public static void main(String[] args) {
		int arr[] = { 1, 20, 6, 4, 5 };
		System.out.println(mergeSort(arr, 0, arr.length-1));
		for(int i : arr) {
			System.out.format("%d ", i);
		}
	}
	
	public static int mergeSort(int[] numbers, int start, int end) {
		int inversion = 0;
		
		if(start < end) {
			int middle = (end + start) / 2;
			
			inversion = mergeSort(numbers, start, middle);
			inversion+= mergeSort(numbers, middle+1, end);
			inversion+= merge(numbers, start, middle, end);
			
		}
		
		return inversion;
	}
	
	public static int merge(int[] numbers, int start, int middle, int end) {
		int inversions = 0;
		int[] temp = new int[end-start+2];
		int i, j, k;
		i = start;
		j = middle+1;
		k = 0;
		while(i <= middle && j <= end) {
			if(numbers[i] <= numbers[j]) {
				temp[k] = numbers[i];
				k++;
				i++;
			} else {
				temp[k] = numbers[j];
				k++;
				j++;
				inversions+=(middle-i+1);
			}
		}
		
		while(i <= middle) {
			temp[k] = numbers[i];
			k++;
			i++;
		}
		
		while(j <= end) {
			temp[k] = numbers[j];
			k++;
			j++;
		}
		
		for(i = 0; i < k; i++) {
			numbers[start++] = temp[i];
		}
		
		return inversions;
	}
}
