package com.designMode;

/**
 * 单一职责:难点职责扩散
 * Created by weideliang on 2016/11/22.
 */
public class Client {
    public static void main(String[] args){
        Animal animal = new Animal();
        animal.breathe("牛");
        animal.breathe("羊");
        animal.breathe("猪");
    }
}

class Animal{
    public void breathe(String animal){
        System.out.println(animal+"呼吸空气");
    }
}