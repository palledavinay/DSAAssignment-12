package in.ineuron.main;

class ListNode7 {
    int val;
    ListNode next;

    ListNode7(int val) {
        this.val = val;
        this.next = null;
    }
}

public class Question8 {
    public static boolean isCircular(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        
        ListNode head = new ListNode(1);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(4);
        ListNode node4 = new ListNode(5);
        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node1;

        boolean isCircular = isCircular(head);
        System.out.println("Is the linked list circular? " + isCircular);

     
    }
}