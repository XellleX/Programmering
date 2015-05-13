package Animering;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class BilRace extends JFrame
{
	
	public BilRace()
	{
		super("RAAACE!!!");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(1000, 400);
		setLocationRelativeTo(null);
		add(new Draw());
		setVisible(true);
	}

	public static void main(String[] args)
	{
		new BilRace();
	}

}

class Draw extends JPanel implements ActionListener
{
	Long time = new Long(0);
	Timer tim = new Timer(20, this);
	Car car1 = new Car(0, 0, "Car 1");
	Car car2 = new Car(0, 90, "Car 2");
	Car car3 = new Car(0, 180, "Car 3");
	Car car4 = new Car(0, 270, "Car 4");
	ArrayList<Car> cars = new ArrayList<>();
	
	public Draw()
	{
		tim.start();
		cars.add(car1);
		cars.add(car2);
		cars.add(car3);
		cars.add(car4);
	}
	
	public void drawCar(Car c, Graphics g)
	{
		c.draw(g);
	}
	
	@Override
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		drawCar(car1, g);
		drawCar(car2, g);
		drawCar(car3, g);
		drawCar(car4, g);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		time++;
		
		if(time % 20 == 0)
		{
			car1.accelerate((Math.random() * Math.random()) / (Math.random() * Math.random() + 0.1) + 1);
			car2.accelerate((Math.random() * Math.random()) / (Math.random() * Math.random() + 0.1) + 1);
			car3.accelerate((Math.random() * Math.random()) / (Math.random() * Math.random() + 0.1) + 1);
			car4.accelerate((Math.random() * Math.random()) / (Math.random() * Math.random() + 0.1) + 1);
		}
		
		for(Car c : cars)
		{
			if(c.x > 1000-60)
			{
				tim.stop();
				System.out.println(c.name + " WINS!!");
			}
		}
		
		car1.move();
		car2.move();
		car3.move();
		car4.move();
		repaint();
	}
}

class Car 
{
	int x, y;
	double vx = 1;
	String name;
	
	public Car()
	{
		
	}
	
	public Car(int x, int y, String name)
	{
		this.name = name;
		this.x = x;
		this.y = y;
	}
	
	public void accelerate(double vx)
	{
		this.vx = vx;
	}
	
	public void move()
	{
		x += vx;
	}
	
	public void draw(Graphics g)
	{
		g.drawLine(0, y + 90, 1000, y + 90);
		g.fillOval(x + 5, y + 80, 10, 10);
		g.fillOval(x + 30, y + 80, 10, 10);
		g.fillRoundRect(x + 5, y + 63, 30, 10, 20, 5);
		g.fillRect(x, y + 70, 50, 15);
	}
}
