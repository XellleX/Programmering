package Synkronisering;

import java.util.ArrayList;

public class Syncad
{
	Thread[] threads = new Thread[1000];
	Integer summa = 0;

	public Syncad()
	{
		for(int i = 0; i < threads.length; i++)
		{
			threads[i] = new Thread(new AddTask(this));
			threads[i].start();
		}
		for(int i = 0; i < threads.length; i++)
		{
			try 
			{
				threads[i].join();
			} 
			catch (InterruptedException e) 
			{
				e.printStackTrace();
			}
		}
	}
	
	public synchronized void addOne()
	{
		summa += 1;
		System.out.println(summa);
	}
	
	public static void main(String[] args) 
	{
		new Syncad();
	}

}
