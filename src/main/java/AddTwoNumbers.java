public class AddTwoNumbers {

    /*You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order,
    and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.
    You may assume the two numbers do not contain any leading zero, except the number 0 itself.

    Example 1:

    Input:
    (2) -> (4) -> (3)
    (5) -> (6) -> (4)
    Output: (7) -> (0) -> (8)

    Input: l1 = [2,4,3], l2 = [5,6,4]
    Output: [7,0,8]
    Explanation: 342 + 465 = 807.

    Example 2:

    Input: l1 = [0], l2 = [0]
    Output: [0]

    Example 3:

    Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
    Output: [8,9,9,9,0,0,0,1]*/

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(9);


        ListNode listNode2 = new ListNode(9);
        ListNode listNode3 = new ListNode(9, listNode2);
        ListNode listNode4 = new ListNode(9, listNode3);
        ListNode listNode5 = new ListNode(9, listNode4);
        ListNode listNode6 = new ListNode(9, listNode5);
        ListNode listNode7 = new ListNode(9, listNode6);
        ListNode listNode8 = new ListNode(9, listNode7);
        ListNode listNode9 = new ListNode(9, listNode8);
        ListNode listNode10 = new ListNode(9, listNode9);
        ListNode listNode11 = new ListNode(1, listNode10);


        /*ListNode listNode1 = new ListNode(3);
        ListNode listNode2 = new ListNode(4, listNode1);
        ListNode listNode3 = new ListNode(2, listNode2);

        ListNode listNode4 = new ListNode(4);
        ListNode listNode5 = new ListNode(6, listNode4);
        ListNode listNode6 = new ListNode(5, listNode5);*/


        addTwoNumbers(listNode1, listNode11);
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode l1Pointer = l1;
        ListNode l2Pointer = l2;

        int[] resultArray =  new int[150];
        int i=0;
        int carry = 0;

        while(l1Pointer != null && l2Pointer != null) {
            int sum = l1Pointer.val + l2Pointer.val + carry;
            carry = sum / 10;
            resultArray[i++] = sum % 10;
            l1Pointer = l1Pointer.next;
            l2Pointer = l2Pointer.next;
        }

        while(l1Pointer != null) {
            int sum = l1Pointer.val + carry;
            carry = sum / 10;
            resultArray[i++] = sum % 10;
            l1Pointer = l1Pointer.next;
        }

        while(l2Pointer != null) {
            int sum = l2Pointer.val + carry;
            carry = sum / 10;
            resultArray[i++] = sum % 10;
            l2Pointer = l2Pointer.next;
        }

        if(carry != 0) {
            resultArray[i++] = carry;
        }

        ListNode result = null;
        for (int j = i - 1; j >= 0; j--) {
            result = new ListNode(resultArray[j], result);
        }

        return result;
    }
}
