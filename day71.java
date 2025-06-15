class Solution {
    // Function to check if the linked list has a loop.
    public static boolean detectLoop(Node head) {
        // Add code here
        Node slow = head;
        Node fast = head;

        // Traverse the list with two pointers
        while (fast != null && fast.next != null) {
            slow = slow.next;          // Move by 1 step
            fast = fast.next.next;     // Move by 2 steps

            if (slow == fast) {
                // If both pointers meet, loop exists
                return true;
            }
        }

        // If we reach here, no loop
        return false;
    }
}
