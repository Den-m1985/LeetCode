package easy.longest_common_prefix;



import java.util.ArrayList;
import java.util.List;

public class Main {
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
        List<Data> arrayData = new ArrayList<>();
        Data data1 = new Data(new String[]{"flower","flow","flight"},"fl");
        Data data2 = new Data(new String[]{"dog","racecar","car"}, "");
        Data data3 = new Data(new String[]{"a"}, "a");
        arrayData.add(data1);
        arrayData.add(data2);
        arrayData.add(data3);

        for (Data data : arrayData) {
            String result = new MySolution().longestCommonPrefix(data.getStrs());
            System.out.println("My solution: " + checkResult(result, data.getOutput()));
        }
//        for (Data data : arrayData) {
//            int[] resultEx = new Solution1().twoSum(data.getNums(), data.getTarget());
//            System.out.println("Solution1: " + checkResult(resultEx, data.getOutput()));
//        }

    }

    public static boolean checkResult(String strIn, String strOut) {
        return strIn != null && strIn.equals(strOut);
    }

}
