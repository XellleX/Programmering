import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Paint;
import java.awt.Toolkit;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;

import javax.swing.ImageIcon;
import javax.swing.JPanel;


public class GamePanel extends JPanel
{	
	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	
	double screenWidth = screenSize.getWidth();
	double screenHeight = screenSize.getHeight();
	
	Player player1;
	Player player2;
	
	public GamePanel()
	{
		player1 = new Player(50, 0);
		player2 = new Player(1276, 0);
	}
	
	public void drawPlayer(Player p, Graphics g)
	{
		g.translate(p.x, getHeight() - p.y);
		
		p.draw(g);
		
		g.translate(-p.x, p.y - getHeight());
	}
	
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		drawPlayer(player1, g);
		drawPlayer(player2, g);
	}
}
