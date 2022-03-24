package com.sist.web;

public class MainClass {
	
	public static void main(String[] args) {
		MyDAO dao=new MyDAO();//스프링 => Container에서 해준다(메모리 할당 = 필요시마다 주소를 얻어서 처리)
		System.out.println("=== select() call ===");
		dao.select();
		System.out.println("=== insert() call ===");
		dao.insert();
		System.out.println("=== update() call ===");
		dao.update();
		System.out.println("=== delete() call ===");
		dao.delete();
		System.out.println("=== find() call ===");
		dao.find();
	}
}
