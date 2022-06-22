public class LinkedListPalindrome {
    public static void main(String args[]) {
        ListNode listNode5 = new ListNode(1);
        ListNode listNode4 = new ListNode(2, listNode5);
        ListNode listNode3 = new ListNode(3, listNode4);
        ListNode listNode2 = new ListNode(2, listNode3);
        ListNode listNode1 = new ListNode(1, listNode2);
        ListNode head = listNode1;
        
        System.out.println("Linked List " + linkedListToString(head));
        
        if(isPalindrome(head)) {
            System.out.println("Given linked list is palindrome");
        } else {
            System.out.println("Given linked list is not palindrome");
        }
    }
    
    public static boolean isPalindrome(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        
        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        
        fast = head;
        slow = reverseLinkedList(slow);
        
        while(fast != null) {
            if(fast.val != slow.val) {
                return false;
            }
            fast = fast.next;
            slow = slow.next;
        }
        return true;
    }
    
    public static ListNode reverseLinkedList(ListNode head) {
        ListNode prev = null;
        ListNode next =  null;
        
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
