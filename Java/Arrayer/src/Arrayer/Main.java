package Arrayer;

import java.util.ArrayList;
import java.util.Scanner;

public class Main
{
	private static int nextint;
	
	public static void main(String[] args) 
	{
		ArrayList<Integer> tal = new ArrayList<>();
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Skriv in en rad med heltal, avsluta med 0");
		
		while(scan.hasNextInt())
		{	
			nextint = scan.nextInt();
			
			if(nextint == 0)
			{
				break;
			}
			
			if(tal.size() == 0)
			{
				tal.add(nextint);
			}
			
			else
			{
				for(int i = 0; i < tal.size(); i++)
				{
					if(tal.contains(nextint))
					{
						
					}
					
					else
					{
						tal.add(nextint);
					}
				}
			}
			
			
		}
		
		scan.close();
		
		for(Integer s:tal)
		{
			System.out.println(s);
		}
	}

}
