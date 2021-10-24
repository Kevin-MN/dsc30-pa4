/*
 * NAME: Kevin Morales-Nguyen
 * PID: A17186624
 */

import java.util.AbstractList;

/**
 * TODO
 * @author Kevin Morales-Nguyen
 * @since 10/22/21
 */
public class DoublyLinkedList<T> extends AbstractList<T> {

    /* DLL instance variables */
    private int nelems;
    private Node head;
    private Node tail;

    /**
     * Node for chaining together to create a linked list
     */
    protected class Node {

        /* Node instance variables */
        T data;
        Node next;
        Node prev;

        /**
         * Constructor to create singleton Node
         */
        private Node(T element) {
            this.data = element;
            this.next = null;
            this.prev = null;
        }

        /**
         * Constructor to create singleton link it between previous and next
         *
         * @param element  Element to add, can be null
         * @param nextNode successor Node, can be null
         * @param prevNode predecessor Node, can be null
         */
        private Node(T element, Node nextNode, Node prevNode) {
            this.data = element;
            this.next = nextNode;
            this.prev = prevNode;
        }

        /**
         * Set the element
         *
         * @param element new element
         */
        public void setElement(T element) {
            this.data = element;
        }

        /**
         * Accessor to get the Nodes Element
         */
        public T getElement() {
            return this.data;
        }

        /**
         * Set the next node in the list
         *
         * @param n new next node
         */
        public void setNext(Node n) {
            this.next = n;
        }

        /**
         * Get the next node in the list
         *
         * @return the successor node
         */
        public Node getNext() {
            return this.next;
        }

        /**
         * Set the previous node in the list
         *
         * @param p new previous node
         */
        public void setPrev(Node p) {
            this.prev = p;
        }


        /**
         * Accessor to get the prev Node in the list
         *
         * @return predecessor node
         */
        public Node getPrev() {
            return this.prev;
        }


        /**
         * Remove this node from the list.
         * Update previous and next nodes
         */
        public void remove() {
            this.prev.setNext(this.next);
            this.next.setPrev(this.prev);
        }
    }


    /**
     * Creates a new, empty doubly-linked list.
     */
    public DoublyLinkedList() {
        this.head = new Node(null);
        this.tail = new Node(null, null, this.head);
        this.head.setNext(this.tail);
        this.nelems = 0;
    }

    /**
     * Add an element to the end of the list
     *
     * @param element data to be added
     * @return whether or not the element was added
     * @throws NullPointerException if data received is null
     */
    @Override
    public boolean add(T element) throws NullPointerException {
        if(element == null){
            throw new NullPointerException();
        }

        Node new_node = new Node(element, this.tail, this.tail.getPrev());
        this.tail.getPrev().setNext(new_node);
        this.tail.setPrev(new_node);
        this.nelems++;
        return true;

    }


    /**
     * Adds an element to a certain index in the list, shifting exist elements
     * create room. Does not accept null values.
     *
     * TODO: Javadoc comments
     */
    @Override
    public void add(int index, T element)
            throws IndexOutOfBoundsException, NullPointerException {

        if(element == null){
            throw new NullPointerException();
        }

        if(index < 0 || index > nelems){
            throw new IndexOutOfBoundsException();
        }

        Node new_node = new Node(element);
        Node prev_node = this.head;
        Node current_node = this.head.getNext();
        for(int i = 0; i < index;i++){
            prev_node = prev_node.getNext();
            current_node =current_node.getNext();
        }

        prev_node.setNext(new_node);
        current_node.setPrev(new_node);
        new_node.setPrev(prev_node);
        new_node.setNext(current_node);
        nelems++;
    }

    /**
     * Clear the linked list
     */
    @Override
    public void clear() {
        this.head.setNext(this.tail);
        this.tail.setPrev(this.head);
        this.nelems = 0;
    }

    /**
     * Determine if the list contains the data element anywhere in the list.
     *
     * TODO: Javadoc comments
     */
    @Override
    public boolean contains(Object element) {
        T data = (T)element;

        Node current_node = this.head.getNext();

        while(current_node.getNext() != null){
            if(current_node.getElement().equals(data)){
                return true;
            }
            current_node = current_node.getNext();
        }
        return false;
    }

    /**
     * Retrieves the element stored with a given index on the list.
     *
     * TODO: Javadoc comments
     */
    @Override
    public T get(int index) throws IndexOutOfBoundsException {
        if(index < 0 || index >= nelems){
            throw new IndexOutOfBoundsException();
        }

        Node index_node = getNth(index);

        // TODO: Fill in implementation to get the node at index
        return index_node.getElement();
    }

    /**
     * Helper method to get the Nth node in our list
     *
     * TODO: Javadoc comments
     */
    private Node getNth(int index) {
        Node current_node = this.head.getNext();

        for(int i = 0; i < index; i++) {
            current_node = current_node.getNext();
        }
        return current_node;
    }

    /**
     * Determine if the list empty
     *
     * @return true if empty, false if not empty
     */
    @Override
    public boolean isEmpty() {
        if(this.nelems == 0){
            return true;
        }
        else{
            return false;
        }
    }

    /**
     * Remove the element from position index in the list
     *
     * TODO: javadoc comments
     */
    @Override
    public T remove(int index) throws IndexOutOfBoundsException {
        // TODO: Fill in implementatio
        if(index < 0 || index >= nelems){
            throw new IndexOutOfBoundsException();
        }

        Node current_node = this.head.getNext();
        Node prev_node = this.head;

        for(int i = 0; i < index; i++) {
            current_node = current_node.getNext();
            prev_node = prev_node.getNext();
        }

        prev_node.setNext(current_node.getNext());
        current_node.getNext().setPrev(prev_node);
        this.nelems--;
        return current_node.getElement();
    }

    /**
     * Set the value of an element at a certain index in the list.
     *
     * TODO: javadoc comments
     */
    @Override
    public T set(int index, T element)
            throws IndexOutOfBoundsException, NullPointerException {
        // TODO: Fill in implmentation
        Node current_node = this.head.getNext();

        for(int i = 0; i < index; i++) {
            current_node = current_node.getNext();
        }

        T data = current_node.getElement();
        current_node.setElement(element);

        return data;
    }

    /**
     * Retrieves the amount of elements that are currently on the list.
     *
     * TODO: javadoc comments
     */
    @Override
    public int size() {
        return this.nelems;
    }

    /**
     * String representation of this list in the form of:
     * "[(head) -> elem1 -> elem2 -> ... -> elemN -> (tail)]"
     *
     * TODO: javadoc comments
     */
    @Override
    public String toString() {
        Node current_node = this.head.getNext();
        String contents = "[(head) -> ";

        while(current_node.getNext() != null){
            contents = contents.concat(current_node.getElement() + " -> " );
            current_node = current_node.getNext();
        }
        contents = contents.concat("(tail)]");

        return contents;
    }

    /* ==================== EXTRA CREDIT ==================== */

    /**
     * Remove nodes whose index is a multiple of base
     *
     * TODO: javadoc comments
     */
    public void removeMultipleOf(int base) {
        // TODO: complete implementation       
    }

    /**
     * Swap the nodes between index [0, splitIndex] of two lists
     *
     * TODO: javadoc comments
     */
    public void swapSegment(DoublyLinkedList other, int splitIndex) {
        // TODO: complete implementation
    }

}