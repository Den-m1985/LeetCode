package medium.minimum_number_of_step_two_strings_anagram;

import java.util.ArrayList;

public class Main {
    /*
    1347. Minimum Number of Steps to Make Two Strings Anagram
    You are given two strings of the same length s and t.
    In one step you can choose any character of t and replace
    it with another character.

    Return the minimum number of steps to make t an anagram of s.
    An Anagram of a string is a string that contains the same
     characters with a different (or the same) ordering.

    Example 1:
    Input: s = "bab", t = "aba"
    Output: 1
    Explanation: Replace the first 'a' in t with b, t = "bba" which is anagram of s.

    Example 2:
    Input: s = "leetcode", t = "practice"
    Output: 5
    Explanation: Replace 'p', 'r', 'a', 'i' and 'c' from t with proper characters to make t anagram of s.
    Example 3:

    Input: s = "anagram", t = "mangaar"
    Output: 0
    Explanation: "anagram" and "mangaar" are anagrams.

    Constraints:
    1 <= s.length <= 5 * 104
    s.length == t.length
    s and t consist of lowercase English letters only.
     */
    public static void main(String[] args) {
        ArrayList<Data> arrayData = fillArray();

        for (Data data : arrayData) {
            int result = new MySolution().minSteps(data.s, data.t);
            System.out.println("My solution: " + checkResult(result, data.output));
        }
    }


    public static ArrayList<Data> fillArray() {
        ArrayList<Data> arrayData = new ArrayList<>();
        Data data1 = new Data("bab","aba", 1);
        Data data2 = new Data("leetcode","practice", 5);
        Data data3 = new Data("anagram","mangaar", 0);

        arrayData.add(data1);
        arrayData.add(data2);
        arrayData.add(data3);
        return arrayData;
    }

    public static boolean checkResult(int input, int output) {
        return input == output;
    }

}
