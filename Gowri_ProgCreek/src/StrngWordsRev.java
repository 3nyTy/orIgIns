
public class StrngWordsRev {

	public static void main(String[] args) {
		String s="Hi how are you";
		char[] atr=reversewords(s.toCharArray());
		System.out.println(new String(atr));
		
	}

	private static char[] reversewords(char[] charArray) {
		// TODO Auto-generated method stub
		int j=0;
		for(int i=0;i<charArray.length;i++){
			if(charArray[i]==' '){
				
				reverseStr(charArray,j,i-1);
				j=i+1;
				
			}
		}
		reverseStr(charArray,j,charArray.length-1);
		reverseStr(charArray,0,charArray.length-1);
		
		return charArray;
	}

	private static void reverseStr(char[] charArray, int j, int i) {
		while(j<i){
			
			char temp=charArray[i];
			charArray[i]=charArray[j];
			charArray[j]= temp;
			j++;i--;
			
		}
		
	}
	
	
	
}
