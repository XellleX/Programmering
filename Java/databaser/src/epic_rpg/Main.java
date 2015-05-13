package epic_rpg;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class Main extends JFrame implements ActionListener
{
	JPanel pan = new JPanel();
	JPanel topPan = new JPanel();
	JPanel centerPan = new JPanel();
	JButton previous = new JButton("Föregående");
	JButton next = new JButton("Nästa");
	JButton seeList = new JButton("Bläddra genom listan");
	JButton adding = new JButton("Lägg till");
	JLabel of = new JLabel("av", SwingConstants.CENTER);
	JTextField page = new JTextField();
	JTextField numOfPages = new JTextField();
	int pageOn = 1;
	
	public static String insertQuery = "";
	
	Font font = new Font("Times new roman", Font.PLAIN, 18);
	
	ArrayList<JTextField> textf = new ArrayList<>();
	
	public Main()
	{
		setTitle("helluu");
		setBounds(100, 100, 550, 400);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		fillDefConstructor();
		setVisible(true);
	}
	
	public void fillDefConstructor() // Ändrar på komponenter och lägger till dem
	{
		GridLayout grid = new GridLayout(9, 2);
		grid.setHgap(15);
		grid.setVgap(10);
		centerPan.setLayout(grid);
		
		for(int i = 0; i < Player.numOfColumns; i++)
		{
			JLabel lab = new JLabel(Player.columnNames.get(i).toUpperCase());
			JTextField tf = new JTextField();
			tf.setPreferredSize(new Dimension(100, 25));
			
			if(i == 0)
			{
				tf.setEnabled(false);
			}
			
			textf.add(tf);
			lab.setFont(font);
			centerPan.add(lab);
			//centerPan.add(Box.createRigidArea(new Dimension(5, 0)));
			centerPan.add(tf);
		}
		
		page.setHorizontalAlignment(JTextField.CENTER);
		numOfPages.setHorizontalAlignment(JTextField.CENTER);
		
		previous.addActionListener(this);
		next.addActionListener(this);
		seeList.addActionListener(this);
		adding.addActionListener(this);
		
		centerPan.add(seeList);
		centerPan.add(adding);
		page.setEnabled(false);
		numOfPages.setEnabled(false);
		topPan.setLayout(new GridLayout(1, 5));
		topPan.add(previous);
		topPan.add(page);
		topPan.add(of);
		topPan.add(numOfPages);
		topPan.add(next);
		pan.add(BorderLayout.NORTH, topPan);
		pan.add(BorderLayout.CENTER, centerPan);
		centerPan.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		add(pan);
	}
	
	public void showPage() // Visar den information som man ska få på den sidan man är på
	{
		int l = 0;
		page.setText("" + pageOn);
		numOfPages.setText("" + Player.reslutSetObjects.size()/8);
		
		for(int i = Player.numOfColumns * (pageOn - 1); i < Player.numOfColumns * pageOn; i++)
		{
			textf.get(l).setText("" + Player.reslutSetObjects.get(i));
			l++;
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent ae) //Visar lista och byter sida när man trycker på en knapp.
	{
		if(ae.getSource() == adding)
		{
			for(int i = 1; i < textf.size(); i++) // om ett textfält är tomt lägger den in NULL
			{
				String holder = textf.get(i).getText();
				if(i + 1 == textf.size())
				{
					if(holder.isEmpty())
					{
						textf.get(i).setText("NULL");
					}
					else
					{
						textf.get(i).setText("\"" + holder + "\"");
					}
				}
				
				else
				{
					if(holder.isEmpty())
					{
						textf.get(i).setText("NULL, ");
					}
					else
					{
						textf.get(i).setText("\"" + holder + "\", ");
					}
				}
			}
			insertQuery = "INSERT INTO Characters (fname, lname, level, experience, race, class, birthdate) VALUES (" 
					+ textf.get(1).getText() + textf.get(2).getText() + textf.get(3).getText() + textf.get(4).getText() 
					+ textf.get(5).getText() + textf.get(6).getText() + textf.get(7).getText() + ")";
			new Player();
		}
		
		if(ae.getSource() == seeList)
		{
			showPage();
		}
		
		if(ae.getSource() == previous)
		{
			if(pageOn == 1)
			{
				pageOn = Player.reslutSetObjects.size()/8;
			}
			else
			{
				pageOn--;
			}
			
			showPage();
		}
		
		if(ae.getSource() == next)
		{
			if(pageOn == Player.reslutSetObjects.size()/8)
			{
				pageOn = 1;
			}
			else
			{
				pageOn++;
			}
			
			showPage();
		}
	}
	
	public static void main(String[] args) 
	{
		new Player();
		new Main();
	}

	

}
