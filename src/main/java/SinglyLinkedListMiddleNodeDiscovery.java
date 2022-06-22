public class SinglyLinkedListMiddleNodeDiscovery {
    public static void main(String args[]) {
        ListNode listNode5 = new ListNode(1);
        ListNode listNode4 = new ListNode(2, listNode5);
        ListNode listNode3 = new ListNode(3, listNode4);
        ListNode listNode2 = new ListNode(2, listNode3);
        ListNode listNode1 = new ListNode(1, listNode2);
        ListNode head = listNode1;
        
        System.out.println("Linked List " + linkedListToString(head));
        int middleNodeValue = retrieveMiddleNodeOfLinkedList(head);
        System.out.println("Middle node value of above linked list is " + middleNodeValue);
    }
    
    public static int retrieveMiddleNodeOfLinkedList(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        
        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow.val;
    }
    
    public static class ListNode {

        int val;
        ListNode next;
    
        ListNode(int val) {
            this.val = val;
        }
    
        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
    
    public static String linkedListToString(ListNode head) {
        StringBuilder stringBuilder = new StringBuilder();
        ListNode trav = head;
        while(trav != null) {
            stringBuilder.append(trav.val + "->");
            trav = trav.next;
        }
        stringBuilder.append("NULL");
        return stringBuilder.toString();
    }
}
