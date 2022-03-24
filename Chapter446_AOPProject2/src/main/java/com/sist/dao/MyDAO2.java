package com.sist.dao;

import org.springframework.stereotype.Component;
import java.util.*;
@Component
public class MyDAO2 {
	public void display()
	{
		int a=10/0;
		System.out.println(a);
	}
}
