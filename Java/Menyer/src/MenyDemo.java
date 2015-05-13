import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.MenuItem;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;


public class MenyDemo extends JFrame implements ActionListener
{
	JMenuBar mb = new JMenuBar();
	JMenu farger = new JMenu("Färger");
	JMenu arkiv = new JMenu("Arkiv");
	JMenuItem[] fargItems = new JMenuItem[6];
	JMenuItem[] arkivItems = new JMenuItem[3];
	String[] arItName = {"Öppna", "Spara", "Avsluta"};
	String[] sFarg = {"Rosa", "Blå", "Gul", "Grön", "Röd", "Vit"};
	Color[] cFarg = {Color.PINK, Color.BLUE, Color.YELLOW, Color.GREEN, Color.RED, Color.WHITE};
	
	JTextArea ta = new JTextArea();
	JScrollPane scroller = new JScrollPane(ta);
	
	JFileChooser file = new JFileChooser();
	
	public MenyDemo()
	{
		setTitle("Meny");
		initMeny();
		add(scroller, BorderLayout.CENTER);
		ta.setLineWrap(true);
		ta.setWrapStyleWord(true);
		setBounds(100, 100, 400, 300);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	private void initMeny()
	{
		setJMenuBar(mb);
		mb.add(arkiv);
		mb.add(farger);
		
		for(int i = 0; i < sFarg.length; i++)
		{
			fargItems[i] = new JMenuItem(sFarg[i]);
			fargItems[i].addActionListener(this);
			farger.add(fargItems[i]);
		}
		
		for(int i = 0; i < arkivItems.length; i++)
		{
			arkivItems[i] = new JMenuItem(arItName[i]);
			arkivItems[i].addActionListener(this);
			arkiv.add(arkivItems[i]);
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent ae) 
	{
		Object ob = ae.getSource();
		
		if(ob instanceof JMenuItem)
		{
			String command = ((JMenuItem) ob).getActionCommand();
			
			for(int i = 0; i < sFarg.length; i++)
			{
				if(command == fargItems[i].getText())
				{
					ta.setBackground(cFarg[i]);
				}
			}
			
			if(command == arkivItems[0].getText())
			{
				if(file.showOpenDialog(null) == JFileChooser.APPROVE_OPTION)
				{
					try 
					{
						FileReader läsSkiten = new FileReader(file.getSelectedFile());
						
						
						ta.read(läsSkiten, null);
						
					} 
					catch (IOException e){}
				}
				
				else 
					System.out.println("fel");
			}
			
			else if(command == arkivItems[1].getText())
			{
				System.out.println("S");
			}
			
			else if(command == arkivItems[2].getText())
			{
				System.exit(0);
			}
		}
		
	}
	
	public static void main(String[] args) 
	{
		new MenyDemo();
	}



}
