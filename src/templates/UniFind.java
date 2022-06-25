package templates;

import java.util.Arrays;

public class UniFind {
	int[] parent;
	int[] rank;
	int size;

	public UniFind(int n) {
		this.parent = new int[n];
		for (int i = 0; i < n; i++) {
			parent[i] = i;
		}
		this.rank = new int[n];
		Arrays.fill(rank, 1);
		this.size = n;
	}

	public int getRoot(int x) {
		int root = parent[x];
		while (root != x) {
			x = root;
			root = parent[x];
		}
		return root;
	}

	public boolean union(int x, int y) {
		int rootX = getRoot(x);
		int rootY = getRoot(y);
		if (rootX == rootY) return false;
		if (rank[rootX] >= rank[rootY]) {
			parent[rootY] = rootX;
			rank[rootX] += rank[rootY];
		} else {
			parent[rootX] = rootY;
			rank[rootY] += rank[rootX];
		}
		size --;
		return true;
	}

	public int getSize() {
		return size;
	}
}