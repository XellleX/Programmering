import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.TextArea;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.text.StyleConstants;


public class Hangman extends JFrame implements ActionListener
{
	private JPanel bottomPan = new JPanel();
	private JPanel topPan = new JPanel();
	private JPanel centerPan = new Draw();
	private JPanel eastPan = new JPanel();
	private JTextArea ta = new JTextArea(); // Visar de fel gissade bokstäverna
	private JButton restartButton = new JButton("Starta om");
	private JButton rulesButton = new JButton("Regler");
	private JTextField textField = new JTextField(); // Där man skriver in bokstaven man vill gissa på
	private JLabel wordLabel = new JLabel(); // Visar hur många bokstäver ordet har och vilka man gissat rätt på
	private ArrayList<Character> guessedLetters = new ArrayList<>();
	public static ArrayList<Character> wrongGuessedLetters = new ArrayList<>();
	private Font font = new Font(Font.SANS_SERIF, Font.BOLD, 30);
	public String word;
	public StringBuffer showedText = new StringBuffer(); // Innehåller ordet så som det ska visas (en * om man inte gissat den bokstaven rätt)
	public Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	
	public Hangman()
	{
		setTitle("Hangman");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		setSize(screenSize);
		fillDefConstructor();
		try {
			selectWord();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		nextWord();
		setVisible(true);
	}
	
	public void restart()
	{
		this.dispose();
		new Hangman();
		wrongGuessedLetters.clear();
		guessedLetters.clear();
	}
	
	public void fillDefConstructor()
	{
		ta.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		ta.setPreferredSize(new Dimension(100,0));
		ta.setEditable(false);
		ta.setFont(font);
		textField.setDocument(new JTextFieldLimit(1)); // Gör så att man bara kan skriva en bokstav i textField
		textField.setPreferredSize(new Dimension(100, 25));
		textField.addKeyListener(new keyBoard());
		bottomPan.add(textField);
		wordLabel.setFont(font);
		restartButton.addActionListener(this);
		rulesButton.addActionListener(this);
		eastPan.add(restartButton);
		eastPan.add(rulesButton);
		add(BorderLayout.EAST, eastPan);
		add(BorderLayout.WEST, ta);
		add(BorderLayout.SOUTH, bottomPan);
		add(BorderLayout.CENTER, centerPan);
	}	
	
	public void selectWord() throws IOException // Väljer ett slumpat ord från textfilen
	{
		BufferedReader reader = new BufferedReader(new FileReader("mathWords.txt")); 
		String readingWords;
		ArrayList<String> words = new ArrayList<>();
		readingWords = reader.readLine();
		
		while(readingWords != null) // Lägger till alla ord i textfilen in i en arraylist
		{
			words.add(readingWords);
			readingWords = reader.readLine();
		}
		
		word = words.get((int)Math.floor(Math.random() * words.size())); // Väljer ett slumpat ord
	}
	
	public void nextWord() // Skriver ut ordet som stjärnor så att spelaren inte vet vad ordet är
	{
		System.out.println(word);
		
		for (char c : word.toCharArray())
		{
			String holder = wordLabel.getText();
			
			if(c == ' ')
			{
				wordLabel.setText(holder + " ");
			}
			
			else
			{
				wordLabel.setText(holder + "*");
			}
		}
		
		showedText.append(wordLabel.getText());
		System.out.println(showedText);
		topPan.add(wordLabel);
		add(BorderLayout.NORTH, topPan);
	}
	
	@Override
	public void actionPerformed(ActionEvent ae) // Gör något när man trycker på en av knapparna
	{
		if(ae.getSource() == restartButton) // Startar om
		{
			restart();
		}
		
		if(ae.getSource() == rulesButton) // Visar reglerna
		{
			JOptionPane.showMessageDialog(this, "Regler: \nDu ska gissa ordet. För att gissa skriv bokstaven längst ner i textrutan och tryck sedan 'Enter'."
					+ "\nOm du gissar fel 8 gånger förlorar du.");
		}
	}
	
	public class keyBoard extends KeyAdapter
	{
		public void keyTyped(KeyEvent ke) 
		{
			if(ke.getKeyChar() == KeyEvent.VK_ENTER) // kollar så att det är Enter spelaren trycker på
			{
				if(textField.getText().equals("")) // Kollar så att textfältet man skriver i inte är tomt
				{
					return;
				}
				
				char letter = textField.getText().charAt(0); // Hämtar bokstaven spelaren skrivit in
				letter = Character.toUpperCase(letter); 
				
				if(!Character.isLetter(letter)) // Kollar så att spelaren skrivit in en bokstav och inte siffra eller annat tecken
				{
					return;
				}
				
				textField.setText("");
				int index = 0; // Håller koll på vart i ordet den rätt gissade bokstaven ska sättas in
				boolean letterInWord = false;
				boolean usedLetter = false;
				
				for(char c : guessedLetters)
				{
					if(Character.toLowerCase(letter) == Character.toLowerCase(c)) // Kollar om man redan använt bokstaven
					{
						usedLetter = true;
					}
				}
				
				if(!usedLetter)
				{
					
					for (char c : word.toCharArray())
					{
						// Kollar om bokstaven finns i ordet, bryr sig inte om det är stor eller liten bokstav
						if(Character.toLowerCase(c) == Character.toLowerCase(letter)) 
						{
							showedText.setCharAt(index, letter); // Ersätter en stjärna med bokstaven man gissa rätt på
							wordLabel.setText(showedText.toString());
							letterInWord = true;
						}
						
						index++;
					}
					
					// Om bokstaven inte fanns i ordet, skrivs den ut bredvid och en del av hangman ritas.
					if(!letterInWord)
					{
						ta.append(letter + "\n");
						centerPan.repaint();
						wrongGuessedLetters.add(letter);
					}
					
					guessedLetters.add(letter);
				}
				
				// Om man redan gissat bokstaven säger den det.
				else
				{
					JOptionPane.showMessageDialog(null, "Du har redan gissat på den bokstaven", "Gissat", 0);
				}
				
				// Kollar om man gissat rätt på hela ordet och restartar eller stänger ner.
				if(showedText.toString().equalsIgnoreCase(word))
				{
					int restart = JOptionPane.showConfirmDialog(null, "Vill du spela igen?", "Du vann!", JOptionPane.YES_NO_OPTION);
					
					if(restart == 1)
					{
						System.exit(0);
					}
					
					else
					{
						restart();
					}
				}
				
				// Kollar om man gissat fel 8 gånger och förlorat
				else if(wrongGuessedLetters.size() >= 8)
				{
					int restart = JOptionPane.showConfirmDialog(null, "Ordet var " + word + "\nVill du spela igen?", "Du förlora!", JOptionPane.YES_NO_OPTION);
					
					if(restart == 1)
					{
						System.exit(0);
					}
					
					else
					{
						restart();
					}
				
				}
			}
		}
	}
}
