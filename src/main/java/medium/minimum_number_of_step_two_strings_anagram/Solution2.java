package medium.minimum_number_of_step_two_strings_anagram;

public class Solution2 {
    public int minSteps(String s, String t) {
        int[] count = new int[26];

        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }

        for (char c : t.toCharArray()) {
            count[c - 'a']--;
        }

        int ans = 0;
        for (int i = 0; i < 26; i++) {
            ans += Math.abs(count[i]);
        }
        return ans / 2;
    }
}
