package lesson6;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        MyTreeMap<Integer, Integer> map = new MyTreeMap<>();

        Random rand = new Random();

        for (int i = 0; i < 100; i++) {
            int r= (rand.nextInt(200)-100);
            map.put(r, i);
        }


        System.out.println("L=" + map.getLeftLen());
        System.out.println("R=" + map.getRigthLen());

        System.out.println("BALANCE:" + map.isBalance());


        System.out.println(map);
    }
}
