package com.designMode;

/**
 * 违反方法级别单一职责
 * Created by weideliang on 2016/11/22.
 */
public class Client03 {
    public static void main(String[] args){
        Animal03 animal = new Animal03();
        animal.breathe("牛");
        animal.breathe("羊");
        animal.breathe("猪");
        animal.breathe2("鱼");
    }
}
class Animal03{
    public void breathe(String animal){
        System.out.println(animal+"呼吸空气");
    }

    public void breathe2(String animal){
        System.out.println(animal+"呼吸水");
    }
}
