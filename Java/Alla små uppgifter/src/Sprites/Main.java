package Sprites;

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
	Player p1 = new Player();
	AnimPanel animPan = new AnimPanel(p1);
	
	boolean[] keyDown = new boolean[]{false, false, false, false, false, false};
	
	boolean isRunning = true;
	
	public Main()
	{
		setTitle("Run");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 500);
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
		add(animPan);
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
			animPan.repaint();
			doGameUpdates();
		}
	}
	
	public void doGameUpdates()
	{
		if(keyDown[0])
		{
			p1.vx = -2;
			p1.vy = 0;
			p1.step(1);
		}
		
		if(keyDown[1])
		{
			p1.vx = 2;
			p1.vy = 0;
			p1.step(2);
		}
		
		if(keyDown[2])
		{
			p1.vy = -2;
			p1.vx = 0;
			p1.step(3);
		}
		
		if(keyDown[3])
		{
			p1.vy = 2;
			p1.vx = 0;
			p1.step(0);
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