package com.Inheritance;

public class Test {
	public static void main(String[] args) {
		
		Parent p=new Child("");
		p.method1();
		//p.method2();
		((Child)p).method2();
		System.out.println(p.a);
		
		Child c= new Child("");
		((Parent)c).method3();
		System.out.println(c.a);
		System.out.println("********************");
		Parent p1 = new Parent();
		Child c1=new Child("");
		p1=c1;
		p1.method1();
		((Child)p1).method2();
		System.out.println(c1.a);
		
		
		
	}

}


class Parent{
	
	
	 int a=20;
	Parent(){
		System.out.println("Inside Parent Constructor");
	}
	void method1(){
		System.out.println("Inside method of Parent");
	}
	void method3(){
		System.out.println("Inside method of Parent 3");
	}
}


class Child extends Parent{
	
	Child(){
		a=40;
		System.out.println("Inside Child Constructor");
	}
	
	Child(String s){
		System.out.println("Inside child constructor "+s);
	}
	
	void method1(){
		a=40;
		System.out.println("Inside method of overriden method");
	}
	void method2(){
		a=40;
		System.out.println("Inside method of child method");
	}
	
}