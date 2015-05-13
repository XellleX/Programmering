import java.awt.Graphics;


public class Player 
{
	static final int HEIGHT = 150;
	int hp = 100;
	int x;
	int y;
	double vx = 0;
	double vy = 0;
	
	public double jumpSpeed = 0;
	
	public Player(int x, int y)
	{
		this.x = x;
		this.y = y;
	}
	
	public void moveTo(int x, int y)
	{
		this.x = x;
		this.y = y;
	}
	
	public void translate(int x, int y)
	{
		this.x += x;
		this.y += y;
	}
	
	public void accelerate(double x, double y)
	{
		vx += x;
		vy += y;
	}
	
	public void step()
	{
		x += vx;
		y += vy;
	}
	
	public boolean collision()
	{
		
		return true;
	}
	
	public void draw(Graphics g)
	{
		g.translate(0, -HEIGHT);
		
		g.drawOval(0, 0, 40, 50);
		g.drawLine(20, 50, 20, 100);
		g.drawLine(20, 100, 5, 150);
		g.drawLine(20, 100, 35, 150);
		g.drawLine(20, 60, 5, 90);
		g.drawLine(20, 60, 35, 90);
		g.drawOval(10, 10, 5, 5);
		g.drawOval(25, 10, 5, 5);
		g.drawArc(15, 35, 15, 7, 180, 180);
		
		g.translate(0, HEIGHT);
	}
	
	public boolean footing()
	{
		
		return y <= 0;
	}
}
