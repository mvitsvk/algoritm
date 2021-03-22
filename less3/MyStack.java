package ru.algoritm.less3;

import java.util.EmptyStackException;

public class MyStack<T> {
    private T[] list;
    private int size;
    private int capacity;
    private final int DEFAULT_CAPACITY = 10;

    public MyStack(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("capacity: " + capacity);
        }
        this.capacity = capacity;
        list = (T[]) new Object[capacity];
    }

    public MyStack() {
        this.capacity = DEFAULT_CAPACITY;
        list = (T[]) new Object[capacity];
    }

    public void push(T item) {
        if (isFull()) {
            //3*. Сделать возможность расширения внутреннего массива у стека и очереди.
            reCapacity(list.length*2);
        }
        list[size]= item;
        size++;
    }

    public T pop(){
        T temp = peek();
        size--;
        list[size]= null;
        return temp;
    }

    public T peek(){
        if (isEmpty()){
            throw new EmptyStackException();
        }
        return list[size-1];
    }


    public boolean isFull() {
        return size == list.length;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }


    //3*. Сделать возможность расширения внутреннего массива у стека и очереди.
    private void reCapacity(int newCapacity){
        T[] tempArr = (T[]) new Object[newCapacity];
        System.arraycopy(list, 0, tempArr, 0, size);
        list = tempArr;
    }
}
