package com.sort;

/**
 * 排序
 * Created by weideliang on 2016/10/24.
 */
public class Sort01 {
    /**
     * 冒泡排序：本质是按序交换 从小到大
     */
    public void bubbleSort(Integer[] arr,SortEnum sortEnum){

        for(int i=0; i<arr.length-1; i++){
            Boolean isContinue = false;
            for(int j=0; j<(arr.length-1-i); j++){
                if(SortEnum.FromMinToMax.equals(sortEnum)){ //从小到大排序
                    if(arr[j] > arr[j+1]){
                        this.swap(j,j+1,arr);
                        isContinue = true;
                    }
                }else {
                    if(arr[j] < arr[j+1]){ //从大到小排序
                        this.swap(j,j+1,arr);
                        isContinue = true;
                    }
                }
            }
            if(!isContinue){
                return;
            }
        }
    }

    /**
     * 交换
     * @param a
     * @param b
     * @param <T>
     */
    private <T> void swap(int a,int b,T[] arr){
        T tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }

    /**
     * 简单选择排序:最小值 从小到大排序
     */
    public void simpleSelectSort(Integer[] arr){
        for(int i=0; i<arr.length-1; i++){
            int min = i;
            for(int j=i+1; j<arr.length; j++){
                if(arr[min] > arr[j]){
                    min = j;
                }
            }
            if(min != i){
                this.swap(min,i,arr);
            }
        }
    }

    /**
     * 直接插入排序：如打扑克牌
     * @param arr
     */
    public void directInsertSort(Integer[] arr){
        int j;//位置
        int t;//待排序算法
        for(int i=1; i<arr.length; i++){
            if(arr[i] < arr[i-1]){
                t = arr[i];

            }
        }
    }

    public static void main(String[] args) {
        Sort01 sort01 = new Sort01();
        Integer[] p = { 5,6,4,1};

        //冒泡排序
//        sort01.bubbleSort(p,SortEnum.FromMinToMax);
//        sort01.bubbleSort(p,SortEnum.FromMinToMax);

        //选择排序
//        sort01.simpleSelectSort(p);



        for (int i : p) {
            System.out.println(i);
        }
    }
}
