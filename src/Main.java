package ru.algoritm.lesson4;

import java.util.ListIterator;

public class Main {
    public static void main(String[] args) {
//        MyLinkedList<String> mll = new MyLinkedList<>();
//        mll.insertFirst("one");
//        mll.insertFirst("two");
//        mll.insertFirst("three");
//        mll.insertFirst("four");
//
//
//        ListIterator<String> li = mll.listiterator();
//        while(li.hasNext()){
//            //if (li.next().equals("two")) li.remove();
//            if (li.next().equals("three")) li.add("three2");
//        }
//
//        ListIterator<String> li2 = mll.listiterator();
//        while(li2.hasNext()){
//            System.out.println(li2.next());
//        }
//
//        while(li.hasPrevious()){
//            System.out.println(li.previous());
//        }

        MyStack2 <String> st = new MyStack2<>();

        st.push("q1");
        st.push("q2");
        st.push("q3");
        st.push("q4");

        int size = st.getSize();
        for (int i = 0; i < size; i++) {
            System.out.println(st.pop());
        }

        System.out.println(st.pop());

        /**
         * result
         * q4
         * q3
         * q2
         * q1
         * null
         * */

        MyQueue2<String> st2 = new MyQueue2<>();
        st2.insert("QE1");
        st2.insert("QE2");
        st2.insert("QE3");
        st2.insert("QE4");
        st2.insert("QE5");
        st2.insert("QE6");
        st2.insert("QE7");

        int size2 = st2.getSize();
        for (int i = 0; i < size2; i++) {
            System.out.println(st2.remove());
        }

        System.out.println(st2.remove());

        /**result
         * QE1
         * QE2
         * QE3
         * QE4
         * QE5
         * QE6
         * QE7
         * null
         *
         * */

    }
}
