package com.test;

import java.util.Date;

public class Test01 extends Date{
	public static void main(String[] args) {
//		String str = null;
//		Object obj = str;
//		if(obj instanceof String){
//			System.out.println("1");
//		}
	/*	Long l1 = 228l;
		Long l2 = 228l;
		//false 有时会为true
		System.out.println(l1 == l2);*/

/*	String[] str = {"1","0"};
	for(int i=0; i<str.length; i++){
		Integer s = Integer.parseInt(str[i]);
		if(s == 0){
			System.out.println("A");
		}
		if(s == 1){
			System.out.println("B");
		}
	}*/
		Test01 test01 = new Test01();
		test01.testSuper();
		System.out.println(test01.getClass().getSuperclass().getName());

	}
	public void testSuper(){
		System.out.println(super.getClass().getName());
	}

}



