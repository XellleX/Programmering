package GUI;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.LayoutManager;

import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Align extends JFrame
{
	JPanel pan = new JPanel();
	
	GridLayout Grid = new GridLayout();
	
	public Align()
	{
		super("Hej");
		setVisible(true);
		setBounds(200, 300, 400, 200);
		
		JCheckBox snap = new JCheckBox("Snap to grid");
		JCheckBox show = new JCheckBox("Show grid");
		pan.add(snap);
		pan.add(show);
		add(BorderLayout.WEST, pan);
	}
}
