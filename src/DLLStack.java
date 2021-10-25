/*
 * NAME: Kevin Morales-Nguyen
 * PID: A17186624
 */

/**
 * TODO
 * @param <T> generic container
 * @author Kevin Morales-Nguyen
 * @since 10/24/21
 */
public class DLLStack<T> {

    private DoublyLinkedList<T> stack;

    public DLLStack() {
        this.stack = new DoublyLinkedList<T>();
    }

    public int size() {
        return this.stack.size();
    }

    public boolean isEmpty() {
        return this.stack.isEmpty();
    }

    public void push(T data) {
        if(data == null){
            throw new IllegalArgumentException();
        }
        this.stack.add(data);
    }

    public T pop() {
        if(this.stack.isEmpty()){
            return null;
        }
        else {
            return this.stack.remove(this.stack.size() - 1);
        }
    }

    public T peek() {
        if(this.stack.isEmpty()){
            return null;
        }
        else{
            return this.stack.get(this.stack.size() - 1);
        }
    }

}
