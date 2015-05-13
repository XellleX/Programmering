package ServerKlient;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.HashSet;
import java.util.Set;

import javax.swing.JTextArea;

public class KeyBoard extends KeyAdapter
{
	private Set<Integer> pressed = new HashSet<Integer>();
	JTextArea textbox;
	JTextArea chatLog;

	public KeyBoard(JTextArea chatLog, JTextArea textbox)
	{
		this.chatLog = chatLog;
		this.textbox = textbox;
	}
	
	@Override
	public void keyPressed(KeyEvent ke) 
	{
		pressed.add(ke.getKeyCode());
		if(pressed.size() == 2)
		{
			if(pressed.contains(KeyEvent.VK_CONTROL) && pressed.contains(KeyEvent.VK_ENTER))
			{
				String hold = textbox.getText();
				textbox.setText("");
				chatLog.append("\n" + hold);
			}
		}
	}
	
	public void keyReleased(KeyEvent ke)
	{
		pressed.remove(ke.getKeyCode());
	}
}
