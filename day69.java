class Solution {
    static Node addTwoLists(Node num1, Node num2) {
        // code here
         num1 = reverse(num1);
        num2 = reverse(num2);

        Node dummy = new Node(-1);
        Node current = dummy;
        int carry = 0;

        // Step 2: Add digits with carry
        while (num1 != null || num2 != null || carry != 0) {
            int sum = carry;
            if (num1 != null) {
                sum += num1.data;
                num1 = num1.next;
            }
            if (num2 != null) {
                sum += num2.data;
                num2 = num2.next;
            }
            carry = sum / 10;
            current.next = new Node(sum % 10);
            current = current.next;
        }

        // Step 3: Reverse the result
        Node result = reverse(dummy.next);

        // Step 4: Remove leading zeros (except if result is 0)
        while (result != null && result.data == 0 && result.next != null) {
            result = result.next;
        }

        return result;
    }

    // Helper function to reverse a linked list
    static Node reverse(Node head) {
        Node prev = null;
        while (head != null) {
            Node nextNode = head.next;
            head.next = prev;
            prev = head;
            head = nextNode;
        }
        return prev;
    }
}
