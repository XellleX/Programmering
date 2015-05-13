import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class Listner extends JFrame
{
	JLabel[] labels = {new JLabel("hej"), new JLabel("då"), new JLabel("din"), new JLabel("lille"), new JLabel("skit")};
	Color[] colors = {Color.BLACK, Color.BLUE, Color.PINK, Color.YELLOW, Color.GREEN};
	JPanel pan = new JPanel();
	Color oldColor;
	
	public Listner()
	{
		super("h");
		setBounds(100, 100, 400, 250);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		addLabels();
		setVisible(true);
	}
	
	public void addLabels()
	{
		pan.setLayout(new GridLayout(1, 5));
		
		for(int i = 0; i < labels.length; i++)
		{
			labels[i].setOpaque(true);
			labels[i].setBackground(colors[i]);
			labels[i].addMouseListener(new musAdapter());
			pan.add(labels[i]);
		}
		
		add(pan);
	}
	
	public static void main(String[] args) 
	{
		new Listner();
	}
	
	class musAdapter extends MouseAdapter
	{
		public void mouseEntered(MouseEvent me)
		{
			Object ob = me.getSource();
			
			if(ob instanceof JComponent)
			{
				JComponent jc = (JComponent)ob;
				oldColor = jc.getBackground();
				jc.setBackground(Color.RED);
			}
			
		}
		
		public void mouseExited(MouseEvent me)
		{
			Object ob = me.getSource();
			
			if(ob instanceof JComponent)
			{
				JComponent jc = (JComponent)ob;
				jc.setBackground(oldColor);
			}
		}
	}
}