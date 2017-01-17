package com.gowri.spring;

import java.util.List;

public class Triangle {

	Point pA;
	Point pB;
	List<Point> points;
		
	public Point getpA() {
		return pA;
	}


	public List<Point> getPoints() {
		return points;
	}


	public void setPoints(List<Point> points) {
		this.points = points;
	}


	public void setpA(Point pA) {
		this.pA = pA;
	}


	public Point getpB() {
		return pB;
	}


	public void setpB(Point pB) {
		this.pB = pB;
	}


	public void draw(){
		//System.out.println("Triangle of type - " + getType() + " of height -" + getHeight());
		/*System.out.println("The two points are :" );
		System.out.println("first-"+ getpA().getX() + " "+getpA().getY() );
		System.out.println("second-"+ getpB().getX() + " "+getpB().getY() );
		*/
		
		for(Point p:points){
			System.out.println("First is :(" +p.getX() + "," +p.getY() + ")");
		}
	}

	
	
}
