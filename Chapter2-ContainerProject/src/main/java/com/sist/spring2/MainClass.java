package com.sist.spring2;

public class MainClass {
	public static void main(String[] args) {
		Hello h=new HelloImple();
		String msg=h.sayHello("박문수");
		System.out.println(msg);
	}
}
