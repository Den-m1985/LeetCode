package medium.insert_greatest_common_divisors_in_linked_list;

import java.util.LinkedList;

public class MySolution {
    // Input: head = [18,6,10,3]
    //    Output: [18,6,6,2,10,1,3]
    public ListNode insertGreatestCommonDivisors(ListNode head) {
        if (head.next == null) {
            return head;
        }
        Integer lastDigit = null;
        ListNode newList = new ListNode();
        while (head != null) {
            if (lastDigit == null) {
                lastDigit = head.val;
                newList.val = lastDigit; // set first digit
            } else {
                int currentDigit = head.val;
                int result = findCommomDivide(lastDigit, currentDigit);
                insertNode(newList, result);  // set calculate digit
                insertNode(newList, currentDigit);  // set current digit
                lastDigit = head.val;
            }
            head = head.next;
        }
        return newList;
    }

    public ListNode insertNode(ListNode list, int val) {
        ListNode new_node = new ListNode(val);
        new_node.next = null;
        ListNode last = getLastNode(list);
        while (last.next != null) {
            last = last.next;
        }
        last.next = new_node;
        return list;
    }

    public ListNode getLastNode(ListNode listNode) {
        ListNode listNodeTemp = listNode;
        while (listNodeTemp.next != null) {
            listNodeTemp = listNodeTemp.next;
        }
        return listNodeTemp;
    }

    public int findCommomDivide(Integer lastDigit, int currentDigit) {
        while (lastDigit != 0 && currentDigit != 0) {
            if (lastDigit > currentDigit) {
                lastDigit = lastDigit % currentDigit;
            } else {
                currentDigit = currentDigit % lastDigit;
            }
        }
        return lastDigit + currentDigit;
    }

}
