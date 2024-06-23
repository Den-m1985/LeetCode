package medium.minimum_number_of_step_two_strings_anagram;

import java.util.HashSet;
import java.util.Set;

public class MySolution {
    //Input: s = "bab", t = "aba"    Output: 1
    public int minSteps(String s, String t) {
        if (s.length() <= 1) {
            return 0;
        }
        char[] arrS = s.toCharArray();
        char[] arrT = t.toCharArray();
        Set<char[]> set = new HashSet<>();
        return 0;
    }

}
