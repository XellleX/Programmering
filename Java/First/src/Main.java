import java.util.Scanner;
import java.lang.Math;

public class Main 
{
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		System.out.println("How old are you?");
		int age;
		age=in.nextInt();
		int randomNumber;
		
		if(age >= 18)
		{
			randomNumber = (int) (Math.random() * 10);
			hello();
			System.out.println(randomNumber);
		}
		
		else
		{
			System.out.println("Bich, get out!");
		}
	}
	
	private static void hello()
	{
		System.out.println("Welcome! ");
	}
	
}
