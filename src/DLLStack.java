/*
 * NAME: Kevin Morales-Nguyen
 * PID: A17186624
 */

/**
 * This class uses a DoublyLinkedList to implement a stack,
 * it uses an adapter design pattern to utilize Doublylinkedlist
 * methods without explicitly using inheritance
 * @param <T> generic container
 * @author Kevin Morales-Nguyen
 * @since 10/24/21
 */
public class DLLStack<T> {

    private DoublyLinkedList<T> stack;

    /**
     * This is the primary constructor for the DLLstack,
     * no parameters, just initializes empty DLL
     */
    public DLLStack() {
        this.stack = new DoublyLinkedList<T>();
    }

    /**
     * This method returns the size of the dll attribute
     * by calling dll size() method
     * @return int that represents size of the dll
     */
    public int size() {
        return this.stack.size();
    }

    /**
     * This method returns a boolean indicating if the dll
     * is empty or not
     * @return boolean true if list is empty, false otherwise
     */
    public boolean isEmpty() {
        return this.stack.isEmpty();
    }

    /**
     * This method pushes data onto the stack by
     * calling dll add(), which adds the node to the
     * end of the dll
     * is empty or not
     * @throws IllegalArgumentException if data is null
     */
    public void push(T data) {
        if(data == null){
            throw new IllegalArgumentException();
        }
        this.stack.add(data);
    }

    /**
     * This method returns the data inside of the node that is at the top of the stack
     * @return element of type T, data from the node on the top of the stack
     */
    public T pop() {
        if(this.stack.isEmpty()){
            return null;
        }
        else {
            return this.stack.remove(this.stack.size() - 1);
        }
    }

    /**
     * This method returns the data held in the node that
     * is at the top or back of the dll
     * @return element of type T
     */
    public T peek() {
        if(this.stack.isEmpty()){
            return null;
        }
        else{
            return this.stack.get(this.stack.size() - 1);
        }
    }

}
