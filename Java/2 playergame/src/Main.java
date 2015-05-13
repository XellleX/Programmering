import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.renderable.RenderableImage;
import java.lang.reflect.Array;

import javax.swing.JFrame;
import javax.swing.JPanel;


public class Main extends JFrame
{
	GamePanel gamePan = new GamePanel();
	
	boolean[] keyDown = new boolean[]{false, false, false, false, false, false};
	
	private boolean isRunning = true;
	
	private int walkSpeed = 3;
	
	private final double GRAVITATION = 0.5;
	
	private boolean collisionOn = true;
	private boolean sideCollision1 = false;
	private boolean sideCollision2 = false;
	
	public Main()
	{
		setTitle("Game");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setExtendedState(MAXIMIZED_BOTH);
		fillDefConstructor();
		setVisible(true);
		gameLoop();
	}
	
	public void fillDefConstructor()
	{
		this.addKeyListener(new KeyBoard());
		add(gamePan);
	}
	
	public static void main(String[] args) 
	{
		new Main();
	}
	
	public void gameLoop()
	{
		while(isRunning)
		{
			checkCollisions(gamePan.player1, gamePan.player2);
			doGameUpdates();
			
			try 
			{
				Thread.sleep(10);
			} 
			catch (InterruptedException e) {}
		}
	}
	
	public void checkCollisions(Player p1, Player p2)
	{	
		if((p1.x + 40 < p2.x && p1.x + 40 > p2.x - 10) && 
		(p1.y < p2.y + 150 && p2.y < p1.y + 150))
		{
			sideCollision1 = collisionOn;
		}
		else
		{
			sideCollision1 = false;
		}
		
		if((p2.x + 40 < p1.x && p2.x + 40 > p1.x - 10) && 
			(p2.y < p1.y + 150 && p1.y < p2.y + 150))
		{
			sideCollision2 = collisionOn;
		}
		else
		{
			sideCollision2 = false;
		}
	}
	
	public void doGameUpdates()
	{	
		if(keyDown[0] && !sideCollision2)
		{
			gamePan.player1.translate(-walkSpeed, 0);
		}
		
		if(keyDown[1])
		{
			if (gamePan.player1.footing())
			{
				playerJump(gamePan.player1);
			}
		}
		
		if(keyDown[2] && !sideCollision1)
		{
			gamePan.player1.translate(walkSpeed, 0);
		}
		
		if(keyDown[3] && !sideCollision1)
		{
			gamePan.player2.translate(-walkSpeed, 0);
		}
		
		if(keyDown[4])
		{
			if (gamePan.player2.footing())
			{
				playerJump(gamePan.player2);
			}
		}
		
		if(keyDown[5] && !sideCollision2)
		{
			gamePan.player2.translate(walkSpeed, 0);
		}
		
		if(!gamePan.player1.footing())
		{
			gamePan.player1.accelerate(0, -GRAVITATION);
		}
		
		if(!gamePan.player2.footing())
		{
			gamePan.player2.accelerate(0, -GRAVITATION);
		}
		
		gamePan.player1.step();
		gamePan.player2.step();
		
		if(gamePan.player1.x + 20 < 0)
		{
			gamePan.player1.x = 1346;
		}
		
		if(gamePan.player1.x + 20 > 1366)
		{
			gamePan.player1.x = -20;
		}
		
		if(gamePan.player2.x + 20 < 0)
		{
			gamePan.player2.x = 1346;
		}
		
		if(gamePan.player2.x + 20 > 1366)
		{
			gamePan.player2.x = -20;
		}
		
		if(gamePan.player1.footing())
		{
			gamePan.player1.y = 0;
			gamePan.player1.vy = 0;
		}
		
		if(gamePan.player2.footing())
		{
			gamePan.player2.y = 0;
			gamePan.player2.vy = 0;
		}
		
		gamePan.repaint();
	}
	
	public void playerJump(Player p)
	{
		p.accelerate(0, 13);
	}

	public class KeyBoard extends KeyAdapter
	{

		@Override
		public void keyPressed(KeyEvent ke) 
		{
			int key = ke.getExtendedKeyCode();
			switch(key)
			{
				case KeyEvent.VK_A:	
					keyDown[0] = true;
					break;
				case KeyEvent.VK_W:	
					keyDown[1] = true;
					break;
				case KeyEvent.VK_D:	
					keyDown[2] = true;
					break;
				case KeyEvent.VK_LEFT:	
					keyDown[3] = true;
					break;
				case KeyEvent.VK_UP:	
					keyDown[4] = true;
					break;
				case KeyEvent.VK_RIGHT:	
					keyDown[5] = true;
					break;
			}
		}

		@Override
		public void keyReleased(KeyEvent ke) 
		{
			int key = ke.getExtendedKeyCode();
			switch(key)
			{
				case KeyEvent.VK_A:	
					keyDown[0] = false;
					break;
				case KeyEvent.VK_W:	
					keyDown[1] = false;
					break;
				case KeyEvent.VK_D:	
					keyDown[2] = false;
					break;
				case KeyEvent.VK_LEFT:	
					keyDown[3] = false;
					break;
				case KeyEvent.VK_UP:	
					keyDown[4] = false;
					break;
				case KeyEvent.VK_RIGHT:	
					keyDown[5] = false;
					break;
			}
		}
		
	}
}
