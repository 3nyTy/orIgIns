package com.ExcHAnd;

public class TestFinalRet {

	public static void main(String[] args) {
		
		int i=2;
		System.out.println(callMeth(i));
		
		
		
	}

	private static int  callMeth(int i) {
		int y=0;
		try{
			System.out.println("Inside try...");
			y=i/0;
			System.out.println(y);
		}
	/*catch(Exception e){
		y = 3;
			System.out.println("Inside catch...");
			return 2;
		}*/
		finally{
			System.out.println("Inside finally..."+y);
			return 3;
		}
		//return 0;
	}
	
	
}
