package ru.algoritm.lesson4;

import java.util.EmptyStackException;

public class MyStack2<T> {
        private MyLinkedList<T> list;
        private int size;

        public MyStack2() {
            list = new MyLinkedList<>();
        }

        public void push(T item) {
            list.insertFirst(item);
            size++;
        }

        public T pop(){
            if (isEmpty()){
                return null;
            }
            size--;
            return list.removeFirst();
        }

        public boolean isEmpty() {
            return size == 0;
        }

        public int getSize() {
            return size;
        }

}
