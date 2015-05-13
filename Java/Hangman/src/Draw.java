import java.awt.Color;
import java.awt.Graphics;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;


public class Draw extends JPanel
{	
	public Draw()
	{
		
	}
	
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		
		if(Hangman.wrongGuessedLetters.size() >= 1) // Ritar kullen
		{
			g.drawArc(450, 500, 250, 100, 0, 180);
		}
		
		if(Hangman.wrongGuessedLetters.size() >= 2) // Ritar pålen
		{
			g.drawLine(575, 500, 575, 200);
		}
		
		if(Hangman.wrongGuessedLetters.size() >= 3) // Ritar sido pålen
		{
			g.drawLine(575, 200, 675, 200);
			g.drawLine(575, 230, 605, 200);
		}
		
		if(Hangman.wrongGuessedLetters.size() >= 4) // Ritar snaran och huvudet
		{
			g.drawLine(675, 200, 675, 230);
			g.drawOval(650, 230, 50, 60);
		}
		
		if(Hangman.wrongGuessedLetters.size() >= 5) // Ritar kroppen
		{
			g.drawLine(675, 290, 675, 350);
		}
		
		if(Hangman.wrongGuessedLetters.size() >= 6) // Ritar benen
		{
			g.drawLine(675, 350, 700, 400);
			g.drawLine(675, 350, 650, 400);
		}
		
		if(Hangman.wrongGuessedLetters.size() >= 7) // Ritar armarna
		{
			g.drawLine(675, 305, 690, 335);
			g.drawLine(675, 305, 660, 335);
		}
		
		if(Hangman.wrongGuessedLetters.size() >= 8) // Ritar ögon och mun
		{
			// Första ögat
			g.drawLine(665, 245, 670, 255);
			g.drawLine(670, 245, 665, 255);
			
			// Andra ögat
			g.drawLine(685, 245, 680, 255);
			g.drawLine(680, 245, 685, 255);
			
			// Mun
			g.drawArc(665, 270, 15, 5, 0, 180);
		}
		
	}
}
