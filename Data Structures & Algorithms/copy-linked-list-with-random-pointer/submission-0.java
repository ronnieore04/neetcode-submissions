/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        // original -> copy map
        HashMap<Node, Node> map = new HashMap<>(); 
        
        // add null node
        map.put(null, null);

        // start at head
        Node curr = head;
        while (curr != null) {

            // when a node is created, the default value is 0
            // when it's reached by curr, you don't need to create it again, just update the copy to have the original value & next & random

            // check if new node needs to be created
            if (!map.containsKey(curr)) {
                map.put(curr, new Node(0));
            }
            // set the copy's val to the original val (currently pointed at by curr)
            map.get(curr).val = curr.val;

            // check if next node needs to be created
            if (!map.containsKey(curr.next)) {
                map.put(curr.next, new Node(0));
            }
            map.get(curr).next = map.get(curr.next);

            // check if random node needs to be created
            if (!map.containsKey(curr.random)) {
                map.put(curr.random, new Node(0));
            }
            map.get(curr).random = map.get(curr.random);

            curr = curr.next;
        }

        return map.get(head);
    }
}
