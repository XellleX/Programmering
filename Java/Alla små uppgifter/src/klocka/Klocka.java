package klocka;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Klocka extends JFrame
{
	
	JPanel pan = new JPanel();
	JTextField field = new JTextField(4);
	Font font = new Font("Arial", Font.BOLD, 22);
	
	public Klocka()
	{
		setTitle("Klocka");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 400);
		fillDefConst();
		pack();
		setVisible(true);
	}
	
	public void fillDefConst()
	{
		field.setFont(font);
		field.addKeyListener(new KeyBoard());
		pan.add(BorderLayout.CENTER, field);
		add(BorderLayout.CENTER, pan);
	}
	
	public static void main(String[] args) 
	{
		new Klocka();
	}

	public class KeyBoard extends KeyAdapter
	{
		
		@Override
		public void keyTyped(KeyEvent ke) 
		{
			char typed = ke.getKeyChar();
			
			if(!Character.isDigit(typed))
			{
				ke.consume();
			}
			
			else if(Character.isDigit(typed))
			{
				int number = (int)typed;
				
				if(field.getText().length() == 3 && number > 53)
				{
					String holder = field.getText();
					field.setText(holder + "0" + typed);
					ke.consume();
				}
				
				if(field.getText().isEmpty() && number >= 51)
				{
					ke.consume();
					field.setText("0" + typed + ":");
				}
				
				if(field.getText().length() == 2)
				{
					String holder = field.getText();
					field.setText(holder + ":");
				}
				
				if(field.getText().length() >= 5)
				{
					ke.consume();
				}
				
				if(field.getText().length() == 1 && field.getText().contains("2") && number > 52)
				{
					System.out.println("h");
					ke.consume();
				}
				
				if(field.getText().length() >= 3 && field.getText().contains("24:"))
				{
					ke.consume();
					field.setText("24:00");
				}
			}
			
		}
		
	}
}
