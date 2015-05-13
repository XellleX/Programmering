package ServerKlient;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class KundSupportServer extends JFrame
{
	
	public static void main(String[] args) 
	{
		new KundSupportServer();
	}
	
	JTextArea serverLog = new JTextArea();
	JScrollPane scrollPane = new JScrollPane(serverLog);
	int kundNr = 0;
	
	public KundSupportServer()
	{
		setTitle("Server log");
		setBounds(50, 50, 500, 300);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		serverLog.setEditable(false);
		add(scrollPane, BorderLayout.CENTER);
		setVisible(true);
		
		
		try
		{
			ServerSocket serverSocket = new ServerSocket(8111);
			serverLog.append(new Date() + ": Server startade på socket 8111\n");
			
			while(true)
			{
				Socket kund = serverSocket.accept();
				kundNr++;
				serverLog.append(new Date() + ": Kund " + kundNr + " startade en session.\n");
				
				SessionHandler task = new SessionHandler(kund);
				
				new Thread(task).start();
			}
		}
		catch(IOException ex){}
	}
	
	class SessionHandler extends JFrame implements Runnable
	{
		Socket kund;
		
		JTextArea chatLog = new JTextArea();
		JScrollPane chatScroll = new JScrollPane(chatLog);
		JTextArea textbox = new JTextArea();
		JScrollPane textboxScroll = new JScrollPane(textbox);
		
		private DataInputStream fromKund;
		DataOutputStream toKund;
		
		String text = "";
		
		public SessionHandler(Socket kund)
		{
			this.kund = kund;
			
			setTitle("Kund " + kundNr);
			setBounds(50, 200, 500, 300);
			setDefaultCloseOperation(EXIT_ON_CLOSE);
			chatLog.setEditable(false);
			chatLog.setPreferredSize(new Dimension(1, 170));
			textbox.setPreferredSize(new Dimension(1, 50));
			textbox.addKeyListener(new KeyBoard());
			add(chatScroll, BorderLayout.NORTH);
			add(textboxScroll, BorderLayout.SOUTH);

			setVisible(true);
		}

		@Override
		public void run() 
		{
			try
			{
				DataInputStream fromKund = new DataInputStream(kund.getInputStream());
				DataOutputStream toKund = new DataOutputStream(kund.getOutputStream());
				while(true)
				{
					sendText(toKund, text);
				}
			}
			
			catch(IOException e){
				e.printStackTrace();
			}
			
		}
		
		public void sendText(DataOutputStream out, String s)
		{
			try {
				out.writeUTF(s);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		class KeyBoard extends KeyAdapter
		{
			private Set<Integer> pressed = new HashSet<Integer>();

			
			@Override
			public void keyPressed(KeyEvent ke) 
			{
				pressed.add(ke.getKeyCode());
				if(pressed.size() == 2)
				{
					if(pressed.contains(KeyEvent.VK_CONTROL) && pressed.contains(KeyEvent.VK_ENTER))
					{
						text = textbox.getText();
						textbox.setText("");
						chatLog.append("\n" + text);
						toKund.notifyAll();
					}
				}
			}
			
			public void keyReleased(KeyEvent ke)
			{
				pressed.remove(ke.getKeyCode());
			}
		}
		
	}

}
