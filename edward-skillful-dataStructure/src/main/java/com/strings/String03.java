package com.strings;

/**
 * 计算kmp算法
 * Created by weideliang on 2016/10/18.
 */
public class String03 {

    public int index(String str,String pattern){
        int strLength = str.length();
        int patternLength = pattern.length();
        int i = 0;
        for(; i<=(strLength-patternLength); ){//strLength-patternLength 防止k在增加时超过str的长度
            int k = i;//当相同时,继续进行
            for (int j=0; j<patternLength; j++){
                if(str.charAt(k) != pattern.charAt(j)){
                    //计算子串的匹配值
                    String substring = pattern.substring(0, j);
                    int subMatchvalue = String02.calSubPartMatch(substring);
                    //计算位数
                    int moveDigit = substring.length() - subMatchvalue;
                    //移动
                    i += moveDigit;
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
        String03 string03 = new String03();
        int abcdabd = string03.index("abc", "bc");
        System.out.println(abcdabd);
    }
}
