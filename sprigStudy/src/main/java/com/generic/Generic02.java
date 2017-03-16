package com.generic;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * 通配符的上下界
 * Created by weideliang on 2017/2/13.
 */
public class Generic02{
    public void setA(List<? super Son> list){
    }

    public void SetB(List<? extends Father> list){

    }

    public static void main(String[] args) {
        Generic02 generic02 = new Generic02();
/*        generic02.setA(Lists.newArrayList(new Father()));
        generic02.setA(Lists.newArrayList(new Son()));//下界*/

        generic02.SetB(Lists.newArrayList(new Father()));
        generic02.SetB(Lists.newArrayList(new Son()));//
    }

}

class Father{

}

class Son extends Father{

}

class Other{

}