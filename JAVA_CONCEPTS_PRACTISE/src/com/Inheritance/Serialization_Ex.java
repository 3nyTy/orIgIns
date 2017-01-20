package com.Inheritance;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Serialization_Ex {
public static void main(String[] args) throws IOException {
	
	Emp e= new Emp();
	e.name="Gowri";
	e.number=99;
	try {
		FileOutputStream fileout=new FileOutputStream("D:/emp2.ser");
		ObjectOutputStream objOut = new ObjectOutputStream(fileout);
		try {
			objOut.writeObject(e);
			objOut.close();
			fileout.close();
			System.out.println("Object is serialozed  and saved in D:/emp.ser ");
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
	} catch (FileNotFoundException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
	
}
}

class Emp implements Serializable{
	
	 public String name;
	   public String address;
	   public int number;
	   public void mailCheck() {
		      System.out.println("Mailing a check to " + name + " " + address);
		   }
	
}
