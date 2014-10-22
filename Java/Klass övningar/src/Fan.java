
public class Fan 
{
	private final int SLOW = 1, MEDIUM = 2, FAST = 3;
	private int speed;
	private boolean on;
	private double rad;
	private String color;
	
	public Fan()
	{
		speed = SLOW;
		on = false;
		rad = 5;
		color = "Bl�";
	}

	public void setSpeed(int _speed) 
	{
		if(_speed >= 3)
		{
			speed = FAST;
		}
		
		else if(_speed == 2)
		{
			speed = MEDIUM;
		}
		
		else if(_speed <= 1)
		{
			speed = SLOW;
		}
	}


	public int getSpeed() 
	{
		return speed;
	}

	public boolean isOn() 
	{
		return on;
	}

	public void setOn(boolean on) 
	{
		this.on = on;
	}

	public double getRad() 
	{
		return rad;
	}

	public void setRad(double rad) 
	{
		this.rad = rad;
	}

	public String getColor() 
	{
		return color;
	}

	public void setColor(String color) 
	{
		this.color = color;
	}
	
	public String toString()
	{
		if(on)
		{
			String text = "Fl�kthastigheten �r p� " + speed + ", fl�ktens f�rg �r " + color + 
			" och fl�ktens radie �r " + rad + "cm.";
			
			return text;
		}
		
		else
		{
			String text = "Fl�ktens f�rg �r " + color + " och fl�ktens radie �r " + rad + "cm. Fl�kten �r av.";
			
			return text;
		}
		
		
	}

}
