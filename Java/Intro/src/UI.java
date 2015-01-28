import java.awt.BorderLayout;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class UI extends JFrame
{
	JPanel wholeScreen = new JPanel();
	
	JPanel myPan = new JPanel();
	JTextField t1 = new JTextField(5);
	JTextField t2 = new JTextField(5);
	JTextField t3 = new JTextField(5);
	JTextField t4 = new JTextField(5);
	Intro player1;
	JLabel namae = new JLabel();
	public static ArrayList<Intro> players = new ArrayList<>();
	
	public UI()
	{
		myPan.add(BorderLayout.NORTH, new JLabel("fyll i det sda d"));
		myPan.add(BorderLayout.SOUTH, t1);
		myPan.add(Box.createHorizontalStrut(15));
		myPan.add(BorderLayout.SOUTH, t2);
		myPan.add(Box.createHorizontalStrut(15));
		myPan.add(BorderLayout.SOUTH, t3);
		myPan.add(Box.createHorizontalStrut(15));
		myPan.add(BorderLayout.SOUTH, t4);
		int result = JOptionPane.showConfirmDialog(null, myPan, "Please Enter X and Y Values", JOptionPane.OK_CANCEL_OPTION);
		
		if(result == JOptionPane.OK_OPTION)
		{
			players.add(new Intro(t1.getText()));
			System.out.println(players.get(0).name);
		}
		
		if(result == JOptionPane.CANCEL_OPTION || result == JOptionPane.CLOSED_OPTION)
		{
			System.exit(0);
		}
		
		setTitle("h");
		setExtendedState(MAXIMIZED_BOTH);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
}
