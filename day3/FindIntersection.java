package week1.day3;

public class FindIntersection {

	public static void main(String[] args) {
		
		
		int a[] = {3,2,11,4,6,7}; 
		int b[] = {1,2,8,4,9,7}; 

		for (int i = 0; i < a.length; i++) {			
			
			
		for (int j = 0; j < b.length; j++) {
				
	         if(a[i]==b[j])
	         {
	        	 System.out.println("The Value in array a[]  " + a[i] +" & the Value in array b[]  "+ b[i] + " are same in both array" );
	        	 break;
	         }
			}
			
		}
		
		
		
		
	}

}
