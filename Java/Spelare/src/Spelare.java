import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;
import java.util.Scanner;


public class Spelare implements Comparable
{
	
	private String typ;
	private int styrka;
	private double pris;
	
	public Spelare()
	{
		
	}
	
	public Spelare(String t, double p, int s)
	{
		typ = t;
		styrka = s;
		pris = p;
	}
	
	public void okaPris(double prisOkning)
	{
		pris *= prisOkning / 100 + 1;
	}
	
	public int visaStyrka()
	{
		return styrka;
	}
	
	public double getPris()
	{
		return pris;
	}
	
	public String getTyp()
	{
		return typ;
	}
	
	public String toString()
	{
		String text = typ + "  " + pris + "  " + styrka;
		return text;
	}

	@Override
	public int compareTo(Object o) 
	{
		Spelare s = (Spelare) o;
		return this.typ.compareTo(s.typ);
	}

}
