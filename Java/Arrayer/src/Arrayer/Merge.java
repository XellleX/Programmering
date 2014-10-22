package Arrayer;

import java.util.ArrayList;

public class Merge 
{

	public static void main(String[] args) 
	{
		ArrayList<Integer> lista1 = new ArrayList<>();
		ArrayList<Integer> lista2 = new ArrayList<>();
		
		for(int i = 0; i < 15; i++)
		{
			lista1.add((int) Math.round(Math.random() * 30));
			lista2.add((int) Math.round(Math.random() * 30));
		}
		
		for(Integer s:lista1)
		{
			System.out.print(s + " ");
		}
		System.out.println();
		for(Integer s:lista2)
		{
			System.out.print(s + " ");
		}
		System.out.println();
		
		merge(lista1, lista2);
		
		System.out.println("Efter");
		for(Integer s:lista1)
		{
			System.out.print(s + " ");
		}
	}
	
	public static ArrayList<Integer> merge(ArrayList<Integer> list1, ArrayList<Integer> list2)
	{
		for(int i = 0; i < list2.size(); i++)
		{
			list1.add(list2.get(i));
		}
		
		return list1;
	}

}
