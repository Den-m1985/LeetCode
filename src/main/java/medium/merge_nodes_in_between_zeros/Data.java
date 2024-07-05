package medium.merge_nodes_in_between_zeros;


class Data {
    private ListNode listNode = new ListNode();
    private ListNode listNodeOutput = new ListNode();

    Data(int[] input, int[] output) {
        listNode = fillNode(input, listNode);
        listNodeOutput = fillNode(output, listNodeOutput);
    }

    ListNode getListNode() {
        return listNode;
    }

    ListNode getListNodeOutput() {
        return listNodeOutput;
    }

    ListNode fillNode(int[] input, ListNode listNode) {
        if (input == null)
            return null;
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
