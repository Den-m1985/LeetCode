package easy.merge_two_sorted_lists;

class Data {

    final int[] output;
    private ListNode listNode1 = new ListNode();
    private ListNode listNode2 = new ListNode();
    private ListNode listNode3 = new ListNode();

    Data(int[] input1, int[] input2, int[] output) {
        this.output = output;
        listNode1 = fillNode(input1, listNode1);
        listNode2 = fillNode(input2, listNode2);
        listNode3 = fillNode(output, listNode3);
    }

    ListNode getListNode1() {
        return listNode1;
    }

    ListNode getListNode2() {
        return listNode2;
    }

    ListNode getListNode3() {
        return listNode3;
    }

    ListNode fillNode(int[] input, ListNode listNode) {
        if (input == null)
            return null;
        if (input.length == 0) {
            listNode.val = -101;
            return listNode;
        }
        if (input.length == 1) {
            listNode.val = input[0];
            return listNode;
        }
        listNode.val = input[0];
        listNode.next = null;
        for (int i = 1; i < input.length; i++) {
            ListNode listNodeLast = getLastNode(listNode);
            ListNode listNodeCurrent = new ListNode();
            if (i == input.length - 1) {
                listNodeCurrent.val = input[i];
                listNodeLast.next = listNodeCurrent;
                break;
            }
            listNodeCurrent.val = input[i];
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
