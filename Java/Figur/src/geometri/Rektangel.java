package geometri;

public class Rektangel 
{
	private int x, y;
	private int a;
	
	public Rektangel()
	{
		this.x = 2;
		this.y = 1;
	}
	
	public Rektangel(int _x, int _y)
	{
		x = _x;
		y = _y;
	}
	
	public int getArea()
	{
		a = x * y;
		return a;
	}
}
