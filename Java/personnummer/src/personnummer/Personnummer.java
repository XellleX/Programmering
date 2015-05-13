package personnummer;

import java.awt.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

public class Personnummer 
{
	public String personNummer;
	
	public static void main(String[] args) 
	{
		Scanner in = new Scanner(System.in);
		
		new Personnummer(in.nextLine());
	}
	
	public Personnummer(String personNr)
	{
		
		String[] parts = personNr.split("");
		
		int persNrLength = parts.length;
		
		for(int i = 0; i < persNrLength-1; i++)
		{
			if(Arrays.asList(parts[i]).contains("-"))
			{
				System.out.println("Yay");
			}
			
			else if(i % 2 == 0)
			{
				int tal = Integer.parseInt(parts[i]);
				int hej = tal * 2;
				
				System.out.println(hej);
			}
			
			else
			{
				int tal = Integer.parseInt(parts[i]);
				int hej = tal * 1;
				if(hej >= 10)
				{
					
				}
				System.out.println(hej);
			}
			
			
		}
		
		//System.out.println(personNummer);
		//System.out.print(parts[1]);
	}
	
	public boolean isMale()
	{
		return true;
	}
	
	public boolean isFemale()
	{
		return false;
	}

}
