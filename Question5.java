package in.ineuron.main;
class ListNode4 {
    int val;
    ListNode next;

    ListNode4(int val) {
        this.val = val;
        this.next = null;
    }
}

public class Question5 {
    public static void removeLoop(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }

        ListNode slowPtr = head;
        ListNode fastPtr = head;

  
        while (fastPtr != null && fastPtr.next != null) {
            slowPtr = slowPtr.next;
            fastPtr = fastPtr.next.next;

            if (slowPtr == fastPtr) {
                break;
            }
        }

  
        if (slowPtr != fastPtr) {
            return;
        }

       
        slowPtr = head;

        
        while (slowPtr.next != fastPtr.next) {
            slowPtr = slowPtr.next;
            fastPtr = fastPtr.next;
        }

       
        fastPtr.next = null;
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
        ListNode node1 = new ListNode(3);
        ListNode node2 = new ListNode(4);
        ListNode node3 = new ListNode(3);
        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node1; 

        removeLoop(head);

       
        printLinkedList(head);

       
    }
}