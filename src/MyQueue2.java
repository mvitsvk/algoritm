package ru.algoritm.lesson4;

import java.util.NoSuchElementException;

public class MyQueue2<T> {
        private MyLinkedList<T> list;
        private int size;

        public MyQueue2() {
            list = new MyLinkedList<>();
        }

        public void insert(T item){
            size++;
            list.insertFirst(item);
        }

        public T remove() {
            if (isEmpty()){
                return null;
            }
            size--;
            return list.removeLast();
        }

        public boolean isEmpty() {
            return size == 0;
        }

        public int getSize() {
            return size;
        }

}
