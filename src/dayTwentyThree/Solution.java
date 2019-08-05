package dayTwentyThree;

import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;
import java.util.Stack;

public class Solution {
	public static class Point {
		public int x;
		public int y;
		
		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
		
		@Override
	    public boolean equals(Object o) {

	        if (o == this) return true;
	        
	        if (!(o instanceof Point)) {
	            return false;
	        }
	        Point p = (Point) o;
	        
	        if(p.x == this.x && p.y == this.y) {
	        	return true;
	        }
	        
	        return false;
	        
	    }

	    @Override
	    public int hashCode() {
	        return Objects.hash(this.x, this.y);
	    }	
		
	}
	
	public static class DistancePoint {
		public Point p;
		public int distance;
		
		public DistancePoint(Point p, int distance) {
			this.p = p;
			this.distance = distance;
		}
	}
	
	public static boolean isValid(int x, int y, int rowLength, int columnLength) {
		if(x < 0 || y < 0) {
			return false;
		}
		
		if(x >= rowLength || y >= columnLength) {
			return false;
		}		
		
		return true;
	}
	
	
	public static int minSteps(boolean[][] board, Point start, Point end) {
		boolean visited[][] = new boolean[board.length][board[0].length];
		
		Queue<DistancePoint> points = new LinkedList<DistancePoint>();
		
		DistancePoint dp = new DistancePoint(start, 0);
		points.add(dp);
		visited[start.x][start.y] = true;
		
		int walkedRowNum[] = {-1, 0, 0, 1};
		int walkedColNum[] = {0, -1, 1, 0};
		
		
		while(!points.isEmpty()) {
			DistancePoint curr = points.remove();
			if(curr.p.equals(end)) {
				return curr.distance;
			}
			
			for(int i = 0; i < 4; i++) {
				int newX = curr.p.x + walkedRowNum[i];
				int newY = curr.p.y + walkedColNum[i];
				if(isValid(newX, newY, board.length, board[0].length) && !board[newX][newY] == true && !visited[newX][newY]) {
					points.add(new DistancePoint(new Point(newX, newY), curr.distance+1));
					visited[newX][newY]=true;
				}
			}
		}
		
		return -1;
	}
	
	public static void main(String[] args) {
		boolean board[][] = {{false, false, false, false},
						     {true, true, false, true},
						     {false, false, false, false},
						     {false, false, false, false}};
		
		Point start = new Point(3, 0);
		Point end = new Point(0,0);
		
		System.out.println(minSteps(board, start, end));
	}
}
