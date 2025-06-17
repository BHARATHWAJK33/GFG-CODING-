class Solution {
    public static Node findFirstNode(Node head) {
        // code here
           Node slow = head, fast = head;

        // Step 1: Detect loop using Floyd's Cycle detection
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                // Step 2: Find the starting node of loop
                slow = head;
                while (slow != fast) {
                    slow = slow.next;
                    fast = fast.next;
                }
                return slow; // First node of loop
            }
        }

        return null;
    }
}
