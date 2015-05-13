package Animering;

import java.awt.Graphics;

import javax.swing.JPanel;

public class Ball extends JPanel
{
	public int x;
	public int y;
	double vx = 0;
	double vy = 0;
	public final double GRAVITATION = 0.1;
	
	public Ball()
	{
		this.x = 0;
		this.y = 0;
		this.vx = 2;
		this.vy = 0;
	}
	
	public Ball(int x, int y, double vx, double vy)
	{
		this.vx = vx;
		this.vy = vy;
		this.x = x;
		this.y = y;
	}
	
	public void bounce()
	{
		if(this.y > 670)
		{
			System.out.println(vy);
			if(vy > 0)
			{
				vy = -Math.abs(vy - 1.3);
			}
		}
		
		if(this.y < 0)
		{
			//System.out.println(vy);
			vy = Math.abs(vy - (GRAVITATION * vy));
			//System.out.println(vy);
		}
		
		if(this.x > 1330 || this.x < 0)
		{
			vx = -vx;
		}
	}
	
	public void accelerate(double x, double y)
	{
		vx += x;
		vy += y;
	}
	
	public void move()
	{	
		this.x += vx;
		this.y += vy;
	}
	
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		g.fillOval(x, y, 30, 30);
	}
}
