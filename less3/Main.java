package ru.algoritm.less3;

public class Main {
    public static void main(String[] args) {

        //1. Создать программу, которая переворачивает вводимые строки (читает справа налево).
        //3*. Сделать возможность расширения внутреннего массива у стека и очереди.
//        MyStack<Character> myStack = new MyStack<>();
//        String str = "To mark the UK day of reflection next Tuesday on the anniversary of the first national lockdown, the Duke of Sussex has written the foreword for Hospital by the Hill, a book project from the Hampshire child bereavement support charity, Simon Says.";
//        for (int i = 0; i < str.length(); i++) {
//            myStack.push(str.charAt(i));
//        }
//        System.out.println("Stack size=" + myStack.size());
//        StringBuilder sb = new StringBuilder();
//        int fori = myStack.size();
//        for (int i = 0; i < fori; i++) {
//            sb.append(myStack.pop());
//        }
//        System.out.println(sb.toString());


        //3*. Сделать возможность расширения внутреннего массива у стека и очереди.
//        MyQueue<Integer> myQueue = new MyQueue<>();
//
//        System.out.println("insert i*10");
//        for (int i = 0; i < 15; i++) {
//            myQueue.insert(i*10);
//        }
//        System.out.println("size="+ myQueue.size());
//        System.out.println(myQueue);
//
//        System.out.println("remove");
//        for (int i = 0; i < 5; i++) {
//            System.out.println(myQueue.remove());
//        }
//
//        System.out.println("size="+ myQueue.size());
//        System.out.println(myQueue);
//
//        System.out.println("insert i*10+1");
//        for (int i = 0; i < 15; i++) {
//            myQueue.insert(i*10+1);
//        }
//
//        System.out.println("size="+ myQueue.size());
//        System.out.println(myQueue);
//
//        System.out.println("remove");
//        for (int i = 0; i < 5; i++) {
//            System.out.println(myQueue.remove());
//        }
//
//        System.out.println("size="+ myQueue.size());
//        System.out.println(myQueue);

        //2. Создать класс для реализации ДЕКА.

//        расширять уже не стал реализовывать
//                хотя можно было по принципу простого копирования
//                т.к. я исрользовал принцип размещения через
//                смещение элементов.

        MyDeka<String> dq = new MyDeka(5);
        dq.insertLeft("left1");
        System.out.println(dq.toString());
        dq.insertLeft("left2");
        System.out.println(dq.toString());
        dq.insertRight("Rigth1");
        System.out.println(dq.toString());
        dq.insertRight("Rigth2");
        System.out.println(dq.toString());
        dq.insertRight("Rigth3");
        System.out.println(dq.toString());

        System.out.println(dq.removeLeft());
        System.out.println(dq.removeLeft());
        System.out.println(dq.removeLeft());
        System.out.println(dq.removeLeft());

        System.out.println(dq.toString());

    }
}
