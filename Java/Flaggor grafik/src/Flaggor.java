import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


public class Flaggor extends JFrame
{
	
	private Color farg1, farg2;
	String svar = JOptionPane.showInputDialog("Vilken flagga vill du se? s/n/f");
	JPanel test = new JPanel();
	JLabel hej = new JLabel("hej");
	JPanel t = new JPanel();
	
	public Flaggor()
	{
		super("Hej");
		setBounds(100, 100, 900, 600);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	public void paint(Graphics g)
	{
		//test.paint(g);
		
		switch(svar)
		{
			case "s": 
				farg1 = new Color(0, 0, 255);
				farg2 = new Color(255, 255, 0);
				break;
			case "n": 
				farg1 = new Color(255, 0,0);
				farg2 = new Color(255, 255, 255);
				break;
			case "f":
				farg1 = new Color(255, 255, 255);
				farg2 = new Color(0, 0, 255);
				break;
		}
		g.setColor(farg1);
		g.fillRect(50, 50, 300, 200);
		g.setColor(farg2);
		g.fillRect(50, 135, 300, 30);
		g.fillRect(140, 50, 30, 200);
	}
}