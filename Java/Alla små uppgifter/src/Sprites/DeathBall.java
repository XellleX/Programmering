package Sprites;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;

import javax.swing.JPanel;

import Sprites.World.Tile;

public class DeathBall extends JPanel implements Constants
{
	ArrayList<ArrayList<Tile>> tileMap;
	Player[] players;
	
	int x = 0;
	int y = 0;
	double vx;
	double vy;
	
	public DeathBall(int x, int y, double vx, double vy, ArrayList<ArrayList<Tile>> t, Player[] p)
	{
		this.x = x;
		this.y = y;
		this.vx = vx;
		this.vy = vy;
		tileMap = t;
		players = p;
	}
	
	public void move()
	{
		x += vx;
		y += vy;
	}
	
	public void tileCollision() //Checks if the ball collides with a tile 
	{
		for(int i = 0; i < tileMap.size(); i++)
		{
			for(int j = 0; j < tileMap.get(i).size(); j++)
			{
				if(tileMap.get(i).get(j).tileType == STONE_TILE)
				{
					Rectangle ball = new Rectangle(x, y, BALL_SIZE, BALL_SIZE);
					int tx = tileMap.get(i).get(j).x;
					int ty = tileMap.get(i).get(j).y;
					Rectangle t = new Rectangle(tx, ty, TILE_SIZE, TILE_SIZE);
					
					if(ball.intersects(t)) //Changes direction of the ball
					{
						vx = -vx;
						vy = -vy;
					}	
				}
			}
		}
	}
	
	
	public void ballCollisionWithPlayer() //Checks if ball collides with a player
	{
		for(int i = 0; i < players.length; i++)
		{
			Rectangle b = new Rectangle(x, y, BALL_SIZE, BALL_SIZE);
			Rectangle p = new Rectangle((int)(players[i].posX1 + 2), players[i].posY1 + 2, PLAYER_WIDTH - 4, PLAYER_HEIGHT - 4);
			
			if(p.intersects(b)) //Sends player back to starting position
			{
				players[i].posX1 = players[i].startPosX;
				players[i].posY1 = players[i].startPosY;
				players[i].posX2 = players[i].posX1 + PLAYER_WIDTH;
				players[i].posY2 = players[i].posY1 + PLAYER_HEIGHT;
			}	
		}
	}
	
	public void draw(Graphics g) //draws the ball
	{
		g.fillOval(x, y, BALL_SIZE, BALL_SIZE);
	}
}
