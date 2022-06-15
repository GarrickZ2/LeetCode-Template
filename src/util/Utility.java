package util;
import java.util.*;


public class Utility {
	public int[][] stringTo2dList(String input) {
		List<int[]> res = stringTo2dIntArray(input);
		return res.toArray(new int[0][0]);
	}

	public List<int[]> stringTo2dIntArray(String input) {
		List<int[]> result = new ArrayList<>();
		if(input == null || input.length() == 0) return result;
		if (input.charAt(0) != '[') return result;
		StringBuilder ss = null;
		for (int i = 1; i < input.length(); i++) {
			char ch = input.charAt(i);
			if (ch == ']' && ss == null) break;
			else if (ch == '[') {
				ss = new StringBuilder();
			} else if (ch == ']') {
				String[] contents = ss.toString().split(",");
				int[] res = new int[contents.length];
				for (int k = 0; k < contents.length; k++) {
					res[k] = Integer.parseInt(contents[k]);
				}
				result.add(res);
				ss = null;
			} else if (ss != null) {
				ss.append(ch);
			}
		}
		return result;
	}

	public static void main(String[] args) {
		Utility u = new Utility();
		int[][] res = u.stringTo2dList("[[1,1],[2,2],[2,0],[2,4],[3,3],[4,2]]");
		for (int[] each : res) {
			System.out.println(Arrays.toString(each));
		}
	}
}
