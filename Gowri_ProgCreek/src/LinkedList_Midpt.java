import java.util.LinkedList;
import java.util.List;


public class LinkedList_Midpt {
	static Node head;
	public static void pushN(int newdata){
		Node temp=new Node(newdata);
		temp.next=head;
		head=temp;
		
	}
	public static void printList(){
		Node tnode=head;
		while(tnode!=null){
			System.out.print(tnode.data + " ");
			tnode=tnode.next;
			
		}
		
		
		
	}
	public static void main(String[] args) {
		
		LinkedList<Integer> slink=new LinkedList<Integer>();
		for(int i=1;i<=5;i++){
			pushN(i);
			printList();
		}
		

		//System.out.println("The middle of odd is :"+findMiddle(slink,l1));
		//System.out.println("The middle of even is :"+findMiddle(slink1,l2));
	}

	private static String findMiddle(List<Integer> slink, int l1) {
		// TODO Auto-generated method stub
		return null;
	}
	

}

class Node{
	int data;
	Node next;
	public Node(int data){
		this.data=data;
		next=null;
	}
	
	
}
