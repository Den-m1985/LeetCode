package easy.merge_two_sorted_lists;

import java.util.ArrayList;
import java.util.List;

public class Main {
    /*
    21. Merge Two Sorted Lists
    You are given the heads of two sorted linked lists list1 and list2.
    Merge the two lists into one sorted list.
    The list should be made by splicing together the nodes of the first two lists.
    Return the head of the merged linked list.

    Example 1:
    Input: list1 = [1,2,4], list2 = [1,3,4]
    Output: [1,1,2,3,4,4]

    Example 2:
    Input: list1 = [], list2 = []
    Output: []

    Example 3:
    Input: list1 = [], list2 = [0]
    Output: [0]

    Constraints:
    The number of nodes in both lists is in the range [0, 50].
    -100 <= Node.val <= 100
    Both list1 and list2 are sorted in non-decreasing order.
     */
    public static void main(String[] args) {
        ArrayList<Data> arrayData =fillArray();
        for (Data data:arrayData) {
            long start = System.nanoTime();
           ListNode result = new MySolution().mergeTwoLists(data.getListNode1(), data.getListNode2());
           boolean bool = check(result, data.getListNode3());
            System.out.println("My solution " + bool);
            long end = System.nanoTime();
            System.out.println("Time in mlSec: " + (end - start)/1000000);

            long start2 = System.nanoTime();
            ListNode result2 = new Solution1().mergeTwoLists(data.getListNode1(), data.getListNode2());
            boolean bool2 = check(result2, data.getListNode3());
            System.out.println("Solution1 " + bool2);
            long end2 = System.nanoTime();
            System.out.println("Time in mlSec: " + (end2 - start2)/1000000);
        }
    }

    public static ArrayList<Data> fillArray() {
        ArrayList<Data> arrayData = new ArrayList<>();
        Data data1 = new Data(new int[]{1,2,4}, new int[]{1,3,4}, new int[]{1,1,2,3,4,4});
        Data data2 = new Data(null, null, null);
        Data data3 = new Data(null, new int[]{0}, new int[]{0});

        arrayData.add(data1);
        arrayData.add(data2);
        arrayData.add(data3);
        return arrayData;
    }

    public static boolean check(ListNode result, ListNode output){
        if (result == null && output == null){
            return true;
        }
        if (result == null || output == null){
            return false;
        }
        ListNode listNodeResultCurrent = result;
        ListNode listNodeOutputCurrent = output;
        while (listNodeOutputCurrent.next != null || listNodeResultCurrent.next !=null) {
            int resultCurrent = listNodeResultCurrent.val;
            int resultOutput = listNodeOutputCurrent.val;
            if(resultOutput != resultCurrent || resultCurrent == -101){
                return false;
            }
            listNodeResultCurrent = getLastNode(result);
            listNodeOutputCurrent = getLastNode(output);
        }
        return true;
    }

    public static ListNode getLastNode(ListNode listNode) {
        ListNode listNodeTemp = listNode;
        while (listNodeTemp.next != null) {
            listNodeTemp = listNodeTemp.next;
        }
        return listNodeTemp;
    }

}
