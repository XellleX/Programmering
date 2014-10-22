
public class Rektangel 
{
	private double width, height;
	
	public Rektangel()
	{
		width = 1;
		height = 1;
	}
	
	public Rektangel(double _width, double _height)
	{
		width = _width;
		height = _height;
	}
	
	public double getArea()
	{
		double area = width * height;
		return area;
	}
	
	public double getPerimeter()
	{
		double perimeter = (height * 2) + (width * 2);
		return perimeter;
	}
	
	public String toString()
	{
		String text = "Rektangeln är (" + width + ") cm bred, (" + height + ") cm hög, ("
		+ getPerimeter() + ") cm omkrets, (" + getArea() + ") cm2 Area"; 
		return text;
	}
}
