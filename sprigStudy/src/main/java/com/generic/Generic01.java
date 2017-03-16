package com.generic;

/**
 * 验证多个限定类型参数的顺序
 * Created by weideliang on 2017/2/13.
 */
public class Generic01<T extends I1> {
    public static void main(String[] args) {
        Generic01<I11> i11Generic01 = new Generic01<>();
        Generic01<C11> c11Generic01 = new Generic01<>();
        System.out.println(i11Generic01);
        System.out.println(c11Generic01);
    }

}

class C1{

}

class C2{

}

interface I1{

}

interface I2{

}

interface I11 extends I1{}

class C11 implements I1{

}
