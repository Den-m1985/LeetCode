package medium.insert_greatest_common_divisors_in_linked_list;

import java.util.ArrayList;

class Main {
    /*
    2807. Insert Greatest Common Divisors in Linked List
    https://leetcode.com/problems/insert-greatest-common-divisors-in-linked-list/

    Given the head of a linked list head, in which each node contains an integer value.
    Between every pair of adjacent nodes, insert a new node with a value equal to the greatest common divisor of them.
    Return the linked list after insertion.
    The greatest common divisor of two numbers is the largest positive integer that evenly divides both numbers.

    Example 1:
    Input: head = [18,6,10,3]
    Output: [18,6,6,2,10,1,3]
    Explanation: The 1st diagram denotes the initial linked list and the 2nd diagram denotes
    the linked list after inserting the new nodes (nodes in blue are the inserted nodes).
    - We insert the greatest common divisor of 18 and 6 = 6 between the 1st and the 2nd nodes.
    - We insert the greatest common divisor of 6 and 10 = 2 between the 2nd and the 3rd nodes.
    - We insert the greatest common divisor of 10 and 3 = 1 between the 3rd and the 4th nodes.
    There are no more adjacent nodes, so we return the linked list.

    Example 2:
    Input: head = [7]
    Output: [7]
    Explanation: The 1st diagram denotes the initial linked list and the 2nd diagram denotes
    the linked list after inserting the new nodes.
    There are no pairs of adjacent nodes, so we return the initial linked list.

    Constraints:
    The number of nodes in the list is in the range [1, 5000].
    1 <= Node.val <= 1000
     */
    static void main(String[] args) {
        ArrayList<Data> arrayData =fillArray();
        for (Data data:arrayData) {
            ListNode result = new MySolution().insertGreatestCommonDivisors(data.getListNode());
            boolean bool = check(result, data.getListNodeOutput());
            System.out.println("My solution " + bool);
        }
        for (Data data:arrayData) {
            ListNode result = new Solution1().insertGreatestCommonDivisors(data.getListNode());
            boolean bool = check(result, data.getListNodeOutput());
            System.out.println("Solution1 " + bool);
        }
    }

    static ArrayList<Data> fillArray() {
        ArrayList<Data> arrayData = new ArrayList<>();
        Data data1 = new Data(new int[]{18,6,10,3}, new int[]{18,6,6,2,10,1,3});
        Data data2 = new Data(new int[]{7}, new int[]{7});
        arrayData.add(data1);
        arrayData.add(data2);
        return arrayData;
    }

    static boolean check(ListNode result, ListNode output){
        if (result == null && output == null){
            return true;
        }
        if (result == null || output == null){
            return false;
        }
        while (output.next != null || result.next !=null) {
            int resultCurrent = result.val;
            int resultOutput = output.val;
            if(resultOutput != resultCurrent){
                return false;
            }
            output = output.next;
            result = result.next;
        }
        return true;
    }

}
