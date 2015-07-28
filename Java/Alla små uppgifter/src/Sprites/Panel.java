package Sprites;

import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JPanel;

public class Panel extends JPanel
{
	Player[] players;
	World w;
	ArrayList<DeathBall> balls;
	
	public Panel(Player[] p, World w, ArrayList<DeathBall> d)
	{
		this.w = w;
		players = p;
		balls = d;
	}
	
	public void paintComponent(Graphics g) //Draws everything, the world, players and balls
	{
		super.paintComponent(g);
		w.placeTiles(g);
		
		for(int i = 0; i < players.length; i++)
		{
			players[i].draw(g);
		}
		
		for(int i = 0; i < balls.size(); i++)
		{
			balls.get(i).draw(g);
		}
	}
	
}
