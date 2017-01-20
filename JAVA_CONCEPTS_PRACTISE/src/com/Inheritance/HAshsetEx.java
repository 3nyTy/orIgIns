package com.Inheritance;

import java.util.HashSet;
import java.util.Iterator;

public class HAshsetEx {
public static void main(String[] args) {
	
	HashSet<Student> set=new HashSet<Student>();
	set.add(new Student("PI"));
	
	Student p1=new Student("PI");
	set.add(p1);
	
	Iterator itr=set.iterator();
	while(itr.hasNext()){
		System.out.println(((Student)itr.next()).getStr());
	}
	System.out.println("---------");
	HashSet<String> set2=new HashSet<String>();
	set2.add("P");
	set2.add("P");
	Iterator itr2=set2.iterator();
	while(itr2.hasNext()){
		System.out.println(itr2.next());
	}
	
	final Student s1Te=new Student("Gowri");
	System.out.println(s1Te.getStr());
	s1Te.setStr("GowrRoop");
	System.out.println("After changing :" +s1Te.getStr());
	
	p1=s1Te;

	System.out.println(p1.getStr());
	p1.setStr("Hello");
	System.out.println("After Change :" +s1Te.getStr() + " , "+p1.getStr());
	
	/*if(set.contains(p1)){
		System.out.println("Both are equal");
	}else{
		
		
	}*/
	
}
}

class Student{
	
	String str;
	
	Student(String str){
		this.str=str;
	}
	
	String getStr(){
		return str;
	}
	
	public void setStr(String str){
		this.str=str;
	}
	
	@Override
	public int hashCode() {
		
		return str.hashCode();
	}
	
	@Override
	public boolean equals(Object obj) {
		Student s=(Student)obj;
		return (this.str== s.str && this.str.equals(s.str));
	}
	
	
}
