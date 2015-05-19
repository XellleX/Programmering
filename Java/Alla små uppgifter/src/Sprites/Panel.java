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

public class Panel extends JPanel
{
	Player p1;
	World w;
	
	public Panel(Player p, World w)
	{
		this.w = w;
		p1 = p;
	}
	
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		w.placeTiles(g);
		p1.draw(g);
	}
	
}
