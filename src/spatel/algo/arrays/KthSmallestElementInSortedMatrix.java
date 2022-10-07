package spatel.algo.arrays;

import java.util.PriorityQueue;

public class KthSmallestElementInSortedMatrix {

	public static void main(String[] args) {
		int matrix[][] = { { 1, 5, 9 }, { 10, 11, 13 }, { 12, 13, 15 }}, k = 8;
		KthSmallestElementInSortedMatrix obj = new KthSmallestElementInSortedMatrix();
		System.out.println(obj.KthSmallestElement(matrix, k));
	}

	private int KthSmallestElement(int[][] matrix, int k) {
		PriorityQueue<Element> pq = new PriorityQueue<>();
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				pq.add(new Element(matrix[i][j]));
			}
		}

		for (int i = 0; i < k; i++) {
			Element temp = pq.poll();
			if (i == k - 1) {
				return temp.key;
			}
		}
		return -1;

	}

}

class Element implements Comparable<Element> {
	Integer key;
	
	public Element(int key) {
		this.key = key;
	}

	@Override
	public int compareTo(Element o) {
		return this.key.compareTo(o.key);
	}
}