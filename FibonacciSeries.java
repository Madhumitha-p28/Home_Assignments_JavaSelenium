package week1.day2;

public class FibonacciSeries {

	public static void main(String[] args) {
		
		int a = 0,b=1;
		System.out.println(a);
		System.out.println(b);
		
		for(int i=1;i<7;i++)
		{	
			int c = a+b;
			System.out.println(c);
			a=b;
			b=c;
			
			
			
			
		}
	}

}
