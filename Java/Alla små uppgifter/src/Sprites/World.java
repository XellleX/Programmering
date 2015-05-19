package Sprites;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class World extends JPanel implements Constants
{
	Image tileSprites;
	ArrayList<Tile> tileLines;
	ArrayList<ArrayList<Tile>> tileMap = new ArrayList<>();
	
	public World()
	{
		tileSprites = new ImageIcon("Tiles.png").getImage();
		getTiles();
	}
	
	public void getTiles()
	{
		Scanner sc;
		try {
			sc = new Scanner(new File("TilePlacement.txt"));
		
			for(int i = 0; i < 23; i++)
			{
				tileLines = new ArrayList<>();
				
				for(int j = 0; j < 44; j++)
				{
					Tile tile = new Tile((TILE_SIZE * j) - 21, (TILE_SIZE * i) - 15, sc.nextInt());
					tileLines.add(tile);
				}
				
				tileMap.add(tileLines);
			}
			
			sc.close();
		} 
		catch (FileNotFoundException e){
			e.printStackTrace();
		}
	}
	
	public void placeTiles(Graphics g)
	{
		for(int j = 0; j < tileMap.size(); j++)
			{
				for(int i = 0; i < tileMap.get(j).size(); i++)
				{
					g.drawImage(tileSprites, tileMap.get(j).get(i).x, tileMap.get(j).get(i).y, 
							tileMap.get(j).get(i).x + TILE_SIZE, tileMap.get(j).get(i).y + TILE_SIZE, 
							0, tileMap.get(j).get(i).tileType * TILE_SIZE, TILE_SIZE,
							(tileMap.get(j).get(i).tileType + 1) * TILE_SIZE, this);
				}
			}
	}
	
	public class Tile
	{
		int x;
		int y;
		int tileType;
		
		public Tile(int x, int y, int tp)
		{
			this.x = x;
			this.y = y;
			tileType = tp;
		}
	}
}
