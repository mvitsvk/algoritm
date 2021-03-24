package ru.algoritm.less3;

import java.util.EmptyStackException;

public class MyDeka<T> {
    private T[] list;
    private int sizeL;
    private int sizeR;
    private int size;
    private int capacity;
    private final int DEFAULT_CAPACITY = 10;

    public MyDeka(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("capacity: " + capacity);
        }
        this.capacity = capacity;
        list = (T[]) new Object[capacity];
    }

    public MyDeka() {
        this.capacity = DEFAULT_CAPACITY;
        list = (T[]) new Object[capacity];
    }

    public void insertLeft(T item) throws IllegalStateException {
        if (isFull()) {
            throw new IllegalStateException("DQ is fool");
        }
        size++;
        moveI('L', item);

    }

    private void moveI(Character status, T item){
    if (status == 'L'){
        for (int i = 0; i < list.length; i++) {
            if (list[i] == null){
                for (int j = i; j > 0; j--) {
                    list[j] = list[j-1];
                }
                list[0] = item;
                break;
            }
        }
    } else {
        for (int i = list.length-1; i > 0; i--) {
            if (list[i] == null){
                for (int j = i; j < list.length-1; j++) {
                    list[j] = list[j+1];
                }
                list[list.length-1] = item;
                break;
            }
        }
    }
    }

    public void insertRight(T item) throws IllegalStateException {
        if (isFull()) {
            throw new IllegalStateException("DQ is fool");
        }
        size++;
        moveI('R', item);
    }

    public T removeLeft(){
        size--;
        return moveRE('L');
    }

    public T removeRight(){
        size--;
        return moveRE('R');
    }

    public T moveRE(Character status){
        if (status == 'L'){
            for (int i = 0; i < list.length; i++) {
                if (list[i] != null){
                    T temp = list[i];
                    list[i] = null;
                    return temp;
                }
            }
        } else {
            for (int i = list.length-1; i > 0; i--) {
                if (list[i] != null){
                    T temp = list[i];
                    list[i] = null;
                    return temp;
                }
            }
        }
      return null;
    }

    public boolean isFull() {
        return size == list.length;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[ ");
        for (int i = 0; i < list.length; i++) {
                sb.append(list[i]).append(", ");
            }
            sb.setLength(sb.length() - 2);
        sb.append(" ]");
        return sb.toString();
    }
}
