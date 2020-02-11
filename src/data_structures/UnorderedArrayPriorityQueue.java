/**
 *  Program # 1
 *  Implement priority queue for an unordered array using FIFO.
 *  Prioritize by value and time of arrival.
 *  CS310
 *  Date: 2/20/2020
 *  @Autho: Ernesto Sanchez cssc1268
 */

package data_structures;

import java.util.Iterator;

public class UnorderedArrayPriorityQueue <E extends Comparable<E>> implements PriorityQueue<E> {
    private E[] array;
    private int maxSize;
    private int currentSize;


    public UnorderedArrayPriorityQueue(){//first constructor
        this(DEFAULT_MAX_CAPACITY);
    }

    public UnorderedArrayPriorityQueue(int size){//second constructor
        maxSize = size;
        currentSize =0;
        array = (E[]) new Object[maxSize];
    }


    @Override
    public boolean insert(E object) {
        if(isFull()){//will check if full
            return false;
        }
        array[currentSize++] = object;//if not full return true
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
        for(int i = highPriority; i < currentSize - 1; i++)
        {
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
        if(isEmpty()){
            return null;
        }

        int highPriority = 0;
        for(int i = 1; i < currentSize; i++)
        {
            if(((Comparable<E>)array[i]).compareTo(array[highPriority]) > 0)
            {
                highPriority = i;
            }
        }
        return array[highPriority];
    }

    @Override
    public boolean contains(E obj) {
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
