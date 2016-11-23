package com.designMode;

/**
 * 违反代码级别的单一职责
 * Created by weideliang on 2016/11/22.
 */
public class Client02 {
    public static void main(String[] args){
        Animal02 animal = new Animal02();
        animal.breathe("牛");
        animal.breathe("羊");
        animal.breathe("猪");
        animal.breathe("鱼");
    }

}
class Animal02{
    public void breathe(String animal){
        if("鱼".equals(animal)){
            System.out.println(animal+"呼吸水");
        }else{
            System.out.println(animal+"呼吸空气");
        }
    }
}