/*public class Stack<T> implements interfaces.StackInterface<T> {
    // This stack implementation will use a linkedList as the foundational data structure
    // Foundational data structure
    public Node top;

    public Stack(){
        top = null;
    }

    @Override
    public void push(T data) {
        Node newNode = new Node(data, top);
        top = newNode;

    }

    @Override
    public T pop() {
        T toPop = (T)top.data;
        if(!isEmpty()){
            top = top.next;
        }

        return toPop;
    }

    @Override
    public T peek() {
        if(isEmpty())
            return null;
        return (T)top.data;
    }

    @Override
    public boolean isEmpty() {
        return top == null;
    }

    @Override
    public void clear() {
        top = null;
    }
}*/