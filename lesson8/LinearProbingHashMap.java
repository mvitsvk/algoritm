package lesson8;

import java.util.Arrays;

public class LinearProbingHashMap<Key, Value> {
    private int capacity;
    private int size;
    //private final Object DELETED;

    private Key[] keys;
    private Value[] values;

    public LinearProbingHashMap(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException();
        }
        this.capacity = capacity;
        keys = (Key[]) new Object[capacity];
        values = (Value[]) new Object[capacity];
//        DELETED = new Object();
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

    private int hash2(Key key) {
        return 7 - Math.abs(key.hashCode() % 7);
    }

    private void checkKeyNotNull(Key key) {
        if (key == null) {
            throw new IllegalArgumentException();
        }
    }

    public void put(Key key, Value value){
        // проверка на прввышение лоад фактора. Либо просаем эксепшн либо
        // перехиширование на массив размером больше, но простое число
        checkKeyNotNull(key);
        int i = hash(key);
        int step = 1;
        while (keys[i] != null){
            if(keys[i].equals(key)){
                values[i]= value;
                return;
            }
            i = (i+step) % capacity;
        }
        keys[i] = key;
        values[i] = value;
        size++;
    }

    public Value get(Key key){
        checkKeyNotNull(key);
        int i = hash(key);
        int step = 1;

        while (keys[i] != null){
            if(keys[i].equals(key)){
                return values[i];
            }
            i = (i+step) % capacity;
        }
        return null;
    }

//и тут я не понял зачем создавать некий ДЕЛЕТЕД
//    ключ уникален
//    значит если есть ключ то в данной конструкции
//    должно быть только одно место в которое можно вставить
//    значение, даже если это значение будет со смещением
//    Мы так ищем ГЕТ
//    и кто мне тогад мешает за НУЛЛ-ить ключ и значение...
    public void del(Key key){
        checkKeyNotNull(key);
        int i = hash(key);
        int step = 1;

        while (keys[i] != null){
            if(keys[i].equals(key)){
                keys[i]=null;
                values[i]=null;
                size--;
                return;
            }
            i = (i+step) % capacity;
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("|");
        for (int i = 0; i < capacity; i++) {
                sb.append(keys[i]).append(" ").append(values[i]).append("|");
        }
        return sb.toString();
    }
}
