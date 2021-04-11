package lesson8;

import java.util.Random;

public class Main {
    static Random random;
    public static void main(String[] args) {
        random = new Random();
        ChainingHashMap<Integer, String> chm= new ChainingHashMap<>(7);

        for (int i = 0; i < 12; i++) {
            chm.put(random.nextInt(100), "V="+i);
        }

        chm.put(13, "VVV");
        chm.put(11, "VVVP");

        System.out.println(chm);

        System.out.println(chm.size());
        chm.del(11);
        System.out.println(chm.size());
        System.out.println(chm);

        LinearProbingHashMap<Integer, String> lphm = new LinearProbingHashMap<>(10);
        lphm.put(1, "one");
        lphm.put(2, "two");
        lphm.put(3, "three");
        lphm.put(2, "twosdfsdf");
        System.out.println(lphm);
        lphm.del(2);
        System.out.println(lphm);

    }
}
