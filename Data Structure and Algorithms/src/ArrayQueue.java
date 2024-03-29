/* Implementation of the queue using a fixed-length array. */

import java.util.*;
public class ArrayQueue < E > {
    private E[] data; // generic array used for storage
    // constructors
    private int frontIndex;
    private int queueSize;

    public ArrayQueue(int capacity) { // constructs queue with given capacity
        data = (E[]) new Object[capacity]; // safe cast; compiler may give warning
        queueSize = 0; // current number of elements
        frontIndex = 0; // index of the front element


    }
    public ArrayQueue() {
        this(1000);
    } // constructs queue with default capacity

    // methods
    /* Returns the number of elements in the queue. */
    public int size() {
        return queueSize;
    }

    /* Tests whether the queue is empty. */
    public boolean isEmpty() {
        return (queueSize == 0);
    }

    /* Inserts an element at the rear of the queue. */
    public void enqueue(E e) throws IllegalStateException {
        if (queueSize == data.length) throw new IllegalStateException("Queue is full");
        int avail = (frontIndex + queueSize) % data.length; // use modular arithmetic
        data[avail] = e;
        queueSize++;
    }

    /* Returns, but does not remove, the first element of the queue (null if empty). */
    public E first() throws IllegalStateException {
        if (queueSize == data.length) throw new IllegalStateException("Queue is empty");
        return data[frontIndex];
    }

    /* Removes and returns the first element of the queue (null if empty). */
    public E dequeue() throws IllegalStateException {
        if (queueSize == data.length) throw new IllegalStateException("Queue is empty");
        E answer = data[frontIndex];
        data[frontIndex] = null; // dereference to help garbage collection
        frontIndex = (frontIndex + 1) % data.length;
        queueSize--;
        return answer;
    }

    public static void main(String[] args) {
        ArrayQueue queue = new ArrayQueue();
        queue.enqueue(18); //a
        System.out.println("Element at front :  " + queue.first()); //b
        System.out.println("Element removed from front : " + queue.dequeue()); //c
        System.out.println("Queue is Empty : " + queue.isEmpty()); //d
        queue.enqueue(79); //e
        queue.enqueue(90); //f
        System.out.println("Size of the queue : " + queue.size()); //g
        System.out.println("Element removed from front end : " + queue.dequeue());
        //h
    }
}

