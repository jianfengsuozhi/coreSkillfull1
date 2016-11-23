package com.designMode;

/**
 * 保证了类单一职责,但修改花销很大:类分解和修改客户端
 * Created by weideliang on 2016/11/22.
 */
public class Client01 {
    public static void main(String[] args){
        Terrestrial terrestrial = new Terrestrial();
        terrestrial.breathe("牛");
        terrestrial.breathe("羊");
        terrestrial.breathe("猪");

        Aquatic aquatic = new Aquatic();
        aquatic.breathe("鱼");
    }
}

class Terrestrial{
    public void breathe(String animal){
        System.out.println(animal+"呼吸空气");
    }
}
class Aquatic{
    public void breathe(String animal){
        System.out.println(animal+"呼吸水");
    }
}
