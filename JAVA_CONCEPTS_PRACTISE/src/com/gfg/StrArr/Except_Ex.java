package com.gfg.StrArr;

import java.util.ArrayList;
import java.util.List;

public class Except_Ex {
	private static int count;
public static void main(String[] args) {
	try {
		count=1;
		add(1,2);
	} catch (RuntimeException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	List<? extends Object> al=new ArrayList<String>();
}

private static  void add(int i, int j)   {
	
	System.out.println("Not Startred");
	
}



}
