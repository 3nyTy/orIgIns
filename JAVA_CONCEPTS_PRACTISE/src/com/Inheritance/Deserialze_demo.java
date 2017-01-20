package com.Inheritance;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class Deserialze_demo {
public static void main(String[] args) throws IOException {
	Emp e =null;
	
	FileInputStream input = new FileInputStream("D:/emp.ser");
	ObjectInputStream objIn=new ObjectInputStream(input);
	try {
		e=(Emp)objIn.readObject();
		objIn.close();
		input.close();
	} catch (ClassNotFoundException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
	  System.out.println("Deserialized Employee...");
      System.out.println("Name: " + e.name);
      System.out.println("Number: " + e.number);
     
}
}
