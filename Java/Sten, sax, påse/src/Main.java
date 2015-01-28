import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class Main extends JFrame
{
	ArrayList<JLabel> labels = new ArrayList<>();
	public JPanel panel = new JPanel();
	public JLabel lab = new JLabel("Spelare 1", JLabel.CENTER);
	public ArrayList<String> choice = new ArrayList<>();
	public boolean bothPlayersDone = false;

	public Main()
	{
		super("Sten, Sax, Påse");
		setBounds(300, 100, 800, 550);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		fillDefConstructor();
		setVisible(true);
	}
	
	public static void main(String[] args) 
	{
		new Main();
	}
	
	public void fillDefConstructor()
	{
		panel.setLayout(new GridLayout(1, 3));
		labels.add(new JLabel(new ImageIcon("sten.png")));
		labels.add(new JLabel(new ImageIcon("sax.png")));
		labels.add(new JLabel(new ImageIcon("påse.png")));
		
		labels.get(0).setName("sten");
		labels.get(1).setName("sax");
		labels.get(2).setName("påse");
		
		for (JLabel l : labels)
		{
			panel.add(l);
			l.addMouseListener(new MusAdapter());
			l.setOpaque(true);
		}
		
		add(BorderLayout.CENTER, panel);
		add(BorderLayout.NORTH, lab);
	}
	
	public void winOrLose()
	{
		if(choice.size() == 2)
		{
			bothPlayersDone = true;
		}
	}
	
	class MusAdapter extends MouseAdapter
	{
		public void mouseClicked(MouseEvent me)
		{
			Object ob = me.getSource();
			
			if(ob instanceof JComponent)
			{
				JComponent jc = (JComponent)ob;
				choice.add(jc.getName());
			}
			
			winOrLose();
			lab.setText("Spelare 2");
		}
	}
	
}
