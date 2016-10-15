package com.stack;

/**
 * 栈的应用：递归 斐波那契数列的实现
 * Created by Edward on 2016/10/15.
 */
public class StackApplicatio01 {
    public int function(int n){
        if(1 == n || 2 == n){
            return 1;
        }
        return function(n - 1) + function(n - 2);
    }

    public static void main(String[] args) {
        StackApplicatio01 applicatio01 = new StackApplicatio01();
        System.out.println(applicatio01.function(9));
    }
}
