package week1.day2;

public class IsPrime {

	public static void main(String[] args) {
		int number = 13;
		int c = 0;
		for(int i=2;i<=number -1;i++)
		{
			
			if(number%i ==0)
			{						
				c=c+1;
				break;
			}
			
		}
		
		if(c>0)
			
			{
				System.out.println("The given number is Not Prime -" + number);
			}
		else
		{
			System.out.println("The given number is Prime -" + number);
		}
		


}
}
