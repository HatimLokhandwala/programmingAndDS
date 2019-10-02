package graph;

/**
 * Created by hatim.lokhandwala on 14/07/19.
 */
public class UnionFind {
	int find(int[] parent, int elem) {
		if(parent[elem] != -1) {
			return find(parent, parent[elem]);
		}
		return elem;
	}

	void union(int[] parent, int x, int y) {
		int xSet = find(parent, x);
		int ySet = find(parent, y);
		parent[xSet] = ySet;
	}


	public static void main(String[] args) {
		int[] arr = new int[10];

	}
}
