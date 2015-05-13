package Trafikljus;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class Panel extends JPanel
{
	Color green;
	Color yellow;
	Color red;
	
	public Panel()
	{
		green = Color.BLACK;
		yellow = Color.BLACK;
		red = Color.RED;
	}
	
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		g.drawLine(350, 350, 350, 200);
		g.drawLine(350, 200, 310, 200);
		g.drawLine(350, 200, 390, 200);
		g.drawLine(310, 200, 310, 10);
		g.drawLine(390, 200, 390, 10);
		g.drawLine(390, 10, 310, 10);
		
		g.setColor(red);
		g.fillOval(325, 20, 50, 50);
		g.setColor(yellow);
		g.fillOval(325, 80, 50, 50);
		g.setColor(green);
		g.fillOval(325, 140, 50, 50);
		
	}
}
