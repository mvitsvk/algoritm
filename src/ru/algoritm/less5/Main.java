package ru.algoritm.less5;

import javax.imageio.spi.ImageInputStreamSpi;
import java.util.*;

public class Main {

    private static float REQUIRED_WEIGHT = 10f; //вес
    private static int MAX_EQUIP_COUNT = 13; //максимальное число предметов
    private static int TOTAL_EQUIP_COUNT = 26;//общее чсило предметов
    private static float epsilon = 0.1f;//точность.



    public static void main(String[] args) {
	// write your code here
        System.out.println(toStep(3,9));


        //Создаем массив весов
        float[] weights = new float[TOTAL_EQUIP_COUNT];
        Random random = new Random();
        for (int i = 0; i < weights.length; i++) {
            weights[i] = random.nextInt(20000) / 1000f;
        }
        System.out.println(Arrays.toString(weights)); //выводим массив весов
        //создаем список, в который будем складывать индексы весов, которые участвуют в текущем наборе
        ArrayList<Integer> indices = new ArrayList<>();
        //запускаем подбор
        recursive(weights, indices);

    }

    //1. Написать программу по возведению числа в степень с помощью рекурсии.
    public static double toStep (double num, int step){
        if (step == 1) return num;
        return num * toStep(num, step -1);
    }

    //2. Написать программу "Задача о рюкзаке" с помощью рекурсии.
    //каждый раз запуская эту функцию она увеличивает линну списка индексов на 1, подставляя все возможные элементы на последнее место, и, если какие-то из вариантов подходят - выводит их.
    private static void recursive(float[] weights, ArrayList<Integer> indices) {
        //если число индексов перевалило за предел - прерываемся
        if (indices.size() > MAX_EQUIP_COUNT)
            return;
        //если в текущем наборе ничего нет, то начинаем перебор с 0
        int i = 0;
        if (indices.size() > 0)
            //если ест, то берем последний индекс в списке и начинаем перебирать со следующего(+1)
            i = indices.get(indices.size() - 1) + 1;
        //i объявили выше, поэтому между открывающейся скобкой и ; ничего нет
        for (; i < weights.length; i++) {
            //добавляем к списку новый элемент и считаем сумму всех весов, попавших в список
            indices.add(i);
            float sum = 0;
            for (Integer index : indices) {
                sum += weights[index];
            }
            //считаем разницу между нужной массой и имеющейся. Берем от результата модуль. Если этот модуль меньше epsilon, то наша сумма оооочень близко к нужной, считаем что этого достаточно и мы подобрали нужный результат
            if (Math.abs(sum - REQUIRED_WEIGHT) < epsilon) {
                StringBuilder s = new StringBuilder();
                s.append(weights[indices.get(0)]);
                for(int j = 1; j < indices.size(); j++){
                    s.append(", ").append(weights[indices.get(j)]);
                }
                System.out.println("Подходящая сумма: " + s.toString());
            } else if (sum < REQUIRED_WEIGHT) {
                //если сумма не подобралась - увеличиваем длинну списка индексов на 1
                recursive(weights, indices);
            }
            //в конце удаляем последний элемент, это тот элемент, который мы добавили в начале цикла
            indices.remove(indices.size() - 1);
        }
    }


}
