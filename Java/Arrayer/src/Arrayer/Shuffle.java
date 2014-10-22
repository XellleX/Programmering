package Arrayer;

import java.util.ArrayList;

public class Shuffle 
{

	public static void main(String[] args) 
	{
		ArrayList<Integer> heltal = new ArrayList<>();
		
		for(int i = 0; i < 20; i++)
		{
			heltal.add(i);
		}
		
		for(Integer s:heltal)
		{
			System.out.print(s + " ");
		}
		System.out.println();
		shuffle(heltal);
		System.out.println("Efter");
		for(Integer s:heltal)
		{
			System.out.print(s + " ");
		}
	}
	
	public static void shuffle(ArrayList<Integer> lista)
	{
		for(int i = 0; i < lista.size(); i++)
		{
			changePlace(lista, i, (int) Math.round(Math.random() * lista.size()));
		}
	}
	
	public static void changePlace(ArrayList<Integer> list, int index1, int index2)
	{
		Integer removedItem = list.remove(index1);
		list.add(index2, removedItem);
	}

}
