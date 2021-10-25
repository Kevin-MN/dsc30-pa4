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
public class DLLQueue<T> {

    private DoublyLinkedList<T> queue;

    public DLLQueue() {
        this.queue = new DoublyLinkedList<T>();
    }

    public int size() {
        return this.queue.size();
    }

    public boolean isEmpty() {
        return this.queue.isEmpty();
    }

    public void enqueue(T data) {
        if(data == null){
            throw new IllegalArgumentException();
        }
        else {
            this.queue.add(data);
        }
    }

    public T dequeue() {
        if (this.queue.isEmpty()){
            return null;
        }
        else {
            return this.queue.remove(0);
        }
    }

    public T peek() {
        if(this.queue.isEmpty()){
            return null;
        }
        else{
            return this.queue.get(0);
        }
    }

}
