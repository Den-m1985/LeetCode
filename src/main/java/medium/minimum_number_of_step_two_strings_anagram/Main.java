package medium.minimum_number_of_step_two_strings_anagram;

import java.util.ArrayList;
import java.util.Timer;

class Main {
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
            long start = System.nanoTime();
            int result = new MySolution().minSteps(data.s(), data.t());
            System.out.println("My solution: " + checkResult(result, data.output()));
            long end = System.nanoTime();
            System.out.println("Time in mlSec: " + (end - start) / 1000000);
        }
        for (Data data : arrayData) {
            long start = System.nanoTime();
            int result = new Solution1().minSteps(data.s(), data.t());
            System.out.println("Solution1: " + checkResult(result, data.output()));
            long end = System.nanoTime();
            System.out.println("Time in mlSec: " + (end - start) / 1000000);
        }
        for (Data data : arrayData) {
            long start = System.nanoTime();
            int result = new Solution2().minSteps(data.s(), data.t());
            System.out.println("Solution2: " + checkResult(result, data.output()));
            long end = System.nanoTime();
            System.out.println("Time in mlSec: " + (end - start) / 1000000);
        }


    }


    static ArrayList<Data> fillArray() {
        ArrayList<Data> arrayData = new ArrayList<>();
        Data data1 = new Data("bab", "aba", 1);
        Data data2 = new Data("leetcode", "practice", 5);
        Data data3 = new Data("anagram", "mangaar", 0);
        Data data4 = new Data(new BigData().s, new BigData().t, 355); //output ?????

        arrayData.add(data1);
        arrayData.add(data2);
        arrayData.add(data3);
        arrayData.add(data4);
        return arrayData;
    }

    static boolean checkResult(int input, int output) {
        return input == output;
    }

}
