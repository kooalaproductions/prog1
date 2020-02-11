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
import java.util.NoSuchElementException;

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
        for(int i = highPriority; i < currentSize - 1; i++){
            array[i] = array[i + 1];
        }
        currentSize--;
        return highElement;//returns object of high priority and has been in the queue the longest
    }

    @Override
    public boolean delete(E obj) {
        if(isEmpty()){
            return false;
        }
        return false;
    }

    @Override
    public E peek() {//checks to see what object has the highest priority
        if(isEmpty()){
            return null;
        }

        int highPriority = 0;
        for(int i = 1; i < currentSize; i++){
            if(((Comparable<E>)array[i]).compareTo(array[highPriority]) > 0){
                highPriority = i;
            }
        }
        return array[highPriority];
    }

    @Override
    public boolean contains(E obj) {//checks to see if an object matches with the object parameter
        for(int i = 0; i < currentSize; i++){
            if (((Comparable<E>) obj).compareTo(((E) array[i])) == 0){
                return true;
            }
        }
        return false;
    }

    @Override
    public int size() {//returns the numbers of objects in queue
        return currentSize;
    }

    @Override
    public void clear() {//sets queue to empty
        currentSize = 0;
    }

    @Override
    public boolean isEmpty() {//checks to see if the queue is empty
        return currentSize == 0;
    }

    @Override
    public boolean isFull() {//checks to see if the queue is full
        return currentSize == maxSize;
    }

    @Override
    public Iterator<E> iterator() {//returns objects unsorted
        return new Iterator<E>(){
            private int counter = 0;
            private int iteratorIndex = 0;

            public boolean hasNext(){
                return counter < currentSize;
            }

            public E next(){
                if(!hasNext()){
                    throw new NoSuchElementException();
                }

                iteratorIndex = counter;
                counter++;
                return array[counter - 1];
            }

            public void remove(){
                if(iteratorIndex != counter)
                    counter--;

                for(int i = counter; i < currentSize - 1; i++){
                    array[i] = array[i + 1];
                }
                currentSize--;
            }
        };
    }


    }
