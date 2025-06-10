class Solution {
    public Node rotate(Node head, int k) {
        // add code here
      if (head == null || head.next == null || k == 0) return head;

        // Step 1: Count length
        Node current = head;
        int length = 1;
        while (current.next != null) {
            current = current.next;
            length++;
        }

        // Step 2: Adjust k
        k = k % length;
        if (k == 0) return head;

        // Step 3: Make it circular
        current.next = head;

        // Step 4: Find new tail: (length - (length - k) - 1) = (k-1)
        int count = 1;
        Node newTail = head;
        while (count < k) {
            newTail = newTail.next;
            count++;
        }

        // Step 5: Set new head and break the cycle
        Node newHead = newTail.next;
        newTail.next = null;

        return newHead;
    }

    // Utility method to print the list
    public static void printList(Node head) {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + (current.next != null ? " -> " : ""));
            current = current.next;
        }
        System.out.println();
    }

}
