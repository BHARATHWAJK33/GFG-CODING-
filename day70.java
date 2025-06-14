class Solution {
    public Node cloneLinkedList(Node head) {
        // code here
         if (head == null) return null;

        // Step 1: Clone nodes and insert after original nodes
        Node current = head;
        while (current != null) {
            Node clone = new Node(current.data);
            clone.next = current.next;
            current.next = clone;
            current = clone.next;
        }

        // Step 2: Assign random pointers
        current = head;
        while (current != null) {
            if (current.random != null)
                current.next.random = current.random.next;
            current = current.next.next;
        }

        // Step 3: Separate original and cloned list
        Node original = head;
        Node cloneHead = head.next;
        Node cloneCurrent = cloneHead;

        while (original != null) {
            original.next = original.next.next;
            if (cloneCurrent.next != null)
                cloneCurrent.next = cloneCurrent.next.next;
            original = original.next;
            cloneCurrent = cloneCurrent.next;
        }

        return cloneHead;
    }
}
