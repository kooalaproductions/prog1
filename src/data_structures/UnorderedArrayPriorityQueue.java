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


    public UnorderedArrayPriorityQueue(){//first constructor
        this(DEFAULT_MAX_CAPACITY);
    }

    public UnorderedArrayPriorityQueue(int size){//second constructor
        maxSize = size;
    }


    @Override
    public boolean insert(E object) {
        return false;
    }

    @Override
    public E remove() {
        return null;
    }

    @Override
    public boolean delete(E obj) {
        return false;
    }

    @Override
    public E peek() {
        return null;
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
