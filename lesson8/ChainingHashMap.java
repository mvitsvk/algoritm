package lesson8;

import java.util.LinkedList;

public class ChainingHashMap<Key, Value> {
    private int capacity;
    private int size;

    private LinkedList<Node>[] st;

    public ChainingHashMap(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException();
        }
        this.capacity = capacity;
        st = new LinkedList[capacity];
        for (int i = 0; i < st.length; i++) {
            st[i] = new LinkedList<>();
        }
    }

    private class Node {
        Key key;
        Value value;

        public Node(Key key, Value value) {
            this.key = key;
            this.value = value;
        }
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private int hash(Key key) {
        return (key.hashCode() & 0x7fffffff) % capacity;
    }

    private void checkKeyNotNull(Key key) {
        if (key == null) {
            throw new IllegalArgumentException();
        }
    }

    public boolean contains(Key key) {
        return get(key) != null;
    }

    public void put(Key key, Value value) {
        checkKeyNotNull(key);
        int i = hash(key);
        for (Node node : st[i]) {
            if (key.equals(node.key)) {
                node.value = value;
                return;
            }
        }
        st[i].addLast(new Node(key, value));
        //st[i].removeIf()
        size++;
    }

    public void del(Key key) {
        checkKeyNotNull(key);
        int i = hash(key);
        //подумал что значений может быть больше
//        на удаление поэтому решил проверять
//                потом понял что это лишнее
//                все равно уникальный ключ только один
//                но решение оставил, чтобы можно было его задействовать
//                если вс-таки не прав
//        int sDo =st[i].size();
//        System.out.println("do="+sDo);
        st[i].removeIf(f->(key.equals(f.key)));
//        int sPo =st[i].size();
//        System.out.println("po="+sPo);
//        size=size-(sDo-sPo);
        size--;
    }

    public Value get(Key key) {
        checkKeyNotNull(key);
        int i = hash(key);
        for (Node node : st[i]) {
            if (key.equals(node.key)) {
                return node.value;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("|");
        for (int i = 0; i < capacity; i++) {
            for (Node node : st[i]) {
                sb.append(node.key).append(" ").append(node.value).append("|");
            }
            sb.append(System.lineSeparator());
        }

        return sb.toString();
    }

    //реализовать метод удаления.
}
