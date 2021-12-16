package probset2;

import java.util.ArrayList;
import java.util.Scanner;
import java.lang.Math;

class Point {
	private int x;
	private int y;
	private boolean isClosestPair;
	
	public Point(int x, int y){
		this.x = x;
		this.y = y;
		this.isClosestPair = false;
	}
	
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}

	public boolean isClosestPair() {
		return isClosestPair;
	}

	public void setClosestPair(boolean isClosestPair) {
		this.isClosestPair = isClosestPair;
	}
}

public class NumberTwo {
	
	private double getDistance(Point pointA, Point pointB) {
		return (double) Math.sqrt(Math.pow(pointB.getX() - pointA.getX(), 2) + Math.pow(pointB.getY() - pointA.getY(), 2));
	}
	
	public double bruteForce(Point[] points, int initialIndex, int lastIndex) {
		double closestDistance = Double.POSITIVE_INFINITY;
		for(int i = initialIndex; i < lastIndex - 1; i++)
			for(int j = i + 1; j < lastIndex; j++) 
				closestDistance = Math.min(closestDistance, getDistance(points[i], points[j]));
		
		return closestDistance;
	}
	
	public double ClosestPair(Point[] points, int initialIndex, int lastIndex) {
		double dist1, dist2, smallestDist;
		int midIndex = lastIndex / 2;
		if(lastIndex - initialIndex < 3) {
			smallestDist = bruteForce(points, initialIndex, lastIndex);
		}
		else {
			dist1 = ClosestPair(points, initialIndex, midIndex);
			dist2 = ClosestPair(points, midIndex + 1, lastIndex);
			smallestDist = Math.min(dist1, dist2);
		}
		
		return smallestDist;
	}
	
	public static void main(String[] args) {
		Scanner scN = new Scanner(System.in);
		int N = scN.nextInt();
		
		Point[] points = new Point[N];
		
		Scanner scPoint = new Scanner(System.in);
		String scPointStr = new String();
		
		for(int i = 0; i < N; i++) {
			scPointStr = scPoint.nextLine();
			Scanner importToArrayList = new Scanner(scPointStr);
			int x = importToArrayList.nextInt();
			int y = importToArrayList.nextInt();
			points[i] = new Point(x, y);
		}
		
		NumberTwo n2 = new NumberTwo();
		double closestDistance = n2.ClosestPair(points, 0 , points.length);
		
		System.out.println(closestDistance);
	}

}
