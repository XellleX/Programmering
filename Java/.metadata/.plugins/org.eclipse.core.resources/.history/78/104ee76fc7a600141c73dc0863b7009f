package Samlingar;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Collections;
import java.util.Scanner;
import java.util.Stack;

public class Samlingar
{
	Stack<String> ord = new Stack<>();
	
	public Samlingar()
	{
		try 
		{
			Scanner scan = new Scanner(new File("ord.txt"));
			while(scan.hasNext())
			{
				ord.add(scan.next());
			}
			Collections.sort(ord);
			for(String o : ord)
			{
				System.out.println(o);
			}
			
		} 
		catch (Exception e) 
		{
			System.out.println("Fu");
		}
		
	}
	public static void main(String[] args) 
	{
		new Samlingar();
	}

}
