package easy.longest_common_prefix;

import java.util.ArrayList;

class Main {
    /*
    Write a function to find the longest common prefix string amongst an array of strings.
    If there is no common prefix, return an empty string "".

    Example 1:
    Input: strs = ["flower","flow","flight"]
    Output: "fl"

    Example 2:
    Input: strs = ["dog","racecar","car"]
    Output: ""
    Explanation: There is no common prefix among the input strings.

    Constraints:
    1 <= strs.length <= 200
    0 <= strs[i].length <= 200
    strs[i] consists of only lowercase English letters.
     */
    public static void main(String[] args) {
        ArrayList<Data> arrayData = fillArray();

        for (Data data : arrayData) {
            String result = new MySolution().longestCommonPrefix(data.strs());
            System.out.println("My solution: " + checkResult(result, data.output()));
        }
        for (Data data : arrayData) {
            String result = new Solution1().longestCommonPrefix(data.strs());
            System.out.println("Solution1: " + checkResult(result, data.output()));
        }
        for (Data data : arrayData) {
            String result = new Solution2().longestCommonPrefix(data.strs());
            System.out.println("Solution2: " + checkResult(result, data.output()));
        }

    }

    static ArrayList<Data> fillArray() {
        ArrayList<Data> arrayData = new ArrayList<>();
        Data data1 = new Data(new String[]{"flower", "flow", "flight"}, "fl");
        Data data2 = new Data(new String[]{"dog", "racecar", "car"}, "");
        Data data3 = new Data(new String[]{"a"}, "a");
        Data data4 = new Data(new String[]{"ab", "a"}, "a");
        Data data5 = new Data(new String[]{}, "");
        Data data6 = new Data(new String[]{"", ""}, "");
        Data data7 = new Data(new String[]{"flower", "flower", "flower", "flower"}, "flower");
        Data data8 = new Data(new String[]{"cir", "car"}, "c");
        arrayData.add(data1);
        arrayData.add(data2);
        arrayData.add(data3);
        arrayData.add(data4);
        arrayData.add(data5);
        arrayData.add(data6);
        arrayData.add(data7);
        arrayData.add(data8);
        return arrayData;
    }

    static boolean checkResult(String strIn, String strOut) {
        return strIn != null && strIn.equals(strOut);
    }

}
