package medium.insert_greatest_common_divisors_in_linked_list;

public class MySolution {
    // Input: head = [18,6,10,3]
    //    Output: [18,6,6,2,10,1,3]
    public ListNode insertGreatestCommonDivisors(ListNode head) {
        if (head.next == null) {
            return head;
        }
        Integer lastDigit = null;
        ListNode newList = new ListNode();
        while (head.next != null) {
            ListNode temp = head.next;
            if (lastDigit == null) {
                lastDigit = head.val;
                newList.val = lastDigit;

            } else {
                int currentDigit = head.val;
                int result = findCommomDivide(lastDigit, currentDigit);
                newList.next = new ListNode(result);
            }
        }
        return null;
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
