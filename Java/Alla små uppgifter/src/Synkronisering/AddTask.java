package Synkronisering;

public class AddTask implements Runnable
{
	Syncad s;
	
	public AddTask(Syncad s)
	{
		this.s = s;
	}

	@Override
	public synchronized void run() 
	{
		s.addOne();
	}
}
