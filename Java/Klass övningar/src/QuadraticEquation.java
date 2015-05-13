

public class QuadraticEquation 
{
	private int a, b, c;
	
	public QuadraticEquation(int _a, int _b, int _c)
	{
		a = _a;
		b = _b;
		c = _c;
	}

	public int getA() 
	{
		return a;
	}

	public int getB() 
	{
		return b;
	}

	public int getC() 
	{
		return c;
	}
	
	public double getDiscriminant()
	{
		double discriminant = Math.pow(b, 2) - 4 * a * c;
		return discriminant;
	}
	
	public double getRoot1()
	{
		double r1 = -b + Math.sqrt(Math.pow(b, 2) - 4 * a * c) / 2 * a;
		
		if(getDiscriminant() < 0)
		{
			return 0;
		}
		
		else
		{
			return r1;
		}	
	}
	
	public double getRoot2()
	{
		double r2 = -b - Math.sqrt(Math.pow(b, 2) - 4 * a * c) / 2 * a;
		
		if(getDiscriminant() < 0)
		{
			return 0;
		}
		
		else
		{
			return r2;
		}
	}
	
	public String toString()
	{
		String text;
		if (getDiscriminant() > 0)
		{
			text = "Ekvationens två rötter är: (" + getRoot1() + ") och (" + getRoot2() + ").";
		}
		
		else if(getDiscriminant() == 0)
		{
			text = "Ekvationen har bara 1 lösning. Den är: (" + getRoot1() + ").";
		}
		
		else
		{
			text = "Ekvationen har inga lösningar.";
		}
		
		return text;
	}
	
}
