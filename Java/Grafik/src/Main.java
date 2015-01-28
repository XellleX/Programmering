import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class Main extends JFrame implements ActionListener
{
	private Gubbe man = new Gubbe();
	//private Gubbe woman = new Gubbe();
	ArrayList<JButton> buttons = new ArrayList<>();
	private JPanel panel = new JPanel();
	
	public Main()
	{
		super("The Walking Man");
		setVisible(true);
		setBounds(150, 150, 700, 500);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		add(BorderLayout.CENTER, man);
		//add(BorderLayout.SOUTH, woman);
		add(BorderLayout.NORTH, panel);
		fillDefConstructor();
	}
	
	public static void main(String[] args) 
	{
		new Main();
	}
	
	private void fillDefConstructor()
	{
		buttons.add(new JButton("vänster"));
		buttons.add(new JButton("ner"));
		buttons.add(new JButton("upp"));
		buttons.add(new JButton("höger"));
		
		for(int i = 0; i < 4; i++)
		{
			panel.add(buttons.get(i));
			buttons.get(i).addActionListener(this);
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		String command = ((JButton) e.getSource()).getActionCommand();
		
		switch(command)
		{
			case "vänster":
				man.setX(-10);
				man.repaint();
				break;
				
			case "ner":
				man.setY(10);
				man.repaint();
				break;
			
			case "upp":
				man.setY(-10);
				man.repaint();
				break;
				
			case "höger":
				man.setX(10);
				man.repaint();
				break;
		}
		
	}

}
