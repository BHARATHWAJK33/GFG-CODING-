class Solution {
    public static Node reverseKGroup(Node head, int k) {
        // code here
           if (head == null || k <= 1) return head;

        Node current = head;
        Node prev = null;
        Node next = null;
        int count = 0;

        // Step 1: Count k nodes
        Node temp = head;
        while (temp != null && count < k) {
            temp = temp.next;
            count++;
        }

        // If we have k nodes, reverse them
        if (count == k) {
            current = head;
            count = 0;

            // Reverse k nodes
            while (current != null && count < k) {
                next = current.next;
                current.next = prev;
                prev = current;
                current = next;
                count++;
            }

            // Recurse on the remaining list
            if (next != null) {
                head.next = reverseKGroup(next, k);
            }

            // prev is new head after reversing
            return prev;
        } else {
            // Less than k nodes left, reverse them as well (per problem statement)
            current = head;
            prev = null;
            while (current != null) {
                next = current.next;
                current.next = prev;
                prev = current;
                current = next;
            }
            return prev;
    }
}
}
