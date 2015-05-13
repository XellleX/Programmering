package Animering;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class StudsBollar extends JFrame implements ActionListener
{
	Timer time = new Timer(10, this);
	Ball pan = new Ball();
	Ball pan2 = new Ball(40, 0, 2, 0);
	ArrayList<Ball> bollar = new ArrayList<>();
	
	JButton moreBalls = new JButton("More Balls :D");
	JButton lessBalls = new JButton("Less Balls D:");
	
	public StudsBollar()
	{
		setTitle("Studsande bollar");
		setExtendedState(MAXIMIZED_BOTH);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		fillDefConst();
		time.start();
		setVisible(true);
	}
	
	public void fillDefConst()
	{
		pan.add(moreBalls);
		add(pan);
		moreBalls.addActionListener(this);
	}

	public static void main(String[] args) 
	{
		new StudsBollar();
	}

	@Override
	public void actionPerformed(ActionEvent ae) 
	{
		/*
		Object ob = ae.getSource();
		
		if(ob instanceof JButton)
		{
			if(((JButton) ob).getActionCommand() == "More Balls :D")
			{
				System.out.println("hej");
				Ball b = new Ball(4, 0, 2, 0);
				add(b);
			}
		}*/
		
		
		pan.bounce();
		pan.accelerate(0, pan.GRAVITATION);
		pan.move();
		pan.repaint();
	}

}
