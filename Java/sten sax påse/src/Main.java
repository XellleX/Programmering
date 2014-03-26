import java.util.Scanner;

public class Main 
{
	public static void main(String[] args) 
	{
		Scanner scan = new Scanner(System.in);
		
		String[] choices = {"sten", "sax", "påse"};
		
		System.out.println("You play to 3");
		
		String playerChoice = scan.nextLine();

		if(playerChoice.equalsIgnoreCase(choices[0]))
		{
			System.out.println("Working");
		}
		
		else
		{
			System.out.println("Not working");
		}
		
	}

}
