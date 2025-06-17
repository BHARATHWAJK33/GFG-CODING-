class Solution {
    // Function to remove a loop in the linked list.
    public static void removeLoop(Node head) {
        // code here
        if (head == null || head.next == null) return;

        Node slow = head, fast = head;
        boolean hasLoop = false;

        // Step 1: Detect loop using Floyd’s algorithm
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                hasLoop = true;
                break;
            }
        }

        // If no loop found, return
        if (!hasLoop) return;

        // Step 2: Find the start of the loop
        slow = head;

        // Special case: loop starts from head
        if (slow == fast) {
            while (fast.next != slow) {
                fast = fast.next;
            }
        } else {
            while (slow.next != fast.next) {
                slow = slow.next;
                fast = fast.next;
            }
        }

        // Step 3: Remove loop
        fast.next = null;
    }
}
