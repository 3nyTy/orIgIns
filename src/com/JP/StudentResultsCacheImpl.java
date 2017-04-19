package com.JP;

import java.util.TreeMap;

public class StudentResultsCacheImpl implements StudentResultsCache {
	private static StudentResultsCacheImpl stuImpl=null;
	private final static int cachesize=3;
	private static DoublyLinkedList studentList = new DoublyLinkedList(cachesize);
	private TreeMap<Integer,Node> stuMap = new TreeMap<Integer,Node>();
	
	private StudentResultsCacheImpl(){};
	
	public static StudentResultsCacheImpl getInstance(){
		if(stuImpl == null){
			 stuImpl = new StudentResultsCacheImpl();
		}
		return stuImpl;
		
	}

	@Override
	public void addCache(Student std) {
		Node stuNode=null;
		int keyM = std.getRank();
		if(stuMap.containsKey(keyM)){
			
			stuNode= stuMap.get(keyM);
			studentList.moveNodeToHead(stuNode);
		}
		else{
		stuMap.put(std.getRank(),new Node(std));
		studentList.addStuObjToList(std);
		}
		
		
	}

	
	public void printCacheState() {
		studentList.printList();
        System.out.println();
    }
	@Override
	public Student readFromCache(int rank) {	
		return stuMap.get(rank).getStuObj();
	}

	@Override
	public void removeFromCache(int rank) {
	
	}

}
