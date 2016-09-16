package com.test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Test02 {
	public static void main(String[] args) {
		List<Integer> list = new LinkedList<Integer>();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(5);
		list.add(9);
		list.add(10);
		f(list);
	}
	
	public static void f(List<Integer> list){
		String result = "";
		int begin = 0;
		int end = 0;
		String symbol = null;
		for (int i = 0; i <list.size()-1; i++) {
			if(!"-".equals(symbol)){
				begin = list.get(i);
				if(list.get(i+1) - begin ==1){
					symbol = "-";
					end = list.get(i+1);
				}else{
					symbol = ",";
				}
				result +=(begin+symbol);
			}else{
				begin = list.get(i);
				if(list.get(i+1) - begin ==1){
					symbol = "-";
					end = list.get(i+1);
				}else{
					i--;
					symbol = null;
					begin = 0;
					end = 0;
				}
			}
		}
		result +=list.get(list.size()-1);
		System.out.println(result);
	}
}
