import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;


public class Gif extends JFrame implements ActionListener
{
	private JLabel lab1 = new JLabel(new ImageIcon("bild1.gif"));
	private JLabel lab2 = new JLabel(new ImageIcon("dancing-banana.gif"));
	private JButton vaxlaBild = new JButton("Växla bild");
	private boolean firstImg = true;
	
	public Gif()
	{
		super("Gifs");
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		//add(BorderLayout.CENTER, lab2);
		add(BorderLayout.CENTER, lab2);
		add(BorderLayout.CENTER, lab1);
		add(BorderLayout.NORTH, vaxlaBild);
		vaxlaBild.addActionListener(this);
		pack();
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		firstImg = !firstImg;
		if(!firstImg)
		{
			lab1.setVisible(false);
			add(BorderLayout.CENTER, lab2);
			lab2.setVisible(true);
		}
		else if(firstImg)
		{
			lab1.setVisible(true);
			lab2.setVisible(false);
		}
		
	}
}
