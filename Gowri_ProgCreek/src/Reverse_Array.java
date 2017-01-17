import java.util.Scanner;


public class Reverse_Array {

	public static void main(String[] args) {
			Scanner sc=new Scanner(System.in);
			int n=sc.nextInt();
			int[] arr=new int[n];
			for(int i=0;i<n;i++){
				arr[i]=sc.nextInt();
				
				
			}
			int[] reversedArray=reverseArray(0,arr,arr.length-1);
			for(int a:reversedArray){
 		System.out.print(a + " ");
		
			}
		
	}

	private static int[] reverseArray(int start, int[] arr, int end) {
		// TODO Auto-generated method stub
		if(start<end)
		{
			int temp=arr[end];
			arr[end]=arr[start];
			arr[start]=temp;
			start+=1;
			end-=1;
			reverseArray(start,arr,end);
		}
		
		
		
		return arr;
	}
	
	
	
}
