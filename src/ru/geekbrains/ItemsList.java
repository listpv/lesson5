package ru.geekbrains;

import java.util.*;

public class ItemsList {

    private Map<Double, Double> originItems;                // оригинальный список вещей.
    private Map<Double, Double> finalItems;                 // список  вещей в рюкзаке.
    private Map<Double,Double> sortedItems;                 // отсортированный список вещей по ценности предметов (цена/вес).
    private Double[] array;                                 // вспомогательный массив для коэффициентов ценности.

    public ItemsList(Map<Double, Double> originItems) {
        this.originItems = originItems;
        this.finalItems = new HashMap<>();
        this.sortedItems = new TreeMap<>(Collections.reverseOrder());
    }


    public void basicTask(Double tempCap){

        System.out.println("Оригинальный список предметов :");
        for (Map.Entry<Double, Double> o : originItems.entrySet()){
            System.out.println(o.getKey() + "  " + o.getValue());
        }

        for (Map.Entry<Double, Double> o : originItems.entrySet()){
            sortedItems.put(o.getKey()/o.getValue(), o.getKey() );
        }

        System.out.println("Отсортированный список вещей по ценности предметов (цена/вес) :");
        for (Map.Entry<Double, Double> o : sortedItems.entrySet()){
            System.out.println(o.getKey() + "  " + o.getValue());
        }

        Set<Double> set = sortedItems.keySet();
        array = set.toArray(new Double[set.size()]);

        recTask(tempCap, 0);

        System.out.println("Список предметов в рюкзаке :");
        for (Map.Entry<Double, Double> o : finalItems.entrySet()){
            System.out.println(o.getKey() + "  " + o.getValue());
        }

    }


    public int recTask(Double cap, int tempI){

        for(int i = tempI; i < array.length; i++){
            Double tempWeight = originItems.get(sortedItems.get(array[i]));
            if(tempWeight <= cap){
                finalItems.put(sortedItems.get(array[i]), tempWeight);
                return recTask((cap - tempWeight), ++tempI);
            }
        }
        return -1;
    }




////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//    public int rec1(Double cap){
//        for(Map.Entry<Double, Double> o : mapOrigin.entrySet()){
//            Double tempWeight = mapBag.get(o.getValue());
//            if(tempWeight <= cap){
//                finMap.put(o.getValue(), tempWeight);
//                return rec1((cap - tempWeight));
//            }
//            break;
//        }
//        return -1;
//    }


}
