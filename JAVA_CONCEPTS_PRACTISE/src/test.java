
public class test {
	
	 
	
	    public static void main(String[] args)
	    {
	        A a = new B();
	 
	        System.out.println(a.i);
	    }
	}

class A
{
    int i = 10;
}
 
class B extends A
{
    int i = 20;
}