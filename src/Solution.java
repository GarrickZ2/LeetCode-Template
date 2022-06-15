import java.util.Arrays;

class Solution {
	class Unigraph {
		int[] points;
		int[] ranks;
		int clusters;
		public Unigraph(int n) {
			points = new int[n];
			for (int i = 0; i < n; i++) {
				points[i] = i;
			}
			ranks = new int[n];
			Arrays.fill(ranks, 1);
			clusters = n;
		}

		public int getRoot(int x) {
			int root = points[x];
			if (root != x) {
				x = root;
				root = points[x];
			}
			return root;
		}

		public void unify(int x, int y) {
			int xRoot = getRoot(x);
			int yRoot = getRoot(y);
			if (xRoot == yRoot) return;
			clusters--;
			if (ranks[xRoot] >= ranks[yRoot]) {
				ranks[xRoot] += ranks[yRoot];
				points[yRoot] = xRoot;
			} else {
				ranks[yRoot] += ranks[xRoot];
				points[xRoot] = yRoot;
			}
		}
	}

	public int makeConnected(int n, int[][] connections) {
		if (connections.length < n - 1) return -1;
		Unigraph graph = new Unigraph(n);
		for (int[] conn : connections) {
			graph.unify(conn[0], conn[1]);
		}
		return graph.clusters - 1;
	}
}