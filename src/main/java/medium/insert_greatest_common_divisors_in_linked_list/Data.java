package medium.insert_greatest_common_divisors_in_linked_list;


public class Data {
    protected final int[] head;
    protected final int[] output;
    private ListNode listNode = new ListNode();
    private ListNode listNodeOutput = new ListNode();

    public Data(int[] input, int[] output) {
        this.head = input;
        this.output = output;
        listNode =fillNode(input, listNode);
        listNodeOutput =fillNode(output, listNodeOutput);
    }

    public ListNode getListNode() {
        return listNode;
    }

    public ListNode getListNodeOutput() {
        return listNodeOutput;
    }

    public ListNode fillNode(int[] input, ListNode listNode) {
        if (input == null)
            return null;
        if (input.length == 0){
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
            if (i == input.length-1) {
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

    public ListNode getLastNode(ListNode listNode) {
        ListNode listNodeTemp = listNode;
        while (listNodeTemp.next != null) {
            listNodeTemp = listNodeTemp.next;
        }
        return listNodeTemp;
    }

}
