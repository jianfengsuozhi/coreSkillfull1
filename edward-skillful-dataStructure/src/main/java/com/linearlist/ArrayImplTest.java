package com.linearlist;

/**
 * Created by weideliang on 2016/10/12.
 */
public class ArrayImplTest {
    public static void main(String[] args) {
        Array<String> array = new ArrayImpl<String>();
        array.append("add1");
        array.append("add2");
        array.append("add3");
        array.append("add4");

        array.insert(1,"moveAdd2");

//        array.delete(1);
        System.out.println(array);

//        for(int i = 0; i < array.length(); i++){
//            System.out.println(array.get(i));
//        }
//        System.out.println(array.set(1,"修改add1"));
//        System.out.println(array.get(1));
//        array.clear();
    }
}
