package Sprites;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.lang.reflect.Array;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Main extends JFrame
{
	int numOfPlayers = 4;
	
	World w = new World();
	ArrayList<DeathBall> balls = new ArrayList<>();
	Player[] players = new Player[numOfPlayers];
	Panel pan;
	
	boolean[] p1KeyDown = new boolean[]{false, false, false, false};
	boolean[] p2KeyDown = new boolean[]{false, false, false, false};
	boolean[] p3KeyDown = new boolean[]{false, false, false, false};
	boolean[] p4KeyDown = new boolean[]{false, false, false, false};
	boolean[][] keysDown = new boolean[][]{p1KeyDown, p2KeyDown, p3KeyDown, p4KeyDown};
	boolean isRunning = true;
	
	public Main()
	{
		setTitle("SPRING");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setExtendedState(MAXIMIZED_BOTH);
		fillDefConst();
		setVisible(true);
		gameLoop();
	}
	
	public static void main(String[] args) 
	{
		new Main();
	}
	
	public void fillDefConst()
	{
		for(int i = 0; i < numOfPlayers; i++)
		{
			if(i == 0)
			{
				Player p = new Player(20, 20, w.tileMap);
				players[i] = p;
			}
			else if(i == 1)
			{
				Player p = new Player(1300, 630, w.tileMap);
				players[i] = p;
			}
			else if(i == 2)
			{
				Player p = new Player(1300, 20, w.tileMap);
				players[i] = p;
			}
			else
			{
				Player p = new Player(20, 630, w.tileMap);
				players[i] = p;
			}
		}
		
			DeathBall ball1 = new DeathBall(820, 550, 0, 5, w.tileMap, players);
			balls.add(ball1);
			DeathBall ball2 = new DeathBall(500, 550, 0, 5, w.tileMap, players);
			balls.add(ball2);
			DeathBall ball3 = new DeathBall(820, 130, 0, 5, w.tileMap, players);
			balls.add(ball3);
			DeathBall ball4 = new DeathBall(500, 130, 0, 5, w.tileMap, players);
			balls.add(ball4);
			DeathBall ball5 = new DeathBall(1010, 550, 0, 4, w.tileMap, players);
			balls.add(ball5);
			DeathBall ball6 = new DeathBall(310, 450, 0, 4, w.tileMap, players);
			balls.add(ball6);
			DeathBall ball7 = new DeathBall(1010, 230, 0, 4, w.tileMap, players);
			balls.add(ball7);
			DeathBall ball8 = new DeathBall(310, 180, 0, 4, w.tileMap, players);
			balls.add(ball8);
		
		pan = new Panel(players, w, balls);
		
		this.addKeyListener(new KeyBoard());
		add(pan);
	}
	
	public void gameLoop()
	{
		while(isRunning)
		{
			try 
			{
				Thread.sleep(17);
				doGameUpdates();
			} 
			catch (InterruptedException e) {}
			pan.repaint();
		}
	}
	
	public void doGameUpdates()
	{
		for(int i = 0; i < balls.size(); i++)
		{
			balls.get(i).collisions();
			balls.get(i).move();
			balls.get(i).ballCollision();
		}
		
		for(int i = 0; i < players.length; i++) // g�r igenom alla spelares nertryckta tangenter
		{
			playerKeysDown(players[i], keysDown[i]);
		}
	}
	
	public void playerKeysDown(Player p, boolean[] keyDown)
	{
		if(keyDown[0]) // v�nster
		{
			p.vx = -p.moveSpeed;
			p.vy = 0;
			if(p.collisions())
			{
				p.vx = 0;
				p.vy = 0;
			}
			p.step(1);
		}
		
		else if(keyDown[1]) // h�ger
		{
			p.vx = p.moveSpeed;
			p.vy = 0;
			if(p.collisions())
			{
				p.vx = 0;
				p.vy = 0;
			}
			p.step(2);
		}
		
		else if(keyDown[2]) // upp
		{
			p.vx = 0;
			p.vy = -p.moveSpeed;
			if(p.collisions())
			{
				p.vx = 0;
				p.vy = 0;
			}
			p.step(3);
		}
		
		else if(keyDown[3]) // ner
		{
			p.vx = 0;
			p.vy = p.moveSpeed;
			if(p.collisions())
			{
				p.vx = 0;
				p.vy = 0;
			}
			p.step(0);
		}
		
		else
		{
			p.imageNumX = 0;
		}
	}
	
	class KeyBoard extends KeyAdapter
	{

		@Override
		public void keyPressed(KeyEvent ke) 
		{
			int key = ke.getExtendedKeyCode();
			
			switch(key)
			{
				//player 1
				case KeyEvent.VK_A:
					p1KeyDown[0] = true;
					break;
				case KeyEvent.VK_D:
					p1KeyDown[1] = true;
					break;
				case KeyEvent.VK_W:
					p1KeyDown[2] = true;
					break;
				case KeyEvent.VK_S:
					p1KeyDown[3] = true;
					break;
					
				//player 2
				case KeyEvent.VK_LEFT:
					p2KeyDown[0] = true;
					break;
				case KeyEvent.VK_RIGHT:
					p2KeyDown[1] = true;
					break;
				case KeyEvent.VK_UP:
					p2KeyDown[2] = true;
					break;
				case KeyEvent.VK_DOWN:
					p2KeyDown[3] = true;
					break;
					
					
				//player 3
				case KeyEvent.VK_NUMPAD1:
					p3KeyDown[0] = true;
					break;
				case KeyEvent.VK_NUMPAD3:
					p3KeyDown[1] = true;
					break;
				case KeyEvent.VK_NUMPAD5:
					p3KeyDown[2] = true;
					break;
				case KeyEvent.VK_NUMPAD2:
					p3KeyDown[3] = true;
					break;
					
				//player 4
				case KeyEvent.VK_H:
					p4KeyDown[0] = true;
					break;
				case KeyEvent.VK_K:
					p4KeyDown[1] = true;
					break;
				case KeyEvent.VK_U:
					p4KeyDown[2] = true;
					break;
				case KeyEvent.VK_J:
					p4KeyDown[3] = true;
					break;
			}
		}

		@Override
		public void keyReleased(KeyEvent ke) 
		{
			int key = ke.getExtendedKeyCode();
			
			switch(key)
			{
				//player 1
				case KeyEvent.VK_A:
					p1KeyDown[0] = false;
					break;
				case KeyEvent.VK_D:
					p1KeyDown[1] = false;
					break;
				case KeyEvent.VK_W:
					p1KeyDown[2] = false;
					break;
				case KeyEvent.VK_S:
					p1KeyDown[3] = false;
					break;
					
				//player 2
				case KeyEvent.VK_LEFT:
					p2KeyDown[0] = false;
					break;
				case KeyEvent.VK_RIGHT:
					p2KeyDown[1] = false;
					break;
				case KeyEvent.VK_UP:
					p2KeyDown[2] = false;
					break;
				case KeyEvent.VK_DOWN:
					p2KeyDown[3] = false;
					break;
					
					
				//player 3
				case KeyEvent.VK_NUMPAD1:
					p3KeyDown[0] = false;
					break;
				case KeyEvent.VK_NUMPAD3:
					p3KeyDown[1] = false;
					break;
				case KeyEvent.VK_NUMPAD5:
					p3KeyDown[2] = false;
					break;
				case KeyEvent.VK_NUMPAD2:
					p3KeyDown[3] = false;
					break;
					
				//player 4
				case KeyEvent.VK_H:
					p4KeyDown[0] = false;
					break;
				case KeyEvent.VK_K:
					p4KeyDown[1] = false;
					break;
				case KeyEvent.VK_U:
					p4KeyDown[2] = false;
					break;
				case KeyEvent.VK_J:
					p4KeyDown[3] = false;
					break;
			}
		}
		
	}
}