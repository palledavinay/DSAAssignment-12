package in.ineuron.main;
class ListNode3 {
    char val;
    ListNode next;

    ListNode3(char val) {
        this.val = val;
        this.next = null;
    }
}

public class Question4 {
    public static boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }

        ListNode slowPtr = head;
        ListNode fastPtr = head;
        ListNode prevPtr = null;

        while (fastPtr != null && fastPtr.next != null) {
            fastPtr = fastPtr.next.next;

            // Reverse the first half of the linked list
            ListNode nextNode = slowPtr.next;
            slowPtr.next = prevPtr;
            prevPtr = slowPtr;
            slowPtr = nextNode;
        }

        // If the list length is odd, move slowPtr one step ahead
        if (fastPtr != null) {
            slowPtr = slowPtr.next;
        }

        // Compare the reversed first half with the second half
        while (slowPtr != null) {
            if (slowPtr.val != prevPtr.val) {
                return false;
            }
            slowPtr = slowPtr.next;
            prevPtr = prevPtr.next;
        }

        return true;
    }

    public static void main(String[] args) {
        // Create the linked list R->A->D->A->R->NULL
        ListNode head = new ListNode('R');
        head.next = new ListNode('A');
        head.next.next = new ListNode('D');
        head.next.next.next = new ListNode('A');
        head.next.next.next.next = new ListNode('R');

        boolean isPalindrome = isPalindrome(head);
        System.out.println(isPalindrome); // Output: true

        // Create the linked list C->O->D->E->NULL
        ListNode head2 = new ListNode('C');
        head2.next = new ListNode('O');
        head2.next.next = new ListNode('D');
        head2.next.next.next = new ListNode('E');

        isPalindrome = isPalindrome(head2);
        System.out.println(isPalindrome); // Output: false
    }
}