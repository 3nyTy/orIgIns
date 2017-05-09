package com.WM;

import java.util.Iterator;
import java.util.LinkedList;

public class Graph {
	private int V;
	private LinkedList<Integer> a[];
	Graph(int v){
		 V=v;
		a = new LinkedList[v];
		for(int i=0;i<v;i++){
			a[i] = new LinkedList<Integer>();
		}
	}

	void addEdge(int x,int y){
		a[x].add(y);
		
	}
	
	 void DFS(int i) {
		boolean visited[] = new boolean[V];
		 DFSUtil(i,visited);
		 
	}
	 void DFSUtil(int elem, boolean[] visited) {
		visited[elem] = true;
		//System.out.print(elem+" ");
		Iterator<Integer> itr = a[elem].iterator();
		while(itr.hasNext()){
			int next=itr.next();
			if(!visited[next]){
				System.out.println(next + " ,Boolean val : "+visited[next]);
				DFSUtil(next,visited);
			}
		}
		
	}

	public static void main(String[] args) {
	Graph test = new Graph(4);
	test.addEdge(0, 1);
	test.addEdge(0, 2);
	test.addEdge(1, 2);
	test.addEdge(2, 0);
	test.addEdge(2, 3);
	test.addEdge(3, 3);
	test.DFS(2);
	}

	
}
