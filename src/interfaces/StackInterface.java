package interfaces;

public interface StackInterface<T> {
    //Add a new entry to the top of the stack
    public void push(T data);
    //Removes the top of the stack
    public T pop();
    //returns a reference to the top of the stack without removing
    public T peek();

    public boolean isEmpty();
    public void clear();

}
