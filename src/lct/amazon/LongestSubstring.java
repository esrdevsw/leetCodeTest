package lct.amazon;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

//Longest Substring Without Repeating Characters

//Given a string s, find the length of the longest substring without repeating characters.
//
//Input: s = "abcabcbb"
//Output: 3
//Explanation: The answer is "abc", with the length of 3.
//
//Input: s = "bbbbb"
//Output: 1
//Explanation: The answer is "b", with the length of 1.
//
//Input: s = "pwwkew"
//Output: 3
//Explanation: The answer is "wke", with the length of 3.
//Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.

public class LongestSubstring {

	public int lengthOfLongestSubstringBrutalForce(String s) {
		int n = s.length();

		int stringLength = 0;

		for (int i = 0; i < n; i++) {
			for (int j = i; j < n; j++) {
				if (checkRepetition(s, i, j)) {
					stringLength = Math.max(stringLength, j - i + 1);
				}
			}
		}
		return stringLength;
	}

	private boolean checkRepetition(String s, int start, int end) {
//		A HashSet is a collection of items where every item is unique, 
//		and it is found in the java.util package
		Set<Character> chars = new HashSet<>();

		for (int i = start; i <= end; i++) {
			char c = s.charAt(i);
			if (chars.contains(c)) {
				return false;
			}
			chars.add(c);
		}
		return true;
	}

	public int lengthOfLongestSlidingWindow(String s) {
		Map<Character, Integer> chars = new HashMap<Character, Integer>();

		int left = 0;
		int right = 0;

		int res = 0;
		while (right < s.length()) {
			char r = s.charAt(right);
			chars.put(r, chars.getOrDefault(r, 0) + 1);

			while (chars.get(r) > 1) {
				char l = s.charAt(left);
				chars.put(l, chars.get(l) - 1);
				left++;
			}

			res = Math.max(res, right - left + 1);

			right++;
		}
		return res;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String s = "abcabcbb";
//		String s = "aaaaaa";

		LongestSubstring ls = new LongestSubstring();

		System.out.println(ls.lengthOfLongestSubstringBrutalForce(s));
		System.out.println(ls.lengthOfLongestSlidingWindow(s));

	}
}
