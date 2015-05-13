import java.util.Scanner;

public class Intro {

	public static void main(String[] args) 
	{
		//Uppgift 1
		/*
		Scanner scan = new Scanner(System.in);
		
		int numOfDollars = scan.nextInt();
		
		for(int i = 1; i <= numOfDollars; i++)
		{
			System.out.print("$");
			if(i % numOfDollars == 0)
			{
				for(i = 2; i <= numOfDollars; i++)
				{
					System.out.println("");
					for(int k = 1; k <= numOfDollars; k++)
					System.out.print("$");
				}
				
			}
		}
		*/
		
		//Uppgift 2
		/*
		Scanner input = new Scanner(System.in);
		
		int tal = input.nextInt();
		
		for(int i = 0; 5 > i; i++)
		{
			
		}
		
		System.out.print(tal);
	*/
		Scanner scan = new Scanner(System.in);
		String s = scan.nextLine();

		try{
		    Integer.parseInt(s);
		}
		catch(NumberFormatException ex){
		    System.out.println("Its not a valid Integer");
		}
		
	}
		

}
