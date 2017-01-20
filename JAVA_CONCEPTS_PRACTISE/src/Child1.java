class Child extends Parent{
	//int a = 20;
	
	Child(){
		s="Hello Gowri";
		a=40;
		System.out.println("Inside Child constructor");
	}
	
	
	void display(){
		
		System.out.println("Inside child");
	}
	
	
	
	
}



 public class Child1 {
	 
	 
	 public static void main(String[] args) {
			
			Child c= new Child();
			c.display();
			System.out.println(c.a);
			Parent p = new Parent();
			p.display();
			System.out.println(p.a);
			Parent pc=new Child();
			pc.display();
			System.out.println(pc.s + ", "+ pc.a);
			System.out.println(((Child)pc).a);
			
		}
	
	
	
	
}


class Test1{
	
	
	
}