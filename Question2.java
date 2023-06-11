package in.ineuron.main;
class ListNode1 {
    int val;
    ListNode next;

    ListNode1(int val) {
        this.val = val;
        this.next = null;
    }
}

public class Question2 {
    public static boolean hasLoop(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }

        ListNode slowPtr = head;
        ListNode fastPtr = head;

        while (fastPtr != null && fastPtr.next != null) {
            slowPtr = slowPtr.next;
            fastPtr = fastPtr.next.next;

            if (slowPtr == fastPtr) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = head.next;

        boolean hasLoop = hasLoop(head);
        System.out.println(hasLoop); 
    }
}