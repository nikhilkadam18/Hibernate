package com.buildertest;

public class Test {
	public static void main(String[] args) {
		
		//C c = new C();

   int test = C.cClassMethod().bClassMethod().aClassMethod();//Builder design pattern
   System.out.println(test);
}
}
