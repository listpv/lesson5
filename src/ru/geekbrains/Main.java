package ru.geekbrains;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
	// write your code here

        System.out.println("1-ое задание");
        System.out.println(exponent(-5, 4));

        System.out.println("2-ое задание");
        Map<Double, Double> map = new HashMap<>();
        map.put(1.0, 50.0);
        map.put(2.0, 60.0);
        map.put(3.0, 70.0);
        map.put(4.0, 80.0);

        Double capacity = 130.0;

        ItemsList itemsList = new ItemsList(map);
        itemsList.basicTask(capacity);
    }

    public static int exponent(int n, int degree){
        if(degree <= 0){
            return 1;
        }
        return n * exponent(n, --degree);
    }

}
