package week2.day1;

import com.beust.jcommander.converters.CharArrayConverter;

public class ChangeOddIndexToUpperCase {

	public static void main(String[] args) {
		
		String name = "changeme";
		char[] charArray = name.toCharArray();
		
		for (int i = 0; i < charArray.length; i++) {
			
		    if(i%2!=0)
		    {
		    	  	char upperCase = Character.toUpperCase(charArray[i]);
		    	  	charArray[i] = upperCase;
		    	  	System.out.print(charArray[i]);
		    	
		    }
		    else
		    {
		    	System.out.print(charArray[i]);
		    }
		}
		
		

	}

}

