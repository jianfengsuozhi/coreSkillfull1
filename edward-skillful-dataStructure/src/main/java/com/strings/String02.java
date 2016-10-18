package com.strings;

/**
 * 计算部分匹配值
 * Created by weideliang on 2016/10/18.
 */
public class String02 {
    public static void main(String[] args) {
        String02 string02 = new String02();
        int[] abcdabds = string02.calPartMatch("abcdabd");
    }

    /**
     * 计算一个字符串的匹配值
     * @return
     */
    public int[] calPartMatch(String str){
        int[] ints = new int[str.length()];
        for(int i=0; i<str.length(); i++){
            int value = this.calSubPartMatch(str.substring(0, i + 1));
            ints[i] = value;
        }
        return ints;
    }
    /**
     * 计算一个子串的匹配值
     * @param str
     * @return
     */
    public static int calSubPartMatch(String str){
        //前缀
        String[] beforeSew = new String[str.length()-1];
        for (int i=0; i<str.length()-1; i++){
            beforeSew[i] = str.substring(0, i+1);
        }
        //后缀
        String[] afterSew = new String[str.length()-1];
        for(int i=0; i<str.length()-1; i++){
            afterSew[i] = str.substring(str.length()-1-i, str.length());
        }
        //比较
        for(int i=0; i<beforeSew.length; i++){
            if(beforeSew[i].equals(afterSew[i])){
                return beforeSew[i].length();
            }
        }
        return 0;//默认为0
    }


}
