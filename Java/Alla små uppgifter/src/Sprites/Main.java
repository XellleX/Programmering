package Sprites;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Main extends JFrame
{
	World w = new World();
	Player p1 = new Player(300, 400, w.tileMap);
	Panel pan = new Panel(p1, w);
	
	boolean[] keyDown = new boolean[]{false, false, false, false, false, false};
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
			} 
			catch (InterruptedException e) {}
			pan.repaint();
			doGameUpdates();
		}
	}
	
	public void doGameUpdates()
	{
		System.out.println(p1.collisions()[0] + ", " + p1.collisions()[1] + ", " + p1.collisions()[2] + ", " + p1.collisions()[3]);
		if(keyDown[0])
		{
			if(p1.collisions()[0])
			{
				p1.vx = 0;
				p1.vy = 0;
			}
			
			else
			{
				p1.vx = -2;
				p1.vy = 0;
			}
			p1.step(1);
		}
		
		else if(keyDown[1])
		{
			if(p1.collisions()[1])
			{
				p1.vx = 0;
				p1.vy = 0;
			}
			
			else
			{
				p1.vx = 2;
				p1.vy = 0;
			}
			p1.step(2);
		}
		
		else if(keyDown[2])
		{
			if(p1.collisions()[2])
			{
				p1.vx = 0;
				p1.vy = 0;
			}
			
			else
			{
				p1.vx = 0;
				p1.vy = -2;
			}
			p1.step(3);
		}
		
		else if(keyDown[3])
		{
			if(p1.collisions()[3])
			{
				p1.vx = 0;
				p1.vy = 0;
			}
			
			else
			{
				p1.vx = 0;
				p1.vy = 2;
			}
			p1.step(0);
		}
		
		else
		{
			p1.imageNumX = 0;
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
				case KeyEvent.VK_A:
					keyDown[0] = true;
					break;
				case KeyEvent.VK_D:
					keyDown[1] = true;
					break;
				case KeyEvent.VK_W:
					keyDown[2] = true;
					break;
				case KeyEvent.VK_S:
					keyDown[3] = true;
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
				case KeyEvent.VK_D:
					keyDown[1] = false;
					break;
				case KeyEvent.VK_W:
					keyDown[2] = false;
					break;
				case KeyEvent.VK_S:
					keyDown[3] = false;
					break;
			}
		}
		
	}
}