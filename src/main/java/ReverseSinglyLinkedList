public class ReverseSinglyLinkedList {

    public static void main(String[] args) {
        ListNode listNode5 = new ListNode(5);
        ListNode listNode4 = new ListNode(4, listNode5);
        ListNode listNode3 = new ListNode(3, listNode4);
        ListNode listNode2 = new ListNode(2, listNode3);
        ListNode listNode1 = new ListNode(1, listNode2);
        ListNode head = listNode1;
        
        head = reverseSinglyLinkedList(head);
        
        ListNode trav = head;
        while(trav != null) {
            System.out.print(trav.val + "->");
            trav = trav.next;
        }
        System.out.println("NULL");
    }
    
    public static ListNode reverseSinglyLinkedList(ListNode head) {

        ListNode prev = null;
        ListNode next = null;
        
        while(head != null) {
            next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        
        return prev;
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
}
