package ru.algoritm.less3;

import java.util.NoSuchElementException;

public class MyQueue<T> {
    private T[] list;
    private int size;
    private int capacity;
    private final int DEFAULT_CAPACITY = 10;
    private int begin;
    private int end;

    public MyQueue(int capacity) throws IllegalArgumentException {
        if (capacity <= 0) {
            throw new IllegalArgumentException("capacity: " + capacity);
        }
        this.capacity = capacity;
        list = (T[]) new Object[capacity];
    }

    public MyQueue() {
        this.capacity = DEFAULT_CAPACITY;
        list = (T[]) new Object[capacity];
    }

    public void insert(T item) throws IllegalStateException {
        if (isFull()) {
            reCapacity(list.length*2);
        }
        size++;
        list[end] = item;
        end = nextIndex(end);
    }

    public T peekFront() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return list[begin];
    }

    public T remove() {
            T temp = peekFront();
            size--;
            list[begin] = null;
            begin = nextIndex(begin);
            return temp;
        }

    public boolean isFull() {
        return size == list.length-1;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    private int nextIndex(int index) {
        return (index + 1) % list.length;
    }

    //победил расширение
    //пока визуально не разрисовал
    //не мог понять где и что вылавливать
    private void reCapacity(int newCapacity){
        T[] tempArr = (T[]) new Object[newCapacity];
        //System.out.println("reCapacity BEGIN"+toString());
        if (begin > 0) {
            int j = 0;
            for (int i = begin; i < list.length; i++) {
                if (list[i] != null) {
                    tempArr[j] = list[i];
                    j++;
                }
            }
            begin = 0;
            for (int i = 0; i < end; i++) {
                tempArr[j] = list[i];
                j++;
            }
            end = j;
        } else System.arraycopy(list, 0, tempArr, 0, list.length);
        list = tempArr;
        //System.out.println("reCapacity END"+toString());
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[ ");
        for (int i = 0; i < list.length; i++) {
            if (begin == i) {
                sb.append("B"+list[i]).append(", ");
            } else if (end == i) {
                sb.append("N"+list[i]).append(", ");
            } else {
                sb.append(list[i]).append(", ");
            }
        }
        if (size > 0) {
            sb.setLength(sb.length() - 2);
        }
        sb.append(" ]");
        sb.append(" begin="+begin+" end="+end);
        return sb.toString();
    }
}
