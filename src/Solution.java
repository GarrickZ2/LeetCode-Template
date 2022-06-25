import java.util.Arrays;

class Solution {
	public int distinctSequences(int n) {
		int[][][] dp = new int[n][6][6];
		for (int i = 0; i < 6; i++) {
			dp[0][i][i] = 1;
		}
		for (int i = 1; i < n; i++) {
			for (int j = 0; j < 6; j++) {
				for (int k = 0; k < 6; k++) {
					if (j == k) continue;
					int gcdNum = gcd(j+1, k+1);
					if (gcdNum != 1) continue;
					for (int varJ = 0; varJ < 6; varJ++) {
						if (varJ == k) continue;
						dp[i][j][k] = (dp[i][j][k] + dp[i-1][varJ][j]) % 100000007;
					}
				}
			}
		}
		int result = 0;
		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 6; j++) {
				result = (result + dp[n-1][i][j]) % 100000007;
			}
		}
		return result;
	}

	public int gcd(int x, int y) {
		int c;
		while (y != 0) {
			c = x % y;
			x = y;
			y = c;
		}
		return x;
	}
}