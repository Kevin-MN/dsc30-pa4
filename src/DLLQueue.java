/*
 * NAME: Kevin Morales-Nguyen
 * PID: A17186624
 */

/**
 * This class uses a DoublyLinkedList to implement a queue,
 * it uses an adapter design pattern to utilize Doublylinkedlist
 * methods without explicitly using inheritance
 * @param <T> generic container
 * @author Kevin Morales-Nguyen
 * @since 10/24/21
 */
public class DLLQueue<T> {


    private DoublyLinkedList<T> queue;

    /**
     * This is the primary constructor for the DLLqueue,
     * no parameters, just initializes empty DLL
     */
    public DLLQueue() {
        this.queue = new DoublyLinkedList<T>();
    }

    /**
     * This method returns the size of the dll attribute
     * by calling dll size()
     * @return int that represents size of the dll
     */
    public int size() {
        return this.queue.size();
    }

    /**
     * This method returns a boolean indicating if the dll
     * is empty or not
     * @return boolean true if list is empty, false otherwise
     */
    public boolean isEmpty() {
        return this.queue.isEmpty();
    }

    /**
     * This method adds data to the stack by FIFO, data is added
     * to the end of the dll
     * @throws IllegalArgumentException if data is null
     */
    public void enqueue(T data) {
        if(data == null){
            throw new IllegalArgumentException();
        }
        else {
            this.queue.add(data);
        }
    }

    /**
     * This method will remove the first node from the dll and
     * return it's data
     * @return element of type T, that is the data attribute of the node
     */
    public T dequeue() {
        if (this.queue.isEmpty()){
            return null;
        }
        else {
            return this.queue.remove(0);
        }
    }

    /**
     * This method returns the data held in the node that
     * is at the beginning of the dll
     * @return element of type T
     */
    public T peek() {
        if(this.queue.isEmpty()){
            return null;
        }
        else{
            return this.queue.get(0);
        }
    }

}
