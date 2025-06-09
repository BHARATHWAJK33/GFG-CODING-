
class Solution {
    Node reverseList(Node head) {
        // code here
        Node prev = null;
        Node curr = head;
        Node next = null;

        while (curr != null) {
            next = curr.next;   // Save next node
            curr.next = prev;   // Reverse pointer
            prev = curr;        // Move prev forward
            curr = next;        // Move curr forward
        }

        return prev;  
    }
}
