package easy.ToSum;

import java.util.ArrayList;
import java.util.List;

public class Main {
    /*
    Given an array of integers nums and an integer target,
    return indices of the two numbers such that they add up to target.
    You may assume that each input would have exactly one solution,
    and you may not use the same element twice.
    You can return the answer in any order.

    Example 1:
    Input: nums = [2,7,11,15], target = 9
    Output: [0,1]
    Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].

    Example 2:
    Input: nums = [3,2,4], target = 6
    Output: [1,2]

    Example 3:
    Input: nums = [3,3], target = 6
    Output: [0,1]

    Constraints:
    2 <= nums.length <= 104
    -109 <= nums[i] <= 109
    -109 <= target <= 109
    Only one valid answer exists.

    Follow-up: Can you come up with an algorithm that is less than O(n2) time complexity?
     */
    public static void main(String[] args) {
        List<Data> arrayData = new ArrayList<>();
        Data data1 = new Data(new int[]{2, 7, 11, 15}, 9, new int[]{0, 1});
        Data data2 = new Data(new int[]{3, 2, 4}, 6, new int[]{1, 2});
        Data data3 = new Data(new int[]{3, 3}, 6, new int[]{0, 1});
        arrayData.add(data1);
        arrayData.add(data2);
        arrayData.add(data3);

        for (Data data : arrayData) {
            int[] resultEx = new MySolution().twoSum(data.getNums(), data.getTarget());
            System.out.println("My solution: " + checkResult(resultEx, data.getOutput()));
        }
        for (Data data : arrayData) {
            int[] resultEx = new Solution1().twoSum(data.getNums(), data.getTarget());
            System.out.println("Solution1: " + checkResult(resultEx, data.getOutput()));
        }

    }

    public static boolean checkResult(int[] arr1, int[] arr2) {
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
    }

}
