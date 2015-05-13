package medelTemperatur;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.border.Border;

public class Temp extends JFrame
{
	File file = new File("temp.txt");
	
	Vector<Integer> temperatures = new Vector<>();
	
	JLabel lab1 = new JLabel();
	JLabel lab2 = new JLabel();
	
	public Temp() throws IOException
	{
		scanning();
		setTitle("ja");
		setBounds(100, 100, 400, 300);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		lab1.setText("Medeltemperaturen är: " + averageTemp());
		lab2.setText("Den högst uppmätta temperaturen är: " + maxTemp());
		add(BorderLayout.NORTH, lab1);
		add(BorderLayout.SOUTH, lab2);
	}
	
	public void scanning() throws IOException
	{
		Scanner scanner = new Scanner(file);
		
		while(scanner.hasNextInt())
		{
			temperatures.add(scanner.nextInt());
		}
	}
	
	public String averageTemp()
	{
		double totalTemp = 0;
		double averageTempe;
		
		for(int i = 0; i < temperatures.size(); i++)
		{
			totalTemp += temperatures.get(i);
		}
		
		averageTempe = Math.round(totalTemp / temperatures.size());
		return Double.toString(averageTempe);
	}
	
	public String maxTemp()
	{
		int maximumTemp = 0;
		
		for(int i = 0; i < temperatures.size(); i++)
		{
			if(temperatures.get(i) > maximumTemp)
			{
				maximumTemp = temperatures.get(i);
			}
		}
		return Integer.toString(maximumTemp);
	}
}
