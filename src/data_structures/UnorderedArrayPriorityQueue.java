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

public class UnorderedArrayPriorityQueue <E> implements Comparable<E>, Iterable<E> {
    private E[] array;

    @Override
    public int compareTo(E o) {
        return 0;
    }

    @Override
    public Iterator<E> iterator() {
        return null;
    }
}
