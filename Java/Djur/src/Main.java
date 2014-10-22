import java.util.ArrayList;


public class Main 
{
	public static void main(String[] args)
	{
		ArrayList<Djur> djur = new ArrayList<>();
		
		djur.add(new Häst());
		djur.add(new Häst());
		
		
		for(Djur m : djur)
		{
			System.out.println(m.läte());
		}
		
	}
}
