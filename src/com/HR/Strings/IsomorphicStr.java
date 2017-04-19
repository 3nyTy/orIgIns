package com.HR.Strings;

public class IsomorphicStr {
	public static boolean isIsomorphic(String s, String t) {
	    if (s.length() != t.length()) {
	      return false;
	    }
	    char characters[] = new char[26];
	    char array1[] = s.toCharArray();
	    char array2[] = t.toCharArray();

	    for (int i=0; i<array1.length; i++) {
	      char c = array1[i];
	      char character = characters[c-'a'];
	      if (character == '\0') {
	        characters[c-'a'] = array2[i];
	        continue;
	      }
	      if (character != array2[i]) {
	        return false;
	      }
	    }
	    return true;
	  }

	  public static void main(String[] args) {
	    System.out.println(isIsomorphic("foo", "bar"));         // false
	    System.out.println(isIsomorphic("paper", "title"));     // true
	    System.out.println(isIsomorphic("apple", "orange"));    // false
	  }
}
