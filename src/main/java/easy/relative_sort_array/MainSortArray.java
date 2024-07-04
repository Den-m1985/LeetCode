package easy.relative_sort_array;

class MainSortArray {
    /*
   1122. Relative Sort Array
   Given two arrays arr1 and arr2, the elements of arr2 are distinct,
   and all elements in arr2 are also in arr1.
   Sort the elements of arr1 such that the relative ordering of items in arr1 are the same as in arr2.
   Elements that do not appear in arr2 should be placed at the end of arr1 in ascending order.
   Example 1:
   Input: arr1 = [2,3,1,3,2,4,6,7,9,2,19], arr2 = [2,1,4,3,9,6]
   Output: [2,2,2,1,4,3,3,9,6,7,19]
   Example 2:
   Input: arr1 = [28,6,22,8,44,17], arr2 = [22,28,8,6]
   Output: [22,28,8,6,17,44]

   Constraints:
   1 <= arr1.length, arr2.length <= 1000
   0 <= arr1[i], arr2[i] <= 1000
   All the elements of arr2 are distinct.
   Each arr2[i] is in arr1.
    */
    public static void main(String[] args) {
        int[] arr1 = new int[]{2, 3, 1, 3, 2, 4, 6, 7, 9, 2, 19};
        int[] arr2 = new int[]{2, 1, 4, 3, 9, 6};
        int[] output = new int[]{2, 2, 2, 1, 4, 3, 3, 9, 6, 7, 19};

        int[] resultEx1 = new MySolution().relativeSortArray(arr1.clone(), arr2);
        System.out.println(checkResult(resultEx1, output));

        int[] resultSolution1 = new Solution1().relativeSortArray(arr1.clone(), arr2);
        System.out.println(checkResult(resultSolution1, output));

        int[] resultSolution2 = new Solution2().relativeSortArray(arr1.clone(), arr2);
        System.out.println(checkResult(resultSolution2, output));
    }


    static boolean checkResult(int[] arr1, int[] arr2) {
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
    }

}
