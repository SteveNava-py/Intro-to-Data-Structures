package stevenNavarretteIII;

public class ReverseLinkedList {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();

        //nodes
        list.append(new NodeIII(10));
        list.append(new NodeIII(20));
        list.append(new NodeIII(30));
        list.append(new NodeIII(40));

        //og order
        System.out.println("Original Linked List:");
        list.printList();

        //reverse list
        list.reverse();

        System.out.println("Reversed Linked List:"); //print reversed list
        list.printList();
    }
}
