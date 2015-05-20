package Sprites;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.lang.reflect.Array;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import Sprites.World.Tile;

public class Player extends JPanel implements Constants
{
	Image playerSprite;
	ArrayList<ArrayList<Tile>> tileMap;
	
	final int PLAYER_WIDTH;
	final int PLAYER_HEIGHT;
	int posX2;
	int posY2;
	int posX1 = 0;
	int posY1 = 0;
	int imageNumX = 0;
	int imageNumY = 0;
	double vx = 0;
	double vy = 0;
	int time = 0;
	
	public Player(int x, int y, ArrayList<ArrayList<Tile>> t)
	{
		posX1 = x;
		posY1 = y;
		tileMap = t;
		playerSprite = new ImageIcon("miniman.png").getImage();
		
		PLAYER_WIDTH = playerSprite.getWidth(this)/4;
		PLAYER_HEIGHT = playerSprite.getHeight(this)/4;
		
		posX2 = posX1 + PLAYER_WIDTH;
		posY2 = posY1 + PLAYER_HEIGHT;
	}
	
	public void accelerate(double x, double y)
	{
		vx += x;
		vy += y;
	}
	
	public void step(int imNumY)
	{
		time++;
		posX1 += vx;
		posX2 += vx;
		posY1 += vy;
		posY2 += vy;
		
		imageNumY = imNumY;
		
		if(time % 8 == 0)
		{
			imageNumX++;
		}
		if(imageNumX >= 4)
		{
			imageNumX = 0;
		}
	}
	
	public void draw(Graphics g)
	{
		g.drawImage(playerSprite, posX1, posY1, posX2, posY2, 
				PLAYER_WIDTH * imageNumX, PLAYER_HEIGHT * imageNumY, PLAYER_WIDTH * (imageNumX + 1), PLAYER_HEIGHT * (imageNumY + 1), this);
	}
	
	public boolean collisions()
	{
		boolean colli = false;
		for(int i = 0; i < tileMap.size(); i++)
		{
			for(int j = 0; j < tileMap.get(i).size(); j++)
			{
				if(tileMap.get(i).get(j).tileType == STONE_TILE)
				{
					Rectangle p = new Rectangle((int)(posX1 + vx), (int)(posY1 + vy), PLAYER_WIDTH, PLAYER_HEIGHT);
					
					int tx = tileMap.get(i).get(j).x;
					int ty = tileMap.get(i).get(j).y;
					Rectangle t = new Rectangle(tx, ty, TILE_SIZE, TILE_SIZE);
					
					if(p.intersects(t))
					{
						colli = true;
					}
				}
			}
		}
		return colli;
	}
}
