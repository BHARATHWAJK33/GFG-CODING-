class Solution {
    Node sortedMerge(Node head1, Node head2) {
        // code here
                Node dummy = new Node(0);
        Node tail = dummy;

        // Traverse both lists
        while (head1 != null && head2 != null) {
            if (head1.data <= head2.data) {
                tail.next = head1;
                head1 = head1.next;
            } else {
                tail.next = head2;
                head2 = head2.next;
            }
            tail = tail.next;
        }

        // Attach the remaining elements
        if (head1 != null) {
            tail.next = head1;
        } else {
            tail.next = head2;
        }

        return dummy.next;
    }
}
