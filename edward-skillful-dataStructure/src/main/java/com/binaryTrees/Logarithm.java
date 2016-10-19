package com.binaryTrees;

/**
 * 对数
 * Created by weideliang on 2016/10/19.
 */
public class Logarithm {
    /**
     *
     * @param value
     * @param base 基数
     * @return
     */
    public static int log(int value,int base){
        return (int) (Math.log(value) / Math.log(base));
    }

    public static void main(String[] args) {
        int log = Logarithm.log(100, 10);//2
    }
}
