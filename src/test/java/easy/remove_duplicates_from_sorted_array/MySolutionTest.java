package easy.remove_duplicates_from_sorted_array;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MySolutionTest {

    @Test
    public void solutionTest1() {
        /*
        Input: nums = [1,1,2]
        Output: 2, nums = [1,2,_]
         */
        int[] data = new int[]{1, 1, 2};
        MySolution mySolution = new MySolution();
        int result = mySolution.removeDuplicates(data);
        assertEquals(2, result);
    }

    @Test
    public void solutionTest2() {
        /*
        Input: nums = [0,0,1,1,1,2,2,3,3,4]
        Output: 5, nums = [0,1,2,3,4,_,_,_,_,_]
         */
        int[] data = new int[]{0,0,1,1,1,2,2,3,3,4};
        MySolution mySolution = new MySolution();
        int result = mySolution.removeDuplicates(data);
        assertEquals(5, result);
    }


}
