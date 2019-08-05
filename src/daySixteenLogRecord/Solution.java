package daySixteenLogRecord;

public class Solution {
	
	public static class CustomLogs {
		int countIndex;
		int offset;
		int[] logLines;
		
		public CustomLogs(int size) {
			logLines = new int[size];
		}
		
		public void record(int orderId) {
			logLines[countIndex++] = orderId;
			if(countIndex == logLines.length) {
				countIndex = 0;
				offset++;
				if(offset > logLines.length) {
					offset = 0;
				}
			}
		}
		
		public int getLast(int i) {
			int index = (i - 1 + offset) % logLines.length;
			
			return logLines[index];
		}
		public void printLogs() {
			for(int i = 0; i < logLines.length; i++) {
				System.out.format("%d ", logLines[i]);
			}
			System.out.println("\nStartLine: " + offset);
		}
	}
	
	public static void main(String[] args) {
		CustomLogs logs = new CustomLogs(10);
		for(int i = 0; i < 30; i++) {
			logs.record(i);
			logs.printLogs();
		}
		System.out.println(logs.getLast(1));
		
	}
}
