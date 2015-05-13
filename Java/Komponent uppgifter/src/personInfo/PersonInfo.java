package personInfo;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class PersonInfo extends JFrame implements ActionListener
{
	JTextField name = new JTextField();
	JTextField length = new JTextField();
	JTextField weight = new JTextField();
	JLabel questionName = new JLabel("What is your name?");
	JLabel questionLength = new JLabel("What is your length in cm?");
	JLabel questionWeight = new JLabel("What is your weight in kg?");
	JLabel info;
	JPanel pan = new JPanel();
	
	public PersonInfo()
	{
		pan.setLayout(new GridLayout(3,2));
		setVisible(true);
		setBounds(100, 100, 400, 300);
		setTitle("Hej");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		fillDefConstructor();
	}
	
	public void fillDefConstructor()
	{
		add(pan);
		pan.add(questionName);
		pan.add(name);
		pan.add(questionWeight);
		pan.add(weight);
		pan.add(questionLength);
		pan.add(length);
		name.addActionListener(this);
		length.addActionListener(this);
		weight.addActionListener(this);
	}


	@Override
	public void actionPerformed(ActionEvent arg0) 
	{
		String _name = name.getText();
		double _length = Integer.parseInt(length.getText());
		double _weight = Integer.parseInt(weight.getText());
		
		double kgPerCm = _weight/_length;
		
		String oneDecimal = String.format("%.1g%n", kgPerCm);
		
		info = new JLabel("Hej " + _name + ". Du väger " + oneDecimal + " kg/cm.");
		pan.setVisible(false);
		add(info);
	}
}
