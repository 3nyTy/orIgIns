/**
 * Reverse wordsi n string without using extra space :
 * Input  : s = "geeks quiz practice code"
Output : s = "code practice quiz geeks"
1) Reverse the individual words, we get the below string.
     "i ekil siht margorp yrev hcum"
2) Reverse the whole string from start to end and you get the desired output.
     "much very program this like i"
*
*
*
**/

package com.HR.StringsAlgo;

import java.util.Scanner;

public class ReverseWords {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		int j=0;
		for(int i=0;i<str.length();i++){
			if(str.charAt(i)==' '){
				str=reverSeStrUsingswap(str.toCharArray(),j,i-1);
				j=i+1;
			}
			
		}
		System.out.println(str+" ");
		str=reverSeStrUsingswap(str.toCharArray(),j,str.length()-1);
		
		str = reverSeStrUsingswap(str.toCharArray(),0,str.length()-1);
		System.out.println(str);
		
	}

	private static String reverSeStrUsingswap(char[] str, int start, int end) {
		for(int i=start;i<end;i++ ){
			if(i<end){
			char temp = str[i];
			str[i]=str[end];
			str[end] = temp;
			
			end--;
			}
			
			
		}
		
		
		
		return String.valueOf(str);
	}
	
	

}
