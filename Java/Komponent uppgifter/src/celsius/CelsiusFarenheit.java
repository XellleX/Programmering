package celsius;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.SwingConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class CelsiusFarenheit extends JFrame implements ChangeListener
{
	JSlider celsiusSlider = new JSlider(JSlider.VERTICAL, 0, 100, 0);
	JSlider farenheitSlider = new JSlider(JSlider.VERTICAL, 32, 212, 32);
	JLabel celsiusText = new JLabel("0 C", SwingConstants.RIGHT);
	JLabel farenheitText = new JLabel("32 F", SwingConstants.RIGHT);
	JPanel pan = new JPanel();
	GridLayout grid = new GridLayout(1, 4);
	
	public CelsiusFarenheit()
	{
		super("Yolo");
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		pan.setLayout(grid);
		addToPanel();
		add(pan);
		celsiusSlider.addChangeListener(this);
		farenheitSlider.addChangeListener(this);
		ticks();
	}
	
	public void addToPanel()
	{
		celsiusText.setOpaque(true);
		farenheitText.setOpaque(true);
		celsiusSlider.setBackground(Color.CYAN);
		celsiusText.setBackground(Color.CYAN);
		farenheitSlider.setBackground(Color.ORANGE);
		farenheitText.setBackground(Color.ORANGE);
		pan.add(celsiusText);
		pan.add(celsiusSlider);
		pan.add(farenheitText);
		pan.add(farenheitSlider);
	}
	public void ticks()
	{
		celsiusSlider.setMajorTickSpacing(10);
		celsiusSlider.setMinorTickSpacing(1);
		celsiusSlider.setPaintTicks(true);
		celsiusSlider.setPaintLabels(true);
		farenheitSlider.setMajorTickSpacing(20);
		farenheitSlider.setMinorTickSpacing(1);
		farenheitSlider.setPaintTicks(true);
		farenheitSlider.setPaintLabels(true);
	}

	@Override
	public void stateChanged(ChangeEvent e) 
	{
		int celsiusValue = celsiusSlider.getValue();
		int farenheitValue = farenheitSlider.getValue();
		
		int celsiusValue2 = (farenheitValue - 32) * 5/9;
		int farenheitValue2 = (celsiusValue * 9/5) + 32;
		
		if(farenheitSlider.getValueIsAdjusting())
		{
			celsiusSlider.setValue(celsiusValue2);
		}
		
		else if(celsiusSlider.getValueIsAdjusting())
		{
			farenheitSlider.setValue(farenheitValue2);
		}
		
		celsiusText.setText(celsiusValue + " C");
		farenheitText.setText(farenheitValue + " F");
	}
}
