package com.proxy;
import java.lang.reflect.Method;
public class $SelfProxy1 implements com.proxy.Subject{
    public $SelfProxy1(SelfInvocationHandler h) {
        this.h = h;
    }
    com.proxy.SelfInvocationHandler h;
    @Override
    public  void targetMethod() {
        try {
        Method md = com.proxy.Subject.class.getMethod("targetMethod");
        h.invoke(this, md);
        }catch(Exception e) {e.printStackTrace();}
    }

}