/**
 *  Program # 1
 *  Implement priority queue for an ordered array using FIFO.
 *  Prioritize by value and time of arrival.
 *  CS310
 *  Date: 2/20/2020
 *  @Autho: Ernesto Sanchez cssc1268
 */

package data_structures;

import java.util.Iterator;

public class OrderedArrayPriorityQueue <E extends Comparable<E>> implements PriorityQueue<E> {
    private E[] array;
    private int maxSize;
    private int currentSize;


    public OrderedArrayPriorityQueue(){//first constructor
        this(DEFAULT_MAX_CAPACITY);
    }

    public OrderedArrayPriorityQueue(int size){//second constructor
        maxSize = size;
        currentSize =0;
        array = (E[]) new Object[maxSize];
    }

    @Override
    public boolean insert(E object) {//insert object into queue
        if(isFull()) {//will check if full
            return false;
        }
        int num = 0;
        while(num < currentSize && ((Comparable<E>)array[num]).compareTo(object) <= 0){
            num++;
        }

        for(int curry = currentSize; curry > num; curry--){
            array[curry] = array[curry - 1];
        }
        array[num] = object;
        currentSize++;

        return true;
    }

    @Override
    public E remove() {
        if(isEmpty()){//returns null if empty
            return null;
        }
        int highPriority = 0;
        E highElement = array[0];

        for(int i = 1; i < currentSize; i++){
            if(((Comparable<E>)array[i]).compareTo(highElement) > 0){
                highPriority = i;
                highElement = array[i];
            }
        }

        for(int i = highPriority; i < currentSize - 1; i++){
            array[i] = array[i + 1];
        }
        currentSize--;

        return highElement;//returns object of high priority and has been in the queue the longest
    }

    @Override
    public boolean delete(E obj) {
        return false;
    }

    @Override
    public E peek() {//checks to see what object has the highest priority
        if(isEmpty()){//returns null if empty
            return null;
        }

        int highPriority = 0;
        for(int i = 1; i < currentSize; i++){
            if(((Comparable<E>)array[i]).compareTo(array[highPriority]) > 0){
                highPriority = i;
            }
        }
        return array[highPriority];//returns but does not remove
    }

    @Override
    public boolean contains(E obj) {//checks to see if an object matches with the object parameter
        for(int i = 0; i < currentSize; i++)
            if(((Comparable<E>) obj).compareTo(((E) array[i])) == 0)
                return true;
        return false;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public void clear() {

    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean isFull() {
        return false;
    }

    @Override
    public Iterator<E> iterator() {
        return null;
    }
}
