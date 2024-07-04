package easy.merge_two_sorted_lists;

import java.util.ArrayList;
import java.util.Collections;

class MySolution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        } else if (list2 == null) {
            return list1;
        }
        ArrayList<Integer> array1 = fillArray(list1);
        ArrayList<Integer> array2 = fillArray(list2);
        array1.addAll(array2);
        Collections.sort(array1);
        return fillNode(array1);
    }

    ArrayList<Integer> fillArray(ListNode list) {
        ArrayList<Integer> array = new ArrayList<>();
        ListNode listNodeTemp = list;
        boolean stop = true;
        while (stop) {
            if (listNodeTemp.next != null) {
                array.add(listNodeTemp.val);
                listNodeTemp = listNodeTemp.next;
            }
            if (listNodeTemp.next == null) {
                array.add(listNodeTemp.val);
                stop = false;
            }
        }
        return array;
    }

    ListNode fillNode(ArrayList<Integer> array) {
        ListNode listNode = new ListNode();
        if (array.size() == 0) {
            listNode.val = -101;
            return listNode;
        }
        if (array.size() == 1) {
            listNode.val = array.get(0);
            return listNode;
        }
        listNode.val = array.get(0);
        listNode.next = null;
        for (int i = 1; i < array.size(); i++) {
            ListNode listNodeLast = getLastNode(listNode);
            ListNode listNodeCurrent = new ListNode();
            if (i == array.size() - 1) {
                listNodeCurrent.val = array.get(i);
                listNodeLast.next = listNodeCurrent;
                break;
            }
            listNodeCurrent.val = array.get(i);
            listNodeCurrent.next = null;
            listNodeLast.next = listNodeCurrent;
        }
        return listNode;
    }

    ListNode getLastNode(ListNode listNode) {
        ListNode listNodeTemp = listNode;
        while (listNodeTemp.next != null) {
            listNodeTemp = listNodeTemp.next;
        }
        return listNodeTemp;
    }

}
