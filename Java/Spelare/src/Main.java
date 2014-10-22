import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.Vector;


public class Main 
{
	public static void main(String[] args) throws IOException
	{	
		Scanner in = new Scanner(new File("text.txt"));
		
		List<Spelare> spelare = new Vector<>();
		
		String typ;
		double pris;
		int styrka;

		
		while(in.hasNext())
		{
			typ = in.next();
			pris = in.nextDouble();
			styrka = in.nextInt();
			
			spelare.add(new Spelare(typ, pris, styrka));
		}
		
		in.close();
		
		
		maxMinPris(spelare, 1);
		maxMinPris(spelare, 0);
		sortVector(spelare);
		text(spelare);
	}
	
	public static void text(List<Spelare> sp)
	{
		System.out.println();
		System.out.println("All characters sorted:");
		System.out.println();
		
		for(Spelare s:sp)
		{
			System.out.println(s);
		}
	}
	
	public static void maxMinPris(List<Spelare> spe, int maxEllerMin)
	{
		List<Double> prisen = new ArrayList<Double>();
		
		for(Spelare s:spe)
		{
			prisen.add(s.getPris());
 		}
		
		if(maxEllerMin == 0)
		{
			Object o = Collections.min(prisen);
			System.out.println("Minsta priset är: " + o);
		}
		
		else if(maxEllerMin == 1)
		{
			Object o = Collections.max(prisen);
			System.out.println("Max priset är: " + o);	
		}
	}

	public static void sortVector(List<Spelare> sp)
	{
		System.out.println();
        System.out.println("Before sort: ");
        System.out.println();
        
        for(Spelare s:sp)
        {
        	System.out.println(s.getTyp());
        }
        Comparator<Spelare> comparator = new SpelareComparator();
        Collections.sort(sp, comparator);
        
        System.out.println();
        System.out.println("After  sort: ");
        System.out.println();
        
        for(Spelare s:sp)
        {
        	System.out.println(s.getTyp());
        }
	}
	
}
