package in.ineuron.main;

class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}

public class Question1 {
    public static ListNode deleteMiddleNode(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }

        ListNode slowPtr = head;
        ListNode fastPtr = head;
        ListNode prevPtr = null;

        while (fastPtr != null && fastPtr.next != null) {
            fastPtr = fastPtr.next.next;
            prevPtr = slowPtr;
            slowPtr = slowPtr.next;
        }

        prevPtr.next = slowPtr.next;

        return head;
    }

    public static void printLinkedList(ListNode head) {
        ListNode curr = head;
        while (curr != null) {
            System.out.print(curr.val + " ");
            curr = curr.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        ListNode newHead = deleteMiddleNode(head);

      
        printLinkedList(newHead);

    }
}