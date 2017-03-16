package com.generic;

/**
 * 求字符串数组的最小值和最大值
 * Created by weideliang on 2017/2/14.
 */
public class PairTest01 {
    public static void main(String[] args) {
        String[] strArr = {"b","a","c"};
        Pair<String> stringPair = PairStringArr.minMax(strArr);
        System.out.println(stringPair.getFirst()+","+stringPair.getSecond());
    }

    /**
     * 求管理人员最大最小利润
     */
    public static void minMaxBonus(Manager[] managers,Pair<? extends Manager> result){
        if(managers == null || managers.length == 0){
            result = null;
            return;
        }
        Manager min = managers[0];
        Manager max = managers[0];
        for (int i=1; i<managers.length; i++){
            if(managers[i].getBonus().compareTo(min.getBonus()) < 0) min = managers[i];
            if(managers[i].getBonus().compareTo(max.getBonus()) > 0) max = managers[i];
        }
        result = new Pair<>(min, max);
        PairStringArr.swapHelper(result);
    }
}

class PairStringArr{
    public static <T extends Comparable> Pair<T> minMax(T[] arr){
        //特殊情况
        if(arr == null || arr.length == 0){
            return null;
        }
        //正常情况
        T min = arr[0];
        T max = arr[0];
        for(int i=1; i<arr.length; i++){
            if(arr[i].compareTo(min) < 0) min = arr[i];
            if(arr[i].compareTo(max) > 0) max = arr[i];
        }
        return new Pair(min, max);
    }

    public boolean hasNulls(Pair<?> pair){
        return pair.getFirst() == null || pair.getSecond() == null;
    }

    public static void swap(Pair<?> pair){
        PairStringArr.swapHelper(pair);
    }

    public static <T> void swapHelper(Pair<T> pair){
        T first = pair.getFirst();
        pair.setFirst(pair.getSecond());
        pair.setSecond(first);
    }
}

class Manager{
    private String name;
    private Double bonus;

    public Manager() {
    }

    public Manager(String name, Double bonus) {
        this.name = name;
        this.bonus = bonus;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getBonus() {
        return bonus;
    }

    public void setBonus(Double bonus) {
        this.bonus = bonus;
    }
}




