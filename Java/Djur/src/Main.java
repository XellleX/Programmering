import java.util.ArrayList;


public class Main 
{
	public static void main(String[] args)
	{
		ArrayList<Djur> djur = new ArrayList<>();
		
		djur.add(new H�st());
		djur.add(new H�st());
		
		
		for(Djur m : djur)
		{
			System.out.println(m.l�te());
		}
		
	}
}
