package Lottdragning;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class Lottdragning 
{
	Map<Integer, String> lottVinster = new HashMap<>();
	String fileName = JOptionPane.showInputDialog("Filens Namn plz:");
	int lowLottNum = Integer.parseInt(JOptionPane.showInputDialog("Lägsta lottnummer"));
	int highLottNum = Integer.parseInt(JOptionPane.showInputDialog("Högsta Lottnummer"));
	
	public Lottdragning()
	{
		try {
			fillDefConst();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void fillDefConst() throws FileNotFoundException
	{
		System.out.println(fileName);
		Scanner scan = new Scanner(new File(fileName));
		
		while(scan.hasNext())
		{
			int antal = scan.nextInt();
			String vinst = scan.nextLine();
			System.out.println(antal + vinst);
			
			for(int i = 0; i < antal; i++)
			{
				int l = (int)Math.round(Math.random() * (highLottNum - lowLottNum) + lowLottNum);
				if(lottVinster.containsKey(l))
				{
					
				}
				else
				{
					lottVinster.put(l, vinst);
				}
			}
		}
		
		for(int i = lowLottNum; i < highLottNum; i++)
		{
			if(lottVinster.containsKey(i))
			{
				
			}
			else
				lottVinster.put(i, "Nitlott");
		}
		
		try {
			setLists();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void setLists() throws IOException
	{
		PrintWriter s = new PrintWriter("vinstLista1.txt");
		BufferedWriter sc = new BufferedWriter(new FileWriter("vinstLista2.txt"));
		
		for(int i = lowLottNum; i < highLottNum; i++)
		{
			sc.write(i + " " + lottVinster.get(i) + "\n");
		}
		sc.close();
		dragning();
	}
	
	public void dragning()
	{
		int nummer = Integer.parseInt(JOptionPane.showInputDialog("Gissa ett lottnummer"));
		String v = lottVinster.get(nummer);
		JOptionPane.showMessageDialog(null, v);
		dragning();
	}
	
	public static void main(String[] args) 
	{
		new Lottdragning();
	}

}
