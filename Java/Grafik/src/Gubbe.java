import java.awt.Graphics;

import javax.swing.JPanel;


public class Gubbe extends JPanel
{
	public Gubbe()
	{
		
	}
	
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		g.fillOval(100, 100, 30, 20);
	}
	
	public void move(int x, int y)
	{
		
	}
}
