package stevenNavarretteIII;

public class LinkedList {
    NodeIII head;
    int size;

    //constructor
    public LinkedList() {
        head = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    //adds node at the beginning of the list
    public void prepend(NodeIII newNode) {
        newNode.next = head;
        head = newNode;
        size++;
    }

    //append adds a node at the end of the linked list
    public void append(NodeIII newNode) {
        // Check if the linked list is empty
        if (head == null) {
            head = newNode;
            size++;
            return;
        }

        //traverse to last node
        NodeIII ptr = head;
        while (ptr.next != null) {
            ptr = ptr.next;
        }
        //attach new node to last node
        ptr.next = newNode;
        size++;
    }

    //reverse linked list
    public void reverse() {
        NodeIII prev = null;
        NodeIII current = head;
        NodeIII next = null;

        while (current != null) {
            next = current.next;  //store next node
            current.next = prev;  //reverse link
            prev = current;       // move last element forward one
            current = next;       // Move current element forward one
        }

        head = prev;  //update head
    }

    public void printList() {
        if (head == null) {
            System.out.println("List is empty"); //print list
            return;
        }

        NodeIII ptr = head;
        while (ptr != null) {
            System.out.print(ptr.data + " -> ");
            ptr = ptr.next;
        }
        System.out.println("null");
    }
}
