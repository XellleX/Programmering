package Trafikljus;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Trafikljus extends JFrame implements ActionListener
{
	Panel pan = new Panel();
	Timer tim = new Timer(500, this);
	int time = 0;
	
	public Trafikljus()
	{
		setTitle("Trafikljus");
		setBounds(200, 200, 700, 400);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		add(pan);
		tim.start();
		
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent ae) 
	{
		time++;
		
		if(time == 6)
		{
			pan.yellow = Color.YELLOW;
		}
		
		if(time == 8)
		{
			pan.red = Color.BLACK;
			pan.yellow = Color.BLACK;
			pan.green = Color.GREEN;
		}
		
		if(time == 14)
		{
			pan.green = Color.BLACK;
			pan.yellow = Color.YELLOW;
		}
		
		if(time == 16)
		{
			pan.yellow = Color.BLACK;
			pan.red = Color.RED;
			time = 0;
		}
		
		pan.repaint();
	}
	
	public static void main(String[] args) 
	{
		new Trafikljus();
	}

}
