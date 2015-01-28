import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.*;


public class UI extends JFrame implements ActionListener
{
	Font titleFont = new Font(Font.SANS_SERIF, Font.BOLD, 32);
	Font font = new Font(Font.SANS_SERIF, Font.PLAIN, 24);
	Font f = new Font(Font.SANS_SERIF, Font.PLAIN, 15);
	
	JPanel gamePan = new JPanel(new BorderLayout());
	JPanel helpPan = new JPanel();
	JPanel topPan = new JPanel(new GridBagLayout());
	JPanel centerPan = new JPanel(new GridLayout(5, 6));
	JTabbedPane tabs = new JTabbedPane();
	
	GridBagConstraints gbc = new GridBagConstraints();
	
	JButton calculateBut = new JButton("Calculate");
	
	JLabel title = new JLabel("Mahjong ber�knare", JLabel.CENTER);
	JLabel picture = new JLabel(new ImageIcon("Mahjong mur.jpg"));
	
	ArrayList<Player> players = new ArrayList<>();
	ArrayList<JTextField> writtenScore = new ArrayList<>();
	ArrayList<JCheckBox> mahjongBoxes = new ArrayList<>();
	ArrayList<JLabel> nameAndWind = new ArrayList<>();
	ArrayList<JLabel> totAndRoundScoreText = new ArrayList<>();
	
	HashMap<String, Boolean> isRondensVind = new HashMap<>();
	
	JTextArea pointInfo = new JTextArea();
	JTextArea doubling = new JTextArea();
	
	int round = 1;
	
	public UI()
	{
		jOptionPaneSettings();
		setTitle("Mahjong ber�knare");
		setExtendedState(MAXIMIZED_BOTH);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		fillDefConstructor();
		addComponents();
		setVisible(true);
	}
	
	public void jOptionPaneSettings()
	{
		int mp = 4; //Max players
		GridLayout layout = new GridLayout(2, 5);
		layout.setHgap(10);
		JPanel startWindow = new JPanel(layout);
		JTextField[] playerName = new JTextField[4];
		ArrayList<JLabel> winds = new ArrayList<JLabel>();
		String[] ws = {"�stan", "Sunnan", "V�stan", "Nordan"};
		JLabel vindLabel = new JLabel("Vind:");
		
		for (int i = 0; i < mp; i++)
		{
			JLabel v = new JLabel();
			v.setText(ws[i]);
			winds.add(v);
		}
		
		startWindow.add(new JLabel("Skriv namn:"));
		for(int i = 0; i < 4; i++)
		{
			playerName[i] = new JTextField(5);
			startWindow.add(playerName[i]);
		}
		
		startWindow.add(vindLabel);
		
		for (JLabel l : winds)
		{	
			startWindow.add(l);
		}
		
		
		boolean ok = false;
		boolean firstTry = true;
		
		while (!ok)
		{
			
			if(firstTry)
			{		
				firstTry = false;
			}
			else
			{
				vindLabel.setText("Du gl�mde �stan!");
			}
			
			int okCancel = JOptionPane.showConfirmDialog(null, startWindow, "hi", JOptionPane.OK_CANCEL_OPTION);
			
			players.clear();
			
			if(okCancel == 0)
			{
				for (int i = 0; i < mp; i++)
				{
					if (!playerName[i].getText().isEmpty())
					{
						Player p = new Player(playerName[i].getText(), winds.get(i).getText());
						players.add(p);
					}
				}
			}
			
			for (Player p : players)
			{
				if (p.wind == "�stan")
				{
					ok = true;
					break;
				}
			}
			
			if(okCancel == -1 || okCancel == 2)
			{
				System.exit(0);
			}
		}
		
		
	}
	
	public void fillDefConstructor()
	{
		picture.setPreferredSize(new Dimension(250, 175));
		gamePan.add(BorderLayout.NORTH, topPan);
		title.setFont(titleFont);
		calculateBut.addActionListener(this);
		pointInfo.setFont(f);
		doubling.setFont(f);
		pointInfo.setEditable(false);
		doubling.setEditable(false);
		pointInfo.setText("Kong (fyrtal)"
				+ "\n� Dold Kong av Drakar eller Vindar: 32p."
				+ "\n� �ppen Kong av Drakar eller Vindar: 16p."
				+ "\n� Dold Kong av 1:or eller 9:or ur n�gon serie: 32p."
				+ "\n� �ppen Kong av 1:or eller 9:or ur n�gon serie: 16p."
				+ "\n� Dold Kong av 2:or till 8:or ur n�gon serie: 16p."
				+ "\n� �ppen Kong av 2:or till 8:or ur n�gon serie: 8p.\n"
				+ "\nPong (tretal)"
				+ "\n� Dold Pong av Drakar eller Vindar: 8p."
				+ "\n� �ppen Pong av Drakar eller Vindar: 4p."
				+ "\n� Dold Pong av 1:or eller 9:or ur n�gon serie: 8p."
				+ "\n� �ppen Pong av 1:or eller 9:or ur n�gon serie: 4p."
				+ "\n� Dold Pong av 2:or till 8:or ur n�gon serie: 4p."
				+ "\n� �ppen Pong av 2:or till 8:or ur n�gon serie: 2p.\n"
				+ "\nChow (par)"
				+ "\n� Ett par av Rondens vind om den samtidigt �r egen vind: 4p."
				+ "\n� Ett par av Drake, Rondens vind eller Egen vind: 2p.\n"
				+ "\nF�ljder (stegar)"
				+ "\n� F�ljder ger aldrig po�ng.\n"
				+ "\nBlommor och �rstider"
				+ "\n� F�r varje Blomma/�rstid: 4p.\n"
				+ "\nPo�ng till vinnaren"
				+ "\n� F�r Mah Jong (vinsten av spelet): 20p."
				+ "\n� F�r v�rdel�s hand: 10p."
				+ "\n� F�r spr�ngd Kong: 10p."
				+ "\n� Om vinstbrickan �r en av de l�sa brickorna: 10p."
				+ "\n� Om vinstbrickan var den enda m�jliga: 2p."
				+ "\n� Om vinstbrickan dras fr�n muren: 2p.");
		doubling.setText("Dubbleringar"
				+ "\n� Pong eller Kong av Drakar: 1 dubblering."
				+ "\n� Pong eller Kong av Egen vind: 1 dubblering."
				+ "\n� Pong eller Kong av Rondens vind: 1 dubblering.\n"
				+ "\nF�ljande dubbleringar g�ller endast f�r vinnaren:"
				+ "\n� Vinnaren f�r Mah Jong med den sista brickan fr�n muren\n(Ruinens 14 brickor ska finnas kvar): 1 dubblering."
				+ "\n� Handen inneh�ller bara Vindar, Drakar, 1:or och 9:or: 1 dubblering."
				+ "\n� Handen inneh�ller inga f�ljder (bara Pong och Kong): 1 dubblering."
				+ "\n� Handen inneh�ller brickor ur en serie, samt Vindar eller Drakar: 1 dubblering."
				+ "\n� Handen inneh�ller en Kong eller Pong av spelarens egna vindbrickor,\nvilka motsvarar Rondens vind: 2 dubbleringar."
				+ "\n� Handen inneh�ller grupper ur bara en serie: 3 dubbleringar."
				+ "\n� Handen inneh�ller tv� Pong av Drakar och en Pong av spelarens vindbrickor,\nsamtidigt som resterande brickor �r ur en och samma serie: 4 dubbleringar."
				+ "\n� Handen inneh�ller en Pong av spelarens egna vindbrickor,\nsamtidigt som resterande brickor �r ur en och samma serie: 5 dubbleringar.");
		helpPan.setBackground(Color.WHITE);
		helpPan.setLayout(new GridLayout(1, 2));
		pointInfo.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		doubling.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		helpPan.add(pointInfo);
		helpPan.add(doubling);
		tabs.add(gamePan, "Ber�knare");
		tabs.add(helpPan, "Hj�lp");
		add(tabs);

		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.weightx = 0.5;
		gbc.insets = new Insets(5, 100, 5, 0);
		topPan.add(title, gbc);
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.weightx = 0.5;
		gbc.insets = new Insets(5, 100, 5, 0);
		topPan.add(picture, gbc);
		gbc.gridx = 1;
		gbc.gridy = 0;
		gbc.weightx = 0.0;
		gbc.insets = new Insets(15, 0, 0, 20);
		gbc.ipadx = 10;
		gbc.ipady = 5;
		topPan.add(calculateBut, gbc);
		
		for(Player player : players)
		{
			if(player.wind == "�stan")
				isRondensVind.put(player.wind, true);
			
			else
				isRondensVind.put(player.wind, false);
		}
	}
	
	private void updateComponents()
	{
		for(int i = 0; i < players.size(); i++)
		{
			if(isRondensVind.get(players.get(i).wind))
			{
				nameAndWind.get(i).setText(players.get(i).name + " (" + players.get(i).wind + ") (R)");
			}
			else
			{
				nameAndWind.get(i).setText(players.get(i).name + " (" + players.get(i).wind + ")");
			}
			
			writtenScore.get(i).setText("");
			
			if(players.get(i).mahjong)
			{
				mahjongBoxes.get(i).setSelected(false);
			}
		}
	}
	
	public void addComponents()
	{
		
		for(int rad = 0; rad < 5; rad++)
		{
			for(int col = 0; col < players.size() + 1; col++)
			{
				if(rad == 0)
				{
					if(col > 0)
					{
						
						if(isRondensVind.get(players.get(col - 1).wind))
						{
							JLabel holder = new JLabel(players.get(col - 1).name + " (" + players.get(col - 1).wind + ") (R)", SwingConstants.CENTER);
							holder.setFont(font);
							holder.setBorder(BorderFactory.createLineBorder(Color.BLACK));
							centerPan.add(holder);
							nameAndWind.add(holder);
						}
						else
						{
							JLabel holder = new JLabel(players.get(col - 1).name + " (" + players.get(col - 1).wind + ")", SwingConstants.CENTER);
							holder.setFont(font);
							holder.setBorder(BorderFactory.createLineBorder(Color.BLACK));
							centerPan.add(holder);
							nameAndWind.add(holder);
						}
					}
					
					else if(col == 0)
					{
						JLabel r = new JLabel("Namn:", SwingConstants.CENTER);
						r.setFont(titleFont);
						r.setBorder(BorderFactory.createLineBorder(Color.BLACK));
						centerPan.add(r);
					}
				}
				
				else if(rad == 1)
				{
					if(col > 0)
					{
						JTextField textField = new JTextField();
						textField.setHorizontalAlignment(JTextField.CENTER);
						textField.setFont(font);
						textField.setBorder(BorderFactory.createLineBorder(Color.BLACK));
						centerPan.add(textField);
						writtenScore.add(textField);
					}
					
					else
					{
						JLabel r = new JLabel("Egen Po�ng:", SwingConstants.CENTER);
						r.setFont(titleFont);
						r.setBorder(BorderFactory.createLineBorder(Color.BLACK));
						centerPan.add(r);
					}
				}
				
				else if(rad == 2)
				{
					if(col > 0)
					{
						JCheckBox box = new JCheckBox();
						box.setBorderPainted(true);
						box.setBorder(BorderFactory.createLineBorder(Color.BLACK));
						box.setBackground(Color.WHITE);
						centerPan.add(box);
						mahjongBoxes.add(box);
					}
					
					else
					{
						JLabel r = new JLabel("Mahjong:", SwingConstants.CENTER);
						r.setFont(titleFont);
						r.setBorder(BorderFactory.createLineBorder(Color.BLACK));
						centerPan.add(r);
					}
				}
				
				else if(rad == 3 || rad == 4)
				{
					if(col > 0)
					{
						JLabel lab = new JLabel("", SwingConstants.CENTER);
						lab.setFont(font);
						lab.setBorder(BorderFactory.createLineBorder(Color.BLACK));
						centerPan.add(lab);
						totAndRoundScoreText.add(lab);
					}
					
					else
					{
						if(rad == 3)
						{
							JLabel r = new JLabel("Rundans Po�ng:", SwingConstants.CENTER);
							r.setFont(titleFont);
							r.setBorder(BorderFactory.createLineBorder(Color.BLACK));
							centerPan.add(r);
						}
						
						else
						{
							JLabel r = new JLabel("Total Po�ng:", SwingConstants.CENTER);
							r.setFont(titleFont);
							r.setBorder(BorderFactory.createLineBorder(Color.BLACK));
							centerPan.add(r);
						}
					}
				}
			}
		}
		
		centerPan.setBackground(Color.WHITE);
		gamePan.add(centerPan);
	}
	
	private void initCalculate()
	{	
		for(JTextField field : writtenScore) // Kollar s� att textf�ltet inte �r tomt
		{
			if(field.getText().isEmpty())
			{
				JOptionPane.showMessageDialog(this, "Du fyllde inte i alla egen po�ng.", "...", 2);
				return;
			}
		}
		
		for(JTextField field : writtenScore)
		{
			for(int i = 0; i < field.getText().length(); i++)
			{
				if(Character.isLetter(field.getText().charAt(i)))
				{
					JOptionPane.showMessageDialog(null, "Du anv�nde bokst�ver i textrutan", "...", 2);
					return;
				}
			}
		}
		
		int numOfSelectedBoxes = 0;
		for(JCheckBox box : mahjongBoxes)
		{
			if(box.isSelected())
			{
				numOfSelectedBoxes++;
			}
		}
		if(numOfSelectedBoxes == 0 || numOfSelectedBoxes > 1)
		{
			JOptionPane.showMessageDialog(this, "Du gl�mde fylla i mahjong rutan eller fyllde i flera.", "...", 2);
			return;
		}
		
		for(int i = 0; i < players.size(); i++)
		{
			players.get(i).currentscore = Integer.parseInt(writtenScore.get(i).getText());
			players.get(i).mahjong = mahjongBoxes.get(i).isSelected();
		}
		
		
		calculateScore();
		
		HashMap<Player, String> windMap = new HashMap<>();
		
		int i = 0;				
		for (Player p : players)
		{
			int next = i < players.size() - 1 ? i+1 : 0;
			windMap.put(players.get(next), p.wind);
			i++;
		}
		
		for (Player p : players)
		{
			p.wind = windMap.get(p);
		}
		
		if(round == players.size() * players.size())
		{
			round = 0;
		}
		
		if(round % players.size() == 0)
		{
			if(round == 0)
			{
				isRondensVind.put(players.get(players.size() - 1).wind, false);
				isRondensVind.put(players.get(round / players.size()).wind, true);
			}
			else
			{
				isRondensVind.put(players.get(round / players.size() - 1).wind, false);
				isRondensVind.put(players.get(round / players.size()).wind, true);
			}
			
		}
		round++;
		updateComponents();
	}
	
	private void calculateScore()
	{	
		for(int i = 0; i < players.size(); i++)
		{
			players.get(i).roundScore = 0;
		}
		for(int i = 0; i < players.size(); i++)
		{	
			if(players.get(i).mahjong)
			{
				if(isRondensVind.get(players.get(i).wind))
				{
					players.get(i).roundScore += Integer.parseInt(writtenScore.get(i).getText()) * ((players.size() - 1) * 2);
					players.get(i).totalScore += Integer.parseInt(writtenScore.get(i).getText()) * ((players.size() - 1) * 2);
					
					for(Player p : players)
					{
						if(p == players.get(i)){}
						
						else
						{
							p.roundScore -= Integer.parseInt(writtenScore.get(i).getText()) * 2;
							p.totalScore -= Integer.parseInt(writtenScore.get(i).getText()) * 2;
						}
					}
				}
				
				else
				{
					players.get(i).roundScore += Integer.parseInt(writtenScore.get(i).getText()) * players.size();
					players.get(i).totalScore += Integer.parseInt(writtenScore.get(i).getText()) * players.size();
					
					for(Player p : players)
					{
						if(p == players.get(i)){}
						
						else
						{
							if(isRondensVind.get(p.wind))
							{
								p.roundScore -= Integer.parseInt(writtenScore.get(i).getText()) * 2;
								p.totalScore -= Integer.parseInt(writtenScore.get(i).getText()) * 2;
							}
							
							else
							{
								p.roundScore -= Integer.parseInt(writtenScore.get(i).getText());
								p.totalScore -= Integer.parseInt(writtenScore.get(i).getText());
							}
						}
					}
				}
			}
			
			else
			{
				for(Player p : players)
				{
					if(p == players.get(i)){}
					else if(p.mahjong){}
					
					else
					{
						if(players.get(i).currentscore > p.currentscore)
						{
							int scoreDif = players.get(i).currentscore - p.currentscore;
							
							if(isRondensVind.get(players.get(i).wind) || isRondensVind.get(p.wind))
							{
								players.get(i).roundScore += scoreDif * 2;
								p.roundScore -= scoreDif * 2;
								players.get(i).totalScore += scoreDif * 2;
								p.totalScore -= scoreDif * 2;
							}
							
							else
							{
								players.get(i).roundScore += scoreDif;
								p.roundScore -= scoreDif;
								players.get(i).totalScore += scoreDif;
								p.totalScore -= scoreDif;
							}
						}
					}
				}
			}
		}
		
		for(int i = 0; i < players.size(); i++)
		{
			totAndRoundScoreText.get(i).setText("" + players.get(i).roundScore);
			totAndRoundScoreText.get(i + players.size()).setText("" + players.get(i).totalScore);
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent ae) 
	{
		Object ob = ae.getSource();
		
		if(ob instanceof JButton)
		{
			if(((JButton) ob).getText() == "Calculate")
			initCalculate();
		}
	}
	
	public class KeyHandler extends KeyAdapter
	{
		public void keyPressed(KeyEvent k)
		{
			if(k.getKeyCode() == KeyEvent.VK_ENTER)
			{
				System.out.println("h");
				initCalculate();
			}
		}
	}
}