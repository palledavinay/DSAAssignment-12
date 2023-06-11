package in.ineuron.main;
class ListNode2 {
    int val;
    ListNode next;

    ListNode2(int val) {
        this.val = val;
        this.next = null;
    }
}

public class Question3{
    public static int findNthNodeFromEnd(ListNode head, int n) {
        if (head == null || n <= 0) {
            return -1;
        }

        ListNode mainPtr = head;
        ListNode refPtr = head;

        for (int i = 0; i < n; i++) {
            if (refPtr == null) {
                return -1; 
            }
            refPtr = refPtr.next;
        }

     
        while (refPtr != null) {
            mainPtr = mainPtr.next;
            refPtr = refPtr.next;
        }

        return mainPtr.val;
    }

    public static void main(String[] args) {
       
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);
        head.next.next.next.next.next.next = new ListNode(7);
        head.next.next.next.next.next.next.next = new ListNode(8);
        head.next.next.next.next.next.next.next.next = new ListNode(9);

        int n = 2;
        int result = findNthNodeFromEnd(head, n);
        System.out.println(result); 
    }
}