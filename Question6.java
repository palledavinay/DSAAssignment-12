package in.ineuron.main;

class ListNode5 {
    int val;
    ListNode next;

    ListNode5(int val) {
        this.val = val;
        this.next = null;
    }
}

public class Question6 {
    public static ListNode retainMDeleteN(ListNode head, int M, int N) {
        if (head == null || M <= 0 || N <= 0) {
            return head;
        }

        ListNode curr = head;
        ListNode prev = null;

        while (curr != null) {
            int count = 0;

            // Retain M nodes
            while (curr != null && count < M) {
                if (prev == null) {
                    prev = curr;
                    head = prev;
                } else {
                    prev.next = curr;
                    prev = curr;
                }

                curr = curr.next;
                count++;
            }

           
            count = 0;
            while (curr != null && count < N) {
                curr = curr.next;
                count++;
            }

            
            prev.next = null;
        }

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
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(4);
        ListNode node4 = new ListNode(5);
        ListNode node5 = new ListNode(6);
        ListNode node6 = new ListNode(7);
        ListNode node7 = new ListNode(8);
        ListNode node8 = new ListNode(9);
        ListNode node9 = new ListNode(10);
        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;
        node7.next = node8;
        node8.next = node9;

        int M = 2;
        int N = 3;

        ListNode modifiedList = retainMDeleteN(head, M, N);
        printLinkedList(modifiedList);

    }
}