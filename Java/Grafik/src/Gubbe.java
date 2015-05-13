import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;


public class Gubbe extends JPanel
{
	private int x, y;
	
	public Gubbe()
	{
		
	}
	
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);	
		g.setColor(Color.RED);
		g.fillOval((x + 100), (y + 100), 30, 30);
		g.drawLine((x + 115), (y + 130), (x + 115), (y + 170));
		g.drawLine((x + 115), (y + 135), (x + 125), (y + 155));
		g.drawLine((x + 115), (y + 135), (x + 105), (y + 155));
		g.drawLine((x + 115), (y + 170), (x + 110), (y + 190));
		g.drawLine((x + 115), (y + 170), (x + 120), (y + 190));
	}
	
	public void setX(int _x)
	{
		x += _x;
		
		if(x > 700 - 115)
		{
			x = 0 - 115;
		}
		
		else if(x < 0 - 115)
		{
			x = 700 - 115;
		}
	}
	
	public void setY(int _y)
	{
		y += _y;
	}
}
