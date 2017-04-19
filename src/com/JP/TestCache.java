package com.JP;

public class TestCache {
public static void main(String[] args) {
	
	StudentResultsCacheImpl cacheImpl = StudentResultsCacheImpl.getInstance() ;
	
	cacheImpl.addCache(new Student(1,"Gowri",430,60));
	//cacheImpl.printCacheState();
	
	cacheImpl.addCache(new Student(2,"RC",430,60));
	cacheImpl.addCache(new Student(3,"Roop",450,70));
	cacheImpl.addCache(new Student(1,"GowriP",430,60));
	cacheImpl.addCache(new Student(4,"Chand",420,50));
	cacheImpl.addCache(new Student(5,"GowriOUY",430,60));
	//cacheImpl.addCache(new Student(6,"GowriOUY",430,60));
	//Student stu1=cacheImpl.readFromCache(1);
	//Student stu2=cacheImpl.readFromCache(2);
//	System.out.println(stu1);
//	System.out.println(stu2);
	cacheImpl.printCacheState();
}
}
