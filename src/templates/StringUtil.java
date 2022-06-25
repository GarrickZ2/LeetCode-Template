package templates;

import java.util.*;

public class StringUtil {

	public boolean isPalindrome(String s) {
		int left = 0, right = s.length() - 1;
		while (left <= right) {
			if (s.charAt(left++) != s.charAt(right--)) return false;
		}
		return true;
	}

	public Map<Character, Integer> getCharacterCount(String s) {
		Map<Character, Integer> counter = new HashMap<>();
		for (char ch : s.toCharArray()) {
			counter.put(ch, counter.getOrDefault(ch, 0) + 1);
		}
		return counter;
	}

	public String stringAdd(String a, String b) {
		StringBuilder result = new StringBuilder();
		int carry = 0, ptr1 = a.length() - 1, ptr2 = b.length() - 1;
		while(ptr1 >= 0 || ptr2 >= 0 || carry > 0) {
			int left = 0;
			if (ptr1 >= 0) left = a.charAt(ptr1--) - '0';
			int right = 0;
			if (ptr2 >= 0) right = b.charAt(ptr2--) - '0';
			int sum = left + right + carry;
			carry = sum / 10;
			result.append(carry % 10);
		}
		return result.reverse().toString();
	}
}
