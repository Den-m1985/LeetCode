package easy.relative_sort_array;

import java.util.Arrays;

class MySolution {

    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int[] result = new int[arr1.length];
        int[] countNotMatches = new int[arr1.length];
        //sort  [1 2 2 2 3 3 4 6 7 9 19]
        Arrays.sort(arr1);
        //find same digit and write to new array  [2 2 2 1 4 3 3 9 6 0 0]
        int count = 0;
        for (int digitArr2 : arr2) {
            for (int j = 0; j < arr1.length; j++) {
                if (arr1[j] == digitArr2) {
                    result[count] = digitArr2;
                    count++;
                    countNotMatches[j]++;
                }
            }
        }
        // find count digit no matches  [1 1 1 1 1 1 1 1 0 1 0]
        int countDigit = 0;
        for (int countNotMatch : countNotMatches) {
            if (countNotMatch == 0) {
                countDigit++;
            }
        }
        // write digit no use to new array  [7 19]
        int[] digitsNoUse = new int[countDigit];
        int index = 0;
        for (int i = 0; i < countNotMatches.length; i++) {
            if (countNotMatches[i] == 0) {
                digitsNoUse[index] = arr1[i];
                index++;
            }
        }
        // fill result array no matches digit
        for (int i = 0; i < countDigit; i++) {
            result[count] = digitsNoUse[i];
            count++;
        }
        return result;
    }

}
