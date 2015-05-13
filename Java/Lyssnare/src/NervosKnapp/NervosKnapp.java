package NervosKnapp;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class NervosKnapp extends JFrame
{
	JPanel pan = new JPanel();
	JLabel lab = new JLabel(new ImageIcon("face_icon_scared.png"));
	Dimension screenSize;
	
	public NervosKnapp()
	{
		setTitle("SPRING");
		setExtendedState(MAXIMIZED_BOTH);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		//lab.setPreferredSize(new Dimension(300, 300));
		pan.add(lab);
		this.addMouseMotionListener(new MouseAdapt());
		add(pan);
		//setResizable(false);
		setVisible(true);
		
		
	}

	public static void main(String[] args) 
	{
		new NervosKnapp();
	}
	
	class MouseAdapt extends MouseMotionAdapter
	{

		@Override
		public void mouseMoved(MouseEvent me) 
		{
			screenSize = new Dimension(getWidth(), getHeight());
			
			int blx = lab.getX();
			int brx = lab.getX() + lab.getWidth();
			int buy = lab.getY();
			int bly = lab.getY() + lab.getHeight();
			
			if(me.getX() > blx - 70 && me.getX() < brx + 70 && me.getY() > buy - 70 && me.getY() < bly + 70)
			{
				System.out.println(screenSize);
				lab.setLocation((int)Math.round((screenSize.width - lab.getWidth()) * Math.random()), (int)Math.round((screenSize.height - lab.getHeight()) * Math.random()));
			}
		}
		
	}

}
