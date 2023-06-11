package in.ineuron.main;
class ListNode6 {
    int val;
    ListNode next;

    ListNode6(int val) {
        this.val = val;
        this.next = null;
    }
}

public class Question7 {
    public static void insertAlternate(ListNode firstHead, ListNode secondHead) {
        ListNode firstPtr = firstHead;
        ListNode secondPtr = secondHead;

        while (firstPtr != null && secondPtr != null) {
            ListNode firstNext = firstPtr.next;
            ListNode secondNext = secondPtr.next;

            firstPtr.next = secondPtr;
            secondPtr.next = firstNext;

            firstPtr = firstNext;
            secondPtr = secondNext;
        }

        if (secondPtr != null) {
            // Append remaining nodes in the second list to the end of the first list
            ListNode firstTail = getTail(firstHead);
            firstTail.next = secondPtr;
        }

        // Empty the second list
        secondHead = null;
    }

    private static ListNode getTail(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode tail = head;
        while (tail.next != null) {
            tail = tail.next;
        }

        return tail;
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
        // Create the first list 5 -> 7 -> 17 -> 13 -> 11
        ListNode firstHead = new ListNode(5);
        ListNode node1 = new ListNode(7);
        ListNode node2 = new ListNode(17);
        ListNode node3 = new ListNode(13);
        ListNode node4 = new ListNode(11);
        firstHead.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        // Create the second list 12 -> 10 -> 2 -> 4 -> 6
        ListNode secondHead = new ListNode(12);
        ListNode node5 = new ListNode(10);
        ListNode node6 = new ListNode(2);
        ListNode node7 = new ListNode(4);
        ListNode node8 = new ListNode(6);
        secondHead.next = node5;
        node5.next = node6;
        node6.next = node7;
        node7.next = node8;

        insertAlternate(firstHead, secondHead);
    }
    }