package com.strings;

/**
 * 串的模式匹配：定位子串在主串的位置
 * 前缀：去掉最后一个字符 从前往后增加
 * 后缀：去掉第一个字符   从后往前增加
 * 部分匹配值：前后缀 交集 最长长度 如 ABCDABD 的部分匹配值：0000120
 * 移动位数：已匹配字符长度 - 对应的部分匹配值
 * Brute-Force：简单的遍历算法
 * Kmp算法：对遍历算法的优化
 *
 *
 * Created by weideliang on 2016/10/17.
 */
public class String01 {
    /**
     * Brute Force 算法
     * @return
     */
    public int index(String str,String pattern){
        int strLength = str.length();
        int patternLength = pattern.length();

        for(int i=0; i<=(strLength-patternLength); i++){//strLength-patternLength 防止k在增加时超过str的长度
            int k = i;//当相同时,继续进行
            for (int j=0; j<patternLength; j++){
                if(str.charAt(k) != pattern.charAt(j)){
                    break;
                }else {
                    k++;
                    if(j == (patternLength -1)){//结束条件
                        return i;
                    }
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        String01 string01 = new String01();
        System.out.println(string01.index("ababc", "abc"));
    }

}
